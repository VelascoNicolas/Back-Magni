package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.business.service.PromocionService;
import com.entidades.buenSabor.domain.dto.DetallePedidoDTO;
import com.entidades.buenSabor.domain.dto.PedidoDTO;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.domain.enums.TipoEnvio;
import com.entidades.buenSabor.repositories.ArticuloInsumoRepository;
import com.entidades.buenSabor.repositories.DetallePedidoRepository;
import com.entidades.buenSabor.repositories.EmpleadoRepository;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private PromocionService promocionService;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    @Transactional
    public List<Pedido> getTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional
    public Pedido getByID(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido guardarPedido(PedidoDTO pedido, Double precioDelivery) {
        Pedido save = new Pedido();
        save.setFechaPedido(pedido.getFechaPedido());
        save.setEliminado(pedido.isEliminado());
        save.setEstado(pedido.getEstado());
        save.setTipoEnvio(pedido.getTipoEnvio());
        save.setFormaPago(pedido.getFormaPago());
        save.setDomicilio(pedido.getDomicilio());
        save.setSucursal(pedido.getSucursal());
        save.setFactura(null);
        save.setCliente(pedido.getCliente());
        save.setEmpleado(pedido.getEmpleado());

        for(DetallePedidoDTO dp : pedido.getDetallePedidos()) {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setEliminado(dp.isEliminado());
            detallePedido.setCantidad(dp.getCantidad());
            detallePedido.setSubTotal(dp.getSubTotal());
            if (dp.getArticulo() != null) {
                detallePedido.setArticulo(articuloService.getById(dp.getArticulo()));
            }
            if (dp.getPromocion() != null) {
                detallePedido.setPromocion(promocionService.getById(dp.getPromocion()));
            }
            save.getDetallePedidos().add(detallePedido);
        }
        save.calcularPrecioVentaTotal(precioDelivery);
        save.calcularPrecioCostoTotal();
        manejoStock(save);
        save.setTiempoDeEspera(tiempoEstimado(save));
        return pedidoRepository.save(save);
    }

    @Override
    public Pedido agregarFactura(Long idPedido) {
        Pedido pedido = getByID(idPedido);
        Factura factura = new Factura();
        factura.setFechaFacturacion(pedido.getFechaPedido());
        factura.setFormaPago(pedido.getFormaPago());
        factura.setSubTotal(pedido.getTotal());
        if (pedido.getTipoEnvio() != TipoEnvio.DELIVERY) {
            factura.setDescuento(pedido.getTotal() * 0.1);
        } else {
            factura.setDescuento(0.0);
        }
        factura.setTotal(factura.getSubTotal() - factura.getDescuento());
        pedido.setFactura(factura);
        pedido.setEstado(Estado.FACTURADO);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarEstado(Long idPedido, Estado estado) {
        Pedido pedido = getByID(idPedido);
        pedido.setEstado(estado);
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> getPedidosByCliente(String userName) {
        return pedidoRepository.findByCliente_UserName(userName);
    }

    @Override
    public List<Pedido> getPedidosByEstado(Estado estado) {
        return pedidoRepository.findByEstado(estado);
    }

    public void manejoStock(Pedido pedido) {
        for (DetallePedido dp : pedido.getDetallePedidos()) {
            if (dp.getArticulo() != null) {
                if (dp.getArticulo() instanceof ArticuloInsumo) {
                    ((ArticuloInsumo) dp.getArticulo()).setStockActual(((ArticuloInsumo) dp.getArticulo()).getStockActual() - dp.getCantidad());
                    articuloInsumoRepository.save((ArticuloInsumo) dp.getArticulo());
                } else if (dp.getArticulo() instanceof ArticuloManufacturado) {
                    for (ArticuloManufacturadoDetalle detalle : ((ArticuloManufacturado) dp.getArticulo()).getArticuloManufacturadoDetalles()) {
                        detalle.getArticuloInsumo().setStockActual(detalle.getArticuloInsumo().getStockActual() - (dp.getCantidad() * detalle.getCantidad()));
                        articuloInsumoRepository.save(detalle.getArticuloInsumo());
                    }
                }
            }
            if (dp.getPromocion() != null) {
                for (PromocionDetalle detalle : dp.getPromocion().getPromocionDetalles()) {
                    if (detalle.getArticulo() instanceof ArticuloInsumo) {
                        ((ArticuloInsumo) detalle.getArticulo()).setStockActual(((ArticuloInsumo) detalle.getArticulo()).getStockActual() - (dp.getCantidad() * detalle.getCantidad()));
                        articuloInsumoRepository.save((ArticuloInsumo) detalle.getArticulo());
                    } else if (detalle.getArticulo() instanceof ArticuloManufacturado) {
                        for (ArticuloManufacturadoDetalle detalle2 : ((ArticuloManufacturado) detalle.getArticulo()).getArticuloManufacturadoDetalles()) {
                            detalle2.getArticuloInsumo().setStockActual(detalle2.getArticuloInsumo().getStockActual() - (dp.getCantidad() * detalle.getCantidad() * detalle2.getCantidad()));
                            articuloInsumoRepository.save(detalle2.getArticuloInsumo());
                        }
                    }
                }
            }
        }
    }

    public LocalTime tiempoEstimado(Pedido save) {
        Integer tiempo = 0;
        Integer actual = 0;
        Integer cocinerosActivos = empleadoRepository.getCocinerosActivos();
        for (DetallePedido dp : save.getDetallePedidos()) {
            if (dp.getArticulo() != null) {
                if(dp.getArticulo() instanceof ArticuloManufacturado) {
                    actual += ((ArticuloManufacturado) dp.getArticulo()).getTiempoEstimadoMinutos();
                }
            }
            if (dp.getPromocion() != null) {
                for (PromocionDetalle promocionDetalle : dp.getPromocion().getPromocionDetalles()) {
                    if (promocionDetalle.getArticulo() instanceof ArticuloManufacturado) {
                        ArticuloManufacturado a = (ArticuloManufacturado) promocionDetalle.getArticulo();
                        actual += a.getTiempoEstimadoMinutos();
                    }
                }
            }
        }
        List<Pedido> pedidosEnCocina = pedidoRepository.findByEstado(Estado.APROBADO);
        Integer cocina = 0;

        if (pedidosEnCocina != null) {
            for (Pedido p : pedidosEnCocina) {
                for (DetallePedido dp : p.getDetallePedidos()) {
                    if (dp.getArticulo() != null) {
                        if(dp.getArticulo() instanceof ArticuloManufacturado) {
                            cocina += ((ArticuloManufacturado) dp.getArticulo()).getTiempoEstimadoMinutos();
                        }
                    }
                    if (dp.getPromocion() != null) {
                        for (PromocionDetalle promocionDetalle : dp.getPromocion().getPromocionDetalles()) {
                            if (promocionDetalle.getArticulo() instanceof ArticuloManufacturado) {
                                ArticuloManufacturado b = (ArticuloManufacturado) promocionDetalle.getArticulo();
                                cocina += b.getTiempoEstimadoMinutos();
                            }
                        }
                    }
                }
            }
        }
        cocina = cocina / cocinerosActivos;
        if (save.getTipoEnvio() == TipoEnvio.DELIVERY) {
            tiempo = actual + cocina + 10;
        } else {
            tiempo = actual + cocina;
        }
        LocalTime horaEstimada = LocalTime.of(0,0);
        horaEstimada = horaEstimada.plusMinutes(tiempo);
        return horaEstimada;
    }
}

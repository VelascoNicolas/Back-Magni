package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.CategoriaHijoDto;
import com.entidades.buenSabor.domain.dto.DomicilioDto;
import com.entidades.buenSabor.domain.dto.EmpresaDto;
import com.entidades.buenSabor.domain.dto.ImagenDto;
import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.dto.PaisDto;
import com.entidades.buenSabor.domain.dto.ProvinciaDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.dto.UnidadMedidaDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Domicilio;
import com.entidades.buenSabor.domain.entities.Empresa;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import com.entidades.buenSabor.domain.entities.Localidad;
import com.entidades.buenSabor.domain.entities.Pais;
import com.entidades.buenSabor.domain.entities.Provincia;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-20T17:15:51-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ArticuloManufacturadoDetalleMapperImpl implements ArticuloManufacturadoDetalleMapper {

    @Override
    public ArticuloManufacturadoDetalleDto toDTO(ArticuloManufacturadoDetalle source) {
        if ( source == null ) {
            return null;
        }

        ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleDto = new ArticuloManufacturadoDetalleDto();

        articuloManufacturadoDetalleDto.setId( source.getId() );
        articuloManufacturadoDetalleDto.setEliminado( source.isEliminado() );
        articuloManufacturadoDetalleDto.setFechaBaja( source.getFechaBaja() );
        articuloManufacturadoDetalleDto.setCantidad( source.getCantidad() );
        articuloManufacturadoDetalleDto.setArticuloInsumo( articuloInsumoToArticuloInsumoDto( source.getArticuloInsumo() ) );

        return articuloManufacturadoDetalleDto;
    }

    @Override
    public ArticuloManufacturadoDetalle toEntity(ArticuloManufacturadoDetalleDto source) {
        if ( source == null ) {
            return null;
        }

        ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleBuilder<?, ?> articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder();

        articuloManufacturadoDetalle.id( source.getId() );
        articuloManufacturadoDetalle.eliminado( source.isEliminado() );
        articuloManufacturadoDetalle.fechaBaja( source.getFechaBaja() );
        articuloManufacturadoDetalle.cantidad( source.getCantidad() );
        articuloManufacturadoDetalle.articuloInsumo( articuloInsumoDtoToArticuloInsumo( source.getArticuloInsumo() ) );

        return articuloManufacturadoDetalle.build();
    }

    @Override
    public List<ArticuloManufacturadoDetalleDto> toDTOsList(List<ArticuloManufacturadoDetalle> source) {
        if ( source == null ) {
            return null;
        }

        List<ArticuloManufacturadoDetalleDto> list = new ArrayList<ArticuloManufacturadoDetalleDto>( source.size() );
        for ( ArticuloManufacturadoDetalle articuloManufacturadoDetalle : source ) {
            list.add( toDTO( articuloManufacturadoDetalle ) );
        }

        return list;
    }

    protected ImagenDto imagenArticuloToImagenDto(ImagenArticulo imagenArticulo) {
        if ( imagenArticulo == null ) {
            return null;
        }

        ImagenDto imagenDto = new ImagenDto();

        imagenDto.setId( imagenArticulo.getId() );
        imagenDto.setEliminado( imagenArticulo.isEliminado() );
        imagenDto.setFechaBaja( imagenArticulo.getFechaBaja() );
        imagenDto.setUrl( imagenArticulo.getUrl() );

        return imagenDto;
    }

    protected Set<ImagenDto> imagenArticuloSetToImagenDtoSet(Set<ImagenArticulo> set) {
        if ( set == null ) {
            return null;
        }

        Set<ImagenDto> set1 = new LinkedHashSet<ImagenDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ImagenArticulo imagenArticulo : set ) {
            set1.add( imagenArticuloToImagenDto( imagenArticulo ) );
        }

        return set1;
    }

    protected UnidadMedidaDto unidadMedidaToUnidadMedidaDto(UnidadMedida unidadMedida) {
        if ( unidadMedida == null ) {
            return null;
        }

        UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();

        unidadMedidaDto.setId( unidadMedida.getId() );
        unidadMedidaDto.setEliminado( unidadMedida.isEliminado() );
        unidadMedidaDto.setFechaBaja( unidadMedida.getFechaBaja() );
        unidadMedidaDto.setDenominacion( unidadMedida.getDenominacion() );

        return unidadMedidaDto;
    }

    protected PaisDto paisToPaisDto(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        PaisDto paisDto = new PaisDto();

        paisDto.setEliminado( pais.isEliminado() );
        paisDto.setFechaBaja( pais.getFechaBaja() );
        paisDto.setId( pais.getId() );
        paisDto.setNombre( pais.getNombre() );

        return paisDto;
    }

    protected ProvinciaDto provinciaToProvinciaDto(Provincia provincia) {
        if ( provincia == null ) {
            return null;
        }

        ProvinciaDto provinciaDto = new ProvinciaDto();

        provinciaDto.setId( provincia.getId() );
        provinciaDto.setEliminado( provincia.isEliminado() );
        provinciaDto.setFechaBaja( provincia.getFechaBaja() );
        provinciaDto.setNombre( provincia.getNombre() );
        provinciaDto.setPais( paisToPaisDto( provincia.getPais() ) );

        return provinciaDto;
    }

    protected LocalidadDto localidadToLocalidadDto(Localidad localidad) {
        if ( localidad == null ) {
            return null;
        }

        LocalidadDto localidadDto = new LocalidadDto();

        localidadDto.setId( localidad.getId() );
        localidadDto.setEliminado( localidad.isEliminado() );
        localidadDto.setFechaBaja( localidad.getFechaBaja() );
        localidadDto.setNombre( localidad.getNombre() );
        localidadDto.setProvincia( provinciaToProvinciaDto( localidad.getProvincia() ) );

        return localidadDto;
    }

    protected DomicilioDto domicilioToDomicilioDto(Domicilio domicilio) {
        if ( domicilio == null ) {
            return null;
        }

        DomicilioDto domicilioDto = new DomicilioDto();

        domicilioDto.setId( domicilio.getId() );
        domicilioDto.setEliminado( domicilio.isEliminado() );
        domicilioDto.setFechaBaja( domicilio.getFechaBaja() );
        domicilioDto.setCalle( domicilio.getCalle() );
        domicilioDto.setNumero( domicilio.getNumero() );
        domicilioDto.setCp( domicilio.getCp() );
        domicilioDto.setPiso( domicilio.getPiso() );
        domicilioDto.setNroDpto( domicilio.getNroDpto() );
        domicilioDto.setLocalidad( localidadToLocalidadDto( domicilio.getLocalidad() ) );

        return domicilioDto;
    }

    protected EmpresaDto empresaToEmpresaDto(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDto empresaDto = new EmpresaDto();

        empresaDto.setId( empresa.getId() );
        empresaDto.setEliminado( empresa.isEliminado() );
        empresaDto.setFechaBaja( empresa.getFechaBaja() );
        empresaDto.setNombre( empresa.getNombre() );
        empresaDto.setRazonSocial( empresa.getRazonSocial() );
        empresaDto.setCuil( empresa.getCuil() );

        return empresaDto;
    }

    protected SucursalDto sucursalToSucursalDto(Sucursal sucursal) {
        if ( sucursal == null ) {
            return null;
        }

        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setId( sucursal.getId() );
        sucursalDto.setEliminado( sucursal.isEliminado() );
        sucursalDto.setFechaBaja( sucursal.getFechaBaja() );
        sucursalDto.setNombre( sucursal.getNombre() );
        sucursalDto.setEsCasaMatriz( sucursal.isEsCasaMatriz() );
        sucursalDto.setDomicilio( domicilioToDomicilioDto( sucursal.getDomicilio() ) );
        sucursalDto.setEmpresa( empresaToEmpresaDto( sucursal.getEmpresa() ) );

        return sucursalDto;
    }

    protected Set<SucursalDto> sucursalSetToSucursalDtoSet(Set<Sucursal> set) {
        if ( set == null ) {
            return null;
        }

        Set<SucursalDto> set1 = new LinkedHashSet<SucursalDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Sucursal sucursal : set ) {
            set1.add( sucursalToSucursalDto( sucursal ) );
        }

        return set1;
    }

    protected CategoriaHijoDto categoriaToCategoriaHijoDto(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaHijoDto categoriaHijoDto = new CategoriaHijoDto();

        categoriaHijoDto.setId( categoria.getId() );
        categoriaHijoDto.setEliminado( categoria.isEliminado() );
        categoriaHijoDto.setFechaBaja( categoria.getFechaBaja() );
        categoriaHijoDto.setDenominacion( categoria.getDenominacion() );
        categoriaHijoDto.setSucursales( sucursalSetToSucursalDtoSet( categoria.getSucursales() ) );

        return categoriaHijoDto;
    }

    protected ArticuloInsumoDto articuloInsumoToArticuloInsumoDto(ArticuloInsumo articuloInsumo) {
        if ( articuloInsumo == null ) {
            return null;
        }

        ArticuloInsumoDto articuloInsumoDto = new ArticuloInsumoDto();

        articuloInsumoDto.setId( articuloInsumo.getId() );
        articuloInsumoDto.setEliminado( articuloInsumo.isEliminado() );
        articuloInsumoDto.setFechaBaja( articuloInsumo.getFechaBaja() );
        articuloInsumoDto.setDenominacion( articuloInsumo.getDenominacion() );
        articuloInsumoDto.setPrecioVenta( articuloInsumo.getPrecioVenta() );
        articuloInsumoDto.setImagenes( imagenArticuloSetToImagenDtoSet( articuloInsumo.getImagenes() ) );
        articuloInsumoDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( articuloInsumo.getUnidadMedida() ) );
        articuloInsumoDto.setCategoria( categoriaToCategoriaHijoDto( articuloInsumo.getCategoria() ) );
        articuloInsumoDto.setPrecioCompra( articuloInsumo.getPrecioCompra() );
        articuloInsumoDto.setStockActual( articuloInsumo.getStockActual() );
        articuloInsumoDto.setStockMaximo( articuloInsumo.getStockMaximo() );
        articuloInsumoDto.setStockMinimo( articuloInsumo.getStockMinimo() );
        articuloInsumoDto.setEsParaElaborar( articuloInsumo.getEsParaElaborar() );

        return articuloInsumoDto;
    }

    protected ImagenArticulo imagenDtoToImagenArticulo(ImagenDto imagenDto) {
        if ( imagenDto == null ) {
            return null;
        }

        ImagenArticulo.ImagenArticuloBuilder<?, ?> imagenArticulo = ImagenArticulo.builder();

        imagenArticulo.id( imagenDto.getId() );
        imagenArticulo.eliminado( imagenDto.isEliminado() );
        imagenArticulo.fechaBaja( imagenDto.getFechaBaja() );
        imagenArticulo.url( imagenDto.getUrl() );

        return imagenArticulo.build();
    }

    protected Set<ImagenArticulo> imagenDtoSetToImagenArticuloSet(Set<ImagenDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ImagenArticulo> set1 = new LinkedHashSet<ImagenArticulo>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ImagenDto imagenDto : set ) {
            set1.add( imagenDtoToImagenArticulo( imagenDto ) );
        }

        return set1;
    }

    protected UnidadMedida unidadMedidaDtoToUnidadMedida(UnidadMedidaDto unidadMedidaDto) {
        if ( unidadMedidaDto == null ) {
            return null;
        }

        UnidadMedida.UnidadMedidaBuilder<?, ?> unidadMedida = UnidadMedida.builder();

        unidadMedida.id( unidadMedidaDto.getId() );
        unidadMedida.eliminado( unidadMedidaDto.isEliminado() );
        unidadMedida.fechaBaja( unidadMedidaDto.getFechaBaja() );
        unidadMedida.denominacion( unidadMedidaDto.getDenominacion() );

        return unidadMedida.build();
    }

    protected Pais paisDtoToPais(PaisDto paisDto) {
        if ( paisDto == null ) {
            return null;
        }

        Pais.PaisBuilder<?, ?> pais = Pais.builder();

        pais.id( paisDto.getId() );
        pais.eliminado( paisDto.isEliminado() );
        pais.fechaBaja( paisDto.getFechaBaja() );
        pais.nombre( paisDto.getNombre() );

        return pais.build();
    }

    protected Provincia provinciaDtoToProvincia(ProvinciaDto provinciaDto) {
        if ( provinciaDto == null ) {
            return null;
        }

        Provincia.ProvinciaBuilder<?, ?> provincia = Provincia.builder();

        provincia.id( provinciaDto.getId() );
        provincia.eliminado( provinciaDto.isEliminado() );
        provincia.fechaBaja( provinciaDto.getFechaBaja() );
        provincia.nombre( provinciaDto.getNombre() );
        provincia.pais( paisDtoToPais( provinciaDto.getPais() ) );

        return provincia.build();
    }

    protected Localidad localidadDtoToLocalidad(LocalidadDto localidadDto) {
        if ( localidadDto == null ) {
            return null;
        }

        Localidad.LocalidadBuilder<?, ?> localidad = Localidad.builder();

        localidad.id( localidadDto.getId() );
        localidad.eliminado( localidadDto.isEliminado() );
        localidad.fechaBaja( localidadDto.getFechaBaja() );
        localidad.nombre( localidadDto.getNombre() );
        localidad.provincia( provinciaDtoToProvincia( localidadDto.getProvincia() ) );

        return localidad.build();
    }

    protected Domicilio domicilioDtoToDomicilio(DomicilioDto domicilioDto) {
        if ( domicilioDto == null ) {
            return null;
        }

        Domicilio.DomicilioBuilder<?, ?> domicilio = Domicilio.builder();

        domicilio.id( domicilioDto.getId() );
        domicilio.eliminado( domicilioDto.isEliminado() );
        domicilio.fechaBaja( domicilioDto.getFechaBaja() );
        domicilio.calle( domicilioDto.getCalle() );
        domicilio.numero( domicilioDto.getNumero() );
        domicilio.cp( domicilioDto.getCp() );
        domicilio.piso( domicilioDto.getPiso() );
        domicilio.nroDpto( domicilioDto.getNroDpto() );
        domicilio.localidad( localidadDtoToLocalidad( domicilioDto.getLocalidad() ) );

        return domicilio.build();
    }

    protected Empresa empresaDtoToEmpresa(EmpresaDto empresaDto) {
        if ( empresaDto == null ) {
            return null;
        }

        Empresa.EmpresaBuilder<?, ?> empresa = Empresa.builder();

        empresa.id( empresaDto.getId() );
        empresa.eliminado( empresaDto.isEliminado() );
        empresa.fechaBaja( empresaDto.getFechaBaja() );
        empresa.nombre( empresaDto.getNombre() );
        empresa.razonSocial( empresaDto.getRazonSocial() );
        empresa.cuil( empresaDto.getCuil() );

        return empresa.build();
    }

    protected Sucursal sucursalDtoToSucursal(SucursalDto sucursalDto) {
        if ( sucursalDto == null ) {
            return null;
        }

        Sucursal.SucursalBuilder<?, ?> sucursal = Sucursal.builder();

        sucursal.id( sucursalDto.getId() );
        sucursal.eliminado( sucursalDto.isEliminado() );
        sucursal.fechaBaja( sucursalDto.getFechaBaja() );
        sucursal.nombre( sucursalDto.getNombre() );
        sucursal.esCasaMatriz( sucursalDto.isEsCasaMatriz() );
        sucursal.domicilio( domicilioDtoToDomicilio( sucursalDto.getDomicilio() ) );
        sucursal.empresa( empresaDtoToEmpresa( sucursalDto.getEmpresa() ) );

        return sucursal.build();
    }

    protected Set<Sucursal> sucursalDtoSetToSucursalSet(Set<SucursalDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Sucursal> set1 = new LinkedHashSet<Sucursal>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( SucursalDto sucursalDto : set ) {
            set1.add( sucursalDtoToSucursal( sucursalDto ) );
        }

        return set1;
    }

    protected Categoria categoriaHijoDtoToCategoria(CategoriaHijoDto categoriaHijoDto) {
        if ( categoriaHijoDto == null ) {
            return null;
        }

        Categoria.CategoriaBuilder<?, ?> categoria = Categoria.builder();

        categoria.id( categoriaHijoDto.getId() );
        categoria.eliminado( categoriaHijoDto.isEliminado() );
        categoria.fechaBaja( categoriaHijoDto.getFechaBaja() );
        categoria.denominacion( categoriaHijoDto.getDenominacion() );
        categoria.sucursales( sucursalDtoSetToSucursalSet( categoriaHijoDto.getSucursales() ) );

        return categoria.build();
    }

    protected ArticuloInsumo articuloInsumoDtoToArticuloInsumo(ArticuloInsumoDto articuloInsumoDto) {
        if ( articuloInsumoDto == null ) {
            return null;
        }

        ArticuloInsumo.ArticuloInsumoBuilder<?, ?> articuloInsumo = ArticuloInsumo.builder();

        articuloInsumo.id( articuloInsumoDto.getId() );
        articuloInsumo.eliminado( articuloInsumoDto.isEliminado() );
        articuloInsumo.fechaBaja( articuloInsumoDto.getFechaBaja() );
        articuloInsumo.denominacion( articuloInsumoDto.getDenominacion() );
        articuloInsumo.precioVenta( articuloInsumoDto.getPrecioVenta() );
        articuloInsumo.imagenes( imagenDtoSetToImagenArticuloSet( articuloInsumoDto.getImagenes() ) );
        articuloInsumo.unidadMedida( unidadMedidaDtoToUnidadMedida( articuloInsumoDto.getUnidadMedida() ) );
        articuloInsumo.categoria( categoriaHijoDtoToCategoria( articuloInsumoDto.getCategoria() ) );
        articuloInsumo.precioCompra( articuloInsumoDto.getPrecioCompra() );
        articuloInsumo.stockActual( articuloInsumoDto.getStockActual() );
        articuloInsumo.stockMaximo( articuloInsumoDto.getStockMaximo() );
        articuloInsumo.stockMinimo( articuloInsumoDto.getStockMinimo() );
        articuloInsumo.esParaElaborar( articuloInsumoDto.getEsParaElaborar() );

        return articuloInsumo.build();
    }
}

package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ArticuloDto;
import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.CategoriaHijoDto;
import com.entidades.buenSabor.domain.dto.DomicilioDto;
import com.entidades.buenSabor.domain.dto.EmpresaDto;
import com.entidades.buenSabor.domain.dto.ImagenDto;
import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.dto.PaisDto;
import com.entidades.buenSabor.domain.dto.ProvinciaDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.dto.UnidadMedidaDto;
import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-27T17:02:14-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ArticuloMapperImpl implements ArticuloMapper {

    @Autowired
    private ArticuloManufacturadoDetalleMapper articuloManufacturadoDetalleMapper;
    @Autowired
    private ImagenArticuloMapper imagenArticuloMapper;

    @Override
    public ArticuloDto toDTO(Articulo source) {
        if ( source == null ) {
            return null;
        }

        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setId( source.getId() );
        articuloDto.setEliminado( source.isEliminado() );
        articuloDto.setFechaBaja( source.getFechaBaja() );
        articuloDto.setDenominacion( source.getDenominacion() );
        articuloDto.setPrecioVenta( source.getPrecioVenta() );
        articuloDto.setImagenes( imagenArticuloSetToImagenDtoSet( source.getImagenes() ) );
        articuloDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( source.getUnidadMedida() ) );
        articuloDto.setCategoria( categoriaToCategoriaHijoDto( source.getCategoria() ) );

        return articuloDto;
    }

    @Override
    public List<ArticuloDto> toDTOsList(List<Articulo> source) {
        if ( source == null ) {
            return null;
        }

        List<ArticuloDto> list = new ArrayList<ArticuloDto>( source.size() );
        for ( Articulo articulo : source ) {
            list.add( toDTO( articulo ) );
        }

        return list;
    }

    @Override
    public ArticuloDto toDto(Articulo articulo) {
        if ( articulo == null ) {
            return null;
        }

        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setId( articulo.getId() );
        articuloDto.setEliminado( articulo.isEliminado() );
        articuloDto.setFechaBaja( articulo.getFechaBaja() );
        articuloDto.setDenominacion( articulo.getDenominacion() );
        articuloDto.setPrecioVenta( articulo.getPrecioVenta() );
        articuloDto.setImagenes( imagenArticuloSetToImagenDtoSet( articulo.getImagenes() ) );
        articuloDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( articulo.getUnidadMedida() ) );
        articuloDto.setCategoria( categoriaToCategoriaHijoDto( articulo.getCategoria() ) );

        return articuloDto;
    }

    @Override
    public Set<ArticuloDto> toDtoSet(Set<Articulo> articulos) {
        if ( articulos == null ) {
            return null;
        }

        Set<ArticuloDto> set = new LinkedHashSet<ArticuloDto>( Math.max( (int) ( articulos.size() / .75f ) + 1, 16 ) );
        for ( Articulo articulo : articulos ) {
            set.add( toDTO( articulo ) );
        }

        return set;
    }

    @Override
    public ArticuloInsumo toEntity(ArticuloInsumoDto dto) {
        if ( dto == null ) {
            return null;
        }

        ArticuloInsumo.ArticuloInsumoBuilder<?, ?> articuloInsumo = ArticuloInsumo.builder();

        articuloInsumo.id( dto.getId() );
        articuloInsumo.eliminado( dto.isEliminado() );
        articuloInsumo.fechaBaja( dto.getFechaBaja() );
        articuloInsumo.denominacion( dto.getDenominacion() );
        articuloInsumo.precioVenta( dto.getPrecioVenta() );
        articuloInsumo.imagenes( imagenDtoSetToImagenArticuloSet( dto.getImagenes() ) );
        articuloInsumo.unidadMedida( unidadMedidaDtoToUnidadMedida( dto.getUnidadMedida() ) );
        articuloInsumo.categoria( categoriaHijoDtoToCategoria( dto.getCategoria() ) );
        articuloInsumo.precioCompra( dto.getPrecioCompra() );
        articuloInsumo.stockActual( dto.getStockActual() );
        articuloInsumo.stockMaximo( dto.getStockMaximo() );
        articuloInsumo.stockMinimo( dto.getStockMinimo() );
        articuloInsumo.esParaElaborar( dto.getEsParaElaborar() );

        return articuloInsumo.build();
    }

    @Override
    public ArticuloInsumoDto toDTO(ArticuloInsumo entity) {
        if ( entity == null ) {
            return null;
        }

        ArticuloInsumoDto articuloInsumoDto = new ArticuloInsumoDto();

        articuloInsumoDto.setId( entity.getId() );
        articuloInsumoDto.setEliminado( entity.isEliminado() );
        articuloInsumoDto.setFechaBaja( entity.getFechaBaja() );
        articuloInsumoDto.setDenominacion( entity.getDenominacion() );
        articuloInsumoDto.setPrecioVenta( entity.getPrecioVenta() );
        articuloInsumoDto.setImagenes( imagenArticuloSetToImagenDtoSet( entity.getImagenes() ) );
        articuloInsumoDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( entity.getUnidadMedida() ) );
        articuloInsumoDto.setCategoria( categoriaToCategoriaHijoDto( entity.getCategoria() ) );
        articuloInsumoDto.setPrecioCompra( entity.getPrecioCompra() );
        articuloInsumoDto.setStockActual( entity.getStockActual() );
        articuloInsumoDto.setStockMaximo( entity.getStockMaximo() );
        articuloInsumoDto.setStockMinimo( entity.getStockMinimo() );
        articuloInsumoDto.setEsParaElaborar( entity.getEsParaElaborar() );

        return articuloInsumoDto;
    }

    @Override
    public ArticuloManufacturadoDto toDTO(ArticuloManufacturado entity) {
        if ( entity == null ) {
            return null;
        }

        ArticuloManufacturadoDto articuloManufacturadoDto = new ArticuloManufacturadoDto();

        articuloManufacturadoDto.setId( entity.getId() );
        articuloManufacturadoDto.setEliminado( entity.isEliminado() );
        articuloManufacturadoDto.setFechaBaja( entity.getFechaBaja() );
        articuloManufacturadoDto.setDenominacion( entity.getDenominacion() );
        articuloManufacturadoDto.setPrecioVenta( entity.getPrecioVenta() );
        articuloManufacturadoDto.setImagenes( imagenArticuloSetToImagenDtoSet( entity.getImagenes() ) );
        articuloManufacturadoDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( entity.getUnidadMedida() ) );
        articuloManufacturadoDto.setCategoria( categoriaToCategoriaHijoDto( entity.getCategoria() ) );
        articuloManufacturadoDto.setDescripcion( entity.getDescripcion() );
        articuloManufacturadoDto.setTiempoEstimadoMinutos( entity.getTiempoEstimadoMinutos() );
        articuloManufacturadoDto.setPreparacion( entity.getPreparacion() );
        articuloManufacturadoDto.setArticuloManufacturadoDetalles( articuloManufacturadoDetalleSetToArticuloManufacturadoDetalleDtoSet( entity.getArticuloManufacturadoDetalles() ) );

        return articuloManufacturadoDto;
    }

    @Override
    public ArticuloManufacturado toEntity(ArticuloManufacturadoDto dto) {
        if ( dto == null ) {
            return null;
        }

        ArticuloManufacturado.ArticuloManufacturadoBuilder<?, ?> articuloManufacturado = ArticuloManufacturado.builder();

        articuloManufacturado.id( dto.getId() );
        articuloManufacturado.eliminado( dto.isEliminado() );
        articuloManufacturado.fechaBaja( dto.getFechaBaja() );
        articuloManufacturado.denominacion( dto.getDenominacion() );
        articuloManufacturado.precioVenta( dto.getPrecioVenta() );
        articuloManufacturado.imagenes( imagenDtoSetToImagenArticuloSet( dto.getImagenes() ) );
        articuloManufacturado.unidadMedida( unidadMedidaDtoToUnidadMedida( dto.getUnidadMedida() ) );
        articuloManufacturado.categoria( categoriaHijoDtoToCategoria( dto.getCategoria() ) );
        articuloManufacturado.descripcion( dto.getDescripcion() );
        articuloManufacturado.tiempoEstimadoMinutos( dto.getTiempoEstimadoMinutos() );
        articuloManufacturado.preparacion( dto.getPreparacion() );
        articuloManufacturado.articuloManufacturadoDetalles( articuloManufacturadoDetalleDtoSetToArticuloManufacturadoDetalleSet( dto.getArticuloManufacturadoDetalles() ) );

        return articuloManufacturado.build();
    }

    @Override
    public List<ArticuloInsumoDto> toDtoListInsumo(List<ArticuloInsumo> articulosInsumos) {
        if ( articulosInsumos == null ) {
            return null;
        }

        List<ArticuloInsumoDto> list = new ArrayList<ArticuloInsumoDto>( articulosInsumos.size() );
        for ( ArticuloInsumo articuloInsumo : articulosInsumos ) {
            list.add( toDTO( articuloInsumo ) );
        }

        return list;
    }

    @Override
    public List<ArticuloManufacturadoDto> toDtoListManufacturado(List<ArticuloManufacturado> articulosManufacturados) {
        if ( articulosManufacturados == null ) {
            return null;
        }

        List<ArticuloManufacturadoDto> list = new ArrayList<ArticuloManufacturadoDto>( articulosManufacturados.size() );
        for ( ArticuloManufacturado articuloManufacturado : articulosManufacturados ) {
            list.add( toDTO( articuloManufacturado ) );
        }

        return list;
    }

    protected Set<ImagenDto> imagenArticuloSetToImagenDtoSet(Set<ImagenArticulo> set) {
        if ( set == null ) {
            return null;
        }

        Set<ImagenDto> set1 = new LinkedHashSet<ImagenDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ImagenArticulo imagenArticulo : set ) {
            set1.add( imagenArticuloMapper.toDTO( imagenArticulo ) );
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

    protected Set<ImagenArticulo> imagenDtoSetToImagenArticuloSet(Set<ImagenDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ImagenArticulo> set1 = new LinkedHashSet<ImagenArticulo>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ImagenDto imagenDto : set ) {
            set1.add( imagenArticuloMapper.toEntity( imagenDto ) );
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

    protected Set<ArticuloManufacturadoDetalleDto> articuloManufacturadoDetalleSetToArticuloManufacturadoDetalleDtoSet(Set<ArticuloManufacturadoDetalle> set) {
        if ( set == null ) {
            return null;
        }

        Set<ArticuloManufacturadoDetalleDto> set1 = new LinkedHashSet<ArticuloManufacturadoDetalleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ArticuloManufacturadoDetalle articuloManufacturadoDetalle : set ) {
            set1.add( articuloManufacturadoDetalleMapper.toDTO( articuloManufacturadoDetalle ) );
        }

        return set1;
    }

    protected Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalleDtoSetToArticuloManufacturadoDetalleSet(Set<ArticuloManufacturadoDetalleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ArticuloManufacturadoDetalle> set1 = new LinkedHashSet<ArticuloManufacturadoDetalle>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleDto : set ) {
            set1.add( articuloManufacturadoDetalleMapper.toEntity( articuloManufacturadoDetalleDto ) );
        }

        return set1;
    }
}

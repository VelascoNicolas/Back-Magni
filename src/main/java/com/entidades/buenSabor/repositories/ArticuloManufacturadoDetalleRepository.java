package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ArticuloManufacturadoDetalleRepository extends BaseRepository<ArticuloManufacturadoDetalle,Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE ARTICULO_MANUFACTURADO_DETALLE SET ELIMINADO = true WHERE ARTICULO_MANUFACTURADO_ID = ?1", nativeQuery = true)
    void logicDelete(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ARTICULO_MANUFACTURADO_DETALLE SET ELIMINADO = false WHERE ARTICULO_MANUFACTURADO_ID = ?1", nativeQuery = true)
    void logicAlta(Long id);

    @Query(value = "SELECT EXISTS(\n" +
            "    SELECT 1\n" +
            "    FROM ARTICULO_MANUFACTURADO_DETALLE\n" +
            "    WHERE ARTICULO_INSUMO_ID = ?1\n" +
            ");", nativeQuery = true)
    boolean contiene(Long id);
}

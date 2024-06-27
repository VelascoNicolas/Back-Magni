package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {
    @Query(value = "SELECT *\n" +
            "FROM ARTICULO_INSUMO ai\n" +
            "JOIN ARTICULO a ON ai.ID = a.ID\n" +
            "WHERE a.CATEGORIA_ID = ?1", nativeQuery = true)
    List<ArticuloInsumo> getArticulosByCategoria(Long idCategoria);

    @Query(value = "SELECT * FROM ARTICULO_INSUMO ai JOIN ARTICULO a ON ai.ID = a.ID WHERE ES_PARA_ELABORAR = TRUE", nativeQuery = true)
    List<ArticuloInsumo> getElaborados();
    @Query(value = "SELECT * FROM ARTICULO_INSUMO ai JOIN ARTICULO a ON ai.ID = a.ID WHERE ES_PARA_ELABORAR = FALSE", nativeQuery = true)
    List<ArticuloInsumo> getNoElaborados();
}

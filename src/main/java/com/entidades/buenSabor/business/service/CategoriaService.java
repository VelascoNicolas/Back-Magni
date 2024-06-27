package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Categoria;

import java.util.List;

public interface CategoriaService extends BaseService<Categoria,Long> {
    String deleteByID(Long id);
    void asociarSucursalCategoria(Categoria categoria);

    List<Categoria> getCategoriasBySucursal(Long idSucursal);
    Categoria asociarSubcategoria(Long idCategoriaPadre, Categoria categoria);
    List<Categoria> getCategoriasByPadre(Long idCategoriaPadre);

    Categoria editado(Long id, Categoria categoria);
}

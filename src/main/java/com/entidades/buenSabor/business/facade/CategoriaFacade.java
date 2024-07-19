package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.CategoriaClaseDTO;
import com.entidades.buenSabor.domain.dto.CategoriaHijoDto;
import com.entidades.buenSabor.domain.dto.CategoriaPadreDto;

import java.util.List;

public interface CategoriaFacade extends BaseFacade<CategoriaPadreDto,Long> {
    String deleteByID(Long id);

    CategoriaHijoDto postCategoria(CategoriaPadreDto categoriaPadreDto);

    CategoriaHijoDto postCategoriaHijo(Long idCategoriaPadre, CategoriaHijoDto categoriaHijoDto);

    List<CategoriaHijoDto> getCategoriasByPadre(Long idCategoriaPadre);

    List<CategoriaClaseDTO> getCategoriasBySucursal(Long idSucursal);

    List<CategoriaHijoDto> getCategoriasPadre();

    CategoriaHijoDto putCategoria(Long id, CategoriaHijoDto categoriaHijoDto);
    CategoriaHijoDto putPadre(Long id, CategoriaPadreDto categoriaPadreDto);

}

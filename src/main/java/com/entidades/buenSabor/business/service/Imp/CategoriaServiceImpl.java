package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl extends BaseServiceImp<Categoria,Long> implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SucursalService sucursalService;

    @Override
    public String deleteByID(Long id) {
        if (categoriaRepository.existe(id) == false) {
            deleteById(id);
            return "CATEGORIA ELIMINADA CON EXITO";
        } else {
            return "NO SE PUEDE ELIMINAR POSEE ARTICULOS";
        }
    }

    @Override
    public List<Categoria> getCategoriasPadre() {
        return categoriaRepository.getCategoriasPadre();
    }


    @Override
    public List<Categoria> getCategoriasBySucursal(Long idSucursal) {
        return categoriaRepository.getCategoriasBySucursal(idSucursal);
    }

    @Override
    public Categoria asociarSubcategoria(Long idCategoriaPadre, Categoria categoriaHijo) {
        this.saveSucursal(categoriaHijo);
        Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).get();
        categoriaPadre.getSubCategorias().add(categoriaHijo);
        categoriaRepository.save(categoriaPadre);

        return categoriaHijo;
    }

    @Override
    public List<Categoria> getCategoriasByPadre(Long idCategoriaPadre) {
        Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).get();
        List<Categoria> hijos = new ArrayList();
        for(Categoria c : categoriaPadre.getSubCategorias()) {
            hijos.add(c);
        }
        return hijos;
    }

    @Override
    public Categoria saveSucursal(Categoria categoria) {
        Categoria save = categoriaRepository.save(categoria);
        for (Sucursal s : save.getSucursales()) {
            Sucursal x = sucursalService.getById(s.getId());
            x.getCategorias().add(save);
            sucursalService.update(x, x.getId());
        }
        return save;
    }

    @Override
    public Categoria editado(Long id, Categoria categoria) {
        Categoria c = categoriaRepository.findById(id).get();
        c.setDenominacion(categoria.getDenominacion());
        c.setEliminado(categoria.isEliminado());
        c.setSubCategorias(categoria.getSubCategorias());
        categoriaRepository.deleteSucursalCategoria(c.getId());
        c.setSucursales(categoria.getSucursales());
        for (Sucursal s : c.getSucursales()) {
            s.getCategorias().add(c);
        }
        categoriaRepository.save(c);
        return c;
    }
}

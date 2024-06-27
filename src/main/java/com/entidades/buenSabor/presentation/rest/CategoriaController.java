package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.CategoriaFacade;
import com.entidades.buenSabor.domain.dto.CategoriaHijoDto;
import com.entidades.buenSabor.domain.dto.CategoriaPadreDto;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*")
public class CategoriaController {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @Autowired
    private CategoriaFacade categoriaFacade;

    @GetMapping
    public ResponseEntity<List<CategoriaPadreDto>> getAll() {
        logger.info("INICIO GET ALL{}");
        return ResponseEntity.ok(categoriaFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        logger.info("INICIO GET BY Long {}", id);
        return ResponseEntity.ok(categoriaFacade.getById(id));
    }

    @PostMapping("/padre")
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaPadreDto categoriaPadreDto) {
        logger.info("INICIO CREATE {}", categoriaPadreDto.getClass());
        return ResponseEntity.ok(categoriaFacade.postCategoria(categoriaPadreDto));
    }

    @PostMapping("/hijo/{idCategoriaPadre}")
    public ResponseEntity<?> createCategoriaHijo(@PathVariable Long idCategoriaPadre, @RequestBody CategoriaHijoDto categoriaHijoDto) {
        logger.info("INICIO CREATE {}", categoriaHijoDto.getClass());
        return ResponseEntity.ok(categoriaFacade.postCategoriaHijo(idCategoriaPadre, categoriaHijoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
        logger.info("INICIO DELETE BY Long");
        return ResponseEntity.ok(categoriaFacade.deleteByID(id));
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<?>> getCategoriasBySucursal(@PathVariable Long id) {
        logger.info("INICIO GET CATEGORIAS BY SUCURSAL");
        return ResponseEntity.ok(categoriaFacade.getCategoriasBySucursal(id));
    }

    @GetMapping("/padre/{id}")
    public ResponseEntity<List<?>> getCategoriasByPadre(@PathVariable Long id) {
        logger.info("INICIO GET CATEGORIAS BY PADRE");
        return ResponseEntity.ok(categoriaFacade.getCategoriasByPadre(id));
    }

    @PutMapping("/padre/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable Long id, @RequestBody CategoriaPadreDto categoriaPadreDto) {
        logger.info("INICIO UPDATE CATEGORIA PADRE");
        return ResponseEntity.ok(categoriaFacade.putPadre(id, categoriaPadreDto));
    }

    @PutMapping("hijo/{id}")
    public ResponseEntity<?> updateCategoriaHijo(@PathVariable Long id, @RequestBody CategoriaHijoDto categoriaHijoDto) {
        logger.info("INICIO UPDATE CATEGORIA HIJO");
        return ResponseEntity.ok(categoriaFacade.putCategoria(id, categoriaHijoDto));
    }
}

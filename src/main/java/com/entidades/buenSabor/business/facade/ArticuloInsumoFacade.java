package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface ArticuloInsumoFacade  {
    public ArticuloInsumoDto createNew(ArticuloInsumoDto request);
    public ArticuloInsumoDto getById(Long id);
    public List<ArticuloInsumoDto> getAll();
    public String deleteById(Long id);
    public ArticuloInsumoDto update(ArticuloInsumoDto request, Long id);
    public List<ArticuloInsumoDto> getArticuloInsumoBySucursal(Long idSucursal);

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);

    public List<ArticuloInsumoDto> getElaborados();
    public List<ArticuloInsumoDto> getNoElaborados();
}

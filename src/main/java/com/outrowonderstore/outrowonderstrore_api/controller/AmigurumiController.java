package com.outrowonderstore.outrowonderstrore_api.controller;

import com.outrowonderstore.outrowonderstrore_api.dto.AmigurumiDto;
import com.outrowonderstore.outrowonderstrore_api.service.AmigurumiService;
import com.outrowonderstore.outrowonderstrore_api.service.StorageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/amigurumis")
@RequiredArgsConstructor
public class AmigurumiController {
    private final AmigurumiService service;
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<List<AmigurumiDto>> getAllAmigurumi() {
        return ResponseEntity.ok(service.getAllAmigurumi());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmigurumiDto> getAmigurumiById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAmigurumiById(id));
    }

    @PostMapping
    public ResponseEntity<AmigurumiDto> createAmigurumi(@Valid @RequestBody AmigurumiDto amigurumi) {
        return  new ResponseEntity<>(service.saveAmigurumi(amigurumi),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AmigurumiDto> deleteAmigurumi(@PathVariable Long id) {
        service.deleteAmigurumi(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmigurumiDto> updateAmigurumi(@PathVariable Long id, @Valid @RequestBody AmigurumiDto dto) {
        return ResponseEntity.ok(service.updateAmigurumi(id, dto));
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<AmigurumiDto> uploadImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {

        // 1. Subir la imagen a Oracle y obtener la URL pública
        String imageUrl = storageService.uploadFile(file);

        // 2. Buscar el Amigurumi al que le pertenece esta foto
        AmigurumiDto amigurumiDto = service.getAmigurumiById(id);

        // 3. Actualizarle la URL al Amigurumi
        amigurumiDto.setImageUrl(imageUrl);

        // 4. Guardar los cambios en la base de datos
        AmigurumiDto updatedAmigurumi = service.updateAmigurumi(id, amigurumiDto);

        // 5. Devolver el amigurumi actualizado con su nueva URL
        return ResponseEntity.ok(updatedAmigurumi);

    }
}

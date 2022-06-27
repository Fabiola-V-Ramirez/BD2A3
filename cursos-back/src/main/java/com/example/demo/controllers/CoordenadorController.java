package com.example.demo.controllers;

import com.example.demo.controllers.dtos.CoordenadorDTO;
import com.example.demo.services.CoordenadoresService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coordenadores")
@AllArgsConstructor
public class CoordenadorController {

    private final CoordenadoresService service;

    private final ConversionService conversionService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id) {
        CoordenadorDTO dto = this.service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/all")
    public @ResponseBody
    Page<CoordenadorDTO> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ) {
        if(query==null) {
            return this.service.findAll(pageable).map(entity -> this.conversionService.convert(entity, CoordenadorDTO.class));
        }
        return this.service.findAll(pageable, query).map(entity -> this.conversionService.convert(entity, CoordenadorDTO.class));
    }

}

package com.example.demo.controllers;

import com.example.demo.controllers.dtos.CursoDTO;
import com.example.demo.controllers.forms.CursoForm;
import com.example.demo.services.CursosService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor
public class CursoController {

    private final CursosService service;

    private final ConversionService conversionService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id) {
        CursoDTO dto = this.service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/all")
    public @ResponseBody
    Page<CursoDTO> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ) {
        if(query==null) {
            return this.service.findAll(pageable).map(entity -> this.conversionService.convert(entity, CursoDTO.class));
        }
        return this.service.findAll(pageable, query).map(entity -> this.conversionService.convert(entity, CursoDTO.class));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> createCurso (@RequestBody CursoForm form) {
        this.service.createCurso(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateCurso (@PathVariable Long id, @RequestBody CursoForm form) {
        this.service.updateCurso(id, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurso (@PathVariable Long id) {
        this.service.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

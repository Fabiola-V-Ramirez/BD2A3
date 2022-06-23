package com.example.demo.controllers;

import com.example.demo.controllers.dtos.DisciplinaDTO;
import com.example.demo.controllers.forms.DisciplinaForm;
import com.example.demo.services.DisciplinasService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/disciplinas")
@AllArgsConstructor
public class DisciplinaController {

    private final DisciplinasService service;

    private final ConversionService conversionService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id) {
        DisciplinaDTO dto = this.service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/all")
    public @ResponseBody
    Page<DisciplinaDTO> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ) {
        if(query==null) {
            return this.service.findAll(pageable).map(entity -> this.conversionService.convert(entity, DisciplinaDTO.class));
        }
        return this.service.findAll(pageable, query).map(entity -> this.conversionService.convert(entity, DisciplinaDTO.class));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> createDisciplina (@RequestBody DisciplinaForm form) {
        this.service.createDisciplina(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateDisciplina (@PathVariable Long id, @RequestBody DisciplinaForm form) {
        this.service.updateDisciplina(id, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDisciplina (@PathVariable Long id) {
        this.service.deleteDisciplina(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

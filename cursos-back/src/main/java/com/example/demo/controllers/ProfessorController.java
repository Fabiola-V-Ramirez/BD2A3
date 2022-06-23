package com.example.demo.controllers;

import com.example.demo.controllers.dtos.ProfessorDTO;
import com.example.demo.controllers.forms.ProfessorForm;
import com.example.demo.services.ProfessoresService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/professores")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessoresService service;

    private final ConversionService conversionService;

    @GetMapping("/{matricula}")
    public ResponseEntity<?> getByMatricula (@PathVariable Long matricula) {
        ProfessorDTO dto = this.service.findByMatricula(matricula);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/all")
    public @ResponseBody
    Page<ProfessorDTO> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ) {
        if(query==null) {
            return this.service.findAll(pageable).map(entity -> this.conversionService.convert(entity, ProfessorDTO.class));
        }
        return this.service.findAll(pageable, query).map(entity -> this.conversionService.convert(entity, ProfessorDTO.class));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> createProfessor (@RequestBody ProfessorForm form) {
        this.service.createProfessor(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{matricula}")
    @Transactional
    public ResponseEntity<?> updateProfessor (@PathVariable Long matricula, @RequestBody ProfessorForm form) {
        this.service.updateProfessor(matricula, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<?> deleteProfessor (@PathVariable Long matricula) {
        this.service.deleteProfessor(matricula);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


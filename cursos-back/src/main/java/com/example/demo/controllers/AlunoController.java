package com.example.demo.controllers;

import com.example.demo.controllers.dtos.AlunoDTO;
import com.example.demo.controllers.forms.AlunoForm;
import com.example.demo.services.AlunosService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping ("/api/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunosService service;

    private final ConversionService conversionService;

    @GetMapping("/{matricula}")
    public ResponseEntity<?> getByMatricula (@PathVariable Long matricula) {
        AlunoDTO dto = this.service.findByMatricula(matricula);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/all")
    public @ResponseBody
    Page<AlunoDTO> findAllPaginated(
           @RequestParam(required = false) String query,
           Pageable pageable
    ) {
        if(query==null) {
            return this.service.findAll(pageable).map(entity -> this.conversionService.convert(entity, AlunoDTO.class));
        }
        return this.service.findAll(pageable, query).map(entity -> this.conversionService.convert(entity, AlunoDTO.class));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> createAluno (@RequestBody AlunoForm form) {
        this.service.createAluno(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{matricula}")
    @Transactional
    public ResponseEntity<?> updateAluno (@PathVariable Long matricula, @RequestBody AlunoForm form) {
        this.service.updateAluno(matricula, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<?> deleteAluno (@PathVariable Long matricula) {
        this.service.deleteAluno(matricula);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

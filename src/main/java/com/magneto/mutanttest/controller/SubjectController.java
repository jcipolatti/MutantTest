package com.magneto.mutanttest.controller;

import com.magneto.mutanttest.model.SubjectModel;
import com.magneto.mutanttest.repository.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SubjectController {

    final
    SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @PostMapping("/mutant/")
    public ResponseEntity postMutant(@Valid @RequestBody SubjectModel subjectModel){

        subjectRepository.save(subjectModel);

        return (subjectModel.isMutant())
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}

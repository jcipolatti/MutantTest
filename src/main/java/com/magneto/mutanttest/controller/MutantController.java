package com.magneto.mutanttest.controller;

import com.magneto.mutanttest.object.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {
    @PostMapping("/mutant/")
    public ResponseEntity postMutant(@RequestBody Subject subject){
        return (subject.isMutant())
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}

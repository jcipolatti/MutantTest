package com.magneto.mutanttest.controller;

import com.magneto.mutanttest.model.DnaModel;
import com.magneto.mutanttest.model.StatsModel;
import com.magneto.mutanttest.repository.DnaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DnaController {

    final
    DnaRepository dnaRepository;

    public DnaController(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    @PostMapping("/mutant/")
    public ResponseEntity postMutant(@Valid @RequestBody DnaModel dnaModel){

        dnaRepository.save(dnaModel);

        return (dnaModel.isMutant())
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/stats")
    @ResponseBody
    public StatsModel getStats(){
        Long mutantCount = dnaRepository.getMutantCount();
        Long humanCount = dnaRepository.getHumanCount();

        StatsModel statsModel = new StatsModel(mutantCount, humanCount);
        return statsModel;
    }
}

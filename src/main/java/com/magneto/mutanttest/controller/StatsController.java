package com.magneto.mutanttest.controller;

import com.magneto.mutanttest.model.StatsModel;
import com.magneto.mutanttest.repository.SubjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    final
    SubjectRepository subjectRepository;

    public StatsController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/stats")
    @ResponseBody
    public StatsModel getStats(){
        Long mutantCount = subjectRepository.getMutantCount();
        Long humanCount = subjectRepository.getHumanCount();

        StatsModel statsModel = new StatsModel(mutantCount, humanCount);
        return statsModel;
    }
}

package com.magneto.mutanttest.repository;

import com.magneto.mutanttest.model.SubjectModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository
        extends CrudRepository<SubjectModel, String> {

        @Query("SELECT " +
                "    COUNT(s) " +
                "FROM " +
                "    SubjectModel s " +
                "WHERE " +
                "    s.isMutant = true")
        Long getMutantCount();

        @Query("SELECT " +
                "    COUNT(s) " +
                "FROM " +
                "    SubjectModel s " +
                "WHERE " +
                "    s.isMutant = false ")
        Long getHumanCount();
}
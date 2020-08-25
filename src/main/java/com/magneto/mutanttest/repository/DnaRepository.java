package com.magneto.mutanttest.repository;

import com.magneto.mutanttest.model.DnaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository
        extends CrudRepository<DnaModel, String> {

        @Query("SELECT " +
                "    COUNT(s) " +
                "FROM " +
                "    DnaModel s " +
                "WHERE " +
                "    s.isMutant = true")
        Long getMutantCount();

        @Query("SELECT " +
                "    COUNT(s) " +
                "FROM " +
                "    DnaModel s " +
                "WHERE " +
                "    s.isMutant = false ")
        Long getHumanCount();
}
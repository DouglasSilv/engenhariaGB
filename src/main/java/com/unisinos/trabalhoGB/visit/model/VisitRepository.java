package com.unisinos.trabalhoGB.visit.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, String> {

    List<Visit> findAllByAprovedIsFalseAndReprovedAtIsNull();

}

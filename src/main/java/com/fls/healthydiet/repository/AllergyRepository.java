package com.fls.healthydiet.repository;

import com.fls.healthydiet.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Integer> {
}

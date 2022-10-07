package com.algodomain_solutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algodomain_solutions.entity.Charges;

@Repository
public interface ChargesRepository extends JpaRepository<Charges , Long> {

}

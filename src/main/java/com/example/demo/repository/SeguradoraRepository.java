package com.example.demo.repository;

import com.example.demo.model.Seguradora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguradoraRepository extends JpaRepository<Seguradora, Integer> {
}

package com.outrowonderstore.outrowonderstrore_api.repository;

import com.outrowonderstore.outrowonderstrore_api.model.Amigurumi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmigurumiRepository extends JpaRepository<Amigurumi, Long> {
}

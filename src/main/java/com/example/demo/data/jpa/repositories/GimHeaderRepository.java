package com.example.demo.data.jpa.repositories;

import com.example.demo.data.jpa.entities.GimHeaderHbn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GimHeaderRepository extends CrudRepository<GimHeaderHbn, String> {
    List<GimHeaderHbn> findAllByCdLength(Integer cdLength);
}
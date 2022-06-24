package com.example.demo.data.jpa.repositories;

import com.example.demo.data.jpa.entities.GimDetailHbn;
import com.example.demo.data.jpa.entities.GimDetailHbnId;
import org.springframework.data.repository.CrudRepository;

public interface GimDetailRepository extends CrudRepository<GimDetailHbn, GimDetailHbnId> {
}
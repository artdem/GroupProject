package com.example.demo.repositores;

import com.example.demo.entity.Purchaser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaserRepository extends CrudRepository<Purchaser, String> {
    List<Purchaser> findAll();
}

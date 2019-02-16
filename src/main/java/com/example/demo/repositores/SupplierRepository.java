package com.example.demo.repositores;

import com.example.demo.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findAll();

    void deleteBySupplierName(String supplierName);
}

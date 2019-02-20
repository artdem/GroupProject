package com.example.demo.repositores;

import com.example.demo.entity.Lack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LackRepository extends CrudRepository<Lack, Long> {

    List<Lack> findByForwarderID(Long forwarderID);
    List<Lack> findByPurchaserID(Long purchaserID);
    List<Lack> findBySupplierID(Long supplierID);
    List<Lack> findAll();
}

package com.example.demo.repositores;

import com.example.demo.entity.Lack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LackRepository extends CrudRepository<Lack, String> {

    List<Lack> findByForwarderID(String forwarderID);
    List<Lack> findByPurchaserID(String purchaserID);
    List<Lack> findBySupplierID(String supplierID);
}

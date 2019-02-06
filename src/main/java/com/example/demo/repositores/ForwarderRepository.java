package com.example.demo.repositores;

import com.example.demo.entity.Forwarder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ForwarderRepository extends CrudRepository<Forwarder, String> {
    List<Forwarder> findAll();

}

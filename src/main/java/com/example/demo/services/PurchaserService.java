package com.example.demo.services;

import com.example.demo.entity.Purchaser;
import com.example.demo.repositores.PurchaserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaserService {

    private final PurchaserRepository purchaserRepository;
    private PurchaserService(PurchaserRepository purchaserRepository){
        this.purchaserRepository = purchaserRepository;
    }

    public List<Purchaser> getAll(){
        return purchaserRepository.findAll();
    }
}

package com.example.demo.services;

import com.example.demo.entity.Purchaser;
import com.example.demo.models.PurchaserDTO;
import com.example.demo.repositores.PurchaserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaserService {

    private final PurchaserRepository purchaserRepository;
    private PurchaserService(PurchaserRepository purchaserRepository){
        this.purchaserRepository = purchaserRepository;
    }

    public List<PurchaserDTO> getAll(){
        return purchaserRepository.findAll().stream().map(this::purchaserToDTO).collect(Collectors.toList());
    }

    public void save(PurchaserDTO purchaserDTO){
        purchaserRepository.save(dtoToPurchaser(purchaserDTO));
    }

    public void delete(Purchaser purchaser){
        purchaserRepository.deleteById(purchaser.getPurchaserID());
    }

    public PurchaserDTO findByID(String id){
        return purchaserToDTO(purchaserRepository.findById(id).get());
    }

    Purchaser dtoToPurchaser(PurchaserDTO purchaserDTO) {
        var purchaser = new Purchaser();
        BeanUtils.copyProperties(purchaserDTO, purchaser);
        return purchaser;
    }

    PurchaserDTO purchaserToDTO(Purchaser purchaser) {
        var purchaserDTO = new PurchaserDTO();
        BeanUtils.copyProperties(purchaser, purchaserDTO);
        return purchaserDTO;
    }
}

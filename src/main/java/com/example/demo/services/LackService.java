package com.example.demo.services;

import com.example.demo.entity.Lack;
import com.example.demo.models.ForwarderDTO;
import com.example.demo.models.LackDTO;
import com.example.demo.models.PurchaserDTO;
import com.example.demo.models.SupplierDTO;
import com.example.demo.repositores.LackRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LackService {

    private final LackRepository lackRepository;
    private LackService(LackRepository lackRepository){
        this.lackRepository = lackRepository;
    }

    public List<LackDTO> getForwarderLacks(ForwarderDTO forwarder){
        return lackRepository.findByForwarderID(forwarder.getForwarderID()).stream().map(this::lackToDTO).collect(Collectors.toList());
    }
    public List<LackDTO> getPurchaserLacks(PurchaserDTO purchaser){
        return lackRepository.findByPurchaserID(purchaser.getPurchaserID()).stream().map(this::lackToDTO).collect(Collectors.toList());
    }
    public List<LackDTO> getSupplierLacks(SupplierDTO supplier){
        return lackRepository.findBySupplierID(supplier.getSupplierID()).stream().map(this::lackToDTO).collect(Collectors.toList());
    }

    public void save(LackDTO lackDTO){
        lackRepository.save(dtoToLack(lackDTO));
    }

    public List<LackDTO> delete(List<String> listID){
        List<LackDTO> lista = new ArrayList<>();
        for (String del:listID){
            lista.add(lackToDTO(lackRepository.findById(del).get()));
            lackRepository.deleteById(del);
        }
        return lista;
    }

    public LackDTO findByID(String id){
        return lackToDTO(lackRepository.findById(id).get());
    }




    Lack dtoToLack(LackDTO lackDTO) {
        var lack = new Lack();
        BeanUtils.copyProperties(lackDTO, lack);
        return lack;
    }

    LackDTO lackToDTO(Lack lack) {
        var lackDTO = new LackDTO();
        BeanUtils.copyProperties(lack, lackDTO);
        return lackDTO;
    }

}

package com.example.demo.services;

import com.example.demo.entity.Forwarder;
import com.example.demo.models.ForwarderDTO;
import com.example.demo.models.LackDTO;
import com.example.demo.models.LackStatus;
import com.example.demo.models.SupplierDTO;
import com.example.demo.repositores.ForwarderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForwarderService {

    private final ForwarderRepository forwarderRepository;
    private final LackService lackService;
    private final SupplierService supplierService;
    private ForwarderService(ForwarderRepository forwarderRepository, LackService lackService, SupplierService supplierService){
        this.forwarderRepository = forwarderRepository;
        this.lackService = lackService;
        this.supplierService = supplierService;
    }

    public List<ForwarderDTO> getAll(){
        return forwarderRepository.findAll().stream().map(this::forwarderToDTO).collect(Collectors.toList());
    }

    public ForwarderDTO findById(String id){
        return forwarderToDTO(forwarderRepository.findById(id).get());
    }

    public void save(ForwarderDTO forwarderDTO){
        forwarderRepository.save(dtoToForwarder(forwarderDTO));
    }

    public void delete(Forwarder forwarder){
        forwarderRepository.deleteById(forwarder.getForwarderID());
    }

    public void saveLack(LackDTO lackDTO){
        lackDTO.setForwarderID("szczur1");
        lackDTO.setLacksSetDateAndTime(LocalDate.now());
        lackDTO.setStatus(LackStatus.NEW);
        lackDTO.setPurchaserID(supplierService.findByID(lackDTO.getSupplierID()).getPurchaserID());
        lackService.save(lackDTO);
    }

    Forwarder dtoToForwarder(ForwarderDTO forwarderDTO) {
        var forwarder = new Forwarder();
        BeanUtils.copyProperties(forwarderDTO, forwarder);
        return forwarder;
    }

    ForwarderDTO forwarderToDTO(Forwarder forwarder) {
        var forwarderDTO = new ForwarderDTO();
        BeanUtils.copyProperties(forwarder, forwarderDTO);
        return forwarderDTO;
    }
}

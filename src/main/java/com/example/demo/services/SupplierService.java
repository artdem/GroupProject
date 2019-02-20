package com.example.demo.services;

import com.example.demo.entity.Supplier;
import com.example.demo.models.SupplierDTO;
import com.example.demo.repositores.SupplierRepository;
import com.example.demo.repositores.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private SupplierService(SupplierRepository supplierRepository, UserRepository userRepository){
        this.supplierRepository = supplierRepository;
        this.userRepository = userRepository;
    }

    public List<SupplierDTO> getAll(){
        return supplierRepository.findAll().stream().map(this::supplierToDTO).collect(Collectors.toList());
    }

    public List<SupplierDTO> findByName(String supplierName){
        return supplierRepository.findBySupplierName(supplierName).stream().map(this::supplierToDTO).collect(Collectors.toList());
    }

    public void save(SupplierDTO supplierDTO){
        supplierDTO.setPurchaserName(userRepository.findById(supplierDTO.getPurchaserID()).get().getUserName());
        supplierRepository.save(dtoToSupplier(supplierDTO));
    }

    public SupplierDTO findByID(Long id){
        return supplierToDTO(supplierRepository.findById(id).get());
    }

    public void delete(Supplier supplier){
        supplierRepository.deleteById(supplier.getSupplierID());
    }

    Supplier dtoToSupplier(SupplierDTO supplierDTO) {
        var supplier = new Supplier();
        BeanUtils.copyProperties(supplierDTO, supplier);
        return supplier;
    }

    SupplierDTO supplierToDTO(Supplier supplier) {
        var supplierDTO = new SupplierDTO();
        BeanUtils.copyProperties(supplier, supplierDTO);
        return supplierDTO;
    }


}

package com.example.demo.services;

import com.example.demo.entity.Supplier;
import com.example.demo.models.SupplierDTO;
import com.example.demo.repositores.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getAll(){
        return supplierRepository.findAll().stream().map(this::supplierToDTO).collect(Collectors.toList());
    }

    public void save(SupplierDTO supplierDTO){
        supplierRepository.save(dtoToSupplier(supplierDTO));
    }

    public SupplierDTO findByID(String id){
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

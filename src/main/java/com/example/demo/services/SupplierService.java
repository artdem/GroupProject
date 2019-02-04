package com.example.demo.services;

import com.example.demo.entity.Supplier;
import com.example.demo.models.SupplierDTO;
import com.example.demo.repositores.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    public void save(SupplierDTO supplierDTO){
        supplierRepository.save(dtoToSupplier(supplierDTO));
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

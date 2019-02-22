package com.example.demo.services;

import com.example.demo.entity.Lack;
import com.example.demo.models.*;
import com.example.demo.repositores.LackRepository;
import com.example.demo.repositores.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LackService {

    private final LackRepository lackRepository;
    private final SmsSender smsSender;
    private final UserRepository userRepository;
    private final EmailSender emailSender;
    private LackService(LackRepository lackRepository, SmsSender smsSender, UserRepository userRepository, EmailSender emailSender){
        this.lackRepository = lackRepository;
        this.smsSender = smsSender;
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public List<LackDTO> getAllLacks(){
        return lackRepository.findAll().stream().map(this::lackToDTO).collect(Collectors.toList());
    }

    public List<LackDTO> getForwarderLacks(UserDTO forwarder){
        return lackRepository.findByForwarderID(forwarder.getUserID()).stream().map(this::lackToDTO).collect(Collectors.toList());
    }
    public List<LackDTO> getPurchaserLacks(UserDTO purchaser){
        return lackRepository.findByPurchaserID(purchaser.getUserID()).stream().map(this::lackToDTO).collect(Collectors.toList());
    }
    public List<LackDTO> getSupplierLacks(SupplierDTO supplier){
        return lackRepository.findBySupplierID(supplier.getSupplierID()).stream().map(this::lackToDTO).collect(Collectors.toList());
    }

    public void save(LackDTO lackDTO){
        lackRepository.save(dtoToLack(lackDTO));

        // twilio.com account required:

//        smsSender.sendSMS(purchaserRepository.findById(lackDTO.getPurchaserID()).get().getPhoneNumber(),
//                "Brak: " + lackDTO.getItem()
//                        + ", data: " + lackDTO.getLacksSetDateAndTime()
//                        + ", ilość: " + lackDTO.getRequiredAmount());
        
        emailSender.sendEmail(userRepository.findById(lackDTO.getPurchaserID()).get().getLogin(),
                lackDTO.getItem() + " " + lackDTO.getLacksSetDateAndTime(),
                "Brak: " + lackDTO.getItem()
                        + ", data: " + lackDTO.getLacksSetDateAndTime()
                        + ", brakująca ilość: " + lackDTO.getRequiredAmount());
    }

    public void update(LackDTO lackDTO){
        lackRepository.save(dtoToLack(lackDTO));
        emailSender.sendEmail(userRepository.findById(lackDTO.getForwarderID()).get().getLogin(),
                lackDTO.getItem() + " " + lackDTO.getLacksSetDateAndTime(),
                "Uwaga zaaktualizowano brak: " + lackDTO.getItem());
    }

    public List<LackDTO> delete(List<Long> listID){
        List<LackDTO> lista = new ArrayList<>();
        for (Long del:listID){
            lista.add(lackToDTO(lackRepository.findById(del).get()));
            lackRepository.deleteById(del);
        }
        return lista;
    }

    public LackDTO findByID(Long id){
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

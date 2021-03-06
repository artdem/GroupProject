package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.models.LackDTO;
import com.example.demo.models.LackStatus;
import com.example.demo.models.Role;
import com.example.demo.models.UserDTO;
import com.example.demo.repositores.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final LackService lackService;
    private final SupplierService supplierService;
    private UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, LackService lackService, SupplierService supplierService){
        this.userRepository = userRepository;
        this.lackService = lackService;
        this.supplierService = supplierService;
        this.passwordEncoder = passwordEncoder;
        if(userRepository.findByLogin("admin@admin.com").isEmpty()){
            User admin = new User();
            admin.setUserName("admin");
            admin.setLogin("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRole("ROLE_ADMIN");
            System.out.println(admin);
            userRepository.save(admin);
        }
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream().map(this::userToDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getAllByRole(Role role){
        return userRepository.getAllByRole(role.toString()).stream().map(this::userToDTO).collect(Collectors.toList());
    }

    public void saveUser(UserDTO userDTO, String role){
        userDTO.setRole(role);
        String passwordToCode = userDTO.getPassword();
        userDTO.setPassword(passwordEncoder.encode(passwordToCode));
        userRepository.save(dtoToUser(userDTO));
    }

    public void deleteUser(UserDTO userDTO){
        userRepository.deleteById(userDTO.getUserID());
    }

    public UserDTO findByID(Long id){
        return userToDTO(userRepository.findById(id).get());
    }

    public UserDTO findByLogin(String login){
        if(userRepository.findByLogin(login).isPresent()){
            return userToDTO(userRepository.findByLogin(login).get());
        }
        throw new IllegalArgumentException("No user with login:" + login + " found!");
    }

    public void updateLack(LackDTO lackDTO){
        lackService.update(lackDTO);
    }

    public void saveLack(LackDTO lackDTO, Principal principal){
        lackDTO.setForwarderID(userRepository.findByLogin(principal.getName()).get().getUserID());
        lackDTO.setForwarderName(userRepository.findByLogin(principal.getName()).get().getUserName());
        lackDTO.setLacksSetDateAndTime(LocalDate.now());
        lackDTO.setStatus(LackStatus.NEW);
        lackDTO.setPurchaserID(supplierService.findByID(lackDTO.getSupplierID()).getPurchaserID());
        lackDTO.setPurchaserName(userRepository.findById(lackDTO.getPurchaserID()).get().getUserName());
        lackDTO.setSupplierName(supplierService.findByID(lackDTO.getSupplierID()).getSupplierName());
        lackService.save(lackDTO);
    }

    User dtoToUser(UserDTO userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    UserDTO userToDTO(User user) {
        var userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
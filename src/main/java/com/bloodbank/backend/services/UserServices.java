package com.bloodbank.backend.services;
import com.bloodbank.backend.dto.CreateUserDto;
import com.bloodbank.backend.dto.RegisterDTO;
import com.bloodbank.backend.dto.UserDTO;
import com.bloodbank.backend.model.Admin;
import com.bloodbank.backend.model.Donneur;
import com.bloodbank.backend.model.Role;
import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.AdminRepository;
import com.bloodbank.backend.repository.DonorRepository;
import com.bloodbank.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@Service
public class UserServices {

    private final AdminRepository adminRepository;
    private final DonorRepository donorRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final UserRepository userRepository;

    public UserServices(AdminRepository adminRepository, DonorRepository donorRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.donorRepository = donorRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> register(RegisterDTO dto) {
        try {
            User user = registerUser(dto);
            return ResponseEntity.ok("Utilisateur enregistré avec succès : " + user.getEmail());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de l'enregistrement");
        }
    }

    public User registerUser(RegisterDTO dto) {
        User newUser;

        String encryptedPassword = encoder.encode(dto.password());

        switch (dto.role()) {
            case ADMIN -> {
                Admin admin = new Admin();
                admin.setFirstName(dto.firstName());
                admin.setLastName(dto.lastName());
                admin.setEmail(dto.email());
                admin.setPassword(encryptedPassword);
                admin.setRole(Role.ADMIN);
                newUser = adminRepository.save(admin);
            }
            case DONOR -> {
                Donneur donneur = new Donneur();
                donneur.setFirstName(dto.firstName());
                donneur.setLastName(dto.lastName());
                donneur.setEmail(dto.email());
                donneur.setPassword(encryptedPassword);
                donneur.setRole(Role.DONOR);
                newUser = donorRepository.save(donneur);
            }

            default -> throw new IllegalArgumentException("Rôle non supporté : " + dto.role());
        }

        return newUser;
    }

    public List<UserDTO> getAllUsers () {
        List<UserDTO> admins = adminRepository.findAll().stream()
                .map(a -> new UserDTO(a.getId(), a.getFirstName(), a.getLastName(), a.getEmail(), "ADMIN"))
                .toList();

        List<UserDTO> donors = donorRepository.findAll().stream()
                .map(d -> new UserDTO(d.getId(), d.getFirstName(), d.getLastName(), d.getEmail(), "DONOR"))
                .toList();

        return Stream.concat(admins.stream(), donors.stream()).toList();
    }


    public ResponseEntity<?> createUserByAdmin(CreateUserDto dto) {
        try{
            User user;
            String encryptedPassword = encoder.encode(dto.password());
            switch (dto.role()) {
                case ADMIN -> {
                    Admin admin = new Admin();
                    admin.setFirstName(dto.firstName());
                    admin.setLastName(dto.lastName());
                    admin.setEmail(dto.email());
                    admin.setPassword(encryptedPassword);
                    user = adminRepository.save(admin);
                }
                case DONOR -> {
                    Donneur donneur = new Donneur();
                    donneur.setFirstName(dto.firstName());
                    donneur.setLastName(dto.lastName());
                    donneur.setEmail(dto.email());
                    donneur.setPassword(encryptedPassword);
                    user = donorRepository.save(donneur);

                }
                default -> throw new IllegalArgumentException("Role not supported.");
            }

            return ResponseEntity.ok("Utilisateur bien ajouté " + user.getFirstName() + " " + user.getEmail());

        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

//    public User UpdateUser(Long id,UpdateUserDto dto) {
//        User ExistingUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("user intouvable"));
//
//        ExistingUser.setFirstName(dto.firstName());
//        ExistingUser.setLastName(dto.lastName());
//        ExistingUser.setEmail(dto.email());
//        if(dto.password() != null && !dto.password().isEmpty()){
//            ExistingUser.setPassword(encoder.encode(dto.password()));
//        }
//        ExistingUser.setRole(dto.role());
//
//        return userRepository.save(ExistingUser);
//    }
//
//    public void deleteUser(Long id){
//        userRepository.deleteById(id);
//    }
//
//    public Long getSenderIdByEmail(String email) {
//        Sender sender = senderRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("Sender not found"));
//        return sender.getId();
//    }


}

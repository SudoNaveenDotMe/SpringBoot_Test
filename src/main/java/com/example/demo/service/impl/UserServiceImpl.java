package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.enumaration.UserStatus;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser() {
        log.info("Execute method saveUser()");

        User user = new User();
        user.setFirstName("Lilanga");
        user.setLastName("MG");
        user.setDob(new Date());
        user.setUserStatus(UserStatus.ACTIVE);

        User saveUser = userRepository.save(user);

        UserDTO responseDTO = new UserDTO();

        responseDTO.setFirstName(saveUser.getFirstName());
        responseDTO.setLastName(saveUser.getLastName());
        responseDTO.setDob(saveUser.getDob());
        responseDTO.setUserStatus(saveUser.getUserStatus());

        log.info("Saved user returned...");
        return responseDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Execute method getUsers");
        try{
            List<UserDTO> responseList = new ArrayList<>();
            List<User> userList = userRepository.findAll();

            for (User user : userList){
                UserDTO dto = new UserDTO();
                dto.setUserId(user.getUserId());
                dto.setFirstName(user.getFirstName());
                dto.setLastName(user.getLastName());
                dto.setDob(user.getDob());
                dto.setUserStatus(user.getUserStatus());

                responseList.add(dto);
            }

            return responseList;

        }catch (Exception e){
            log.info("Error in method getUsers :" + e.getMessage());
            throw e;
        }
    }
}

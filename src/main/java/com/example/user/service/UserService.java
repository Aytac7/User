package com.example.user.service;

import com.example.user.dto.ProfileDTO;
import com.example.user.dto.UserResponseDTO;
import com.example.user.entity.UserEntity;
import com.example.user.exception.UserNotFoundException;
import com.example.user.feignClient.ProfileClient;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProfileClient profileClient;
    private final ModelMapper modelMapper;

    public UserResponseDTO getUserWithProfile(Long id){
        UserEntity user= userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(),"user not found"));
        ProfileDTO profile =null;
        if(user.getProfileId()!=null){
            try {
                profile = profileClient.getProfileById(user.getProfileId());
            }
            catch (Exception e){
                log.error("Error fetching profile for userId: {} - {}", id, e.getMessage());
            }
        }
        UserResponseDTO response=modelMapper.map(user, UserResponseDTO.class);
        response.setProfile(profile);
        return response;

    }

}

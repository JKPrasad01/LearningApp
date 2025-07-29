package com.example.LearningApp.service.serviceImpl;

import com.example.LearningApp.dto.UserDto;
import com.example.LearningApp.entity.User;
import com.example.LearningApp.exception.UserNotFoundException;
import com.example.LearningApp.repository.UserRepository;
import com.example.LearningApp.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto createUser(UserDto userDto){
        userRepository.findByEmail(userDto.getEmail())
                .ifPresent(user -> {
                    throw new UserNotFoundException("User already exists with email: " + userDto.getEmail());
                });   User user=modelMapper.map(userDto,User.class);
        User saved =userRepository.save(user);
        return modelMapper.map(saved,UserDto.class);
    }

    public UserDto getUserById(Long userId){
        User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("user details not found"));
        return modelMapper.map(user,UserDto.class);
    }

    public UserDto getUserByEmail(String email){
        User user=userRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("user Details not found with this email ID : "+email));
        return modelMapper.map(user,UserDto.class);
    }
    public UserDto getUserByEmailAndPassword(String email,String password){
        User user=userRepository.findByEmailAndPassword(email,password).orElseThrow(()->new UserNotFoundException("user not found with email : "+email+" and password :"+password));
        return modelMapper.map(user,UserDto.class);
    }
    public UserDto updateUserById(Long userId,UserDto userDto){
        User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("user Details not found to update..."));
        modelMapper.map(userDto,user);
        User updated=userRepository.save(user);
        return modelMapper.map(updated,UserDto.class);
    }
    public String deleteUSerById(Long userId){
        userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Details not found to Delete..."));
        userRepository.deleteById(userId);
        return "User Details Successfully deleted";
    }
}

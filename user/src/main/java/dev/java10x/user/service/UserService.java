package dev.java10x.user.service;

import dev.java10x.user.domain.UserModel;
import dev.java10x.user.producer.UserProducer;
import dev.java10x.user.repositorie.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel saveAndPublish(UserModel userModel) {
        userModel = userRepository.save(userModel);
        userProducer.publishEvent(userModel);
        return userModel;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}

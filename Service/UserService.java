package com.example.pcmarket.Service;

import com.example.pcmarket.Model.User;
import com.example.pcmarket.Repository.UserRepository;
import com.example.pcmarket.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public User update(Integer id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user1 = byId.get();
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            User save = userRepository.save(user1);
            return save;
        }
        return null;
    }

    public Result delete(Integer id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return new Result("ochdi",true);
            }
        } catch (Exception e) {
            return new Result("ERROR",false);
        }
        return new Result("ochirilmadi",false);
    }

    public List<User> getUser() {
        List<User> all = userRepository.findAll();
        return all;
    }
}

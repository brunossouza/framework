package dev.valhalla.backend.services;

import dev.valhalla.backend.models.User;
import dev.valhalla.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUsername(String username){
        return Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}

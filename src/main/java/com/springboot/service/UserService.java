package com.springboot.service;

import com.springboot.model.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }
    @Transactional
    public List<User> getUsers() {
       return repository.findAll();
    }
    @Transactional
    public void createUser(User user) {
        repository.save(user);
    }
    @Transactional
    public User findUserById(Long id) {
       return repository.getById(id);
    }
    @Transactional
    public void updateUser(User user) {
        repository.save(user);
    }
    @Transactional
    public void delete(Long id) {
        repository.delete(findUserById(id));
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByName(username);
    }
}

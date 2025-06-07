package com.luv2code.studybaseweb.service;

import com.luv2code.studybaseweb.dao.daoInterface.UserDAO;
import com.luv2code.studybaseweb.entity.User;
import com.luv2code.studybaseweb.exception.NotFoundException;
import com.luv2code.studybaseweb.service.interfaces.UserService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAllUser() {
        return userDAO.findAll();
    }

    @Override
    public User findById(String user_id) {
        Optional<User> userOptional = userDAO.findById(user_id);

        User user = null;

        if (userOptional.isPresent())
            user = userOptional.get();
        else
            throw new RuntimeException("Did not found the user " + user_id);

        return user;
    }

    @Override
    public User save(User user) {
        return null;
    }
}

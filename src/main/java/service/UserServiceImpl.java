package service;

import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import entity.validator.UserValidator;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;
    UserDaoImpl userDao = UserDaoImpl.getInstance();
    UserValidator userValidator = UserValidator.getInstance();
    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException {
        if(userValidator.isValidate(user)){
            userDao.saveUser(user);
        }
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }
    }


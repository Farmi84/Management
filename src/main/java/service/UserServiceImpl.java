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

    public User getUserById(Long userId) {
        List<User> allUsers = userDao.getAllUsers();
        for(User searchedUser : allUsers){
            if(searchedUser.getId() == userId){
                return searchedUser;
            }
        }
        return null;
    }

    public User getUserByLogin(String login) {
        List<User> allUsers = userDao.getAllUsers();
        for(User searchedUser : allUsers){
            if(searchedUser.getLogin().equals(login)){
                return searchedUser;
            }
        }
        return null;
    }

    public boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException {
        if(userValidator.isValidate(user)){
            userDao.saveUser(user);
            return true;
        } else{
            return false;
        }
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }
    }


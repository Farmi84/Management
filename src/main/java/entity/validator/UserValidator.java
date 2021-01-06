package entity.validator;

import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.util.List;

public class UserValidator {
    private static UserValidator userValidator = null;

    private UserValidator() {
    }

    public static UserValidator getInstance(){
        if(userValidator == null ){
            userValidator = new UserValidator();
        }
        return userValidator;
    }

    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException, UserLoginAlreadyExistException {
        if(isLoginHasFourCharacters(user)){
            throw new UserShortLengthLoginException();
        }
        if(isPasswordHasSixCharacters(user)){
            throw new UserShortLengthPasswordException();
        }
        if(isUserByLoginExist(user)){
            throw new UserLoginAlreadyExistException();
        }
        return true;
    }

    private boolean isPasswordHasSixCharacters(User user)  {
        return user.getPassword().length() >= 6;
    }

    private boolean isLoginHasFourCharacters(User user) {
        return user.getLogin().length() >= 4;
    }
    private boolean isUserByLoginExist(User user) {
        String fileName = null;
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        List<User> allUsers = userDao.getAllUsers();
        for(User allUser : allUsers){
            if(allUser.getLogin().equals(user)){
                return true;
            }
            }
            return false;
        }


}

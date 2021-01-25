package facade;

import api.UserRegisterLoginFacade;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private static UserRegisterLoginFacadeImpl instance = null;
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl() {
    }
    
    public static UserRegisterLoginFacadeImpl getInstance(){
        if(instance == null){
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public boolean registerUser(User user) {
        try {
            return userService.addUser(user);
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return false;
    }

    public boolean loginUser(String user, String password) {
        return userService.getUserByLogin(user).getPassword().equals(password);
    }
}

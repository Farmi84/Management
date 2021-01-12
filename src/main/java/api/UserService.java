package api;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException;
    List<User> getAllUsers();
    User getUserById(Long userId);
    User getUserByLogin(String login);
    void removeUserById(Long userId) throws IOException;
}

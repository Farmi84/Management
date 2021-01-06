package api;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException;
    void removeUserById(Long userId) throws IOException;
}

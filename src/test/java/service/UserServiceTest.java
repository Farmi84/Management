package service;

import api.UserService;
import entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(11, "Damian", "haslo1"));
        users.add(new User(12, "Iwona", "haslo2"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> searchedUsers = userService.getAllUsers();

        Assert.assertEquals(users, searchedUsers);
    }

    @Test
    public void testAddUser(){
        List<User> users = new ArrayList<User>();
        User user = new User(32, "Milan", "milanek1");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> listOfAddedUsers = userService.getAllUsers();
        Assert.assertEquals(users, listOfAddedUsers);
    }

    @Test
    public void testRemoveUser(){
        List<User> users = new ArrayList<User>();
        User damian = new User(45, "Damain", "haslo4");
        User iwona = new User(65, "Iwona", "haslo5");
        users.add(damian);
        users.add(iwona);

        UserServiceImpl userService = new UserServiceImpl(users);
        users.remove(damian);
        userService.removeUserById(45l);
        List<User> finalList = userService.getAllUsers();
        Assert.assertEquals(users, finalList);
    }
}

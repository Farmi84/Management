package dao;

import api.UserDao;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    String fileName;

    public UserDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    public void saveUser(User user) throws IOException {
        List<User> allUsers = getAllUsers();
        allUsers.add(user);
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allUsers.size(); i++){
            User userToSave = allUsers.get(i);
            fileWriter.write(userToSave.toString() + "\n");
        }
        fileWriter.close();
    }

    public void saveUsers(List<User> users) throws IOException {
        List<User> allUsers = getAllUsers();
        allUsers.addAll(users);
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allUsers.size(); i++){
            User userToSave = allUsers.get(i);
            fileWriter.write(userToSave.toString() + "\n");
        }
        fileWriter.close();
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while (readLine != null){
            String [] userData = readLine.split("#");
            long id = Integer.parseInt(userData[0]);
            String login = userData[1];
            String password = userData[2];
            User user = new User(id, login, password);
            users.add(user);
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        return users;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> allUsers = getAllUsers();
        for(int i = 0; i < allUsers.size(); i++){
            User user = allUsers.get(i);
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public User getUserById(long id) throws IOException {
        List<User> allUsers = getAllUsers();
        for(int i = 0; i < allUsers.size(); i++){
            User user = allUsers.get(i);
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> allUsers = getAllUsers();
        for(int i = 0; i < allUsers.size(); i++){
            User user = allUsers.get(i);
            if(user.getLogin().equals(login)){
                allUsers.remove(i);
                break;
            }
        }
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allUsers.size(); i++){
            User userToSave = allUsers.get(i);
            fileWriter.write(userToSave.toString() + "\n");
        }
        fileWriter.close();
    }

    public void removeUserById(long id) throws IOException {
        List<User> allUsers = getAllUsers();
        for(int i = 0; i < allUsers.size(); i++){
            User user = allUsers.get(i);
            if(user.getId() == id){
                allUsers.remove(i);
                break;
            }
        }
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allUsers.size(); i++){
            User userToSave = allUsers.get(i);
            fileWriter.write(userToSave.toString() + "\n");
        }
        fileWriter.close();
    }
}

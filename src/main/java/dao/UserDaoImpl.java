package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    String fileName = "users.txt";
    private static UserDaoImpl instance = null;
    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public void saveUser(User user) throws IOException {
        List<User> allUsers = getAllUsers();
        allUsers.add(user);
        saveUsers(allUsers);
    }

    public void saveUsers(List<User> users) throws IOException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for(int i = 0; i < users.size(); i++){
            User userToSave = users.get(i);
            printWriter.write(userToSave.toString() + "\n");
        }
        printWriter.close();
    }

    public List<User> getAllUsers()  {
        List<User> users = new ArrayList<User>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                String[] userData = readLine.split("#");
                users.add(UserParser.stringToUser(userData));
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch(IOException e){
            System.out.println("Nie można obsłużyć pliku");
        }
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
        saveUsers(allUsers);
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
        saveUsers(allUsers);
    }
}

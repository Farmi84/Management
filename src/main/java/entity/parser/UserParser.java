package entity.parser;

import entity.User;

public class UserParser {
    public static User stringToUser(String [] userData){
        long id = Integer.parseInt(userData[0]);
        String login = userData[1];
        String password = userData[2];
        User user = new User(id, login, password);
        return user;
    }
}

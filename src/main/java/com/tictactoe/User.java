package com.tictactoe;


import java.util.ArrayList;
import java.util.List;

public class User {
    static int userNum = 1;
    static boolean sign = false;
    char assignedSign;
    String name;
    List<List<Integer>> positions;
    static User createNewUser() {
        System.out.println("New user is being created");
        return new User();
    }

    private User() {
        setName("user" + userNum);
        userNum++;
        if(sign) {
            assignedSign = 'X';
        } else {
            assignedSign = 'O';
        }
        sign = !sign;
        positions = new ArrayList<>();
        System.out.println("Name of new user is:" + this.getName());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

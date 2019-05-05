/*
* Author: Kris Sherbondy
* Date: 4 May 2019
* Class: SDEV 360
* File Name: Username_and_Password_Setup
* Purpose: This application verifies that a user creates a username and password
* that contains at least one special character (i.e. !,@,#,$,%) and one number.
* The username MUST also be 12 characters in length and the password MUST be
* 16 characters in length. 
*/

import java.util.*;
import java.util.regex.*;

public class Username_and_Password_Setup {

    private static String username;
    private static String password;
    private static Scanner input = new Scanner(System.in);
    private static String newUsername;
    private static String newPassword;

    public static void main(String[] args) {

        System.out.println("Enter Username");
        newUsername = input.nextLine();
        while(Username_Validation(newUsername) == false){
            System.out.println("Incorrect Username. Username must be 12 characters long and must" +
                    " include at least one special character and at least one number.\nEnter Username.");
            newUsername = input.nextLine();
        }

        System.out.println("Enter Password.");
        newPassword = input.nextLine();
        while(Password_Validation(newPassword) == false){
            System.out.println("Password incorrect. Password must be 12 characters long and must" +
                    " include at least one special character and at least one number.\nEnter Password.");
            newPassword = input.nextLine();
        }
    }

    private static boolean Username_Validation(String newUsername) {
        username = newUsername;
        if (username.length() >= 12) {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasLetter = letter.matcher(username);
            Matcher hasDigit = digit.matcher(username);
            Matcher hasSpecial = special.matcher(username);
            return hasLetter.find() && hasDigit.find() && hasSpecial.find();
        } else {
            return false;
        }
    }

    public static boolean Password_Validation(String newPassword) {
        password = newPassword;
        if (password.length() >= 16) {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);
            return hasLetter.find() && hasDigit.find() && hasSpecial.find();
        } else {
            return false;
        }
    }
}
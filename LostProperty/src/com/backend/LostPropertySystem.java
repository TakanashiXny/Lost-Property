package com.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LostPropertySystem {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitSystem = false;
        String currentUser = null;

        // Welcome
        System.out.println("Welcome to the system");

        while (!exitSystem) {
            if (currentUser == null) {
                homePage();
                boolean illegalInput = false;
                while (!illegalInput) {
                    int choice = getHomePageInput(input);
                    switch (choice) {
                        case 1 -> {
                            illegalInput = true;
                            register(input);
                        }
                        case 2 -> {
                            illegalInput = true;
                            currentUser = login(input);
                        }
                        case 3 -> {
                            illegalInput = true;
                            exitSystem = true;
                        }
                        default -> System.out.println("Please input 1-6!");
                    }


                }
            } else {
                loginHomePage();
                boolean illegalInput = false;
                while (!illegalInput) {
                    int choice = getHomePageInput(input);
                    switch (choice) {
                        case 1 -> {
                            illegalInput = true;
                            publishLostProperty(currentUser, input);
                        }
                        case 2 -> {
                            illegalInput = true;
                            searchLostProperty(currentUser);
                        }
                        case 3 -> {
                            illegalInput = true;
                            changeInformation(currentUser);
                        }
                        case 4 -> {
                            illegalInput = true;
                            currentUser = null;
                        }
                        case 5 -> {
                            illegalInput = true;
                            exitSystem = true;
                            break;
                        }
                        default -> System.out.println("Please input 1-5!");
                    }
                }
            }



        }

        input.close();

    }

    public static void homePage() {
        System.out.println("Now please choose from the following: ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Please make your choice (Please input the number): ");
    }

    public static void loginHomePage() {
        System.out.println("Now please choose from the following: ");
        System.out.println("1. Publish lost properties");
        System.out.println("2. Search lost properties");
        System.out.println("3. Change personal information");
        System.out.println("4. Log out");
        System.out.println("5. Exit");
        System.out.println("Please make your choice (Please input the number): ");
    }

    public static int getHomePageInput(Scanner input) {
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    public static void register(Scanner input) {
        ArrayList<String> usernameList = new ArrayList<String>();
        String path = "LostProperty/src/com/backend/data/user.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String username = line.split(",")[0];
                usernameList.add(username);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String newUsername;
        while (true) {
            System.out.println("Please enter your username");
            newUsername = input.nextLine();

            if (usernameList.contains(newUsername)) {
                System.out.println("The username exists");
            } else {
                break;
            }

        }

        String firstPassword;
        System.out.println("Please enter your password");
        while (true) {
            firstPassword = input.nextLine();
            System.out.println("Please confirm your password");
            String confirmPassword = input.nextLine();

            if (!firstPassword.equals(confirmPassword)) {
                System.out.println("Please enter the same password");
            } else {
                break;
            }
        }

        String content =  newUsername + "," + firstPassword;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(content);
            writer.newLine();
            writer.close();
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String login(Scanner input) {
        ArrayList<String> usernameList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();
        String path = "LostProperty/src/com/backend/data/user.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String username = line.split(",")[0];
                usernameList.add(username);

                String password = line.split(",")[1];
                passwordList.add(password);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Please enter your username");
            String inputUsername = input.nextLine();

            int index = usernameList.indexOf(inputUsername);
            if (index == -1) {
                System.out.println("The username doesn't exist");
                continue;
            }

            System.out.println("Please enter your password");
            String inputPassword = input.nextLine();

            if (inputPassword.equals(passwordList.get(index))) {
                System.out.println("Login Success");

                return inputUsername;
            } else {
                System.out.println("Wrong username or password");
            }
        }


    }

    public static void publishLostProperty(String currentUser, Scanner input) {
        String type = chooseType(input);


    }

    public static String chooseType(Scanner input) {
        String type = null;
        boolean illegalInput = false;
        while (!illegalInput) {
            System.out.println("Please choose which type of properties you're going to post");
            System.out.println("1. Card");
            System.out.println("2. Daily Use");
            System.out.println("3. Electronic products");
            System.out.println("4. Others");
            System.out.println("Please enter (1-4): ");

            int number = input.nextInt();
            input.nextLine();

            switch (number) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    illegalInput = true;
                    System.out.println("Please enter a number from 1 to 4");
                    break;
            }

        }
        return type;
    }

    public static void searchLostProperty(String currentUser) {

    }

    public static void changeInformation(String currentUser) {

    }

}

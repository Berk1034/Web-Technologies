package com.company;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    private ListOfUserProfiles UserProfiles;
    private ListOfUserOrders UserOrders;

    public Controller(){
        UserProfiles = new ListOfUserProfiles();
        UserOrders = new ListOfUserOrders();
    }
    public void execute() throws IOException {
        boolean ShowCommands = true;
        boolean NoReturn;
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("Available commands:");
            System.out.println("1. Show userprofile commands.");
            System.out.println("2. Show coffee-order commands.");
            System.out.println("0. Exit");
            System.out.println("---------------------------------------------------");
            Scanner scan = new Scanner(System.in);
            String ShowCommandsString = scan.nextLine();
            switch (ShowCommandsString){
                case "1":
                    NoReturn = true;
                    while(ShowCommands & NoReturn) {
                        System.out.println("1. Create a userprofile.");
                        System.out.println("2. Load userprofiles.");
                        System.out.println("3. Choose a userprofile.");
                        System.out.println("4. Update a userprofile.");
                        System.out.println("5. Delete a userprofile.");
                        System.out.println("6. Save your changes.");
                        System.out.println("7. Return.");
                        System.out.println("0. Exit.");
                        Scanner scanner = new Scanner(System.in);
                        String CommandsString = scanner.nextLine();
                        switch (CommandsString) {
                            case "1":
                                System.out.println("Enter your name:");
                                String name = scanner.nextLine();
                                System.out.println("Enter your surname:");
                                String surname = scanner.nextLine();
                                System.out.println("Enter your age:");
                                int age = scanner.nextInt();
                                UserProfile user = new UserProfile(name, surname, age, new Date());
                                System.out.println("Success!");
                                getUserProfiles().AddUserProfile(user);
                                break;
                            case "2":
                                getUserProfiles().LoadFromFile("UserProfiles.xml");
                                break;
                            case "3":
                                int count = getUserProfiles().getListOfUserProfiles().size();
                                for(int i = 0; i<count; i++){
                                    System.out.println("---------------------------------------------------");
                                    System.out.println("Account #"+i);
                                    System.out.println("Name: "+getUserProfiles().getListOfUserProfiles().get(i).getName());
                                    System.out.println("Surname: "+getUserProfiles().getListOfUserProfiles().get(i).getSurname());
                                    System.out.println("Age: "+getUserProfiles().getListOfUserProfiles().get(i).getAge());
                                    System.out.println("CreationDate: "+getUserProfiles().getListOfUserProfiles().get(i).getCreationDate());
                                    System.out.println("Coffee Settings: "+getUserProfiles().getListOfUserProfiles().get(i).getCoffeeSettings());
                                    System.out.println("---------------------------------------------------");
                                }
                                System.out.println("Choose an account:");
                                int number = scanner.nextInt();
                                getUserProfiles().ChooseUserProfile(getUserProfiles().getListOfUserProfiles().get(number));
                                System.out.println("You are successfully logged in!");
                                break;
                            case "4":
                                System.out.println("Enter new name:");
                                getUserProfiles().getLoggedinUserProfile().setName(scanner.nextLine());
                                System.out.println("Enter new surname:");
                                getUserProfiles().getLoggedinUserProfile().setSurname(scanner.nextLine());
                                System.out.println("Enter new age:");
                                getUserProfiles().getLoggedinUserProfile().setAge(scanner.nextInt());
                                break;
                            case "5":
                                getUserProfiles().getListOfUserProfiles().remove(getUserProfiles().getLoggedinUserProfile());
                                getUserProfiles().ChooseUserProfile(null);
                                System.out.println("Successfully removed!");
                                break;
                            case "6":
                                getUserProfiles().SaveToFile("UserProfiles.xml");
                                break;
                            case "7":
                                NoReturn = false;
                                break;
                            case "0":
                                ShowCommands = false;
                                break;
                        }
                    }
                    break;
                case "2":
                    NoReturn = true;
                    while(ShowCommands & NoReturn) {
                        System.out.println("1. Create an order.");
                        System.out.println("2. Remove an order.");
                        System.out.println("3. Update an order.");
                        System.out.println("4. Delete an order.");
                        System.out.println("5. Sort your orders.");
                        System.out.println("6. Show your orders.");
                        System.out.println("7. Save your orders.");
                        System.out.println("8. Return.");
                        System.out.println("0. Exit.");
                        Scanner scanner = new Scanner(System.in);
                        String CommandsString = scanner.nextLine();
                        switch (CommandsString) {
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                            case "6":
                                break;
                            case "7":
                                break;
                            case "8":
                                NoReturn = false;
                                break;
                            case "0":
                                ShowCommands = false;
                                break;
                        }
                    }
                    break;
                case "0":
                    ShowCommands = false;
                    break;
            }
        } while (ShowCommands);

        System.out.println("Sos");
        UserProfile cst = new UserProfile();
        cst.setName("Berk");
        System.out.println(cst.getName());
        cst.WriteInfo("TestUserProfile.txt",cst.getName());
        Americano am = new Americano();
        System.out.println(am.getCoffeeAmount());
    }

    public ListOfUserProfiles getUserProfiles() {
        return UserProfiles;
    }

    public void setUserProfiles(ListOfUserProfiles userProfiles) {
        UserProfiles = userProfiles;
    }
}

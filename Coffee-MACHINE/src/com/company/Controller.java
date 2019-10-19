package com.company;

import java.util.Scanner;

public class Controller {
    public void execute(){
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
                        System.out.println("2. Load a userprofile.");
                        System.out.println("3. Update a userprofile.");
                        System.out.println("4. Delete a userprofile.");
                        System.out.println("5. Save your changes.");
                        System.out.println("6. Return.");
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
}

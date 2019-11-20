package com.company.controller;

import com.company.*;
import com.company.view.ViewFactory;

import java.util.Scanner;

public class Controller {
//    private final CommandHelper helper = new CommandHelper();
//    private final char paramDelimeter = ' ';
/*
    private ListOfUserProfiles UserProfiles;
    private ListOfUserOrders UserOrders;
    private String UserProfileFile = "UserProfiles.xml";
*/
    public Controller(){
//        UserProfiles = new ListOfUserProfiles();
//        UserOrders = new ListOfUserOrders();
    }

    public void execute(){
        Scanner CommandScanner = new Scanner(System.in);
        CommandHelper helper = CommandHelper.getInstance();
        boolean ShowCommands = true;
        do{
            //PrintListOfCommands();
            ViewFactory.getInstance().getConsoleView().showAvailableCommands();
            System.out.println("Enter command:");
            String CommandToExecute = CommandScanner.nextLine();
            ICommand command = helper.getCommand(CommandToExecute);
            ShowCommands = command.execute(CommandToExecute);
        }while(ShowCommands);
    }
/*
    public void PrintListOfCommands() {
        System.out.println("Available Commands in COFFEE-MACHINE:");
        CommandName[] commandNames = CommandName.values();
        for(CommandName commandName:commandNames){
            if(commandName!=CommandName.NO_SUCH_COMMAND)
                System.out.println(commandName);
        }
    }
*/
/*
    public boolean execute(String request){
        String commandName;
        ICommand executionCommand;

        commandName = request.substring(0,request.indexOf(paramDelimeter));
        executionCommand = helper.getCommand(commandName);

        boolean response;
        response = executionCommand.execute(request);

        return response;
    }
*/
/*
    public void executeOLD() throws IOException {
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
                        System.out.println("UserProfile Commands:");
                        System.out.println("1. Create a userprofile.");
                        System.out.println("2. Load userprofiles.");
                        System.out.println("3. Choose a userprofile.");
                        System.out.println("4. Show current userprofile.");
                        System.out.println("5. Update a userprofile.");
                        System.out.println("6. Delete a userprofile.");
                        System.out.println("7. Save your changes.");
                        System.out.println("8. Return.");
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
                                getUserProfiles().LoadFromFile(UserProfileFile);
                                System.out.println("Successfully loaded!");
                                break;
                            case "3":
                                int count = getUserProfiles().getListOfUserProfiles().size();
                                if(count != 0){
                                    for(int i = 0; i<count; i++){
                                        System.out.println("---------------------------------------------------");
                                        System.out.println("Account #" + i);
                                        System.out.println("Name: " + getUserProfiles().getListOfUserProfiles().get(i).getName());
                                        System.out.println("Surname: " + getUserProfiles().getListOfUserProfiles().get(i).getSurname());
                                        System.out.println("Age: " + getUserProfiles().getListOfUserProfiles().get(i).getAge());
                                        System.out.println("CreationDate: " + getUserProfiles().getListOfUserProfiles().get(i).getCreationDate());
                                        System.out.println("Coffee Settings: " + getUserProfiles().getListOfUserProfiles().get(i).getCoffeeSettings());
                                        System.out.println("---------------------------------------------------");
                                    }
                                    System.out.println("Choose an account:");
                                    int number = scanner.nextInt();
                                    getUserProfiles().ChooseUserProfile(getUserProfiles().getListOfUserProfiles().get(number));
                                    System.out.println("You are successfully logged in!");
                                }
                                else{
                                    System.out.println("Add/Load at least 1 UserProfile!");
                                }
                                break;
                            case "4":
                                if(getUserProfiles().getLoggedinUserProfile() != null) {
                                    System.out.println("---------------------------------------------------");
                                    System.out.println("Account #" + getUserProfiles().getListOfUserProfiles().indexOf(getUserProfiles().getLoggedinUserProfile()));
                                    System.out.println("Name: " + getUserProfiles().getLoggedinUserProfile().getName());
                                    System.out.println("Surname: " + getUserProfiles().getLoggedinUserProfile().getSurname());
                                    System.out.println("Age: " + getUserProfiles().getLoggedinUserProfile().getAge());
                                    System.out.println("CreationDate: " + getUserProfiles().getLoggedinUserProfile().getCreationDate());
                                    System.out.println("Coffee Settings: " + getUserProfiles().getLoggedinUserProfile().getCoffeeSettings());
                                    System.out.println("---------------------------------------------------");
                                }
                                else{
                                    System.out.println("Choose UserProfile first!");
                                }
                                break;
                            case "5":
                                if(getUserProfiles().getLoggedinUserProfile() != null){
                                    System.out.println("Enter new name:");
                                    getUserProfiles().getLoggedinUserProfile().setName(scanner.nextLine());
                                    System.out.println("Enter new surname:");
                                    getUserProfiles().getLoggedinUserProfile().setSurname(scanner.nextLine());
                                    System.out.println("Enter new age:");
                                    getUserProfiles().getLoggedinUserProfile().setAge(scanner.nextInt());
                                    getUserProfiles().getLoggedinUserProfile().setCreationDate(new Date());
                                    ArrayList<Espresso> NewSettings = new ArrayList<Espresso>();
                                    NewSettings.add(new Americano());
                                    NewSettings.add(new Cappuccino());
                                    NewSettings.add(new Espresso());
                                    NewSettings.add(new FlatWhite());
                                    NewSettings.add(new Latte());
                                    NewSettings.add(new Romano());
                                    boolean NothingToUpdate = false;
                                    while(!NothingToUpdate){
                                        System.out.println("Choose coffee you want to update its settings:");
                                        System.out.println("1. Americano");
                                        System.out.println("2. Cappuccino");
                                        System.out.println("3. Espresso");
                                        System.out.println("4. FlatWhite");
                                        System.out.println("5. Latte");
                                        System.out.println("6. Romano");
                                        System.out.println("0. Nothing to update.");
                                        Scanner CoffeeScan = new Scanner(System.in);
                                        switch (CoffeeScan.nextLine()){
                                            case "1":
                                                Americano CoffeeAmericano = new Americano();
                                                System.out.println("Do you want sugar?(true/false)");
                                                CoffeeAmericano.setSugar(CoffeeScan.nextBoolean());
                                                System.out.println("Set water temperature: ");
                                                CoffeeAmericano.setWaterTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set water volume: ");
                                                CoffeeAmericano.setWaterVolume(CoffeeScan.nextInt());
                                                System.out.println("Set coffee amount: ");
                                                CoffeeAmericano.setCoffeeAmount(CoffeeScan.nextInt());
                                                System.out.println("Set additional water volume: ");
                                                CoffeeAmericano.setAdditionalWaterVolume(CoffeeScan.nextInt());
                                                NewSettings.remove(0);
                                                NewSettings.add(0,CoffeeAmericano);
                                                break;
                                            case "2":
                                                Cappuccino CoffeeCappuccino = new Cappuccino();
                                                System.out.println("Do you want sugar?(true/false)");
                                                CoffeeCappuccino.setSugar(CoffeeScan.nextBoolean());
                                                System.out.println("Set water temperature: ");
                                                CoffeeCappuccino.setWaterTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set water volume: ");
                                                CoffeeCappuccino.setWaterVolume(CoffeeScan.nextInt());
                                                System.out.println("Set coffee amount: ");
                                                CoffeeCappuccino.setCoffeeAmount(CoffeeScan.nextInt());
                                                System.out.println("Set milk temperature: ");
                                                CoffeeCappuccino.setMilkTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set milk volume: ");
                                                CoffeeCappuccino.setMilkVolume(CoffeeScan.nextInt());
                                                NewSettings.remove(1);
                                                NewSettings.add(1,CoffeeCappuccino);
                                                break;
                                            case "3":
                                                Espresso CoffeeEspresso = new Espresso();
                                                System.out.println("Do you want sugar?(true/false)");
                                                CoffeeEspresso.setSugar(CoffeeScan.nextBoolean());
                                                System.out.println("Set water temperature: ");
                                                CoffeeEspresso.setWaterTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set water volume: ");
                                                CoffeeEspresso.setWaterVolume(CoffeeScan.nextInt());
                                                System.out.println("Set coffee amount: ");
                                                CoffeeEspresso.setCoffeeAmount(CoffeeScan.nextInt());
                                                NewSettings.remove(2);
                                                NewSettings.add(2,CoffeeEspresso);
                                                break;
                                            case "4":
                                                FlatWhite CoffeeFlatWhite = new FlatWhite();
                                                System.out.println("Do you want sugar?(true/false)");
                                                CoffeeFlatWhite.setSugar(CoffeeScan.nextBoolean());
                                                System.out.println("Set water temperature: ");
                                                CoffeeFlatWhite.setWaterTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set water volume: ");
                                                CoffeeFlatWhite.setWaterVolume(CoffeeScan.nextInt());
                                                System.out.println("Set coffee amount: ");
                                                CoffeeFlatWhite.setCoffeeAmount(CoffeeScan.nextInt());
                                                System.out.println("Set coconutmilk volume: ");
                                                CoffeeFlatWhite.setCoconutMilkVolume(CoffeeScan.nextInt());
                                                NewSettings.remove(3);
                                                NewSettings.add(3,CoffeeFlatWhite);
                                                break;
                                            case "5":
                                                Latte CoffeeLatte = new Latte();
                                                System.out.println("Do you want sugar?(true/false)");
                                                CoffeeLatte.setSugar(CoffeeScan.nextBoolean());
                                                System.out.println("Set water temperature: ");
                                                CoffeeLatte.setWaterTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set water volume: ");
                                                CoffeeLatte.setWaterVolume(CoffeeScan.nextInt());
                                                System.out.println("Set coffee amount: ");
                                                CoffeeLatte.setCoffeeAmount(CoffeeScan.nextInt());
                                                System.out.println("Set milk temperature: ");
                                                CoffeeLatte.setMilkTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set milk volume: ");
                                                CoffeeLatte.setMilkVolume(CoffeeScan.nextInt());
                                                System.out.println("Set whipped cream volume: ");
                                                CoffeeLatte.setWhippedCreamVolume(CoffeeScan.nextInt());
                                                break;
                                            case "6":
                                                Romano CoffeeRomano = new Romano();
                                                System.out.println("Do you want sugar?(true/false)");
                                                CoffeeRomano.setSugar(CoffeeScan.nextBoolean());
                                                System.out.println("Set water temperature: ");
                                                CoffeeRomano.setWaterTemperature(CoffeeScan.nextInt());
                                                System.out.println("Set water volume: ");
                                                CoffeeRomano.setWaterVolume(CoffeeScan.nextInt());
                                                System.out.println("Set coffee amount: ");
                                                CoffeeRomano.setCoffeeAmount(CoffeeScan.nextInt());
                                                System.out.println("Set lemon juice volume: ");
                                                CoffeeRomano.setLemonJuiceVolume(CoffeeScan.nextInt());
                                                break;
                                            case "0":
                                                NothingToUpdate = true;
                                                break;
                                        }
                                    }
                                    getUserProfiles().getLoggedinUserProfile().setCoffeeSettings(NewSettings);

                                    //ArrayList<Espresso> NewSettings = new ArrayList<Espresso>();
                                    //Americano am = new Americano();
                                    //am.setSugar(true);
                                    //NewSettings.add(am);
                                    //NewSettings.add(new Cappuccino());
                                    //NewSettings.add(new Espresso());
                                    //NewSettings.add(new FlatWhite());
                                    //NewSettings.add(new Latte());
                                    //NewSettings.add(new Romano());
                                    //getUserProfiles().getLoggedinUserProfile().setCoffeeSettings(NewSettings);

                                }
                                else{
                                    System.out.println("Choose UserProfile first!");
                                }
                                break;
                            case "6":
                                if(getUserProfiles().getLoggedinUserProfile() != null){
                                    getUserProfiles().getListOfUserProfiles().remove(getUserProfiles().getLoggedinUserProfile());
                                    getUserProfiles().ChooseUserProfile(null);
                                    System.out.println("Successfully removed!");
                                }
                                else{
                                    System.out.println("Choose UserProfile first!");
                                }
                                break;
                            case "7":
                                getUserProfiles().SaveToFile(UserProfileFile);
                                System.out.println("Successfully saved to file: " + UserProfileFile);
                                break;
                            case "8":
                                NoReturn = false;
                                break;
                            case "0":
                                ShowCommands = false;
                                break;
                            default:
                                System.out.println("You have entered incorrect command!");
                        }
                    }
                    break;
                case "2":
                    NoReturn = true;
                    while(ShowCommands & NoReturn) {
                        System.out.println("Coffee-Order Commands:");
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

*/
}

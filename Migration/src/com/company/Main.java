package com.company;

import com.company.beans.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String DB_USERNAME = scanner.nextLine();
        System.out.println("Enter password:");
        String DB_PASSWORD = scanner.nextLine();
        System.out.println("Enter DB name:");
        String DB_NAME = scanner.nextLine();

        DBController dbController = new DBController(DB_NAME, DB_USERNAME, DB_PASSWORD);
        Connection connection = dbController.EstablishConnection();
        if(connection == null){
            System.out.println("Can't establish connection!");
            return;
        }

        Logger logger = Logger.getLogger(Main.class);
        BasicConfigurator.configure();

        logger.info("Successfully!");

        XMLMigrator xmlMigrator = new XMLMigrator(DB_NAME, connection);
        xmlMigrator.MigrateXML(".\\validation\\");

/*
        XMLSerializer xmlSerializer = new XMLSerializer();
        UserProfile userProfile = new UserProfile("Peepee","Pooooo",20, new Date());
        xmlSerializer.Serialize(userProfile,userProfile.getName() + ".xml");
        UserOrder userOrder = new UserOrder(7, new Date(), new Latte(), userProfile);
        xmlSerializer.Serialize(userOrder,userOrder.getID() + ".xml");
*/
    }
}

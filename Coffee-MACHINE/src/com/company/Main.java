package com.company;

import com.company.controller.Controller;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.execute();
    }
}

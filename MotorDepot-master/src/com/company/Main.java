package com.company;

import com.company.json.AutoPark;
import com.company.json.DataOfDriver;
import com.company.json.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    static  Scanner sc=new Scanner(System.in);
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();


    public static void main(String[] args) throws IOException {

        AutoPark[] autoParks = {
                new AutoPark(1, "Renault", "", "base"),
                new AutoPark(2, "Volvo", "", "base"),
                new AutoPark(3, "DAF XT", "", "base")
        };
        DataOfDriver[] dataOfDrivers = {
                new DataOfDriver(1,"dr-1","Petr"),
                new DataOfDriver(2,"dr-2","Vova" ),
                new DataOfDriver(3,"dr-3","Azamat")
        };
        print(autoParks);
        print(dataOfDrivers);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (true) {
            System.out.println("Choose one of the trucks: ");
            int input = sc.nextInt();
            sc.nextLine();
            DataOfDriver.printInfo(autoParks[input - 1]);
            ServiceImpl service = new ServiceImpl();
            getCommands();
            String action = sc.nextLine();
            if (action.equals("1")) {
                service.changeDriver(autoParks[input - 1], dataOfDrivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(autoParks[input - 1], dataOfDrivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(autoParks[input - 1], dataOfDrivers[input - 1]);
            }
            print(autoParks);
            print(dataOfDrivers);

        }


    }
    public static void print(AutoPark[] cars) {
        System.out.println("~~~~~~~~~~~~ * CARS * ~~~~~~~~~~~~~~");
        System.out.println(" # |    Bus    |  Driver  |  State");
        System.out.println("---+-----------+----------+---------");
        for (int j = 0; j < cars.length; j++) {
            System.out.println(cars[j]);
        }
    }

    public static void print(DataOfDriver[]dataOfDrivers) {
        System.out.println("~~~~~~~~~~ * DRIVERS * ~~~~~~~~~~~~~");
        System.out.println("     #    |   Driver   |   Bus      ");
        System.out.println("----------+------------+------------");
        for (int j = 0; j < dataOfDrivers.length; j++) {
            System.out.println(dataOfDrivers[j]);
        }
    }

    public static void getCommands() {
        System.out.println("Press to 1 to change driver");
        System.out.println("Press to 2 to start driving");
        System.out.println("Press to 3 to start repair");
    }


}

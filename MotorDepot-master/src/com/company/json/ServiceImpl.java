package com.company.json;

import java.util.Random;

public class ServiceImpl implements  Service{
    @Override
    public void changeDriver(AutoPark autoPark, DataOfDriver dataOfDriver) {
        if (autoPark.getState().equals("base")) {
            autoPark.setDriver(dataOfDriver.getDriver());
            dataOfDriver.setName(dataOfDriver.getName());
        } else if (autoPark.getState().equals("route")) {
            System.out.println("Driver is already on the road!!!");
        } else {
            System.out.println("You can't change the driver!!!");
        }
    }

    @Override
    public void startDriving(AutoPark autoPark, DataOfDriver dataOfDriver) {
        if (autoPark.getState().equals("base")) {
            if (!autoPark.getDriver().equals("")) {
                autoPark.setState("route");
                System.out.println("Driver started his way successfully!");
            } else {
                System.out.println("There is no driver!!!");
            }

        } else if (autoPark.getState().equals("route")) {
            System.out.println("Driver is ALREADY on the way!!!");
        } else {
            Random random = new Random();
            int rnd = random.nextInt(2);
            if (rnd == 0) {
                autoPark.setState("route");
                System.out.println("Truck is on the way!!!");
            } else {
                autoPark.setState("base");
                System.out.println("Truck is in the base");
            }
        }

    }

    @Override
    public void startRepair(AutoPark autoPark, DataOfDriver dataOfDriver) {
        if (autoPark.getState().equals("base")) {
            autoPark.setState("repair");
            System.out.println("Truck is under repairing now!!!");
        } else if (autoPark.getState().equals("route")) {
            autoPark.setState("repair");
        } else {
            System.out.println("Truck is ALREADY under repair!!!");
        }

    }


    }


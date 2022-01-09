package com.company;

import com.company.json.AutoPark;
import com.company.json.Change;
import com.company.json.DataOfDriver;
import com.company.json.State;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    static  Scanner sc=new Scanner(System.in);
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();


    public static void main(String[] args) throws IOException{
        System.out.println("#  | Bus     |  Driver  |  State");
        System.out.println("***_*********_**********_********");
        AutoPark[] parks = {
                new AutoPark(1, "Renault", "", "base"),
                new AutoPark(2, "Volvo", "", "base"),
                new AutoPark(3, "DAF XT", "", "base")
        };
        String gson = GSON.toJson(parks);
        AutoPark.writeJson(gson);
        AutoPark[] parks1 = GSON.fromJson(AutoPark.readJson(), AutoPark[].class);
        for (AutoPark p :
                parks1) {
            System.out.println(p.toString());
        }
        System.out.println("Выберите машину:");
        int number=sc.nextInt();

        if(number==1) {
            Change.findID(parks, number);
        }if(number==2){
            Change.findID(parks,number);
        }if(number==3){
            Change.findID(parks,number);
        }
        Change.commands();
        int command=sc.nextInt();
        if(command==1) {
            ResultOfDrivers();
        }
    }
    public static void ResultOfDrivers(){
        System.out.println("# | id|  Driver           |  Bus");
        System.out.println("----------------------------------");
        DataOfDriver[] dataOfDrivers = {
                new DataOfDriver(1,"dr-1","Petr"),
                new DataOfDriver(2,"dr-2","Vova" ),
                new DataOfDriver(3,"dr-3","Azamat")
        };
        String gson1 = GSON.toJson(dataOfDrivers);
        DataOfDriver.writeJson(gson1);
        for (DataOfDriver d :
                dataOfDrivers) {
            System.out.println(d.toString());
        }
    }
    public static void State(){
        System.out.println("#  | Bus     |  Driver  |  State");
        System.out.println("***_*********_**********_********");
        AutoPark[] parks = {
                new AutoPark(1, "Renault", "", State.BASE),
                new AutoPark(2, "Volvo", "", State.ROUTE),
                new AutoPark(3, "DAF XT", "",State.REPAIR)
        };
        String gson = GSON.toJson(parks);
        AutoPark.writeJson(gson);
        AutoPark[] parks1 = GSON.fromJson(AutoPark.readJson(), AutoPark[].class);
        for (AutoPark p :
                parks1) {
            System.out.println(p.toString());
        }
    }

}

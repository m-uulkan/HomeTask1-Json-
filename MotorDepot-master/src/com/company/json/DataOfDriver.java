package com.company.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
@Getter
@Setter

public class DataOfDriver {
    public static  final GsonBuilder BUILDER = new GsonBuilder();
    public  static Gson GSON = BUILDER.setPrettyPrinting().create();
    private  static final Path WRITE_PATH = Paths.get("./dataframe.json");

    private int number;
    private String  id;
    private String driver;
    private String name;



    public DataOfDriver() {
    }

    public DataOfDriver(int number,String id, String driver) {
        this.number=number;
        this.id = id;
        this.driver = driver;

    }

    @Override
    public String toString() {
        return
                number+" " + id+" " +
                 "  "+driver +"   ";
    }
    public static  void getInfoDrivers(){
        System.out.println("# | id|  Driver           |  Bus");
        System.out.println("----------------------------------");
        DataOfDriver[] dataOfDrivers = {
                new DataOfDriver(1,"dr-1","Petr"),
                new DataOfDriver(2,"dr-2","Vova" ),
                new DataOfDriver(3,"dr-3","Azamat")
        };
        DataOfDriver[] drivers1 = GSON.fromJson(readJson(), DataOfDriver[].class);
        for (DataOfDriver driver : drivers1) {
            System.out.println(driver.toString());
        }
    }

    public static void writeJson(String object1) {
        Path writePath = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(writePath, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readJson() {
        String json = "";
        try {
            FileReader reader = new FileReader("./autoPark.json");
            int c;
            while ((c = reader.read()) != -1) {
                json += (char) c;
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    public static void printInfo(AutoPark autoPark) {
        System.out.println("N: " + autoPark.getId());
        System.out.println("Name: " + autoPark.getName());
        System.out.println("Driver: " + autoPark.getDriver());
        System.out.println("State: " + autoPark.getState());
    }

}
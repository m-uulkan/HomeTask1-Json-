package com.company;

import com.company.json.AutoPark;
import com.company.jsonOne.DataOfDriver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    private static final Path WRITE_PATH = Paths.get("./autoPark.json");


    public static void main(String[] args) {

        System.out.println("#  | Bus     |  Driver  |  State");
        System.out.println("***_*********_**********_********");
        AutoPark [] parks={
                new AutoPark(1, "Renault", "", "base"),
                new AutoPark(2, "Volvo", "", "base"),
                new AutoPark(3, "DAF XT", "", "base")
        };
        String gson=GSON.toJson(parks);
        writeJson(gson);

        AutoPark[]parks1=GSON.fromJson(readJson(),AutoPark[].class);
        for (AutoPark p:
             parks1) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println("#   Driver           |  Bus");
        System.out.println("***_*****************_******");

        DataOfDriver[]dataOfDrivers={
                new DataOfDriver("1","Petr"),
                new DataOfDriver("2","Jenya" ),
                new DataOfDriver("3","Vova")
        };
        String gson1=GSON.toJson(dataOfDrivers);
       // DataOfDriver.writeJson(gson1);

        for (DataOfDriver d:
             dataOfDrivers) {
            System.out.println(d.toString());
        }

    }
    private static void writeJson(String object1) {
        Path writePath = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(writePath, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String readJson() {
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
        }return json;
    }
}

package com.company;

import com.company.json.AutoPark;
import com.company.jsonOne.DataOfDriver;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException{
        AutoPark.getResult();
        System.out.println();
        DataOfDriver.getResultOfDriver();
    }
}

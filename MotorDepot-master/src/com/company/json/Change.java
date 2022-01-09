package com.company.json;

public class Change {

       public static void commands(){
           System.out.println("1 change driver");
           System.out.println("2 send to the route");
           System.out.println("3 send to the repairing");
       }
        static public void findID(AutoPark[]autoParks,int number){
           for(AutoPark a:autoParks){
               if(a.getId()==number){
                   System.out.println("# "+number);
                   System.out.println("Bus: "+a.getName()+"\n"+"Driver: "+a.getDriver()+"\n"+"Bus state: "+a.getState());
               }
           }

       }

}

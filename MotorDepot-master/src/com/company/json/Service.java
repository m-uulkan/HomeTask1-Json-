package com.company.json;

public interface Service {
    void changeDriver(AutoPark autoPark,DataOfDriver dataOfDriver);
    void startDriving(AutoPark autoPark,DataOfDriver dataOfDriver);
    void startRepair(AutoPark autoPark,DataOfDriver dataOfDriver);
}

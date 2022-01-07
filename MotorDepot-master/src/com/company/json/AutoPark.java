package com.company.json;

import lombok.Getter;
import lombok.Setter;



    @Getter
    @Setter

    public class AutoPark {
        private int id;
        private String name;
        private String driver;
        private String state;



        public AutoPark(int id, String name, String driver, String state) {
            this.id = id;
            this.name = name;
            this.driver = driver;
            this.state = state;
        }



        @Override
        public String toString() {
            return id +"    "+
                    name +"|   " +
                    driver +"|   "+
                    state + "  ";
        }
}

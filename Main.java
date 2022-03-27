package com.CatJam;

public class Main {

    public static void main(String[] args) {

        Staff Abigail = new Staff("Abigail",
                "Williams",
                "480 123 4567",
                "abigail123@hotmail.com",
                "abyWill",
                "securePassword123",
                "Rural road",
                "Tempe",
                "Arizona",
                879100);

        Customer Carlos = new Customer("Carlos",
                "Perez",
                "480 891 2323",
                "carlosPerez@hotmail.com",
                "carlitosP",
                "iDontKnow456",
                "Eastern Ave",
                "Phoenix",
                "Arizona",
                879100);

        System.out.println(Abigail.toString());
        System.out.println(Carlos.toString());
    }
}

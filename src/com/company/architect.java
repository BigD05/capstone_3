package com.company;

public class architect {//creating our variables
    String name;
    int phoneNumber;
    String email;
    String Address;

    //invokes our current class constructor
    public architect(String name, int phoneNUmber, String email, String Address){
        this.name = name;
        this.phoneNumber = phoneNUmber;
        this.email = email;
        this.Address = Address;
    }
    // our method toString() that prints out the details and returns them all
    public String toString(){
        String output = "\nArchitect";
        output += "\nName: " + name;
        output += "\nPhone number: " + phoneNumber;
        output += "\nEmail: " + email;
        output += "\nAddress: " + Address;
        return output;
    }
}

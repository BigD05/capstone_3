package com.company;

import java.sql.*;
import java.util.Scanner;

public class customer {//creating our class

    //this method creates a new customer for the project using prepared statements
    public static void newCLNT() throws SQLException {

        // Use username "otheruser", password "swordfish".
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Poised_PMS?allowPublicKeyRetrieval=true&useSSL=false",
                "otheruser",
                "123"
        );
        // Create a direct line to the database for running our queries
        Statement statement = connection.createStatement();
        ResultSet results;
        Scanner input = new Scanner(System.in);


        System.out.print("\nPlease enter the name of the customer first Name: ");
        String customername = input.nextLine();


        System.out.print("Please enter the Surname of the customer: ");
        String customerSurname = input.nextLine();


        System.out.print("Please enter the customer phone number: ");
        input = new Scanner(System.in);
        int customerphoneNumber = input.nextInt();


        System.out.print("Please enter the email address of the customer: ");
        input = new Scanner(System.in);
        String customeremail = input.nextLine();


        System.out.print("Please enter the customer address: ");

        String sql2 = "INSERT INTO Poised_CLNT VALUES(?, ?, ?, ?); ";
        PreparedStatement preparedStatement2 =
                connection.prepareStatement(sql2);

        String customerAddress = input.nextLine();
        preparedStatement2.setString(1,customername + " " +  customerSurname);
        preparedStatement2.setInt(2,customerphoneNumber);
        preparedStatement2.setString(3,customeremail);
        preparedStatement2.setString(4,customerAddress);
        preparedStatement2.execute();
        connection.close();



    }

}

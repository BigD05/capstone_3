package com.company;

import java.sql.*;
import java.util.Scanner;

public class architect {//creating our variables

    //this method creates a new Architectc for the project using prepared statements
    public static void newARCH() throws SQLException {

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

        System.out.print("\nPlease enter the name of the architect: ");
        String archiname = input.nextLine();


        System.out.print("Please enter the architect phone number: ");
        input = new Scanner(System.in);
        int archiphoneNumber = input.nextInt();


        System.out.print("Please enter the email address of the architect: ");
        input = new Scanner(System.in);
        String archiemail = input.nextLine();


        System.out.print("Please enter the architect address: ");
        input = new Scanner(System.in);
        String archiAddress = input.nextLine();


        String sql3 = "INSERT INTO Poised_ARCH VALUES(?, ?, ?, ? );";
        PreparedStatement preparedStatement3 =
                connection.prepareStatement(sql3);
        preparedStatement3.setString(1, archiname);
        preparedStatement3.setInt(2, archiphoneNumber);
        preparedStatement3.setString(3, archiemail);
        preparedStatement3.setString(4, archiAddress);
        preparedStatement3.execute();
        connection.close();

    }
}
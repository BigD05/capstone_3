package com.company;

import java.sql.*;
import java.util.Scanner;

public class contractor {//creating our class

    //this method creates a new Projectmanager for the project using prepared statements
    public static void newPM() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Poised_PMS?allowPublicKeyRetrieval=true&useSSL=false", "otheruser",
                "123"
        );
        // Create a direct line to the database for running our queries
        Statement statement = connection.createStatement();
        ResultSet results;
        Scanner input = new Scanner(System.in);


        System.out.print("Please enter the name of the Contractor: ");
        input = new Scanner(System.in);//asks the user what they should input
        String contractorname = input.nextLine();                   //reads user variable


        System.out.print("Please enter the Contractor phone number: ");
        input = new Scanner(System.in);
        int contractorphoneNumber = input.nextInt();


        System.out.print("Please enter the email address of the Contractor: ");
        input = new Scanner(System.in);
        String contractoremail = input.nextLine();

        System.out.print("Please enter the Contractor address: ");
        input = new Scanner(System.in);
        String contractorapddress = input.nextLine();

        String sql4 = "INSERT INTO Poised_PM VALUES(?, ?, ?, ? );";
        PreparedStatement preparedStatement4 =
                connection.prepareStatement(sql4);
        preparedStatement4.setString(1, contractorname);
        preparedStatement4.setInt(2, contractorphoneNumber);
        preparedStatement4.setString(3, contractoremail);
        preparedStatement4.setString(4, contractorapddress);
        preparedStatement4.execute();
        connection.close();


    }
}

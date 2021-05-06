package com.company;

import java.sql.*;
import java.util.Scanner;

public class project {

    //method that allows us to add all the information into our db
    //using prepared statements
    public static void newPROJECt() throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Poised_PMS?allowPublicKeyRetrieval=true&useSSL=false",
                "otheruser",
                "123"
        );
        // Create a direct line to the database for running our queries
        Statement statement = connection.createStatement();
        ResultSet results;
        Scanner input = new Scanner(System.in);

        System.out.print("\nPlease enter the name of the Contractor: ");//asks the user what they should input
        input = new Scanner(System.in);
        String contractorname = input.nextLine();                   //reads user variable


        System.out.print("Please enter the name of the customer first Name: ");
        input = new Scanner(System.in);
        String customername = input.nextLine();


        System.out.print("Please enter the Surname of the customer: ");
        input = new Scanner(System.in);
        String customerSurname = input.nextLine();


        System.out.print("Please enter the name of the architect: ");
        input = new Scanner(System.in);
        String archiname = input.nextLine();


        System.out.print("Please enter the Project number:");
        input = new Scanner(System.in);
        int projectnum = input.nextInt();


        System.out.print("Please enter the name of the Project: ");
        input = new Scanner(System.in);
        String projectName = input.next();


        System.out.print("Please enter the building type: ");
        input = new Scanner(System.in);
        String buildName = input.nextLine();


        System.out.print("Please enter the full Address: ");
        input = new Scanner(System.in);
        String Address = input.nextLine();


        System.out.print("Please enter the ERF number: ");
        input = new Scanner(System.in);
        int erfNum = input.nextInt();


        System.out.print("Please enter the total amount: R");
        input = new Scanner(System.in);
        float totalAmount = input.nextFloat();


        System.out.print("Please enter the total amount that has been paid so far: R");
        input = new Scanner(System.in);
        float totalAmountpaid = input.nextFloat();


        System.out.print("Please enter the deadline date e.g 2021-05-19: ");
        input = new Scanner(System.in);
        String deadline = input.nextLine();

        String sql = "INSERT INTO Poised_CLNT VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

        preparedStatement.setInt(1, projectnum);
        preparedStatement.setString(2,projectName);
        preparedStatement.setString(3,buildName);
        preparedStatement.setString(4,Address);
        preparedStatement.setInt(5,erfNum);
        preparedStatement.setFloat(6,totalAmount);
        preparedStatement.setFloat(7,totalAmountpaid);
        preparedStatement.setString(8,deadline);
        preparedStatement.setString(9,archiname);
        preparedStatement.setString(10,customername + customerSurname);
        preparedStatement.setString(11,contractorname);
        preparedStatement.execute();
        connection.close();

    }

}

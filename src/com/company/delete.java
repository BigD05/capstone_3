package com.company;

import java.sql.*;
import java.util.Scanner;

public class delete {

    public static void deleterow() throws SQLException { // our method that connects to the db and delets the specified data
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Poised_PMS?allowPublicKeyRetrieval=true&useSSL=false",
                "otheruser",
                "123"
        );
        // Create a direct line to the database for running our queries
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Poised_Project");
        System.out.println("all Current Projects");

        while (rs.next()) {
            int projectNum = rs.getInt("ProjectNum");
            String ProjectName = rs.getString("ProjectName");
            String BuildingType = rs.getString("BuildingType");
            String ProjAddress = rs.getString("ProjAddress");
            int erfNum = rs.getInt("erfNum");
            float TotalFee = rs.getFloat("TotalFee");
            float TotalPaid = rs.getFloat("TotalPaid");
            String deadline = rs.getString("deadline");
            String AssignedARCH = rs.getString("ASSignedARCH");
            String AssignedCLNT = rs.getString("AssignedCLNT");
            String AssignedPM = rs.getString("AssignedPM");
            System.out.println(projectNum + "  " + ProjectName + "  " + BuildingType + "  " + ProjAddress + "  " +
                    erfNum + "  " + TotalFee + "  " + TotalPaid + "  " + deadline + "  " + AssignedARCH + "  " + AssignedCLNT + "  " + AssignedPM);
        }


            Scanner input = new Scanner(System.in);
            System.out.print("Please select from the above projects based on the project number to delete or enter 0 to exit: ");
            int ans = input.nextInt();

            if(ans == 0){
                System.out.println("Good Bye!!");
            }
            else {
                String sql = "DELETE FROM Poised_Project WHERE ProjectNum = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,ans);

            }
        }
    }


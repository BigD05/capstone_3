package com.company;

import java.sql.*;
import java.util.Scanner;

public class updateDB {

    //this method allows us to update selected data and writes us a quote on set data
    //using prepared statements
    static public void printDb() throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Poised_PMS?allowPublicKeyRetrieval=true&useSSL=false", "otheruser",
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

        }rs.close();


        Scanner input = new Scanner(System.in);
        System.out.println("out of the above projects please select which one you want to edit/Finalise based on the projectNum");
        int answer = input.nextInt();
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM Poised_Project WHERE ProjectNUM = " + answer);
        System.out.println("\nchosen project");


        while (rs1.next()) {
            int projectNum = rs1.getInt("ProjectNum");
            String ProjectName = rs1.getString("ProjectName");
            String BuildingType = rs1.getString("BuildingType");
            String ProjAddress = rs1.getString("ProjAddress");
            int erfNum = rs1.getInt("erfNum");
            float TotalFee = rs1.getFloat("TotalFee");
            float TotalPaid = rs1.getFloat("TotalPaid");
            String deadline = rs1.getString("deadline");
            String AssignedARCH = rs1.getString("ASSignedARCH");
            String AssignedCLNT = rs1.getString("AssignedCLNT");
            String AssignedPM = rs1.getString("AssignedPM");
            System.out.println("   "+"   " + projectNum + "  " + ProjectName + "  " + BuildingType + "  " + ProjAddress + "  " +
                    erfNum + "  " + TotalFee + "  " + TotalPaid + "  " + deadline + "  " + AssignedARCH + "  " + AssignedCLNT + "  " + AssignedPM);


            System.out.println("\nPlease choose from the following on what you want to edit or enter 0 to Finalise project");
            System.out.println("1. BuildingType");
            System.out.println("2. ProjAddress");
            System.out.println("3. erfNumber");
            System.out.println("4. TotalFee ");
            System.out.println("5. TotalPaid");
            System.out.println("6. deadline");
            System.out.print("Enter answer here: ");
            int ans = input.nextInt();


            if(ans == 1){
                System.out.print("What would you like tp change building type to?: ");
                input = new Scanner(System.in);
                String newBuilding = input.nextLine();
                String sql2 = "UPDATE Poised_Project SET BuildingType =? WHERE ProjectNum =? ";
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement(sql2);
                preparedStatement2.setString(1,newBuilding);
                preparedStatement2.setInt(2,answer);
                preparedStatement2.execute();

            }if (ans == 2){
                System.out.print("What would you like to change ProjectAddress to?: ");
                input = new Scanner(System.in);
                int newERF = input.nextInt();
                String sql2 = "UPDATE Poised_Project SET erfNum =? WHERE ProjectNum =? ";
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement(sql2);
                preparedStatement2.setInt(1,newERF);
                preparedStatement2.setInt(2,answer);
                preparedStatement2.execute();


            }if (ans ==3){
                System.out.print("What would you like tp change erfNUmber to?: ");
                input = new Scanner(System.in);
                int newERF = input.nextInt();
                String sql2 = "UPDATE Poised_Project SET erfNum =? WHERE ProjectNum =? ";
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement(sql2);
                preparedStatement2.setInt(1,newERF);
                preparedStatement2.setInt(2,answer);
                preparedStatement2.execute();

            }if (ans == 4){
                System.out.print("What would you like to change TotalFee to?: ");
                input = new Scanner(System.in);
                float newTotalFee = input.nextFloat();
                String sql2 = "UPDATE Poised_Project SET TotalFee =? WHERE ProjectNum =? ";
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement(sql2);
                preparedStatement2.setFloat(1,newTotalFee);
                preparedStatement2.setInt(2,answer);
                preparedStatement2.execute();

            }if (ans == 5){
                System.out.print("What would you like to change TotalPaid to?: ");
                input = new Scanner(System.in);
                Float TotalPaid1 = input.nextFloat();
                String sql2 = "UPDATE Poised_Project SET TotalPaid =? WHERE ProjectNum =? ";
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement(sql2);
                preparedStatement2.setFloat(1,TotalPaid1);
                preparedStatement2.setInt(2,answer);
                preparedStatement2.execute();

            }if(ans == 6){
                System.out.print("What would you like to change the Deadline to e.g 2021-05-19?: ");
                input = new Scanner(System.in);
                String Deadline = input.nextLine();
                String sql2 = "UPDATE Poised_Project SET deadline =? WHERE ProjectNum =? ";
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement(sql2);
                preparedStatement2.setString(1,Deadline);
                preparedStatement2.setInt(2,answer);
                preparedStatement2.execute();

            }
                System.out.println("\nYour project has been finalised ");
                System.out.println("\n"+AssignedCLNT);
            System.out.println("-------------------------");
            System.out.println("Amount Due");
            System.out.print("R");
            System.out.println(TotalFee);
            System.out.println("-------------------------");
            System.out.println("Amount paid");
            System.out.print("R");
            System.out.println(TotalPaid);
            System.out.println("-------------------------");
            System.out.println("Amount Still to be owed");
            System.out.print("R");
            System.out.println(TotalFee-TotalPaid);

        }
    }

}

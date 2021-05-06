
package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;//import our scanner
import java.sql.*;//import sql to the folder



public class Poised {

    public static void main(String[] args) {

        //Variables for the project
        int i = 0;
        String completed = "No";

        Scanner input = new Scanner(System.in);//initiate our scanner

        //ask user for they choice if they would like to start a new project

        System.out.println("Start of a new Project please enter all the fields below");

        try {
//gets some user information for so  we know what to do
            Scanner inputs = new Scanner(System.in);
            System.out.println("Choose between the following options");
            System.out.println("1. create Project ");
            System.out.println("2. Update/Finalise Project");
            System.out.println("3. Delete Project");
            System.out.println("0. exit");
            System.out.print("Enter from the above options: ");
            int answer = inputs.nextInt();


                if (answer == 1) {
//calls the appropriate classes that connect to mysql database and send information to it
                    architect newarchi = new architect();
                    customer newcust = new customer();
                    project newproj = new project();
                    contractor newpm = new contractor();
                    newcust.newCLNT();
                    newarchi.newARCH();
                    newpm.newPM();
                    newproj.newPROJECt();




                }
                if (answer == 2) {
//a class which allows you to change specific information within the database
                    updateDB displayPro = new updateDB();
                    displayPro.printDb();

                }
                //a class allows you to delete the specified project
                if (answer == 3){
                    delete del = new delete();
                    del.deleterow();

                }
                else{//good bye message
                    System.out.println(" All done Have a great Day!!!");

                }


            } catch (InputMismatchException | SQLException e) {
                System.out.println(e);
            }

    }


}










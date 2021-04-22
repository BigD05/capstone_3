
package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;//import our scanner
import java.util.StringJoiner;


public class Poised {

    public static void main(String[] args) {

       //Variables for the project
        int i = 0;
        String completed = "No";
        ArrayList<String> arrOfStr = new ArrayList<>();
        String[] arrOfProjects = new String[9];
        ArrayList<String> neatenArray = new ArrayList<>();
        ArrayList<String> UncompletedArray = new ArrayList<>();
        String s = "";
        String fullProg = null;
        String key = null;
        String[] change = new String[2];


        Scanner input = new Scanner(System.in);//initiate our scanner

        //ask user for they choice if they would like to start a new project

        System.out.print("Please select from the below number options on what you would like to do.");
        System.out.println("\n1- Create project");
        System.out.println("2- update an Existing project");
        System.out.println("3- Show Uncompleted projects");
        System.out.println("4- Show projects past due date");
        System.out.println("5- Finalise a project");
        System.out.print("Please enter the option here: ");
        int ans = input.nextInt();//reads the user input and stores it in the variable

        try {

            if (ans == 1) {                                                                            //if the user input is equal to yes then the following code will run

                //line 35 to line 130 is basically the same thing besides the different variable names
                //takes in the names of the users

                System.out.print("Please enter the name of the Contractor: ");//asks the user what they should input
                input = new Scanner(System.in);                              //creates scanner
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


                System.out.print("\nPlease enter the name of the architect: ");
                input = new Scanner(System.in);
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


                System.out.println("\nPlease enter the name of the customer: ");
                input = new Scanner(System.in);
                String customername = input.nextLine();


                System.out.println("Please enter the customer phone number: ");
                input = new Scanner(System.in);
                int customerphoneNumber = input.nextInt();


                System.out.println("Please enter the email address of the customer: ");
                input = new Scanner(System.in);
                String customeremail = input.nextLine();


                System.out.println("Please enter the customer address: ");
                input = new Scanner(System.in);
                String customerAddress = input.nextLine();


                System.out.println("\nPlease enter the Project number:");
                int projectnum = input.nextInt();


                System.out.println("Please enter the name of the Project: ");
                String projectName = input.next();


                System.out.println("Please enter the building type: ");
                input = new Scanner(System.in);
                String buildName = input.nextLine();


                System.out.println("Please enter the full Address: ");
                input = new Scanner(System.in);
                String Address = input.nextLine();


                System.out.println("Please enter the ERF number: ");
                input = new Scanner(System.in);
                int erfNum = input.nextInt();


                System.out.print("Please enter the total amount: R");
                input = new Scanner(System.in);
                double totalAmount = input.nextFloat();


                System.out.print("Please enter the total amount that has been paid so far: R");
                input = new Scanner(System.in);
                double totalAmountpaid = input.nextFloat();


                System.out.print("Please enter the deadline date e.g 20 October 2021: ");
                input = new Scanner(System.in);
                String deadline = input.nextLine();



                //prints out the projects using the method toString()


                customer newCustomer = new customer(customername, customerphoneNumber, customeremail, customerAddress);//initializes the customer
                System.out.println(newCustomer.toString());                                                         //prints out the customer details using toString() method


                architect newArchitect = new architect(archiname, archiphoneNumber, archiemail, archiAddress);//initializes the customer
                System.out.println(newArchitect.toString());                                              //prints out the architect details using the toString() method


                contractor newContractor = new contractor(contractorname, contractorphoneNumber, contractoremail, contractorapddress);//initializes the contractor
                System.out.println(newContractor.toString());                                                                      //prints out the contractors details using toString() method


                try {

                    projectStart newProject = new projectStart(projectnum, projectName, buildName, Address, erfNum, totalAmount, totalAmountpaid, deadline, completed);
                    String data = newProject.toString();

                    File f1 = new File("projects.txt");
                    FileWriter fileWritter = new FileWriter(f1.getName(), true);
                    BufferedWriter bw = new BufferedWriter(fileWritter);
                    bw.write(data);
                    bw.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }

//updates the project
            }  if (ans == 2) {


                //adding the lines to a file and allowing the updating of set lines
                try {

                    BufferedReader br = new BufferedReader(new FileReader("projects.txt"));
                    System.out.println("\nALL the Projects!!");

                    while ((s = br.readLine()) != null) { //adds the lines into our array
                        i++;
                        System.out.println(i + "- " + s);
                        arrOfStr.add(s);
                    }


                    System.out.print("\nChoose between the above projects to edit by (selecting the number given to it on the line!): ");
                    int opt = input.nextInt(); //asks for user input


                    if (opt > 0) ; //adds the contents of the selected array into the new array
                    String line = arrOfStr.get(opt - 1);
                    arrOfProjects = line.split(",", 0);
                    System.out.print("\nWould you like to change anything from the above selection by choosing the numbers " +
                            "between " + "1-8" + "(Note you cannot edit value(0) project number): ");
                    int opt1 = input.nextInt();


                    String element = "";
                    if (opt1 > 0)
                        element = arrOfProjects[opt1];
                    System.out.println("\noption chosen");
                    System.out.println(element);
                    change = element.split(":");


                    System.out.print("What would you like to change to: ");
                    input = new Scanner(System.in);
                    String newval = input.nextLine();
                    change[1] = newval + "";


                    for (int t = 0; t < change.length; t++) {
                        arrOfProjects[opt1] = change[0] + ": " + change[1];

                    }

                    StringJoiner joiner = new StringJoiner("");
                    for (int d = 0; d < arrOfProjects.length; d++) {
                        joiner.add(arrOfProjects[d] + ",");

                    }
                    fullProg = joiner.toString();
                    System.out.println("Project After Edit!!");
                    System.out.println(fullProg);
                    modifyFile("projects.txt", arrOfStr.get(opt-1),fullProg );

                } catch (Exception ex) {
                    return;  }
            }




//Prints out all the Uncompleted projects
            if (ans == 3) {

                BufferedReader br = new BufferedReader(new FileReader("projects.txt"));
                while ((s = br.readLine()) != null) { //adds the lines into our array
                    arrOfStr.add(s);
                }

                int c = 0;
                String element;

                while (c < arrOfStr.size()) {
                    c++;
                    String line = arrOfStr.get(c-1);
                    arrOfProjects = line.split(",", 0);
                    element = arrOfProjects[arrOfProjects.length - 1] + "\n";

                    if(element.equals(" Completed: No\n")) {
                        for (int m = 0; m < arrOfProjects.length; m++) {
                            System.out.print(arrOfProjects[m]);

                            }
                        }
                    }


                        br.close();
                    }

           //checks if a project it passed due date
            if(ans == 4) {
                BufferedReader br = new BufferedReader(new FileReader("projects.txt"));
                System.out.println("\nProjects not completed!!\n");
                while ((s = br.readLine()) != null) { //adds the lines into our arrayarrOfStr.add(s);
                }


                System.out.print("Please enter the current date e.g (30 October 2022): ");
                String contexts = "Deadline date: ";
                input = new Scanner(System.in);
                String dateChoice = input.nextLine();



                int c = 0;
                String element = null;
                while (c < arrOfStr.size()) {
                    c++;
                    String line = arrOfStr.get(c - 1);
                    arrOfProjects = line.split(",", 0);
                    element = arrOfProjects[arrOfProjects.length - 2];


                    if (element.equals("Deadline date: "+dateChoice) ){
                        System.out.println("Projects passed due date!!1");
                        for(int m = 0 ; m<arrOfProjects.length; m++){
                            System.out.print(arrOfProjects[m]);
                        }

                    }
                }
            }


            //finalises the project
            if(ans == 5){

                BufferedReader br = new BufferedReader(new FileReader("projects.txt"));
                System.out.println("\nALL the Projects!!");

                while ((s = br.readLine()) != null) { //adds the lines into our array
                    i++;
                    System.out.println(i + "- " + s);
                    arrOfStr.add(s);
                }


                System.out.print("\nChoose between the above projects to Finalise: ");
                int opt = input.nextInt(); //asks for user input


                if (opt > 0); //adds the contents of the selected array into the new array
                    String line = arrOfStr.get(opt - 1);
                    arrOfProjects = line.split(",", 0);
                    String newval = "Yes";
                    String element = "";
                    element = arrOfProjects[8];
                change = element.split(":");
                change[1] = newval + "";


                for (int t = 0; t < change.length; t++) {
                    arrOfProjects[8] = change[0] + ": " + change[1];

                }

                StringJoiner joiner = new StringJoiner("");
                for (int d = 0; d < arrOfProjects.length; d++) {
                    joiner.add(arrOfProjects[d] + ",");

                }

                fullProg = joiner.toString();
                System.out.println(fullProg);
                modifyFile("projects.txt", arrOfStr.get(opt-1),fullProg );

                    System.out.println("\nThe following project has been Finalised\n");

                for(String l :arrOfProjects){
                    System.out.println(l);
                   String  data = l;
                    File f1 = new File("Finalise.txt");
                    FileWriter fileWritter = new FileWriter(f1.getName(), true);
                    BufferedWriter bw = new BufferedWriter(fileWritter);
                    bw.write(data);
                    bw.close();
                }
                System.out.println("\nThe "+ arrOfProjects[5]+" for  the project" );


            }

        }catch (InputMismatchException | IOException e) {
            System.out.printf("entered the wrong value please restart!");

        }

    }



    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}


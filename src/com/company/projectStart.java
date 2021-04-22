package com.company;

public class projectStart {
    int projectNum;
    String projectName;
    String buildName;
    String Address;
    int erfNum;
    double totalAmount;
    double totalAmountpaid;
    String deadline;
    String completed;

    public projectStart(int projectNum, String projectName, String buildName, String Address, int erfNum, double totalAmount, double totalAmountpaid, String deadline,
                        String completed) {
        this.projectNum = projectNum;
        this.projectName = projectName;
        this.buildName = buildName;
        this.Address = Address;
        this.erfNum = erfNum;
        this.totalAmount = totalAmount;
        this.totalAmountpaid = totalAmountpaid;
        this.deadline = deadline;
        this.completed = completed;
    }

    public String toString() {
        String output =  "Project Number: " + projectNum + ",";
         output = output + " Project Name: " + projectName + ",";
        output = output + " Building Type: " + buildName + ",";
        output = output + " Address: " + Address + ",";
        output = output + " ERF number: " + erfNum + ",";
        output = output + " Total amount: R" + totalAmount + ",";
        output = output + " Total amount paid: R" + totalAmountpaid + ",";
        output = output + " Deadline date: " + deadline + ",";
        output = output + " Completed: " + completed + "\n";
        return output;
    }
}

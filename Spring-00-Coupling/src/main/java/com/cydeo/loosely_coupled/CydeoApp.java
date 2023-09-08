package com.cydeo.loosely_coupled;

//What is the coupling?
    //One object requires another object to complete its assigned task.
//Loosly coupling: reduces the dependencies of a class that uses the different classes directly!
public class CydeoApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();
        ///PartTimeMentor partTime = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();

    }
}

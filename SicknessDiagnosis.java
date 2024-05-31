import java.util.Scanner;

public class SicknessDiagnosis{
public static void main (String[]args){
Scanner scanner = new Scanner(System.in);

System.out.println("Welcome to the Sickness Diagnosis Program");

System.out.println("============================================");

System.out.println("Please answer the following questions (yes/no) : ");

System.out.print("Do you have a headache?");
String hasHeadache = scanner.nextLine().toLowerCase();

System.out.println("Do you feel cold? ");
String feelsCold = scanner.nextLine().toLowerCase();

System.out.println("Are you sweating? ");
String isSweating = scanner.nextLine().toLowerCase();

if(hasHeadache.equals("yes") && feelsCold.equals("yes") && isSweating.equals("yes")){
System.out.println("You may have a fever");
}else if (hasHeadache.equals("yes") && feelsCold.equals("yes") && isSweating.equals("no")){
System.out.println("You may have a cold. ");
}else if(hasHeadache.equals("no") && feelsCold.equals("yes") && isSweating.equals("yes")){
System.out.println("You may be experiencing flu like symptoms. ");
}else{
System.out.println("We couldn't diagnose your sickness based on the given symptoms. ");
}
}
}


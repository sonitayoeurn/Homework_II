package exception;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    String gender;
    int age;
    String classRoom;
    int score;

    Student(){}

    public Student(int id, String name, String gender, int age, String classRoom, int score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classRoom = classRoom;
        this.score = score;
    }

    void outputInformation(){
        System.out.println("Student ID : " +id);
        System.out.println("Student Name : " +name);
        System.out.println("Student Gender : " +gender);
        System.out.println("Student Age : " + age);
        System.out.println("Classroom Name : " + classRoom);
        System.out.println("Student Score : " +score);
        System.out.println("------------------------------------------------------------------");
    }

    void inputInformation(){
        boolean isIDValid = false;
        boolean isAgeValid = false;
        boolean isScoreValid = false;
        Scanner input = new Scanner(System.in);
        do{
            String strId;
            System.out.print("Enter Student ID : ");
            try{
                strId = input.next();
                id = Integer.parseInt(strId);
                isIDValid = true;
            }catch (Exception ex){
                System.out.println("ERROR !! ID can only be Integer...! ");
            }
        }while(!isIDValid);

        System.out.print("Enter Student Name : ");
        input.nextLine();
        name = input.nextLine();
        System.out.print("Enter Student Gender : ");
        gender = input.nextLine();

        do{
            String strAge;
            System.out.print("Enter Student AGE : ");
            try{
                strAge = input.next();
                age = Integer.parseInt(strAge);
                isAgeValid = true;
            }catch (Exception ex){
                System.out.println("ERROR !! AGE can only be Integer...! ");
            }
        }while(!isAgeValid);

        System.out.print("Enter Classroom Name : ");
        input.nextLine();
        classRoom = input.nextLine();

        do{
            String strScore;
            System.out.print("Enter Student Score : ");
            try{
                strScore = input.next();
                score = Integer.parseInt(strScore);
                isScoreValid = true;
            }catch (Exception ex){
                System.out.println("ERROR !! Score cannot be String...! ");
            }
        }while(!isScoreValid);

        System.out.println("SUCCESSFULLY ADDED STUDENT TO THE SYSTEM!!");
    }

}
public class Main {
    static void pressEnterKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================Press Enter to continue========================");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n==================== ISTAD STUDENT MANAGEMENT SYSTEM ==================== ");
            System.out.println("1. Insert Student to System ");
            System.out.println("2. Edit Student Information ");
            System.out.println("3. Search Student Information ");
            System.out.println("4. Delete Student Information ");
            System.out.println("5. Show Student Information ");
            System.out.println("6. Exit");

            do{
                String strOption;
                System.out.print(">>>>> Choose your option from 1-6 : ");
                strOption = input.nextLine();
                try {
                    option = Integer.parseInt(strOption);

                    if (option <= 0 || option > 6) {
                        System.out.println("Wrong option ! Choose again from 1-6 ");
                        option = 0;
                    }
                } catch (Exception e) {
                    System.out.println("ERROR !! INVALID INPUT...! TRY AGAIN");
                    option = 0;
                }
            }while (option == 0);


            switch (option){
                case 1 :
                    System.out.println("------------------------ Insert Student to System ------------------------");
                    Student newWorker = new Student();
                    newWorker.inputInformation();
                    students.add(newWorker);
                    pressEnterKey();
                    break;
                case 2 :
                    System.out.println("------------------------ Update Student's Information ------------------------");
                    boolean idExist = false;
                    boolean isIDValid = false;
                    boolean isAgeValid = false;
                    boolean isScoreValid = false;
                    int editID = 0;
                    do{
                        String strId;
                        System.out.print("Enter Student's ID to search : ");
                        try{
                            strId = input.next();
                            editID = Integer.parseInt(strId);
                            isIDValid = true;
                        }catch (Exception ex){
                            System.out.println("ERROR !! ID can only be Integer...! ");
                        }
                    }while(!isIDValid);
                    for(int i = 0; i < students.size(); i++){
                        if (students.get(i).id == editID) {
                            idExist = true;
                            System.out.println("--------------- Enter new Student Information -----------");
                            System.out.print("Enter Student Updated Name : ");
                            input.nextLine();
                            students.get(i).name = input.nextLine();
                            System.out.print("Enter Student Updated Gender : ");
                            students.get(i).gender = input.nextLine();
                            do{
                                String strAge;
                                System.out.print("Enter Student Updated AGE : ");
                                try{
                                    strAge = input.next();
                                    students.get(i).age = Integer.parseInt(strAge);
                                    isAgeValid = true;
                                }catch (Exception ex){
                                    System.out.println("ERROR !! AGE can only be Integer...! ");
                                }
                            }while(!isAgeValid);
                            System.out.print("Enter Student Updated Classroom : ");
                            input.nextLine();
                            students.get(i).classRoom = input.nextLine();

                            do{
                                String strScore;
                                System.out.print("Enter Student Updated Score : ");
                                try{
                                    strScore = input.next();
                                    students.get(i).score = Integer.parseInt(strScore);
                                    isScoreValid = true;
                                }catch (Exception ex){
                                    System.out.println("ERROR !! Score cannot be String...! ");
                                }
                            }while(!isScoreValid);

                            System.out.println("Student with ID : " + editID + " has updated successfully.");
                            pressEnterKey();
                            input.nextLine();
                        }
                    }
                    if(!idExist){
                        System.out.println("Student with ID of " + editID + " doesn't exist! Try Different One!");
                        pressEnterKey();
                        input.nextLine();
                    }
                    break;
                case 3 :
                    if(students.size() > 0){
                        int searchOption;
                        System.out.println("------------------------ Search Student Information ------------------------");
                        do{
                            System.out.println("1. Search By ID ");
                            System.out.println("2. Search By Name");
                            System.out.println("3. Search By Gender");
                            System.out.println("4. Search By Classname");
                            System.out.println("5. Exit.......");

                            do{
                                String strOption;
                                System.out.print(">>>>> Choose option from 1-5 : ");
                                strOption = input.nextLine();
                                try {
                                    searchOption = Integer.parseInt(strOption);

                                    if (searchOption <= 0 || searchOption > 5) {
                                        System.out.println("Wrong option ! Choose again from 1-5 ");
                                        searchOption = 0;
                                    }
                                } catch (Exception e) {
                                    System.out.println("ERROR !! INVALID INPUT...! TRY AGAIN");
                                    searchOption = 0;
                                }
                            }while (searchOption == 0);

                            switch (searchOption){
                                case 1 :
                                    int searchID = 0;
                                    boolean isIDExist = false;
                                    boolean isWorkerExist = false;
                                    System.out.println("================== Search by ID ==================");

                                    do{
                                        String strId;
                                        System.out.print("Enter Student ID to search : ");
                                        try{
                                            strId = input.next();
                                            searchID = Integer.parseInt(strId);
                                            isIDExist = true;
                                        }catch (Exception ex){
                                            System.out.println("ERROR !! ID can only be Integer...! ");
                                        }
                                    }while(!isIDExist);

                                    for(int i = 0; i < students.size(); i++){
                                        if(searchID == students.get(i).id){
                                            isWorkerExist = true;
                                            System.out.println("--------------- Result of search by ID ------------------");
                                            students.get(i).outputInformation();
                                        }
                                    }
                                    if(!isWorkerExist){
                                        System.out.println("Student with ID of " +searchID+ " doesn't exist !!!");
                                    }
                                    pressEnterKey();
                                    input.nextLine();
                                    break;
                                case 2 :
                                    boolean isNameExist = false;
                                    System.out.println("------------------------Search by Name------------------------");
                                    String searchName;
                                    System.out.print("Enter Student Name to search : ");
                                    searchName = input.nextLine();

                                    for(int i = 0; i < students.size(); i++){
                                        if(searchName.equalsIgnoreCase(students.get(i).name)){
                                            isNameExist = true;
                                            System.out.println("--------------- Result of search by Name ------------------");
                                            students.get(i).outputInformation();
                                        }
                                    }if(!isNameExist){
                                    System.out.println("Student Name " +searchName+ " doesn't exist !!!");
                                }
                                    pressEnterKey();
                                    break;
                                case 3 :
                                    boolean isGenderExist = false;
                                    System.out.println("------------------------Search by Gender------------------------");
                                    String searchGender;
                                    System.out.print("Enter Student Gender to search : ");
                                    searchGender = input.nextLine();

                                    for(int i = 0; i < students.size(); i++){
                                        if(searchGender.equalsIgnoreCase(students.get(i).gender)){
                                            isGenderExist = true;
                                            System.out.println("--------------- Result of search by Name ------------------");
                                            students.get(i).outputInformation();
                                        }
                                    }if(!isGenderExist){
                                    System.out.println("Student with gender " +searchGender+ " doesn't exist !!!");
                                }
                                    pressEnterKey();
                                    break;
                                case 4 :
                                    boolean isClassNameExist = false;
                                    System.out.println("------------------------Search by ClassName------------------------");
                                    String searchClassName;
                                    System.out.print("Enter Classroom Name to search : ");
                                    searchClassName = input.nextLine();

                                    for(int i = 0; i < students.size(); i++){
                                        if(searchClassName.equalsIgnoreCase(students.get(i).classRoom)){
                                            isClassNameExist = true;
                                            System.out.println("--------------- Result of search by Classname ------------------");
                                            students.get(i).outputInformation();
                                        }
                                    }if(!isClassNameExist){
                                    System.out.println("There is no student in classroom name " +searchClassName+ " in our system !!!");
                                }
                                    pressEnterKey();
                                    break;
                                case 5 :
                                    System.out.println("Exit the search option!");
                                    pressEnterKey();
                                    break;
                            }
                        }while (searchOption != 5);
                    }else {
                        System.out.println("There is no student in the system yet !!");
                    }
                    break;
                case 4 :
                    boolean idfound = false;
                    int removeID = 0;

                    boolean isDelteIDExist = false;
                    do{
                        String strId;
                        System.out.print("Enter the student ID to delete : ");
                        try{
                            strId = input.next();
                            removeID = Integer.parseInt(strId);
                            isDelteIDExist = true;
                        }catch (Exception ex){
                            System.out.println("ERROR !! ID can only be Integer...! ");
                        }
                    }while(!isDelteIDExist);

                    for(int i = 0; i < students.size(); i++){
                        if (students.get(i).id == removeID) {
                            idfound = true;
                            students.remove(i);
                            System.out.println("Student with ID : " + removeID + " has removed successfully.");
                            pressEnterKey();
                            input.nextLine();
                        }
                    }
                    if(!idfound) {
                        System.out.println("Wrong ID, Please input ID again.");
                        pressEnterKey();
                        input.nextLine();

                    }
                    break;

                case 5 :
                    System.out.println("\n------------------------Show Student Information------------------------");
                    for (int i = 0; i < students.size(); i++) {
                        students.get(i).outputInformation();
                    }
                    pressEnterKey();
                    break;
                case 6 :
                    System.out.println("Exit the program");
                    break;
            }
        }while (option != 6);
    }
}






















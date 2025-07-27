import Utility.Utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void welcome(){
        DayOfWeek day = Utility.get_day();
        LocalDate date = Utility.get_today_date();
        String time = Utility.get_current_time();
        System.out.println(time+" | "+date+" | "+day);

    }
    public static void main_menu(){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Enter 1 : Sign In");
        System.out.println("Enter 2 : Sign Up");
        System.out.println("Enter -1 : Exit ");
        System.out.println("--------------------------------------------------------------------------------------------------------");

    }


    public static void main(String[] args) {
        welcome();


        Scanner scan = new Scanner(System.in);
        while(true) {
            main_menu();
            System.out.println("Response : ");
            Integer command = scan.nextInt();
            switch (command) {
                case (1):
                    Sign_In signin = new Sign_In();
                    Thread thread = new Thread(signin);
                    thread.start();
                    try {
                        thread.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case (2):
                    Sign_Up sign_up = new Sign_Up();
                    Thread thread_ = new Thread(sign_up);
                    thread_.start();
                    try{
                        thread_.join();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    //System.out.println("Sign Up...");
                    break;
                case (-1):
                    System.out.println("Exit...");
                    return;

            }
        }





    }
}
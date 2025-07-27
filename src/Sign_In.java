import Utility.Utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Sign_In implements Runnable{
    public static void welcome(Profile profile){
        DayOfWeek day = Utility.get_day();
        LocalDate date = Utility.get_today_date();
        String time = Utility.get_current_time();
        String name = profile.getUser().getFul_name();
        String index = profile.getUser().getIndex();


        System.out.println("=====================================================================================================================================================");
        System.out.println("Welcome "+name+" | "+" Log In at : "+time+"  "+date+"  "+day);
        System.out.println("Index number : "+index);
        System.out.println("=====================================================================================================================================================");


    }
    public static void main_menu(){
        System.out.println("-----------------------------------------");
        System.out.println("Enter 1 : Setting ");
        System.out.println("Enter 2 :Review Account ");
        System.out.println("Enter -1 : Log out ");
        System.out.println("-----------------------------------------");
    }
    @Override
    public void run() {
        ArrayList<Object> profile_list= Utility.deserealize("user_profile.ser");
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter User name : ");
        String username = scan.nextLine();
        System.out.println("Password : ");
        String password = scan.nextLine();

        for(Object obj : profile_list){
            if(obj instanceof Profile) {
                Profile profile = (Profile) obj;
                if (profile.getPassword().equals(password) && profile.getUser_name().equals(username)) {
                    welcome(profile);
                    while(true) {
                        try {
                            main_menu();
                            System.out.println("Response : ");
                            Scanner scan_1 = new Scanner(System.in);
                            Integer command = scan_1.nextInt();
                            switch (command) {
                                case (1):
                                    Setting setting = new Setting(profile);
                                    Thread thread = new Thread(setting);
                                    thread.start();
                                    try{
                                        thread.join();

                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                    break;
                                case (2):
                                    User user = profile.getUser();
                                    Utility.slow_down(200);
                                    System.out.println("USER INFO :");
                                    System.out.println("===============================================================================================");
                                    System.out.println("Ful name : "+ user.getFul_name()+" | "+"Index Number : "+user.getIndex() );
                                    //System.out.println("Index Number : "+user.getIndex());
                                    System.out.println("Address : "+ user.getAddress() );
                                    System.out.println("Birthday : "+user.getBirthdate());
                                    System.out.println("Gender : "+user.getGender());
                                    System.out.println("Mob_No : "+user.getPhonenumber()+" | "+"Country : "+user.getCountry());
                                    System.out.println("===============================================================================================");

                                    break;
                                case (-1):
                                    System.out.println("Exit.......");
                                    return;


                            }
                        }catch(Exception e){
                            System.out.println("Log In Error....");
                            e.printStackTrace();
                        }
                    }

                }
            }

        }

    }
}


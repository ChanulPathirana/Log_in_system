import Utility.Utility;
import java.time.*;
import java.io.*;
import java.util.Scanner;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

public class Sign_Up implements Runnable {
    private static final Object file_lock = new Object();
    private static final Object file_lock_ = new Object();
    public static void write_safe_(Profile profile){
        String file_name = "user_profile.ser";
        boolean append;
        synchronized (file_lock_){
            append = new File(file_name).exists();
        }
        try(ObjectOutputStream out = append
                ? new AppendableObjectOutputStream(new FileOutputStream(file_name,true))
                :new ObjectOutputStream(new FileOutputStream(file_name))){
            out.writeObject(profile);
            //System.out.println(profile.getUser().getFul_name() + "is Serialized ");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void write_safe(User user){
        String file_name = "user.ser";
        boolean append;
        synchronized (file_lock){
            append = new File(file_name).exists();
        }
        try(ObjectOutputStream out = append
                ? new AppendableObjectOutputStream(new FileOutputStream(file_name,true))
                :new ObjectOutputStream(new FileOutputStream(file_name))){
            out.writeObject(user);
            //System.out.println(profile.get_user().get_name() + "is Serialized ");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main_menu(){
        System.out.println("Enter  1 : Save ");
        System.out.println("Enter 2 : Review Details ");
        System.out.println("Enter -1 : Exit ");

    }
    public static String Generate_birthday(String year,String month,String date){
        StringBuilder builder = new StringBuilder();
        builder.append(year);
        builder.append("-");
        builder.append(month);
        builder.append("-");
        builder.append(date);
        String day = builder.toString();
        return day;

    }
    public static String Fisrt_letter_Capitalize(String string){
        return string.substring(0,1).toUpperCase()+string.substring(1);


    }
    public static String generate_index(){
        Integer count =1;
        ArrayList<Object> list = Utility.deserealize("user.ser");
        for(Object obj : list){
            if(obj instanceof User){
                count++;
            }
        }
        count = count+1000;

        int current_year = LocalDate.now().getYear();
        String str_year = String.valueOf(current_year);
        String str_index = String.valueOf(count);
        StringBuilder builder = new StringBuilder();
        builder.append("EMP");
        builder.append("/");
        builder.append(str_year);
        builder.append("/");
        builder.append(str_index);
        String index = builder.toString();
        return index;


        //String index ;

    }
    /*
    public static void main(String[] args){
        System.out.println(generate_index());
    }

     */


    public void run(){
        String index = generate_index();
        Scanner scan = new Scanner(System.in);
        System.out.println("=================================================================================================================================================================");
        System.out.println("Personal Information ");
        System.out.println(" First_name :");
        String First_name = scan.nextLine();
        System.out.println(" Last_name :");
        String Last_name = scan.nextLine();
        System.out.println(" Address :");
        String Adress = scan.nextLine();
        System.out.println(" Gender :");
        String gender = scan.nextLine();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Birth Day Info : ");
        System.out.println("Year : ");
        String year= scan.nextLine();
        System.out.println("Month : Enter Months  ");
        String month = scan.nextLine();
        System.out.println("Date  : ");
        String  Date = scan.nextLine();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Communicate Info : ");
        System.out.println(" Country : ");
        String Country = scan.nextLine();
        System.out.println(" Mobile Number : ");
        String Mobile_no = scan.nextLine();
        String index_ = generate_index();
        System.out.println("=================================================================================================================================================================");
        User user = new User(First_name,Last_name,Adress,Generate_birthday(year,month,Date),index_,gender,Mobile_no,Fisrt_letter_Capitalize(Country));
        System.out.println("Profile Info....");
        String Username = Utility.generate_username(user.getSecond_name(),user.getIndex());

        String Password=scan.nextLine();
        String Re_Password = scan.nextLine();
        if(Password.equals(Re_Password) && Password.length()>=12 && Re_Password.length()>=12){
            Profile profile = new Profile(Username,Password,user);


        }
        /*
        main_menu();
        System.out.println("Response : ");
        Integer command = scan.nextInt();

         */
        /*
        switch(command){
            case(1):
                ;
                break;
            case(2):
                break;
            case(-1):
                System.out.println("Exit.....");
                return;

        }

         */








    }


}
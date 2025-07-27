package Utility;

import java.io.*;
import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Utility {

    public static void slow_down(int time){
        try {

            Thread.sleep(time);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static String get_current_time(){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm:ss ");
        LocalTime time_1 = LocalTime.now();
        String str_time = time_1.format(formatter);
        return str_time;



    }
    public static LocalDate get_today_date(){
        LocalDate today= LocalDate.now();
        return today;

    }
    public static DayOfWeek get_day(){
        LocalDate today= LocalDate.now();
        DayOfWeek day = today.getDayOfWeek();
        return day;

    }


    public static String generate_username(String lastname,String index){
        String[] prt_1 = index.split("/");
        String username = lastname.toLowerCase()+"."+prt_1[prt_1.length-1];
        return username;

    }
    public static String generate_password(int length){
        String upper= "ABCDEFGHIJKLMNOQRSTUWXYZ";
        String lower= "abcdefghijklmnopqrstuvwxyz";
        String digit = "1234567890";
        String symbol = "!@#$%^&*?";
        String allchars = upper+lower+digit+symbol;
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            switch(i){
                case 0:
                    Integer fisrtindex = random.nextInt(upper.length());
                    builder.append(upper.charAt(fisrtindex));
                    break;
                case 1:
                    Integer secondindex = random.nextInt(lower.length());
                    builder.append(lower.charAt(secondindex));
                    break;
                case 10:
                    Integer prev_index = random.nextInt(digit.length());
                    builder.append(digit.charAt(prev_index));
                    break;
                case 11:
                    Integer last_index = random.nextInt(digit.length());
                    builder.append(digit.charAt(last_index));
                    break;

                default:
                    Integer index = random.nextInt(allchars.length());
                    builder.append(allchars.charAt(index));
                    break;

            }
        }



        return builder.toString();
    }
    //private static final Object file_lock = new Object();
    public static ArrayList<String[]> Reader(String filename){
        ArrayList<String[]> list=new ArrayList<>();
        try{
            FileReader file = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(file);
            String line;
            while((line = buffer.readLine()) != null) {
                String[] row = line.split("\\|");
                list.add(row);





            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return list;


    }
    public static String write_trim(String[] obj,Integer i){
        return obj[i].trim();
    }
    public static void append_object(String filename){



    }
    public static ArrayList<Object> deserealize(String filename){
        ArrayList<Object> list_1 = new ArrayList<>();
        //String file_name = filename;
        try{
                FileInputStream in = new FileInputStream(filename);
                ObjectInputStream obj = new ObjectInputStream(in);
                while(true){
                    try{
                        Object obj_1  = (Object) obj.readObject();
                        list_1.add(obj_1);

                    }catch(EOFException e){
                        break;
                        //e.printStackTrace();


                }

            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return list_1;


    }
    /*public static void safe_serealize(String filename,Object object){
        String file_name = filename;
        boolean append;
        synchronized (file_lock){
            append= new File(file_name).exists();

        }
        try(ObjectOutputStream out = append
                ? new AppendableObjectOutputStream(new FileOutputStream(file_name,true))
                :new ObjectOutputStream(new FileOutputStream(file_name))){
            out.writeObject(object);
            //System.out.println(profile.get_user().get_name() + "is Serialized ");

        }catch(IOException e){
            e.printStackTrace();
        }










    }*/

}

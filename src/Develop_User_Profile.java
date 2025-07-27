import Utility.Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;

public class Develop_User_Profile {


    private static final Object file_lock = new Object();
    /*public static String generate_username(String lastname,String index){
        String[] prt_1 = index.split("/");
        String username = lastname+"."+prt_1[prt_1.length-1];
        return username;

    }

     */
    /*public static String generate_password(int length){
        String upper= "ABCDEFGHIJKLMNO[QRSTUWXYZ";
        String lower= "abcdefghijklmnopqrstuvwxyz";
        String digit = "1234567890";
        String symbol = "!@#$%^&*?/";
        String allchars = upper+lower+digit+symbol;
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            Integer index = random.nextInt(allchars.length());
            builder.append(allchars.charAt(index));
        }



        return builder.toString();
    }

     */


    public static void write_safe(Profile profile){
        String file_name = "user_profile.ser";
        boolean append;
        synchronized (file_lock){
            append = new File(file_name).exists();
        }
        try(ObjectOutputStream out = append
                ? new AppendableObjectOutputStream(new FileOutputStream(file_name,true))
                :new ObjectOutputStream(new FileOutputStream(file_name))){
            out.writeObject(profile);
            System.out.println(profile.getUser().getFul_name() + "is Serialized ");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        ArrayList<Object> user_list = Utility.deserealize("user.ser");
        ArrayList<String[]> list_1 = Utility.Reader("user_login_list.txt");


        for(Object obj : user_list){
            if(obj instanceof User){
                User user = (User) obj;
                //Integer index =0;
                for(String[] row : list_1){
                    String index = row[0].trim();
                    if(index.equals(user.getIndex())){
                        String username = row[1].trim();
                        String password = row[2].trim();
                        Profile profile = new Profile(username,password,user);
                        write_safe(profile);

                        System.out.println(profile.getUser().getIndex()+" "+profile.getUser().getFul_name()+" Profile is Created");
                        try{
                            FileWriter file = new FileWriter("user_ful_text.txt",true);
                            BufferedWriter buffer = new BufferedWriter(file);
                            buffer.write(profile.getUser().getIndex()+" | "+profile.getUser().getFul_name()+" | "+profile.getUser_name()+" | "+profile.getPassword());
                            buffer.newLine();
                            buffer.close();
                        }catch(Exception e){
                            e.printStackTrace();

                        }
                        break;
                    }
                }

                /*
                String username = Utility.generate_username(((User) obj).getSecond_name(),((User) obj).getIndex());
                String password = Utility.generate_password(12);
                User user = (User) obj;
                Profile profile = new Profile(username,password,user);
                System.out.println(((User) obj).getFul_name()+" | "+username+" | "+password);

                 */

                /*try{
                    FileWriter file = new FileWriter("user_login_list.txt",true);
                    BufferedWriter buff= new BufferedWriter(file);
                    buff.write(user.getIndex()+" | "+user.getFul_name()+" | "+profile.getUser_name()+" | "+profile.getPassword());
                    buff.newLine();
                    buff.close();



                }catch(Exception e){
                    e.printStackTrace();
                }
                write_safe(profile);

                 */


            }
        }


        /*for(int i=0;i<5;i++){
            System.out.println(Utility.generate_password(12));
        }

         */
    }
}

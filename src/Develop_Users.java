//Package Utility;
import Utility.Utility;
import java.security.SecureRandom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class Develop_Users {
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



    public static void main(String[] args){
        ArrayList<String[]> list = Utility.Reader("src/user.txt");
        ArrayList<User> user_list = new ArrayList<>();
        for(String[] row :list){
            String index =  row[0].trim();
            String First_name = row[1].trim();
            String last_name = row[2].trim();
            String Address = row[3].trim();
            String birth_day = row[4].trim();
            String gender = row[5].trim();
            String Mob_No= row[6].trim();
            String Country= row[7].trim();

            User user  = new User(First_name,last_name,Address,birth_day,index,gender,Mob_No,Country);
            write_safe(user);
            //String username = generate_username(user.getSecond_name(),user.getIndex());
            //String password = generate_password(12);
            //Profile profile = new Profile(username,password,user);



            System.out.println(user.getFirst_name()+" User Object is made");

        }

        /*ArrayList<Object> list_2 = Utility.deserealize("user.ser");

        //list_2 =
        for(Object obj: list_2){
            if(obj instanceof User){
                System.out.println(((User) obj).getFirst_name()+" is deserealized..");
            }
        }

         */









    }

}

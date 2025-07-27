import Utility.Utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Generate_profile {
    public static void main(String[] args){
        ArrayList<Object> list = Utility.deserealize("user.ser");
        for(Object obj : list){
            if(obj  instanceof User ){
                User user = (User) obj;
                String username = Utility.generate_username(user.getSecond_name(),user.getIndex());
                String password = Utility.generate_password(12);
                try {
                    FileWriter file = new FileWriter("user_login_list.txt",true);
                    BufferedWriter buff = new BufferedWriter(file);
                    buff.write(user.getIndex()+" | "+username+" | "+password);
                    System.out.println(user.getFul_name()+" Wrote..");
                    buff.newLine();
                    buff.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
}

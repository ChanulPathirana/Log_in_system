import Utility.Utility;

import java.io.Serializable;

public class Profile implements Serializable {
    private User user ;
    private String user_name;
    private String password;
    public Profile(String username,String password,User user){
        this.password=password;
        this.user_name=username;
        this.user=user;
    }
    public String getUser_name(){

        return this.user_name;
    }
    public String getPassword(){
        return this.password;
    }
    public User getUser(){
        return this.user;
    }
    public void setUser_name(String user_name){
        this.user_name=user_name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void review_profile(){
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
        //System.out.println("\n");
        System.out.println("LOG IN INFO :");
        System.out.println("===============================================================================================");
        //System.out.println("\n");
        System.out.println("Username : "+getUser_name());
        System.out.println("Password : "+getPassword());
        System.out.println("===============================================================================================");
        //System.out.println("\n");



    }
}

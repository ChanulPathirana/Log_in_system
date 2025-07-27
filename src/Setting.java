import java.util.Scanner;

public class Setting implements Runnable{
    private static Profile profile;
    private static  User user;
    public Setting(Profile profile){
        this.profile=profile;
        this.user=profile.getUser();

    }

    public static void change_username(String username){
        profile.setUser_name(username);

    }
    public static void change_password(String password){
        profile.setPassword(password);


    }
    public static void Review_account(){
        profile.review_profile();
    }
    public static void main_menu(){
        System.out.println("Enter 1 : change password");
        System.out.println("Enter 2 : Review Profile ");
        System.out.println("Enter -1 : Exit ");

    }

    @Override
    public void run() {
        Scanner scan= new Scanner(System.in);
        while(true){
            main_menu();
            System.out.println("Response : ");
            Integer command = scan.nextInt();
            switch(command){
                case(1):
                    Scanner input = new Scanner(System.in);
                    System.out.println("Current Password : ");
                    String old_password = input.nextLine();
                    System.out.println("New Password : ");
                    String password = input.nextLine();
                    System.out.println("ReEnter New Password : ");
                    String re_enter= input.nextLine();
                    if(old_password.equals(profile.getPassword()) && password.equals(re_enter)){
                        change_password(password);
                        break;
                    }
                case(2):

                    Scanner p = new Scanner(System.in);
                    try{
                        System.out.println("Enter  Password : ");
                        String curr_password = p.nextLine();

                        if(curr_password.equals(profile.getPassword())) {
                            Review_account();
                        }

                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    break;
                case(-1):
                    System.out.println("Exit.....");
                    return;







            }


        }



    }
}

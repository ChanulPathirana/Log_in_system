import java.io.Serializable;

public class User implements Serializable {
    private String first_name;
    private String second_name;
    private String address;
    private String birthdate;
    private String Index;
    private String gender;
    private String phonenumber;
    private String country;
    public User(String first_name,String second_name ,String address,String birthdate,String index
            ,String gender,String phonenumber,String country ){
        this.first_name=first_name;
        this.second_name = second_name;
        this.address=address;
        this.birthdate=birthdate;
        this.Index=index;
        this.gender=gender;
        this.phonenumber=phonenumber;
        this.country=country;

    }
    public String getAddress(){
        return this.address;
    }
    public String getFul_name(){
        String ful_name = first_name+" "+second_name;
        return ful_name;


    }
    public String getFirst_name(){
        return this.first_name;
    }
    public String getSecond_name(){
        return this.second_name;
    }
    public String getBirthdate(){
        return this.birthdate;

    }
    public String getIndex(){
        return this.Index;
    }
    public String getGender(){return this.gender;}
    public String getPhonenumber(){return this.phonenumber;}
    public String getCountry(){return this.country;}

}

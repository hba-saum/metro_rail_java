package entities;



public class Passenger extends MetroUser{
    String userType;
    int mCard;

    public Passenger(){}
    public Passenger(String name, String username, String email, String password, String dob, String nid, String mobNo, String gender, String userType){
        super(name,username,email,password,dob,nid,mobNo,gender);
        this.userType = userType;
    }

    //seter
    public void setUserType(String userType){
        this.userType = userType;
    }
    public void setMcard(int mCard){
        this.mCard = mCard;
    }
    
    //getter
    public int getMcard(){
        return mCard;
    }
    public String getuserType(){
        return userType;
    }
}
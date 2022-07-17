package services;

import repositories.PassengerRepository;

public class LoginService{
    PassengerRepository pr = new PassengerRepository();
    public LoginService(){}

    public boolean isPassengerLogin(String username,String password){
        return pr.isPassengerLoged(username,password);
    }
    public boolean isAdminLogin(String username,String password, String type){
        return false;
    }
}


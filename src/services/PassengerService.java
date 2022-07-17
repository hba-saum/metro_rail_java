package services;

import entities.*;
import repositories.PassengerRepository;

public class PassengerService{
    InstTicket t;
    Passenger p;
    PassengerRepository pr = new PassengerRepository();

    public boolean addPassenger(Passenger p){
        return pr.passRegInsert(p);
    }

    public Passenger getPasenger(String username){
        return pr.getPasengerFromDb(username);
    }

    public boolean buyInstTicket(InstTicket t){
        return pr.insertInstTicket(t);
    }
    public boolean buyOdp(Odp t){
        return pr.insertOdp(t);
    }
    
}
package repositories;

import entities.*;
import java.sql.*;

public class PassengerRepository{
    Connection con;
    Statement st;
    ResultSet result;

    Passenger p = new Passenger();
    InstTicket t = new InstTicket();
    Odp o = new Odp();
    public PassengerRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_pro", "root", "");
            st = con.createStatement();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    ///reg
    public boolean passRegInsert(Passenger p){
        int i=0;
        try{
            i=st.executeUpdate("INSERT INTO passenger(name,username,email,password,dob,nid,mobNo,gender,userType,mCard) VALUES('"+p.getName()+"','"+p.getUsername()+"','"+p.getEmail()+"','"+p.getPassword()+"','"+p.getDob()+"','"+p.getnid()+"','"+p.getMobNo()+"','"+p.getGender()+"','"+p.getuserType()+"','0')");
            
        }catch(SQLException ex){
            System.out.println(ex);
        }

        if(i==1){
            return true;
        }
        else{
            return false;
        }
    }
    ///ticket buy
    public boolean insertInstTicket(InstTicket t){
        int i=0;
        try{
            i=st.executeUpdate("INSERT INTO insticket(tfrom,tto,quantity,time,date,total,name,mobNo,payType, userId) VALUES('"+t.getFrom()+"','"+t.getTo()+"','"+t.getQuantity()+"','CURRENT_TIME()','CURRENT_DATE()','"+t.getFair()+"','"+t.getName()+"','"+t.getMobNo()+"','"+t.getPayType()+"','"+t.getUserId()+"')");
            
        }catch(SQLException ex){
            System.out.println(ex);
        }

        if(i==1){
            return true;
        }
        else{
            return false;
        }
    }

    /////ODP////
    public boolean insertOdp(Odp o){
        int i=0;
        try{
            i=st.executeUpdate("INSERT INTO odp(name,phone,payType,date,time,userid,quantity,fair) VALUES('"+o.getName()+"','"+o.getMobNo()+"', '"+o.getPayType()+"','CURRENT_DATE()', 'CURRENT_TIME()', '"+o.getUserId()+"', '"+o.getQuantity()+"', '"+o.getFair()+"')");
            
        }catch(SQLException ex){
            System.out.println(ex);
        }

        if(i==1){
            return true;
        }
        else{
            return false;
        }
    }
    
        ////passenger login chek
    public boolean isPassengerLoged(String username,String password){
        try{
            result = st.executeQuery("SELECT * FROM passenger WHERE username='"+username+"' AND password='"+password+"'");

            if(result.next()){
                return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return false;
    }

    public Passenger getPasengerFromDb(String username){
        try{
            result=st.executeQuery("SELECT * FROM passenger WHERE username='"+username+"'");
            if(result.next()){
                p.setName(result.getString("name"));
                p.setUserType(result.getString("userType"));
                p.setMcard(Integer.parseInt(result.getString("mCard")));
                return p;
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }


}
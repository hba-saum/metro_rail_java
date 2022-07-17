package entities;

public class Odp{
    String name,ticketid,phone, payType, date, time;
    int userid;
    int quantity;
    int fair;

    public Odp(){}
    public Odp(String name, String phone, String payType, int quantity, int fair, int userid){
        this.name = name;
        this.phone = phone;
        this.payType = payType;
        this.quantity = quantity;
        this.fair = fair;
        this.userid = 0;
    }
    public void setName(String name){this.name=name;}

    public void setTicketid(String ticketid){this.ticketid=ticketid;}



    public void setQuantity(int quantity){this.quantity=quantity;}

    public void setFair(int fair){this.fair=fair;}

    public void setMobNo(String phone){this.phone=phone;}

    public void setPayType(String payType){
        this.payType=payType;
    }

    public String getName(){return name;}

    public String getTicketid(){return ticketid;}

    public String getTime(){return time;}

    public String getDate(){return date;}
    
    public String getPayType(){return payType;}

    public String getMobNo(){return phone;}

    public int getQuantity(){return quantity;}

    public int getUserId(){return userid;}

    public int getFair(){return fair;} 
}
package entities;

public class InstTicket{
    String name,ticketid,from,to,phone, payType;
    int userid;
    int quantity;
    int fair;


    public InstTicket(){}
    public InstTicket(String name,String from,String to,int quantity,int fair,String phone, String payType, int userid){
            this.name=name;
            this.from=from;
            this.to=to;
            this.quantity=quantity;
            this.fair=fair;
            this.phone=phone;
            this.userid=userid;
            this.payType = payType;
    }

    public void setName(String name){this.name=name;}

    public void setTicketid(String ticketid){this.ticketid=ticketid;}

    public void setFrom(String from){this.from=from;}

    public void setTo(String to){this.to=to;}

    public void setQuantity(int quantity){this.quantity=quantity;}

    public void setFair(int fair){this.fair=fair;}

    public void setMobNo(String phone){this.phone=phone;}

    public void setPayType(String payType){
        this.payType=payType;
    }


    public String getName(){return name;}

    public String getTicketid(){return ticketid;}

    public String getFrom(){return from;}

    public String getTo(){return to;}

    public String getPayType(){return payType;}

    public String getMobNo(){return phone;}

    public int getQuantity(){return quantity;}

    public int getUserId(){return userid;}

    public int getFair(){return fair;} 

   
}
package ui;

import java.io.*;


public class Ticketprinter {

   public  Ticketprinter(String ticketid,String from,String to,int fair ,int quantity){

try {

    File file =new File("ticket.txt");

    if(!file.exists()){

        file.createNewFile();
    }

    PrintWriter pw=new PrintWriter(file);

    pw.println("ticket serial  :"+ticketid);
    pw.println("From           :"+from);
    pw.println("TO             :"+to);
    pw.println("Price          :"+fair);
    pw.println("quantity       :"+quantity);
    
    pw.close();
}catch (IOException e){e.printStackTrace();}

   }

}

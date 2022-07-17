package ui;

import java.awt.*;
import javax.swing.*;

import entities.*;
import services.PassengerService;

class passProfilePanel extends JPanel{
    private String username;
    private String name;
    private String userType;
    private int balance;
    

    JLabel lName= new JLabel("Name: ");
    JLabel lUsername= new JLabel("Username: ");
    JLabel luserType = new JLabel("");
    JLabel lbalance = new JLabel("");

    public passProfilePanel(){}

    PassengerService ps = new PassengerService();
    Passenger p = new Passenger();

    public passProfilePanel(String username){
        this.username=username;
        p = ps.getPasenger(username);

        lName.setText("Name: " + p.getName());
        lUsername.setText("UserName: " + username);
        luserType.setText("User Type: " + p.getuserType());
        lbalance.setText("MCard Balance: " + p.getMcard());

        System.out.println(p.getName());

        Dimension size = new Dimension(300, 50);

        Font txt =  new Font(Font.SANS_SERIF, Font.BOLD, 25);     

        //layout
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        ///

        lName.setPreferredSize(size);
        lName.setFont(txt);

        lName.setPreferredSize(size);
        lName.setFont(txt);
        gb.gridx = 0;
        gb.gridy = 0;
        add(lName, gb);


        lUsername.setPreferredSize(size);
        lUsername.setFont(txt);
        gb.gridy++;
        add(lUsername, gb);


        luserType.setPreferredSize(size);
        luserType.setFont(txt);
        gb.gridy++;
        gb.gridy++;
        add(luserType, gb);

        

        lbalance.setPreferredSize(size);
        luserType.setFont(txt);
        gb.gridy++;
        add(lbalance, gb);


    }

}
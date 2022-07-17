package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import entities.*;
import services.PassengerService;

class PassHome extends JFrame implements ActionListener{
    
    // Labels
    int balance=0;
    private String username;
    JLabel dmr = new JLabel(" Dhaka Metro Rail");
    ImageIcon logo = new ImageIcon("E:/javaProject2019/src/images/mr.png");
    JLabel logoLabel = new JLabel(logo);

    // Panels
    JPanel headPanel = new JPanel();
    JPanel menuPanel = new JPanel();
    
    //center panels
    JPanel mainPanel = new HomePanel();
    JPanel instantPanel = new RegInstantPanel();
    JPanel odpPanel = new RegOdpPanel();

    //buttons
    JButton instBtn = new JButton("Buy Ticket");
    JButton odpBtn = new JButton("Buy One Day Pass");
    JButton profileBtn = new JButton("MCard Balance");
    JButton logoutBtn = new JButton("Logout");

    PassengerService ps = new PassengerService();
    Passenger p = new Passenger();

    public PassHome(){}
    public PassHome(String username){
        this.username = username;
        

        /////
        p = ps.getPasenger(username);
        balance = p.getMcard();
        // frame///////////////////////////////////////////
        setSize(1024, 768);  
        setLayout(new BorderLayout());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(145, 255, 163));
        setResizable(true);

        // HEAD PANEL //////////////////////////////////////
        Dimension headSize = headPanel.getPreferredSize();
        headSize.height = 100;
        headPanel.setPreferredSize(headSize);

        headPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

        // //LOGO
        headPanel.add(logoLabel);

        //color
        headPanel.setBackground(new Color(145, 255, 163));

        // Menu Label
        dmr.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        dmr.setForeground(new Color(193, 72, 48));
        headPanel.add(dmr);

        //add
        add(headPanel, BorderLayout.NORTH);

        // MENU PANEL  /////////////////////////////////////////
        Dimension menuSize = menuPanel.getPreferredSize();
        menuSize.width = 250;
        menuPanel.setPreferredSize(menuSize);
        Font menuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        menuPanel.setBackground(new Color(6, 43, 13));

        add(menuPanel, BorderLayout.WEST);

        //panel Layout
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints panelGb = new GridBagConstraints();

        //BUTTONS //////////////////
        Dimension menuBtnSize = new Dimension(250, 40);
        
        //instant button////
        instBtn.setPreferredSize(menuBtnSize);
        instBtn.setFont(menuFont);
        
        panelGb.gridx = 0;
        panelGb.gridy = 0;
        menuPanel.add(instBtn, panelGb);


        ////ODP/////
        odpBtn.setPreferredSize(menuBtnSize);
        odpBtn.setFont(menuFont);

        panelGb.gridy++;
        menuPanel.add(odpBtn, panelGb);


        ///Profile///
        profileBtn.setPreferredSize(menuBtnSize);
        profileBtn.setFont(menuFont);

        panelGb.gridy++;
        menuPanel.add(profileBtn, panelGb);

        ///Logout///
        logoutBtn.setPreferredSize(menuBtnSize);
        logoutBtn.setFont(menuFont);

        panelGb.gridy++;
        menuPanel.add(logoutBtn, panelGb);

        //add
        add(instantPanel, BorderLayout.CENTER);

        //acion listeners
        instBtn.addActionListener(this);
        odpBtn.addActionListener(this);
        profileBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        // odpBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==instBtn){
            odpPanel.setVisible(false);
            instantPanel.setVisible(true);
            add(instantPanel, BorderLayout.CENTER);
        }
        else if(e.getSource()==odpBtn){
            instantPanel.setVisible(false);
            odpPanel.setVisible(true);
            add(odpPanel, BorderLayout.CENTER);
        }
        else if(e.getSource()==profileBtn){
            String msg = "MCard Balance: "+balance+" taka";
            JOptionPane.showMessageDialog(this,msg,"MCard Balace",JOptionPane.INFORMATION_MESSAGE);

        }
        else if(e.getSource()==logoutBtn){
            this.dispose();
            new Home();
        }

    }


}
package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Home extends JFrame implements ActionListener{
    // Labels
    JLabel dmr = new JLabel(" Dhaka Metro Rail");
    ImageIcon logo = new ImageIcon("E:/javaProject2019/src/images/mr.png");
    JLabel logoLabel = new JLabel(logo);

    // Panels
    JPanel headPanel = new JPanel();
    JPanel menuPanel = new JPanel();
    //center panels
    JPanel mainPanel = new HomePanel();
    JPanel loginPanel = new LoginPanel();
    JPanel instantPanel = new InstantPanel();
    JPanel regPanel = new RegisterPanel();
    JPanel odpPanel = new OdpPanel();
    // buttons
    //JButton homeBtn = new JButton("Home");
    JButton loginBtn = new JButton("Login");
    JButton instBtn = new JButton("Buy Instant Ticket");
    JButton odpBtn = new JButton("Buy One Day Pass");
    JButton rechargeBtn = new JButton("Recharge MCard");
    JButton priceBtn = new JButton("Check Ticket Prices");
    JButton regBtn = new JButton("Register");

    public Home(){
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
        //login button/////
        loginBtn.setPreferredSize(menuBtnSize);
        loginBtn.setFont(menuFont);
        
        panelGb.gridy++;
        menuPanel.add(loginBtn, panelGb);

        //reg///
        regBtn.setPreferredSize(menuBtnSize);
        regBtn.setFont(menuFont);
        
        panelGb.gridy++;
        menuPanel.add(regBtn, panelGb);
        
        
        //adding menu panel
        add(menuPanel, BorderLayout.WEST);

        // MAIN PANEL  //////////////////////////////////////
        
        //add
        add(instantPanel, BorderLayout.CENTER);
        

        //homeBtn.addActionListener(this);
        loginBtn.addActionListener(this);
        instBtn.addActionListener(this);
        regBtn.addActionListener(this);
        odpBtn.addActionListener(this);
    }


    ///////////////////////////Actions///////////////////////////////
   
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loginBtn){
            odpPanel.setVisible(false);
            regPanel.setVisible(false);
            instantPanel.setVisible(false);
            loginPanel.setVisible(true);
            add(loginPanel, BorderLayout.CENTER);
        }

        else if(e.getSource()==instBtn){
            odpPanel.setVisible(false);
            regPanel.setVisible(false);
            loginPanel.setVisible(false);
            instantPanel.setVisible(true);
            add(instantPanel, BorderLayout.CENTER);
        }
        
        else if(e.getSource()==regBtn){
            odpPanel.setVisible(false);
            loginPanel.setVisible(false);
            instantPanel.setVisible(false);
            regPanel.setVisible(true);
            add(regPanel, BorderLayout.CENTER);
        }
        else if(e.getSource()==odpBtn){
            loginPanel.setVisible(false);
            instantPanel.setVisible(false);
            regPanel.setVisible(false);
            odpPanel.setVisible(true);
            add(odpPanel, BorderLayout.CENTER);
        }
    }    
    
    public static void main(String[] args) {
        Home home = new Home();
    }
}

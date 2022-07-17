package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import services.LoginService;

class LoginPanel extends JPanel implements ActionListener{

    JLabel user = new JLabel("Username: ");
    JLabel pass = new JLabel("Password: ");
    JTextField userTf = new JTextField();
    JPasswordField passPf = new JPasswordField();
    
    String userType[] = {"Passenger", "Head Admin", "Recharger/Ticket Checker"};
    JComboBox type = new JComboBox<String>(userType);

    JButton login = new JButton("Login");


    //box size
    

    public LoginPanel(){
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        
        gb.gridx = 0;
        gb.gridy = 0;     
        add(user, gb);
        
        gb.gridy = 1;     
        add(userTf, gb);

        gb.gridy = 2;     
        add(pass, gb);

        gb.gridy = 3;     
        add(passPf, gb);

        gb.gridy = 4;     
        add(type, gb);


        gb.gridy = 5;     
        add(login, gb);

        //set the size 
        Dimension boxSize = new Dimension(300, 50);
        user.setPreferredSize(boxSize);
        pass.setPreferredSize(boxSize);
        userTf.setPreferredSize(boxSize);
        passPf.setPreferredSize(boxSize);
        login.setPreferredSize(boxSize);
        type.setPreferredSize(boxSize);

        //sets font
        user.setFont(font);
        pass.setFont(font);
        userTf.setFont(font);
        passPf.setFont(font);
        type.setFont(font);
        login.setFont(font);

        userTf.addActionListener(this);
        passPf.addActionListener(this);
        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            LoginService l = new LoginService();
            if(userTf.getText().equals("") || passPf.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Username/Password is Empty!","",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(type.getSelectedItem().toString()=="Passenger"){
                    if(l.isPassengerLogin(userTf.getText(), passPf.getText())){
                        new PassHome(userTf.getText());
                        JFrame superFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                        superFrame.dispose();
                    }
                }
                else if(type.getSelectedItem().toString()=="Head Admin"){
                    
                }
                else if(type.getSelectedItem().toString()=="Recharger/Ticket Checker"){
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Inavlid username/password","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

}
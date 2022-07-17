package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import entities.*;
import services.PassengerService;

class RegisterPanel extends JPanel implements ActionListener{
    JLabel upperlabel = new JLabel("User Registration: ");
    JLabel lName=new JLabel("Name: ");
    JLabel lUsername=new JLabel("Username: ");
    JLabel lEmail=new JLabel("Email: ");
    JLabel lPassword=new JLabel("Password: ");
    JLabel lConfirmPassword=new JLabel("Confirm Password: ");
    JLabel lDob=new JLabel("Date of Birth: ");
    JLabel lGender=new JLabel("Gender: ");
    JLabel lNid=new JLabel("NiD: ");
    JLabel lmob_no=new JLabel("Mobile No: ");
    JLabel lUsertype=new JLabel("User type: ");

    String usercat[]={"General user","Govt Job Holder"};
    JComboBox cb=new JComboBox<String>(usercat); 

    JTextField name=new JTextField();
    JTextField username=new JTextField();
    JTextField email=new JTextField();
    JPasswordField password=new JPasswordField();
    JPasswordField confirmPassword=new JPasswordField();
    JTextField dob=new JTextField();
    JTextField mob_no=new JTextField();
    JTextField nid=new JTextField();
    JRadioButton male=new JRadioButton("Male");
    JRadioButton female=new JRadioButton("Female");
    ButtonGroup bg=new ButtonGroup();


    JButton register=new JButton("Register");



    public RegisterPanel(){
        //adding radio buttons
        bg.add(male);
        bg.add(female);

        setLayout(new GridBagLayout());

        GridBagConstraints c=new GridBagConstraints();

        c.gridx=0;
        c.gridy=0;
        add(upperlabel,c);//font lebel

        c.gridx=0;
        c.gridy=1;
        //c.anchor=GridBagConstraints.LINE_END;
        add(lName,c);

        c.gridy++; 
        add(lUsername,c);

        c.gridy++; 
        add(lEmail,c);

        c.gridy++;
        add(lPassword,c);

        c.gridy++;
        add(lConfirmPassword,c);

        c.gridy++;
        add(lDob,c);

        c.gridy++;
        add(lNid,c);

        c.gridy++;
        add(lmob_no,c);

        c.gridy++;
        add(lGender,c);

        c.gridy+=2;
        add(lUsertype,c);

        c.gridy++;
           
        c.gridx=1;
        c.gridy=1;

        //c.anchor=GridBagConstraints.LINE_START;
        add(name,c);

        c.gridy++; 
        add(username,c);

        c.gridy++; 
        add(email,c);

        c.gridy++;
        add(password,c);

        c.gridy++;
        add(confirmPassword,c);

        c.gridy++;
        add(dob,c);

        c.gridy++;
        add(nid,c);

        c.gridy++;
        add(mob_no,c);

        c.gridy++;
        add(male,c);

        c.gridy++;
        add(female,c);

        c.gridy++;
        add(cb,c);

        c.gridy++;
        add(register,c);

        ///set size
        Dimension size = new Dimension(250, 40);

        upperlabel.setPreferredSize(size);
        lName.setPreferredSize(size);
        lUsername.setPreferredSize(size);
        lEmail.setPreferredSize(size);
        lPassword.setPreferredSize(size);
        lConfirmPassword.setPreferredSize(size);
        lDob.setPreferredSize(size);
        lGender.setPreferredSize(size);
        lNid.setPreferredSize(size);
        lmob_no.setPreferredSize(size);
        lUsertype.setPreferredSize(size);
        name.setPreferredSize(size);
        username.setPreferredSize(size);
        email.setPreferredSize(size);
        password.setPreferredSize(size);
        confirmPassword.setPreferredSize(size);
        dob.setPreferredSize(size);
        nid.setPreferredSize(size);
        male.setPreferredSize(size);
        female.setPreferredSize(size);
        register.setPreferredSize(size);
        cb.setPreferredSize(size);
        mob_no.setPreferredSize(size);

        //set Font
        Font font = new Font(Font.SANS_SERIF,  Font.PLAIN, 20);

        upperlabel.setFont(font);
        lName.setFont(font);
        lUsername.setFont(font);
        lEmail.setFont(font);
        lPassword.setFont(font);
        lConfirmPassword.setFont(font);
        lDob.setFont(font);
        lGender.setFont(font);
        lNid.setFont(font);
        lmob_no.setFont(font);
        lUsertype.setFont(font);
        name.setFont(font);
        username.setFont(font);
        email.setFont(font);
        password.setFont(font);
        confirmPassword.setFont(font);
        dob.setFont(font);
        nid.setFont(font);
        male.setFont(font);
        female.setFont(font);
        register.setFont(font);
        cb.setFont(font);
        mob_no.setFont(font);
        //actions////
        register.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==register){
            String genderBtn = new String();
            if(male.isSelected()){
                genderBtn="Male";
            }
            else if(female.isSelected()){
                genderBtn="Female";
            }

            Passenger p = new Passenger(name.getText(), username.getText(), email.getText(), password.getText(), dob.getText(), nid.getText(), mob_no.getText(), genderBtn, cb.getSelectedItem().toString());
            PassengerService ps = new PassengerService();
            
            if(ps.addPassenger(p)){
                JOptionPane.showMessageDialog(this, "Passenger Registered.", "Success!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import entities.*;
import services.PassengerService;


class InstantPanel extends JPanel implements ActionListener{
    static int ticketPrice = 5;
    private int total;
    JLabel instTicket = new JLabel("Buy Instant Ticket");
    JLabel from = new JLabel("From: ");
    JLabel to = new JLabel("To: ");
    JLabel quantity = new JLabel("Quantity");
    JLabel fair = new JLabel(" ");
    JButton nextBtn = new JButton("Buy");
    String[] location = {"UTTRA NORTH","UTTRA CENTER","UTTRA SOUTH",
                        "PALLABI","MIRPUR 11","MIRPUR 10","KAZIPARA",
                        "SHWRAPARA","AGARGAON","BIJOY-SARANI","FRAM-GATE",
                        "KAWRAN-BAZAR","SHAHBAG","DHAKA-UNIVERSITY",
                        "BANGLADESH SCRETARIAT","MOTIJHEEL"};
    JComboBox fromCb = new JComboBox<String>(location);
    JComboBox toCb = new JComboBox<String>(location);
    
    String[] cQuantity = {"1", "2", "3", "4", "5"};
    JComboBox quanityCb = new JComboBox<String>(cQuantity);

    JLabel name= new JLabel("Name:");
    JLabel phone= new JLabel("Phone number:");
    JTextField tname=new JTextField();
    JTextField tphone=new JTextField();
    //pay type
    JLabel payType = new JLabel("Select Payment Type: ");
    JRadioButton cardR = new JRadioButton("Card");
    JRadioButton bkashR = new JRadioButton("BKash");
    ButtonGroup pay = new ButtonGroup();
    


    public InstantPanel(){
        pay.add(cardR);
        pay.add(bkashR);
    
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        Font txt =  new Font(Font.SANS_SERIF, Font.BOLD, 25);     
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        add(instTicket, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        add(from, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        add(fromCb, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        add(to, gb);

        gb.gridx = 1;
        gb.gridy = 2;
        add(toCb, gb);

        gb.gridx = 0;
        gb.gridy = 3;
        add(quantity, gb);

        gb.gridx = 1;
        gb.gridy = 3;
        add(quanityCb, gb);

        gb.gridx = 1;
        gb.gridy = 4;
        add(fair, gb);

        gb.gridx = 0;
        gb.gridy = 5;
        add(name, gb);

        gb.gridx = 1;
        gb.gridy = 5;
        add(tname, gb);

        gb.gridx = 0;
        gb.gridy = 6;
        add(phone, gb);
        
        gb.gridx = 1;
        gb.gridy = 6;
        add(tphone, gb);

        gb.gridx = 0;
        gb.gridy = 7;
        add(payType, gb);
        
        gb.gridx = 1;
        gb.gridy = 7;
        add(cardR, gb);

        gb.gridx = 1;
        gb.gridy = 8;
        add(bkashR, gb);
        
        gb.gridx = 0;
        gb.gridy = 10;
        add(nextBtn, gb);

        //set the size 
        Dimension size = new Dimension(300, 50);
        fromCb.setPreferredSize(size);
        toCb.setPreferredSize(size);
        from.setPreferredSize(size);
        to.setPreferredSize(size);
        quantity.setPreferredSize(size);
        quanityCb.setPreferredSize(size);

        fair.setPreferredSize(size);
        
        name.setPreferredSize(size);
        tname.setPreferredSize(size);
        phone.setPreferredSize(size);
        tphone.setPreferredSize(size);
        nextBtn.setPreferredSize(size);
        payType.setPreferredSize(size);
        cardR.setPreferredSize(size);
        bkashR.setPreferredSize(size);

        //set font
        fromCb.setFont(font);
        toCb.setFont(font);
        from.setFont(txt);
        instTicket.setFont(txt);
        to.setFont(txt);
        quantity.setFont(txt);
        quanityCb.setFont(font);
        fair.setFont(txt);
        nextBtn.setFont(font);
        name.setFont(txt);
        phone.setFont(txt);
        tname.setFont(font);
        tphone.setFont(font);
        payType.setFont(txt);
        cardR.setFont(txt);
        bkashR.setFont(txt);
        nextBtn.setFont(font);

        fromCb.addActionListener(this);
        toCb.addActionListener(this);
        nextBtn.addActionListener(this);
        quanityCb.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==fromCb || e.getSource()==toCb || e.getSource()==quanityCb){
            if(fromCb.getSelectedIndex()==toCb.getSelectedIndex()){
                fair.setText("Can not visit!");
            }
            else{
                int a = fromCb.getSelectedIndex();
                int b = toCb.getSelectedIndex();
    
                int q = Integer.parseInt(quanityCb.getSelectedItem().toString());
                total = q*Math.abs(((a+1)-(b+1))*ticketPrice);
                fair.setText("Total: "+total+"/=");    
            }
    
        }
        else if(e.getSource()==nextBtn){
            String payBtn = new String();
            if(cardR.isSelected()){
                payBtn="Card";
            }
            else if(bkashR.isSelected()){
                payBtn="BKash";
            }
            InstTicket t = new InstTicket(tname.getText(), fromCb.getSelectedItem().toString(), toCb.getSelectedItem().toString(), Integer.parseInt(quanityCb.getSelectedItem().toString()), total, tphone.getText(), payBtn, 0);
            PassengerService ps = new PassengerService();

            if(ps.buyInstTicket(t)){
                JOptionPane.showMessageDialog(this, "Ticket Bought Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                new Ticketprinter(tphone.getText(), fromCb.getSelectedItem().toString(), toCb.getSelectedItem().toString(), total, Integer.parseInt(quanityCb.getSelectedItem().toString()));
            }
        }
        

    }
    


}
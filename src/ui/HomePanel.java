package ui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class HomePanel extends JPanel  implements ActionListener{
    //Home  components
    JButton instBtn = new JButton("Buy Instant Ticket");
    JButton odpBtn = new JButton("Buy One Day Pass");
    JButton rechargeBtn = new JButton("Recharge MCard");
    JButton priceBtn = new JButton("Check Ticket Prices");



    //instant ticket components

    JLabel from = new JLabel("From: ");
    JLabel to = new JLabel("To: ");
    JLabel fair = new JLabel("Fair: ");

    String[] location = {"UTTRA NORTH","UTTRA CENTER","UTTRA SOUTH",
                        "PALLABI","MIRPUR 11","MIRPUR 10","KAZIPARA",
                        "SHWRAPARA","AGARGAON","BIJOY-SARANI","FRAM-GATE",
                        "KAWRAN-BAZAR","SHAHBAG","DHAKA-UNIVERSITY",
                        "BANGLADESH SCRETARIAT","MOTIJHEEL"};
    JComboBox fromCb = new JComboBox<String>(location);
    JComboBox toCb = new JComboBox<String>(location);
    JButton nexttBtn = new JButton("Next");


    public HomePanel(){
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 25);      
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        // gb.weightx = .1;
        // gb.weighty = .1;

        gb.gridx = 0;
        gb.gridy = 0;     
        add(instBtn,gb);

        gb.gridx = 1;
        gb.gridy = 0;     
        add(odpBtn, gb);

        gb.gridx = 0;
        gb.gridy = 1;     
        add(rechargeBtn, gb);

        gb.gridx = 1;
        gb.gridy = 1;     
        add(priceBtn, gb);

        //set size
        Dimension boxSize = new Dimension(300, 200);
        instBtn.setPreferredSize(boxSize);
        odpBtn.setPreferredSize(boxSize);
        rechargeBtn.setPreferredSize(boxSize);
        priceBtn.setPreferredSize(boxSize);
        
        //setFont
        instBtn.setFont(font);
        odpBtn.setFont(font);
        rechargeBtn.setFont(font);
        priceBtn.setFont(font);

        //adding actions////
        instBtn.addActionListener(this);
        odpBtn.addActionListener(this);
        rechargeBtn.addActionListener(this);
        priceBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==instBtn){
            //removing home
            instBtn.setVisible(false);
            odpBtn.setVisible(false);
            rechargeBtn.setVisible(false);
            priceBtn.setVisible(false);
            remove(instBtn);
            remove(odpBtn);
            remove(rechargeBtn);
            remove(priceBtn);

            //adding instant ticket
            Font font = new Font(Font.SANS_SERIF, Font.BOLD, 25);      
            setLayout(new GridBagLayout());
            GridBagConstraints gb = new GridBagConstraints();

            gb.gridx = 0;
            gb.gridy = 0;
            add(from, gb);

            gb.gridx = 1;
            gb.gridy = 0;
            add(fromCb, gb);

            gb.gridx = 2;
            gb.gridy = 0;
            add(to, gb);

            gb.gridx = 3;
            gb.gridy = 0;
            add(toCb, gb);

            gb.gridx = 0;
            gb.gridy = 1;
            add(fair, gb);

            gb.gridx = 1;
            gb.gridy = 2;
            add(nexttBtn, gb);

        }
    }
}
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class RegOdpPanel extends JPanel implements ActionListener{
    static int odpPrice = 600;
    private int total;

    JLabel odp = new JLabel("Buy One Day Pass(ODP)");
    JLabel fair = new JLabel(" ");

    JLabel quantity = new JLabel("Quantity");
    String[] cQuantity = {"1", "2", "3", "4", "5"};
    JComboBox quanityCb = new JComboBox<String>(cQuantity);

    JButton buyBtn = new JButton("Buy");
    //pay type
    JLabel payType = new JLabel("Select Payment Type: ");
    JRadioButton cardR = new JRadioButton("Card");
    JRadioButton bkashR = new JRadioButton("BKash");
    JRadioButton mcardR = new JRadioButton("MCard");
    ButtonGroup pay = new ButtonGroup();

    public RegOdpPanel(){
        pay.add(cardR);
        pay.add(bkashR);
        pay.add(mcardR);

        Dimension size = new Dimension(300, 50);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        Font txt =  new Font(Font.SANS_SERIF, Font.BOLD, 25);     
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        ///
        odp.setPreferredSize(size);
        odp.setFont(txt);

        gb.gridx = 0;
        gb.gridy = 0;
        add(odp, gb);

        ////
        quantity.setPreferredSize(size);
        quantity.setFont(txt);

        gb.gridx = 0;
        gb.gridy = 1;
        add(quantity, gb);

        ////
        quanityCb.setPreferredSize(size);
        quanityCb.setFont(font);

        gb.gridx = 1;
        gb.gridy = 1;
        add(quanityCb, gb);

        ////
        fair.setPreferredSize(size);
        fair.setFont(txt);
        
        ////

        gb.gridx = 1;
        gb.gridy = 2;
        add(fair, gb);

        ////
        fair.setPreferredSize(size);
        fair.setFont(txt);
        
        ////
        payType.setPreferredSize(size);
        payType.setFont(txt);

        gb.gridx = 0;
        gb.gridy = 3;
        add(payType, gb);
        
        /////
        cardR.setPreferredSize(size);
        cardR.setFont(txt);

        gb.gridx = 1;
        gb.gridy = 3;
        add(cardR, gb);

        ////
        bkashR.setPreferredSize(size);
        bkashR.setFont(txt);

        gb.gridx = 1;
        gb.gridy = 4;
        add(bkashR, gb);
        
        ////
        mcardR.setPreferredSize(size);
        mcardR.setFont(font);

        gb.gridx = 1;
        gb.gridy = 5;
        add(mcardR, gb);
        
        ////
        buyBtn.setPreferredSize(size);
        buyBtn.setFont(font);

        gb.gridx = 0;
        gb.gridy = 6;
        add(buyBtn, gb);
///////////

        quanityCb.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==quanityCb){
            int q = Integer.parseInt(quanityCb.getSelectedItem().toString());
            total = q*odpPrice;
            fair.setText("Total: "+total+"/=");    
        }
    }



}
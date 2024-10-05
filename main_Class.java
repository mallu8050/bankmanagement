package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_Class(String  pin){

        this.pin = pin;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1680,980,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l3 =new JLabel(i3);
        l3.setBounds(0,0,1680,980);
        add(l3);


        JLabel label=new JLabel("Please select your  Transaction");
        label.setFont(new Font("System",Font.BOLD,28));
        label.setBounds(469,240,700,35);
        label.setForeground(Color.white);
        l3.add(label);

        b1 =new JButton("DEPOSIT");
        b1.setForeground(Color.white);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.setBackground(new Color(65,125,125));
        b1.setBounds(450,320,180,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 =new JButton("CASH WITHDRAWAL");
        b2.setForeground(Color.white);
        b2.setFont(new Font("System",Font.BOLD,14));
        b2.setBackground(new Color(65,125,125));
        b2.setBounds(740,320,180,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 =new JButton("FAST CASH");
        b3.setForeground(Color.white);
        b3.setFont(new Font("System",Font.BOLD,14));
        b3.setBackground(new Color(65,125,125));
        b3.setBounds(450,375,180,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 =new JButton("MINI STATEMENT");
        b4.setForeground(Color.white);
        b4.setFont(new Font("System",Font.BOLD,14));
        b4.setBackground(new Color(65,125,125));
        b4.setBounds(740,375,180,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 =new JButton("PIN CHANGE");
        b5.setForeground(Color.white);
        b5.setFont(new Font("System",Font.BOLD,14));
        b5.setBackground(new Color(65,125,125));
        b5.setBounds(450,430,180,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 =new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.white);
        b6.setFont(new Font("System",Font.BOLD,14));
        b6.setBackground(new Color(65,125,125));
        b6.setBounds(740,430,180,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 =new JButton("EXIT");
        b7.setForeground(Color.white);
        b7.setFont(new Font("System",Font.BOLD,14));
        b7.setBackground(new Color(65,125,125));
        b7.setBounds(740,485,180,35);
        b7.addActionListener(this);
        l3.add(b7);



        setLayout(null);
        setSize(1680,1050);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource() == b1){
    new Deposit(pin);
    setVisible(false);
        } else if (e.getSource() == b7) {
    setVisible(false);
    new Login();

    }else if (e.getSource()==b2){
        new Withdrawl(pin);
        setVisible(false);
    } else if (e.getSource()==b6) {
    new BalanceEnquriy(pin);
    setVisible(false);
} else if (e.getSource()==b3) {
    new FastCash(pin);
    setVisible(false);
} else if (e.getSource()==b5) {
    new Pin(pin);
    setVisible(false);
} else if (e.getSource()==b4) {
    new mini(pin);
}
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}

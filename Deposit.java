package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1,b2;
    Deposit(String pin){

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1680,980,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l3 =new JLabel(i3);
        l3.setBounds(0,0,1680,980);
        add(l3);

        JLabel label1 =new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setBounds(500,200,400,35);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(Color.white);
        l3.add(label1);

        textField = new JTextField();
        textField.setBackground(new Color(87, 182, 177,125));
        textField.setForeground(Color.white);
        textField.setFont(new Font("System",Font.BOLD,20));
        textField.setBounds(500,240,330,35);
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(760,432,150,35);
        b1.setBackground(new Color(87, 182, 177,125));
        b1.setForeground(Color.white);
       b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(760,488,150,35);
        b2.setBackground(new Color(87, 182, 177,125));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);



        this.pin =pin;
        setLayout(null);
        setSize(1680,1050);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try {
           String amount = textField.getText();
           Date date =new Date();
           if(e.getSource() == b1){
               if (textField.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"Please Enter the Amount You Wnt to Deposit");
               }else{
                   Con c =new Con();

                   c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                   JOptionPane.showMessageDialog(null,"Rs.  "+amount+"  Deposit successfully");
                   setVisible(false);
                   new main_Class(pin);
               }
           } else if (e.getSource() ==b2) {
               setVisible(false);
               new main_Class(pin);
           }
       }catch(Exception E){
           E.printStackTrace();
       }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

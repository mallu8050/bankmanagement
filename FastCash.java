package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){

        this.pin = pin;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1680,980,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l3 =new JLabel(i3);
        l3.setBounds(0,0,1680,980);
        add(l3);


        JLabel label=new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setFont(new Font("System",Font.BOLD,24));
        label.setBounds(491,240,700,30);
        label.setForeground(Color.white);
        l3.add(label);

        b1 =new JButton("Rs. 100");
        b1.setForeground(Color.white);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.setBackground(new Color(65,125,125));
        b1.setBounds(450,320,180,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 =new JButton("Rs. 500");
        b2.setForeground(Color.white);
        b2.setFont(new Font("System",Font.BOLD,14));
        b2.setBackground(new Color(65,125,125));
        b2.setBounds(740,320,180,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 =new JButton("Rs. 1000");
        b3.setForeground(Color.white);
        b3.setFont(new Font("System",Font.BOLD,14));
        b3.setBackground(new Color(65,125,125));
        b3.setBounds(450,375,180,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 =new JButton("Rs. 2000");
        b4.setForeground(Color.white);
        b4.setFont(new Font("System",Font.BOLD,14));
        b4.setBackground(new Color(65,125,125));
        b4.setBounds(740,375,180,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 =new JButton("Rs. 5000");
        b5.setForeground(Color.white);
        b5.setFont(new Font("System",Font.BOLD,14));
        b5.setBackground(new Color(65,125,125));
        b5.setBounds(450,430,180,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 =new JButton("Rs. 10,000");
        b6.setForeground(Color.white);
        b6.setFont(new Font("System",Font.BOLD,14));
        b6.setBackground(new Color(65,125,125));
        b6.setBounds(740,430,180,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 =new JButton("BACK");
        b7.setForeground(Color.white);
        b7.setFont(new Font("System",Font.BOLD,14));
        b7.setBackground(new Color(65,125,125));
        b7.setBounds(740,485,180,35);
        b7.addActionListener(this);
        l3.add(b7);



        setLayout(null);
        setUndecorated(true);
        setSize(1680,1050);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7){
            setVisible(false);
            new main_Class(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Con c =new Con();
            Date date =new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance =0;
                while(resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }



                if (e.getSource()!= b7 && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','withdrawl','"+amount+"')");
                JOptionPane.showMessageDialog(null," Rs. "+ amount+ " debited Successfully");


            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

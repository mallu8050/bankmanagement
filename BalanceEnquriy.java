package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {
    JLabel label2;
    JButton b1;
    String pin;
    BalanceEnquriy(String pin){
        this.pin=pin;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1680,980,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l3 =new JLabel(i3);
        l3.setBounds(0,0,1680,980);
        add(l3);

        JLabel label1 =new JLabel("Your Current Balance is Rs");
        label1.setForeground(Color.white);
        label1.setBounds(450,200,700,35);
        label1.setFont(new Font("System",Font.BOLD,14));
        l3.add(label1);

        JLabel label2=new JLabel();
        label2.setBounds(450,230,700,35);
        label2.setFont(new Font("System",Font.BOLD,30));
        label2.setForeground(new Color(255, 255, 255));
        l3.add(label2);

        b1 = new JButton("BACK");
        b1.setBounds(760,432,150,35);
        b1.setBackground(new Color(87, 182, 177,125));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        int balance =0;
        try{
            Con c=new Con();
            ResultSet resultSet =c.statement.executeQuery("select * from bank where pin ='"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);


        setLayout(null);
        setSize(1680,1050);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}

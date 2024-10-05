package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1,b2;
    Withdrawl(String pin){
        this.pin=pin;



            ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
            Image i2 = i1.getImage().getScaledInstance(1680,980,Image.SCALE_DEFAULT);
            ImageIcon i3 =new ImageIcon(i2);
            JLabel l3 =new JLabel(i3);
            l3.setBounds(0,0,1680,980);
            add(l3);

            JLabel label1 =new JLabel("(MAXIMUM WITHDRAWAL IS RS 10,000)");
            label1.setForeground(new Color(239, 82, 82));
            label1.setBounds(500,200,700,35);
            label1.setFont(new Font("System",Font.BOLD,14));
            l3.add(label1);

         JLabel label2 =new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setBounds(500,230,700,35);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(new Color(255, 255, 255));
        l3.add(label2);

            textField = new JTextField();
            textField.setBackground(new Color(87, 182, 177,125));
            textField.setForeground(Color.white);
            textField.setFont(new Font("System",Font.BOLD,20));
            textField.setBounds(500,270,330,35);
            l3.add(textField);

            b1 = new JButton("WITHDRAWAL");
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
            setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Amount you want to Withdraw");
                } else {
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(null, " RS " + amount + " Debited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }

            } catch (Exception E) {

            }
        }else if (e.getSource()==b2){
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}

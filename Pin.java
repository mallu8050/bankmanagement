package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
       this.pin=pin;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1680,980,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l3 =new JLabel(i3);
        l3.setBounds(0,0,1680,980);
        add(l3);

        JLabel label1 =new JLabel("CHANGE YOUR PIN");
        label1.setBounds(450,220,400,30);
        label1.setFont(new Font("System",Font.BOLD,25));
        label1.setForeground(Color.white);
        l3.add(label1);

        JLabel label2 =new JLabel("NEW PIN");
        label2.setBounds(450,260,400,35);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(Color.white);
        l3.add(label2);

        JLabel label3 =new JLabel("Re-Enter NEW PIN");
        label3.setBounds(450,329,400,40);
        label3.setFont(new Font("System",Font.BOLD,18));
        label3.setForeground(Color.white);
        l3.add(label3);


        p1 = new JPasswordField();
        p1.setForeground(Color.black);
        p1.setFont(new Font("System",Font.BOLD,20));
        p1.setBounds(450,290,250,30);
        l3.add(p1);


        p2 = new JPasswordField();
        p2.setForeground(Color.black);
        p2.setFont(new Font("System",Font.BOLD,20));
        p2.setBounds(450,360,250,30);
        l3.add(p2);

        b1 = new JButton("CHANGE");
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

        setSize(1680,1050);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1=p1.getText();
            String pin2 =p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"PIN dose not Match");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter PIN");
                    return;
                }

                Con c=new Con();
                String q1= "update bank set pin = '"+pin1+"' where pin = '"+pin+"' ";
                String q2= "update login set pin = '"+pin1+"' where pin = '"+pin+"' ";
                String q3= "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"' ";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_Class(pin);

            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}

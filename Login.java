package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JButton button1,button2,button3;
    JTextField t;
    JPasswordField p;
    Login()
    {
        super("Bank Management System");




        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 =i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        label1 =new JLabel("WELL COME TO ATM");
        label1.setForeground(Color.yellow);
        label1.setFont(new Font("AvantGarde",Font.BOLD,30));
        label1.setBounds(250,115,380,30);
        add(label1);

        label2 =new JLabel("Card No.: ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("AvantGarde",Font.BOLD,20));
        label2.setBounds(200,180,120,30);
        add(label2);

        t=new JTextField(15);
        t.setFont(new Font("AvantGarde",Font.BOLD,17));
        t.setBounds(295,180,250,30);
        add(t);

        label3 =new JLabel("Pin: ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("AvantGarde",Font.BOLD,20));
        label3.setBounds(200,220,118,30);
        add(label3);

        p=new JPasswordField(15);
        p.setBounds(295,220,250,30);
        add(p);

        button1 =new JButton("Sign In");
        button1.setBounds(200,280,150,30);
        button1.setForeground(Color.white);
        button1.setFont(new Font("AvantGarde",Font.BOLD,20));
        button1.setBackground(Color.black);
        button1.addActionListener(this);
        add(button1);

        button2 =new JButton("Clear");
        button2.setBounds(400,280,150,30);
        button2.setForeground(Color.white);
        button2.setFont(new Font("AvantGarde",Font.BOLD,20));
        button2.setBackground(Color.black);
        button2.addActionListener(this);
        add(button2);

        button3 =new JButton("Sign Up");
        button3.setBounds(200,320,350,30);
        button3.setFont(new Font("AvantGarde",Font.BOLD,20));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        button3.addActionListener(this);
        add(button3);



        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 =ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel iimage =new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 =iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage =new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setUndecorated(true);
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1)
            {
                Con c =new Con();
                String cardno = t.getText();
                String pin = p.getText();
                String q= "select * from login where card_no = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }


            } else if (e.getSource() == button2) {

                t.setText("");
                p.setText("");

            }else if(e.getSource() == button3){
                new signup();
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Login();
    }
}

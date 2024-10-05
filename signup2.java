package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class signup2 extends JFrame implements ActionListener {
    String formno;
    JComboBox  comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhaar;
    JRadioButton r1,r2,e1,e2;
    JButton next;


    signup2(String formno){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        JLabel l1=new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD, 22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2=new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD, 22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3=new JLabel("Religon");
        l3.setFont(new Font("Raleway",Font.BOLD, 18));
        l3.setBounds(100,120,100,30);
        add(l3);

        String  religion[] ={"Hindu","Muslim","Sikh","Christion","other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(172, 168, 55));
        comboBox.setFont(new Font("Raleway",Font.BOLD, 14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel l4=new JLabel("Category");
        l4.setFont(new Font("Raleway",Font.BOLD, 18));
        l4.setBounds(100,170,100,30);
        add(l4);
        String  category[] ={"Genarl","OBC","SC","ST","other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(172, 168, 55));
        comboBox2.setFont(new Font("Raleway",Font.BOLD, 14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel l5=new JLabel("Income");
        l5.setFont(new Font("Raleway",Font.BOLD, 18));
        l5.setBounds(100,220,100,30);
        add(l5);

        String  income[] ={"Null","<1,50,000","<2,50,000","5,00,000","Upto 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(172, 168, 55));
        comboBox3.setFont(new Font("Raleway",Font.BOLD, 14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        JLabel l6=new JLabel("Educational");
        l6.setFont(new Font("Raleway",Font.BOLD, 18));
        l6.setBounds(100,270,150,30);
        add(l6);
        String  educational[] ={"Non-Graduate","Graduate","Post-Graduation","Doctorate","Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(172, 168, 55));
        comboBox4.setFont(new Font("Raleway",Font.BOLD, 14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

        JLabel l7=new JLabel("Occupation");
        l7.setFont(new Font("Raleway",Font.BOLD, 18));
        l7.setBounds(100,340,150,30);
        add(l7);
        String  occupation[] ={"Salaried","Self-Employed","Business","Student","Retired","Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(172, 168, 55));
        comboBox5.setFont(new Font("Raleway",Font.BOLD, 14));
        comboBox5.setBounds(350,340,320,30);
        add(comboBox5);

        JLabel l8=new JLabel("PAN Number");
        l8.setFont(new Font("Raleway",Font.BOLD, 18));
        l8.setBounds(100,390,150,30);
        add(l8);
        textPan =new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD, 18));
        textPan.setBounds(350,390,320,30);
        add(textPan);

        JLabel l9=new JLabel("Aadhaar Number");
        l9.setFont(new Font("Raleway",Font.BOLD, 18));
        l9.setBounds(100,440,150,30);
        add(l9);
        textAadhaar =new JTextField();
        textAadhaar.setFont(new Font("Raleway",Font.BOLD, 18));
        textAadhaar.setBounds(350,440,320,30);
        add(textAadhaar);

        JLabel l10=new JLabel("Senior Citizen");
        l10.setFont(new Font("Raleway",Font.BOLD, 18));
        l10.setBounds(100,490,180,30);
        add(l10);

        r1 =new JRadioButton("yes");
        r1.setFont(new Font("Raleway",Font.BOLD, 14));
        r1.setBackground(new Color(172, 168, 55));
        r1.setBounds(350,490,100,30);
        add(r1);
        r2 =new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD, 14));
        r2.setBackground(new Color(172, 168, 55));
        r2.setBounds(460,490,100,30);
        add(r2);
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel l11=new JLabel("Existing Account");
        l11.setFont(new Font("Raleway",Font.BOLD, 18));
        l11.setBounds(100,540,180,30);
        add(l11);

        e1 =new JRadioButton("yes");
        e1.setFont(new Font("Raleway",Font.BOLD, 14));
        e1.setBackground(new Color(172, 168, 55));
        e1.setBounds(350,540,100,30);
        add(e1);
        e2 =new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD, 14));
        e2.setBackground(new Color(172, 168, 55));
        e2.setBounds(460,540,100,30);
        add(e2);
        ButtonGroup buttonGroup2=new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel l12=new JLabel("Form No:");
        l12.setFont(new Font("Raleway",Font.BOLD, 18));
        l12.setBounds(650,10,100,30);
        add(l12);

        JLabel l13=new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD, 18));
        l13.setBounds(760,10,180,30);
        add(l13);

        next =new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBackground(Color.WHITE);
        next.setBounds(570,640,100,30);
        add(next);
        next.addActionListener(this);

        this.formno = formno;
        getContentPane().setBackground(new Color(172, 168, 55));
        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
String rel = (String) comboBox.getSelectedItem();
String cat= (String) comboBox2.getSelectedItem();
String inc = (String) comboBox3.getSelectedItem();
String edu =(String) comboBox4.getSelectedItem();
String occ =(String) comboBox5.getSelectedItem();
String pan = textPan.getText();
String aadhar =textAadhaar.getText();

String scitizen = " ";
if(r1.isSelected()){
    scitizen = "yes";
}else if(r2.isSelected()){
    scitizen ="No";
        }
String eaccount = " ";
if(e1.isSelected()){
    eaccount ="yes";
}else if(e2.isSelected()){
    eaccount = "No";
}
try{
    if(textPan.getText().equals("") || textAadhaar.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Fill all the fields");
    }else {
        Con c1 = new Con();
        String q= "insert into signuptwo values('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
        c1.statement.executeUpdate(q);
        new signup3(formno);
        setVisible(false);
    }
}catch (Exception E){
    E.printStackTrace();
}




    }

    public void main(String[] args){

        new signup2(" ");
    }
}

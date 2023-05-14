import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Salesmen_F extends JFrame {
    public static int salesmen_index =0;
    JLabel ID,Passward;
    JTextField j1;
    JPasswordField j2;
    JButton register,enter,back;
    Salesmen_F(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        ID = new JLabel("ID");
        Passward = new JLabel("Password");
        j1=new JTextField(20);
        j2=new JPasswordField(20);
        j2.setEchoChar('*');
        register = new JButton("Register");
        enter=new JButton("Enter");
        back = new JButton("Back");
        MyActionListener a = new MyActionListener();
        register.addActionListener(a);
        enter.addActionListener(a);
        back.addActionListener(a);
        add(ID);
        add(j1);
        add(Passward);
        add(j2);

        add(enter);add(register);add(back);
    }
    public ArrayList<Salesmen> readAllFromFile(){

        ArrayList<Salesmen> stuArr = new ArrayList<Salesmen>();

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Salesmen.ser"));
            while(true){
                Salesmen s = (Salesmen) ois.readObject();
                stuArr.add(s);
            }
        }
        catch(ClassNotFoundException c){
            System.out.println(c);
        }
        catch(EOFException eof){
            System.out.println(eof);
        }
        catch(IOException eee){
            System.out.println(eee);
        }

        return stuArr;

    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("Back")){
                dispose();
                new Home();
            }
            else if(ae.getActionCommand().equals("Register")){
                dispose();
                new Register_salesmen();
            }
            else if (ae.getActionCommand().equals("Enter")){
                ArrayList<Salesmen> stuArr =  readAllFromFile();
                int verify = 0;
                for (int i = 0; i < stuArr.size(); i++) {
                    if (stuArr.get(i).getId().equals(j1.getText()) && stuArr.get(i).getPassward().equals(j2.getText())){
                        salesmen_index=i;
                        verify =1;
                        dispose();
                        new Salesmen_Home_F();
                        return;
                    }
                }
                if(verify ==0){
                    JOptionPane.showMessageDialog(new JFrame(),"Wrong Credential ");
                }
            }
        }
    }
}

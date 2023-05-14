import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Supplier_F extends JFrame {
    public static int supplier_index=0;
    JLabel ID,Passward;
    JTextField j1;
    JPasswordField j2;
    JButton register,enter,back;
    Supplier_F(){
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

        add(enter); add(register);add(back);
    }
    public ArrayList<Supplier> readAllFromFile(){

        ArrayList<Supplier> stuArr = new ArrayList<Supplier>();

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Supplier.ser"));
            while(true){
                Supplier s = (Supplier) ois.readObject();
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
                new Register_supplier();
            }
            else if (ae.getActionCommand().equals("Enter")){
                ArrayList<Supplier> stuArr =  readAllFromFile();
                int verify = 0;
                for (int i = 0; i < stuArr.size(); i++) {
                    if (stuArr.get(i).getId().equals(j1.getText()) && stuArr.get(i).getPassword().equals(j2.getText())){
                        supplier_index=i;
                        verify =1;
                        dispose();
                        new Supplier_Home_F();
                    }
                }
                if(verify ==0){
                    JOptionPane.showMessageDialog(new JFrame(),"Wrong Credential ");
                }
            }
        }
    }
}

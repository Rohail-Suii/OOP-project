import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Register_supplier extends JFrame {
    JLabel name,contact,id,passward;
    JTextField j1,j2,j3;
    JPasswordField j4;
    JButton register,back;
    Register_supplier(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        name = new JLabel("Name");
        contact = new JLabel("Contact");
        id = new JLabel("ID");
        passward = new JLabel("Password");
        j1=new JTextField(20);

        j2=new JTextField(20);
        j3=new JTextField(20);
        j4=new JPasswordField(20);
        j4.setEchoChar('*');
        register = new JButton("Register");
        back = new JButton("Back");
        MyActionListener a = new MyActionListener();
        register.addActionListener(a);
        back.addActionListener(a);
        add(name);add(j1);
        add(contact);add(j2);
        add(id);add(j3);
        add(passward);add(j4);
        add(register);
        add(back);
    }
    Supplier[] S = new Supplier[10];
    public void writeToFile(Supplier e){
        try{
            File f = new File("Supplier.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(e);
            oos.close();
            JOptionPane.showMessageDialog(new JFrame(),"Registered");
        }
        catch(IOException p){
            System.out.println(p);
        }
    }
    public ArrayList<Supplier> readAllFromFile() {

        ArrayList<Supplier> stuArr = new ArrayList<Supplier>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Supplier.ser"));
            while (true) {
                Supplier s = (Supplier) ois.readObject();
                stuArr.add(s);
            }
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (EOFException eof) {
            System.out.println(eof);
        } catch (IOException eee) {
            System.out.println(eee);
        }
        return stuArr;
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if(j1.getText().isEmpty() && j2.getText().isEmpty() && j3.getText().isEmpty() && j4.getText().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(),"Fill all Fields");
            }
            else if (ae.getActionCommand().equals("Register")) {
                ArrayList<Supplier> list  = readAllFromFile();
                    if (list.size()==9){
                        JOptionPane.showMessageDialog(new JFrame(),"No more Supplier required");
                    }else{
                        File f = new File("Supplier.ser");
                        for (int i = 0; i < S.length; i++) {
                            for (int j = 0; j <list.size() ; j++) {
                                if (f.exists()) {
                                    if(list.get(j).getName().equals(j1.getText()) && list.get(j).getContantnum().equals(j2.getText()) && list.get(j).getId().equals(j3.getText()) && list.get(j).getPassword().equals(j4.getText())){
                                        JOptionPane.showMessageDialog(new JFrame(),"Same person can't register twice");
                                        return;
                                    } else if (list.get(j).getName().equals(j1.getText()) && list.get(j).getContantnum().equals(j2.getText())) {
                                        JOptionPane.showMessageDialog(new JFrame(),"Same person can't register twice");
                                        return;
                                    }
                                }
                            }
                            if(S[i]==null){
                                S[i] = new Supplier(j1.getText(), j2.getText(), j3.getText(), j4.getText());
                                writeToFile(S[i]);
                                return;
                            }
                        }
                    }

            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                new Supplier_F();
            }
        }
    }

}

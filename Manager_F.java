//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Manager_F extends JFrame {
    public static int mindex=0;
    JLabel ID;
    JLabel Passward;
    JTextField j1;
    JPasswordField j2;
    JButton register,back;
    JButton enter;

    Manager_F() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.ID = new JLabel("ID");
        this.Passward = new JLabel("Password");
        this.j1 = new JTextField(20);
        this.j2 = new JPasswordField(20);
        this.j2.setEchoChar('*');
        this.register = new JButton("Register");
        this.enter = new JButton("Enter");
        back = new JButton("Back");
        MyActionListener a = new MyActionListener();
        this.register.addActionListener(a);
        this.enter.addActionListener(a);
        back.addActionListener(a);
        this.add(this.ID);
        this.add(this.j1);
        this.add(this.Passward);
        this.add(this.j2);

        this.add(this.enter);this.add(this.register);add(back);
    }

    public ArrayList<Manager> readAllFromFile() {
        ArrayList<Manager> stuArr = new ArrayList();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Manager.ser"));

            while(true) {
                Manager s = (Manager)ois.readObject();
                stuArr.add(s);
            }
        } catch (ClassNotFoundException var4) {
            System.out.println(var4);
        } catch (EOFException var5) {
            System.out.println(var5);
        } catch (IOException var6) {
            System.out.println(var6);
        }

        return stuArr;
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("Back")){
                dispose();
                new Home();
            }
            else
            if(ae.getActionCommand().equals("Back")){
                dispose();
                new Home();
            }
            else if (ae.getActionCommand().equals("Register")) {
                Manager_F.this.dispose();
                new Register_manager();
            } else if (ae.getActionCommand().equals("Enter")) {
                ArrayList<Manager> stuArr = Manager_F.this.readAllFromFile();
                boolean verify = false;

                for(int i = 0; i < stuArr.size(); ++i) {
                    if (((Manager)stuArr.get(i)).getId().equals(Manager_F.this.j1.getText()) && ((Manager)stuArr.get(i)).getPassward().equals(Manager_F.this.j2.getText())) {
                        mindex = i;
                        verify = true;
                        dispose();
                        new Manager_Home_F();
                    }
                }

                if (!verify) {
                    JOptionPane.showMessageDialog(new JFrame(), "Wrong Credential ");
                }
            }

        }
    }
}

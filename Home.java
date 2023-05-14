import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    JButton supplier,manager,salesman;
    Home(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        supplier=new JButton("Supplier");
        manager=new JButton("Manager");
        salesman=new JButton("Salesmen");
        MyActionListener a = new MyActionListener();
        supplier.addActionListener(a);
        manager.addActionListener(a);
        salesman.addActionListener(a);
        add(salesman);
        add(manager);
        add(supplier);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Salesmen")) {
                dispose();
                new Salesmen_F();
            }
            else if (ae.getActionCommand().equals("Manager")) {
                dispose();
                new Manager_F();
            }
            else if (ae.getActionCommand().equals("Supplier")) {
                dispose();
                new Supplier_F();
            }
        }
    }


}

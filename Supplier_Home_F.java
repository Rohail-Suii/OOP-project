import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Supplier_Home_F extends JFrame{
    JButton Pproduct,MyPproduct,orders,back;
    Supplier_Home_F(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        Pproduct = new JButton("Propose your Product");
        MyPproduct = new JButton("Proposed Product");
        orders = new JButton("orders");
        back = new JButton("Logout");
        MyActionListener a = new MyActionListener();
        Pproduct.addActionListener(a);
        MyPproduct.addActionListener(a);
        orders.addActionListener(a);
        back.addActionListener(a);
        add(Pproduct);add(MyPproduct);add(orders);add(back);

    }
    public ArrayList<Product> readAllFromFile(){

        ArrayList<Product> stuArr = new ArrayList<Product>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Product.ser"));){

            while(true){
                Product s = (Product) ois.readObject();
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
    public void writeToFile(Product e){
        try{
            File f = new File("Product.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));// not appending
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(e);
            oos.close();

        }
        catch(IOException p){
            System.out.println(p);
        }
    }
    File f = new File("Product.ser");
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Logout")) {
                dispose();
                new Supplier_F();
            }
            else if (ae.getActionCommand().equals("Propose your Product")) {
                dispose();
                new ProposeProduct_F();
            }
            else if (ae.getActionCommand().equals("Proposed Product")) {
                if(f.exists()){
                    ArrayList<Product> list = readAllFromFile();
                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(Supplier_F.supplier_index).getSupplierindex()==Supplier_F.supplier_index){
                            ImageIcon ii = new ImageIcon(list.get(i).getImagepath());
                            Image image = ii.getImage(); // transform it
                            Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                            ii = new ImageIcon(newimg);
                            JOptionPane.showMessageDialog(new JFrame(),list.get(i).toString(),"",JOptionPane.INFORMATION_MESSAGE,ii);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"No Products");
                }
            }else if(ae.getActionCommand().equals("orders")){
                ArrayList<Product> list = Supplier_Home_F.this.readAllFromFile();
                boolean verify = false;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(Supplier_F.supplier_index).getSupplierindex()==Supplier_F.supplier_index){
                        ImageIcon ii = new ImageIcon(list.get(i).getImagepath());
                        Image image = ii.getImage(); // transform it
                        Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                        ii = new ImageIcon(newimg);
                        if(list.get(i).isStatus()==true && list.get(i).isReceived()==false){
                            verify = true;
                            int a=JOptionPane.showConfirmDialog(new JFrame(),"Enter yes to order \n"+list.get(i).toString(),"",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,ii);
                            if(a==0){
                                list.get(i).setReceived(true);
                            }
                        }
                    }
                }f.delete();
                for (int i = 0; i < list.size(); i++) {
                    writeToFile(list.get(i));
                }
                if (verify==false) {
                    JOptionPane.showMessageDialog(new JFrame(),"No Orders for now!");
                }
            }
        }
    }
}

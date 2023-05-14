import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Salesmen_Home_F extends JFrame{
    JButton sell,earning,back,allproduct,search,sold;
    Salesmen_Home_F(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        sell = new JButton("Sell");
        earning = new JButton("Check Earning");
        back = new JButton("Log Out");
        allproduct = new JButton("All Products in Shop");
        search = new JButton("Search product");
        sold = new JButton("Sold");
        MyActionListener a = new MyActionListener();
        sell.addActionListener(a);
        earning.addActionListener(a);
        back.addActionListener(a);
        allproduct.addActionListener(a);
        search.addActionListener(a);
        sold.addActionListener(a);
        add(allproduct);add(sell);add(search);add(earning);add(sold);
        add(back);
    }
    public ArrayList<Product> readAllFromFilep() {

        ArrayList<Product> stuArr = new ArrayList<Product>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BuyableProduct.ser"));) {
            while (true) {
                Product s = (Product) ois.readObject();
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
    public ArrayList<Salesmen> readAllFromFileS(){

        ArrayList<Salesmen> stuArr = new ArrayList<Salesmen>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Salesmen.ser"));){
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
    public ArrayList<Product> readAllFromFileBuyed(){

        ArrayList<Product> stuArr = new ArrayList<Product>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Buyed Product.ser"));){
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
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            ArrayList<Salesmen> list = readAllFromFileS();
            if (ae.getActionCommand().equals("Sell")){
                dispose();
                new Sell_F();
            }else if (ae.getActionCommand().equals("Check Earning")){
                JOptionPane.showMessageDialog(new JFrame(),"Your earning is "+list.get(0).getSalary()+" RS/-");
            } else if (ae.getActionCommand().equals("Log Out")) {
                dispose();
                new Salesmen_F();
            }else if (ae.getActionCommand().equals("All Products in Shop")) {
                ArrayList<Product> list2 =readAllFromFilep();
                for (int i = 0; i < list2.size(); i++) {
                    JOptionPane.showMessageDialog(new JFrame(),list2.get(i).toString());
                }
            } else if (ae.getActionCommand().equals("Search product")) {
                dispose();
                new search_f();
            } else if (ae.getActionCommand().equals("Sold")) {
                ArrayList<Product> buyed= readAllFromFileBuyed();
                for (int i = 0; i < buyed.size(); i++) {
                    JOptionPane.showMessageDialog(new JFrame(),buyed.get(i).toString());
                }
            }
        }
    }
}

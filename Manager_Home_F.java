import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Manager_Home_F extends JFrame {
    JButton Pproposed ,add,addProduct,addbills,demandingproduct,update,addrecieved,allproduct,profit,back;
    JPanel panel;
    Manager_Home_F(){
        panel=new JPanel();
        panel.setBounds(40,80,200,200);
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        Pproposed = new JButton("Proposed Product");
        add = new JButton("Add");
        addProduct = new JButton("Add Product");
        addbills = new JButton("Add Bills");
        demandingproduct = new JButton("Products on Demand");
        update = new JButton("Update");
        addrecieved=new JButton("Add Arrived Products");
        allproduct = new JButton("All Products in Shop");
        back = new JButton("Logout");
        profit = new JButton("Check Profit");
        MyActionListener a = new MyActionListener();
        Pproposed.addActionListener(a);
        add.addActionListener(a);
        addProduct.addActionListener(a);
        addbills.addActionListener(a);
        demandingproduct.addActionListener(a);
        update.addActionListener(a);
        addrecieved.addActionListener(a);
        allproduct.addActionListener(a);
        profit.addActionListener(a);
        back.addActionListener(a);
        panel.add(add);
        add(Pproposed);add(addProduct);add(addrecieved);add(addbills);add(allproduct);add(demandingproduct);add(profit);add(back);
    }
    public ArrayList<Product> readAllFromFile(){

        ArrayList<Product> stuArr = new ArrayList<Product>();

        try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Product.ser"));){
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
    public ArrayList<Product> readAllFromFilebuyed(){

        ArrayList<Product> stuArr = new ArrayList<Product>();

        try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Buyed Product.ser"));){
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
    public ArrayList<Bills> readAllFromFilebill(){

        ArrayList<Bills> stuArr = new ArrayList<Bills>();

        try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Bills.ser"));){
            while(true){
                Bills s = (Bills) ois.readObject();
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
    public ArrayList<Manager> readAllFromFileM() {
        ArrayList<Manager> stuArr = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Manager.ser"));){
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
    public ArrayList<Supplier> readAllFromFilesupplier() {
        ArrayList<Supplier> stuArr = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Supplier.ser"));){
            while(true) {
                Supplier s = (Supplier) ois.readObject();
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
    public void writeToFileBuy(Product e){
        try{
            File f = new File("BuyableProduct.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(e);
            oos.close();
            JOptionPane.showMessageDialog(new JFrame(),"Added");
        }
        catch(IOException p){
            System.out.println(p);
        }
    }


    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("Logout")){
                dispose();
                new Manager_F();
            }
            else if (ae.getActionCommand().equals("Proposed Product")) {
                ArrayList<Supplier> suppliername = readAllFromFilesupplier();
                File p = new File("Product.ser");
                if(p.exists()){
                    ArrayList<Product> list = new ArrayList<Product>(0);
                    list = readAllFromFile();
                    int verify=0;
                    for (int i = 0; i < list.size(); i++) {
                        if(!list.get(i).isStatus()){
                            verify=1;
                        }
                    }if(verify==1){
                        for (int i=0;i<list.size();i++) {
                            ImageIcon ii = new ImageIcon(list.get(i).getImagepath());
                            Image image = ii.getImage(); // transform it
                            Image newimg = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // scale it the smooth way
                            ii = new ImageIcon(newimg);
                            // new JFrame().add(panel);
                            int a = 1;
                            if (!list.get(i).isStatus()) {
                                a = JOptionPane.showConfirmDialog(new JFrame(), suppliername.get(i).toString()+" Enter yes to order \n" + list.get(i).toString(), "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, ii);
                            }
                            // yes=0  no=1
                            System.out.println(a);
                            if (a == 0) {
                                list.get(i).setStatus(true);
                                System.out.println(list.get(i).isStatus());
                                JOptionPane.showMessageDialog(new JFrame(), "Order send!");
                            }else{
                                list.remove(list.get(i));
                            }
                        }
                        p.delete();
                        System.out.println(list.size());
                        for (int i = 0; i < list.size(); i++) {
                            writeToFile(list.get(i));
                        }
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(),"No Products");
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"No Products");
                }
            }
            else if (ae.getActionCommand().equals("Add Product")) {
                dispose();
                new buyableProduct_F();
            }else if (ae.getActionCommand().equals("Add Bills")) {
                dispose();
                new Bills_F();
            } else if (ae.getActionCommand().equals("Products on Demand")) {
                ArrayList<Product> list2 =Manager_Home_F.this.readAllFromFilep();
                boolean verify = true;
                for (int i = 0; i < list2.size(); i++) {
                    if (list2.get(i).getQuantity()<3) {
                        verify =false;
                        JOptionPane.showMessageDialog(new JFrame(),list2.get(i).toString());
                    }
                }if(verify==true){
                    JOptionPane.showMessageDialog(new JFrame(),"No Products on demand");
                }// profit / remaining items <5
            } else if (ae.getActionCommand().equals("Add Arrived Products")) {
                ArrayList<Product> list =readAllFromFile();
                int verify=0;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).isReceived()){
                        verify =1;
                        ImageIcon ii = new ImageIcon(list.get(i).getImagepath());
                        Image image = ii.getImage(); // transform it
                        Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                        ii = new ImageIcon(newimg);
                        int a=1;
                        a = JOptionPane.showConfirmDialog(new JFrame(), " Enter yes to Add in Inventory \n" + list.get(i).toString(), "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, ii);
                        if(a==0){
                            Product p = new Product(list.get(i).getName(),list.get(i).getQuantity(),list.get(i).getPrice());
                            writeToFileBuy(p);
                            list.remove(i);
                        }
                    }
                }
                if(verify==0){
                    JOptionPane.showMessageDialog(new JFrame(),"No Products");
                }
                File p = new File("Product.ser");
                p.delete();
                for (int i = 0; i < list.size(); i++) {
                    writeToFile(list.get(i));
                }
            } else if (ae.getActionCommand().equals("All Products in Shop")) {
                ArrayList<Product> list =readAllFromFilep();
                for (int i = 0; i < list.size(); i++) {
                    JOptionPane.showMessageDialog(new JFrame(),list.get(i).toString());
                }
            } else if (ae.getActionCommand().equals("Check Profit")) {
                ArrayList<Bills> bill = readAllFromFilebill();
                ArrayList<Product> pricelist= readAllFromFilep();
                ArrayList<Product> buyedpricelist = readAllFromFilebuyed();
                double totalbill = 0;
                for (int i = 0; i < bill.size(); i++) {
                    totalbill=totalbill+bill.get(i).totalbill();
                }
                double totalbuy =0;
                for (int i = 0; i < pricelist.size(); i++) {
                    totalbuy=totalbuy+pricelist.get(i).getPrice();
                }
                double totalbuyed=0;
                for (int i = 0; i < buyedpricelist.size(); i++) {
                    totalbuyed=totalbuyed+(buyedpricelist.get(i).getPrice()*buyedpricelist.get(i).getQuantity());
                }
                double profit = totalbuyed-totalbill+totalbuy;
                JOptionPane.showMessageDialog(new JFrame(),"Your current budget is "+profit);

            }

        }
    }

}

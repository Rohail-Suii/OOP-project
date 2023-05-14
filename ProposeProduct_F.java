import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProposeProduct_F extends JFrame{
    JLabel name,quantity,price,pic;
    JLabel jLabelImage;
    JButton add ,back,browse;
    JTextField j1,j2,j3;
    ProposeProduct_F(){
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        name = new JLabel("Name");
        quantity = new JLabel("Quantity");
        price = new JLabel("Price");
        pic = new JLabel("Picture");
        jLabelImage = new JLabel();
        add = new JButton("Add");
        back = new JButton("Back");
        browse = new JButton("Browse");
        j1 = new JTextField(20);
        j2 = new JTextField(20);
        j3 = new JTextField(20);
        MyActionListener a = new MyActionListener();
        add.addActionListener(a);
        back.addActionListener(a);
        browse.addActionListener(a);
        add(name);add(j1);
        add(quantity);add(j2);
        add(price);add(j3);
        add(pic);add(browse);add(jLabelImage);
        add(add);add(back);
    }
    public void writeToFile(Product e){
        try{
            File f = new File("Product.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(e);
            oos.close();
            JOptionPane.showMessageDialog(new JFrame(),"Proposed");
        }
        catch(IOException p){
            System.out.println(p);
        }
    }
    String selectedImagePath = null;
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            Image image;
            if (ae.getActionCommand().equals("Back")) {
                dispose();
                new Supplier_Home_F();
            }

            else if(j1.getText().isEmpty() && j2.getText().isEmpty() && j3.getText().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(),"Fill all Fields");
            }
            else if(ae.getActionCommand().equals("Browse")) {
                JFileChooser browseImageFile = new JFileChooser();
                //Filter image extensions
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
                browseImageFile.addChoosableFileFilter(fnef);
                int showOpenDialogue = browseImageFile.showOpenDialog(null);
                if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
                    File selectedImageFile = browseImageFile.getSelectedFile();
                    selectedImagePath = selectedImageFile.getAbsolutePath();
                    JOptionPane.showMessageDialog(null, selectedImagePath);
                    //Display image on jlablel
                    ImageIcon ii = new ImageIcon(selectedImagePath); //
                    // Resize image to fit jlabel

                    image = ii.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    jLabelImage.setIcon(new ImageIcon(image));
                   // writeToFile(image);
                }
            }else if (ae.getActionCommand().equals("Add")) {
                if (selectedImagePath == null) {
                    JOptionPane.showMessageDialog(new JFrame(),"Add an image");
                } else{
                    Product P = new Product(j1.getText(), Integer.parseInt(j2.getText()), Double.parseDouble(j3.getText()),selectedImagePath,Supplier_F.supplier_index);
                    System.out.println(P.toString());
                    writeToFile(P);
                    }
                }
            }
        }
    }

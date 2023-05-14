import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.*;

public class FileOperations extends JFrame {



//    public void readFromFile(){
//
//        try{
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
//            while(true){
//                Salesmen e = (Salesmen) ois.readObject();
//                System.out.println(e.getName());
//            }
//        }
//        catch(ClassNotFoundException m){
//
//        }
//        catch(EOFException p){
//            return;
//        }
//        catch(IOException c){
//
//        }

   // }



//    public void searchAStudent(String regno){
//
//        ArrayList<student> list = readAllFromFile();
//
//        if(list.size() < 1){
//            System.out.print("\nList is empty..\n");
//        }
//        else{
//
//            for(int i = 0 ; i < list.size() ; i++){
//                if(list.get(i).getRegNo().equals(regno)){
//                    System.out.println("\nStudent was found!\n");
//                }
//                else{
//                    System.out.println("Student not found");
//                }
//            }
//
//        }
//
//    }

//    public void DeleteAStudent(String rego){
//
//        ArrayList <student> delFrom = readAllFromFile();
//
//        for(int i = 0 ; i < delFrom.size() ; i++){
//            if(delFrom.get(i).getRegNo().equals(rego)){
//                delFrom.remove(i); break;
//            }
//        }
//
//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
//
//            for(int i = 0 ; i < delFrom.size() ; i++){
//                oos.writeObject(delFrom.get(i));
//            }
//        }
//        catch(IOException e){
//
//        }
//    }

//    public void UpdateAStudent(String regno , String em){
//
//        ArrayList <student> delFrom = readAllFromFile();
//
//        for(int i = 0 ; i < delFrom.size() ; i++){
//            if(delFrom.get(i).getRegNo().equals(regno)){
//
//                delFrom.get(i).setEmail(em);;
//                break;
//            }
//        }
//
//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
//
//            for(int i = 0 ; i < delFrom.size() ; i++){
//                oos.writeObject(delFrom.get(i));
//            }
//        }
//        catch(IOException e){
//
//        }
//
//    }
//
//    public void UpdateAStudent2(String regno , String deptName){
//
//        ArrayList <student> delFrom = readAllFromFile();
//
//        for(int i = 0 ; i < delFrom.size() ; i++){
//            if(delFrom.get(i).getRegNo().equals(regno)){
//
//                delFrom.get(i).getD().setName(deptName);
//                break;
//            }
//        }
//
//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
//
//            for(int i = 0 ; i < delFrom.size() ; i++){
//                oos.writeObject(delFrom.get(i));
//            }
//        }
//        catch(IOException e){
//
//        }
//
//    }
//
//    public int CountAllStudentsOnProb(){
//
//        ArrayList<student> list = readAllFromFile();
//
//        int c = 0;
//
//        for(int i  = 0 ; i < list.size() ; i++){
//            if(list.get(i).getGPA() < 2.0){
//                c++;
//            }
//        }
//
//        return c;
//
//    }
//
//    public void DisplayAllStudentsInDept(String dept){
//
//        ArrayList<student> list = readAllFromFile();
//
//        System.out.print("\nStudents in " + dept + " : \n");
//
//        for(int i = 0 ; i < list.size() ; i++){
//            if(list.get(i).getD().getName().equals(dept)){
//                System.out.print("\n" + list.get(i).toString());
//            }
//        }
//
//    }
//
//    public void DeleteAllStudentsInDept(String dept){
//
//        ArrayList<student> list = readAllFromFile();
//
//        System.out.print("\nStudents in " + dept + " : \n");
//
//        for(int i = 0 ; i < list.size() ; i++){
//            if(list.get(i).getD().getName().equals(dept)){
//                list.remove(i);
//                --i;
//            }
//        }
//
//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
//
//            for(int i = 0 ; i < list.size() ; i++){
//                oos.writeObject(list.get(i));
//            }
//        }
//        catch(IOException e){
//
//        }
//
//    }

}
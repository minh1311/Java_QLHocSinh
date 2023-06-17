/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demokt2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class inout {
     private final String path = "QLSV.dat";
    
    public ArrayList<SV> Read()
    {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<SV> list = new ArrayList<>();
        
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<SV>)ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        } finally{
            CloseStream(fis);
            CloseStream(ois);
        }
        return list;
    }
    
    
    public void Write(ArrayList<SV> list)
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos =null;
        try{
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch(IOException ex){
            ex.printStackTrace();
        } finally{
            CloseStream(fos);
            CloseStream(oos);
        }
    }
    
    
    private void CloseStream(InputStream is){
        if(is != null){
            try{
                is.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    private void CloseStream(OutputStream os){
        if(os != null){
            try{
                os.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}

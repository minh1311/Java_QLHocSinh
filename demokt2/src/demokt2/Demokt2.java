/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demokt2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Demokt2 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args)  {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        ArrayList<SV> list = new ArrayList<SV>();
        inout db=new inout();
        list = db.Read();
        int chose;
        
        do{
        System.out.println("CHUONG TRINH QLSV");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Nhap");
        System.out.println("2. Hien thi");
        System.out.println("3. Sap xep");
        System.out.println("4. Tim kiem");
        System.out.println("5. Thoat");
        System.out.println("        Chon chuc nang:");chose=sc.nextInt();
        switch(chose){
            case 1:
                
                SV sv = new SV();
                sv.nhap();
                boolean check = false;
                for(var i : list)
                {
                    if(i.getId().equals(sv.getId())){
                        check = true;
                        break;
                    }
                }
                if(check){
                    System.out.println("Warning: Ma sinh vien da ton tai!");
                } else {
                    list.add(sv);
                    db.Write(list);
                }
                
                
                break;
            case 2:
                for (var i : list) {
                    i.toString();
                }
                break;
            case 3:
                for (int i=0;i<list.size();i++) {
                    for(int j=i+1;j<list.size();j++)
                    if(list.get(i).getId().compareTo(list.get(j).getId())>=0 )
                    {
                        Collections.swap(list, i, j);
                    }              
                }
                break;
            case 4: 
                System.out.print("Nhap ma can tim:");String findID = sc.nextLine();
                for (SV i : list) {
                    if(i.getId().equals(findID)){
                        i.toString();
                    }
                }
                break;    
            }
        }
        while(chose!=5);
    }
    
}

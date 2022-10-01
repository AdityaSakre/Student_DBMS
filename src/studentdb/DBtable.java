/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class DBtable {
            DBCollection collection;
            DefaultTableModel tablemodel;
            
            
           
    DefaultTableModel table(String key) {
        
         try {
                MongoClient mongo =new MongoClient("localhost", 27017);
            DB db=mongo.getDB("DB");
            System.out.println("Connected Successfullly");       
            DBCollection collection = db.getCollection("Attendance"); 
            
        
        
        switch(key)  {
            case "Attendance":  
                    String[] columnName={"StudentId","Semester","First Day Attendance","Fortnight Attendance","Final Atendance"};
                    DefaultTableModel tablemodel= new DefaultTableModel(columnName,0);
                    
                    DBCursor cursor = collection.find();
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();


                        String Studentid = document.getString("StudentId");
                        String sem = document.getString("Semester");
                        String FDA=document.getString("FirstDayAttendance"); 
                        String FNA= document.getString("FortnightAttendance");
                        String FA=document.getString("FinalAttendance");
                            
                        String[] row = {Studentid,sem,FDA,FNA,FA};
                        System.out.println(row[0]);
                        tablemodel.addRow(row);  
                    }
            break;
        }
            
            }
            catch(Exception e)  {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
       return tablemodel; 
    }    
}

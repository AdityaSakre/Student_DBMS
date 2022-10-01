package studentdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;




/**
 *
 * @author Aditya
 */

public class DBconn {
        DBCollection collection;
        DB db ;
        BasicDBObject obj=new BasicDBObject();
        
    void connect(String dbname ,String Collname ,BasicDBObject obj ){
           
            try {
                MongoClient mongo = new MongoClient("localhost", 27017);
                db = mongo.getDB(dbname);
                collection = db.getCollection(Collname);
                collection.insert(obj);
            }
            catch(Exception e)  {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
               
    }
     void connect(String dbname ,String Collname  ){
           
            try {
                MongoClient mongo = new MongoClient("localhost", 27017);
                db = mongo.getDB(dbname);
                collection = db.getCollection(Collname);
                
            }
            catch(Exception e)  {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
               
    }
    
    void addelement(String Key, String Value ){
                obj.put(Key,Value);
    }
    
    void addelement(String Key,int Value){
                obj.put(Key, Value);
    }
    void insert(){
                collection.insert(obj);
    }
    
    
    void update(String Prekey,String PreValue, String key ,String Value){
          try {
                    DBCursor cursor = collection.find();
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();
 
                        if(PreValue.equals(document.get(Prekey)))  {
                            DBObject query = new BasicDBObject(Prekey,PreValue);
                            DBObject update = new BasicDBObject();
                            update.put("$set", new BasicDBObject(key,Value)); 
                            WriteResult result = collection.update(query, update);
                            break;
                        }
                    }
                }   
          catch(Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();      
        }
    }
    void update(String Prekey,String PreValue, String key ,int Value){
          try {
                    DBCursor cursor = collection.find();
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();
 
                        if(PreValue.equals(document.get(Prekey)))  {
                            DBObject query = new BasicDBObject(Prekey,PreValue);
                            DBObject update = new BasicDBObject();
                            update.put("$set", new BasicDBObject(key,Value)); 
                            WriteResult result = collection.update(query, update);
                            break;
                        }
                    }
                }   
          catch(Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();      
        }
    }
    
    
    void update(String Prekey,int PreValue, String key ,String Value){
          try {
                    
                    DBCursor cursor = collection.find();
                    String dou = String.valueOf(PreValue);
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();
                        String pre = String.valueOf(document.get(Prekey)) ;
                        if(pre.equals(dou))  {
                            DBObject query = new BasicDBObject(Prekey,PreValue);
                            DBObject update = new BasicDBObject();
                            update.put("$set", new BasicDBObject(key,Value)); 
                            WriteResult result = collection.update(query, update);
                            break;
                        }
                    }
                }   
          catch(Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();      
        }
    }
    
    
    
    void update(String Prekey,int PreValue, String key ,int Value){
          try {
                    
                    DBCursor cursor = collection.find();
                    String dou = String.valueOf(PreValue);
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();
                        String pre = String.valueOf(document.get(Prekey)) ;
                        if(pre.equals(dou))  {
                            DBObject query = new BasicDBObject(Prekey,PreValue);
                            DBObject update = new BasicDBObject();
                            update.put("$set", new BasicDBObject(key,Value)); 
                            WriteResult result = collection.update(query, update);
                            break;
                        }
                    }
                }   
          catch(Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();      
        }
    }
    
    
    void update(String Prekey,int PreValue,String Prekey1,int PreValue1, String key ,String Value){
          try {
                   
                    String dou = String.valueOf(PreValue);
                    String dou1 = String.valueOf(PreValue1);
                    
                    DBCursor cursor = collection.find();
                    
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();
                        String pre = String.valueOf(document.get(Prekey)) ;
                        String pre1 = String.valueOf(document.get(Prekey1)) ;
                        if(pre.equals(dou))  {
                            if(pre1.equals(dou1)){
                            DBObject query = new BasicDBObject(Prekey,PreValue);
                            DBObject update = new BasicDBObject();
                            update.put("$set", new BasicDBObject(key,Value)); 
                            WriteResult result = collection.update(query, update);
                            break;
                            }
                        }
                    }
                }   
          catch(Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();      
        }
    }
    
    void update(String Prekey,String PreValue,String Prekey1,String PreValue1, String key ,String Value){
          try {
               
                    
                    DBCursor cursor = collection.find();
                    
                    while(cursor.hasNext()) {
                        BasicDBObject document = (BasicDBObject)cursor.next();
                        String pre = String.valueOf(document.get(Prekey)) ;
                        String pre1 = String.valueOf(document.get(Prekey1)) ;
                        if(pre.equals(PreValue))  {
                            if(pre1.equals(PreValue1)){
                            DBObject query = new BasicDBObject(Prekey1,PreValue1);
                            DBObject update = new BasicDBObject();
                            update.put("$set", new BasicDBObject(key,Value)); 
                            WriteResult result = collection.update(query, update);
                            break;
                            }
                        }
                    }
                }   
          catch(Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();      
        }
    }
/***********************************************Search by two keys(String, String)
 * and return a Value with reqKey(String)*/    
    String dbsearch( String preKey,String preValue,String Key,String Value,String reqKey ){
        String out=null;
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put(preKey, preValue);
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
             BasicDBObject document = (BasicDBObject)cursor.next();
               String pre = String.valueOf(document.get(Key)) ;
            if(Value.equals(pre)){
                out =String.valueOf(document.get(reqKey)) ;
            }
            else{
                out = null;
            }
        }
        return out;
    }
  /////////////////////////////////////////////////////////////////////////////////////////
    
    
    /***********************************************Search by two keys(int, String)
 * and return a Value with reqKey(String)*/    
    String dbsearch( String preKey,int preValue,String Key,String Value,String reqKey ){
        String out=null;
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put(preKey, preValue);
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
             BasicDBObject document = (BasicDBObject)cursor.next();
               String pre = String.valueOf(document.get(Key)) ;
            if(Value.equals(pre)){
                out =String.valueOf(document.get(reqKey)) ;
            }
            else{
                out = null;
            }
        }
        return out;
    }
  /////////////////////////////////////////////////////////////////////////////////////////
  
    
    
 /* and return a Value with reqKey(String)*/    
    String dbsearch( String preKey,int preValue,String reqKey ){
        String out=null;
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put(preKey, preValue);
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
             BasicDBObject document = (BasicDBObject)cursor.next();
            
                out =String.valueOf(document.get(reqKey)) ;
        }
        
        
        return out;
    }
  /////////////////////////////////////////////////////////////////////////////////////////   
/*
  ****************************** Searching with 3 string keys*********************************** 
 
 */   
    String dbsearch( String preKey,String preValue,String Key,String Value,String Key1,String Value1,String reqKey ){
        String out=null;
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put(preKey, preValue);
        
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
             BasicDBObject document = (BasicDBObject)cursor.next();
               String pre = String.valueOf(document.get(Key)) ;
               String pre1 =String.valueOf(document.get(Key1)) ;
            if(Value.equals(pre)){
                if(Value1.equals(pre1))
                out =String.valueOf(document.get(reqKey)) ;
                else
                    out =null;
            }
            else{
                out = null;
            }
        }
        return out;
    }
  /////////////////////////////////////////////////////////////////////////////////////////   
    
    String dbsearch( String preKey,String preValue,String reqKey ){
        String out=null;
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put(preKey, preValue);
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
             BasicDBObject document = (BasicDBObject)cursor.next();
            
                out =String.valueOf(document.get(reqKey)) ;
        }
        
        
        return out;
    }
    
   ////////////////////////////////////////for one to many 
      DBCursor dbsearchd( String preKey,String preValue ){
   
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put(preKey, preValue);
        DBCursor cursor = collection.find(whereQuery);
        
        return cursor;
        }
   
}
    
       


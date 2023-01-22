/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 1003334001
 */
public class ParseJSON {

    public static String findInfo(String fileName, String tableName, String checkerName, String checker, String containerName) {
        String req = "";
        JSONObject obj = parseFile(fileName);
        JSONArray arr = (JSONArray) obj.get(tableName);
        System.out.println(arr.toString());
        for (Object o : arr) {                         
            JSONObject person = (JSONObject) o;
            String info = (String) person.get(checkerName);
            if (info.equals(checker)) {
                req = (String) person.get(containerName);
            }
        }
        System.out.println(req);
        return req;
    }
    
    protected static JSONObject parseFile(String fileName) {
        JSONParser parser = new JSONParser();
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/temp/json/" + fileName + ".json";
        JSONObject obj = null;
        
        try {
            obj = (JSONObject) parser.parse(new FileReader(filePath));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            Logger.getLogger(ParseJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            System.out.println("Incorrect JSON format.");
        }
        
        return obj;
    }

    public static ArrayList<String> getCourseNames() {
        JSONObject obj = parseFile("user_courses");
        ArrayList<String> req = new ArrayList<>();
        
        JSONArray arr = (JSONArray) obj.get("courses");
        for (Object o : arr) {                          
            JSONObject course = (JSONObject) o;
            String info = (String) course.get("courseName");
            req.add(info);
        }
        return req;
    }
    
    public static ArrayList<String> getCourseNames(String username) {
        JSONObject obj = parseFile("user_courses");
        ArrayList<String> req = new ArrayList<>();
        
        JSONArray arr = (JSONArray) obj.get("courses");
        for (Object o : arr) {                          
            JSONObject course = (JSONObject) o;
            String check = (String) course.get("creatorName");
            String info = "";
            if(check.equals(username)) {
                info += (String) course.get("courseName");
                req.add(info);
            }
            
        }
        return req;
    }
    
    public static ArrayList<String> getCreatorNames() {
        JSONObject obj = parseFile("user_courses");
        ArrayList<String> req = new ArrayList<>();
        
        JSONArray arr = (JSONArray) obj.get("courses");
        for (Object o : arr) {                            
            JSONObject course = (JSONObject) o;
            String info = (String) course.get("creatorName");
            req.add(info);
        }
        return req;
    }
    
    public static ArrayList<Long> getCourseNumbers() {
        JSONObject obj = parseFile("user_courses");
        ArrayList<Long> req = new ArrayList<>();
        
        JSONArray arr = (JSONArray) obj.get("courses");
        for (Object o : arr) {                                
            JSONObject course = (JSONObject) o;
            Long info = (Long) course.get("courseNumber");
            req.add(info);
        }
        return req;
    }

}

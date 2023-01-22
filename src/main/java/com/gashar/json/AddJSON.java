/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.json;

import com.gashar.cloud.AccessCloud;
import com.gashar.cloud.UploadCloud;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author 1003334001
 */
public class AddJSON {

    private static ArrayList<Long> courseNumbers = ParseJSON.getCourseNumbers();

    public static Long generateCourseNumber() {
        String numString = "";
        for (int i = 0; i < 5; i++) {
            Random rdm = new Random();
            Integer courseNumber = rdm.nextInt(9) + 1;
            numString += courseNumber;
        }
        return Long.parseLong(numString);

    }

    public static void addToJSON(String creatorName, String courseName) {

        // JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
        JSONObject obj = new JSONObject();
        obj.put("creatorName", creatorName);
        obj.put("courseName", courseName);
        Long num = generateCourseNumber();

        for (int i = 0; i < courseNumbers.size(); i++) {
            if (courseNumbers.get(i) == num) {
                num = generateCourseNumber();
                i = 0;
            }
        }
        obj.put("courseNumber", num);
        JSONArray arr = (JSONArray) ParseJSON.parseFile("user_courses").get("courses");
        arr.add(obj);
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/temp/json/user_courses.json";
        
        JSONObject finalObj = new JSONObject();
        finalObj.put("courses", arr);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            FileWriter fw = new FileWriter(filePath);
            fw.write(finalObj.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);

        }
        
        UploadCloud cloud = new UploadCloud("mycoursesbucketscholrapplication");
        String path = System.getProperty("user.dir");
        cloud.uploadObject("user_courses.json", path + "/temp/json/user_courses.json");
    }

}

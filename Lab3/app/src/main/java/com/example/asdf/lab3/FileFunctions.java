package com.example.asdf.lab3;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileFunctions {
    final static String fileName = "passwords.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/asdf/lab3/";
    final static String TAG = FileFunctions.class.getName();

    public static String ReadFile(Context context){
        String output = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path + fileName));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((output = bufferedReader.readLine()) != null){
                stringBuilder.append(output + System.getProperty("line.separator"));
            }
            fileInputStream.close();
            output = stringBuilder.toString();

            bufferedReader.close();
        }
        catch (FileNotFoundException ex){
            Log.d(TAG, ex.getMessage());
        }
        catch (IOException ex){
            Log.d(TAG, ex.getMessage());
        }
        return  output;
    }

    public static boolean saveToFile(String data){
        try {
            new File(path).mkdirs();
            File file = new File(path+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());
            return true;
        }
        catch (FileNotFoundException ex){
            Log.d(TAG, ex.getMessage());
        }
        catch (IOException ex){
            Log.d(TAG, ex.getMessage());
        }
        return false;
    }
}

package com.example.dimaculangan.datawriting;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etData = (EditText) findViewById(R.id.et_Data);
    }

    public void saveInternalCache(View view){
        File folder = getCacheDir();
        File file = new File(folder, "data1.txt");
        String message = etData.getText().toString();
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successful written to internal cache", Toast.LENGTH_LONG).show();
    }

    public void saveExternalCache(View view){
        File folder = getExternalCacheDir();
        File file = new File(folder, "data2.txt");
        String message = etData.getText().toString();
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successful written to external cache", Toast.LENGTH_LONG).show();
    }

    public void saveExternalStorage(View view){
        File folder = getExternalFilesDir("temp");
        File file = new File(folder, "data3.txt");
        String message = etData.getText().toString();
        writeData(file,message);
        Toast.makeText(this, "Successful written to external storage", Toast.LENGTH_LONG).show();
    }

    public void saveExternalPublicStorage(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "data4.txt");
        String message = etData.getText().toString();
        writeData(file,message);
        Toast.makeText(this, "Successful written to external public storage", Toast.LENGTH_LONG).show();
    }

    public void writeData(File file, String message) {
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Next(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}

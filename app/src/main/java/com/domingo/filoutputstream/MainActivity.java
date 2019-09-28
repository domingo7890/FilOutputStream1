package com.domingo.filoutputstream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editText);
    }

    public void writeData(View v) {
        String data = input.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IOException");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found 2");
            }
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }
}
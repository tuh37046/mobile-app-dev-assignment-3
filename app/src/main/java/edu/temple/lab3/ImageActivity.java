package edu.temple.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList options = new ArrayList<String>();
        options.add("Banana");
        options.add("Apple");
        options.add("Blueberry");
        options.add("Raspberry");

        ImageAdapter adapter = new ImageAdapter(this, options);

       ListView listView;
       listView = findViewById(R.id.imageViewer);
       Spinner spinner = findViewById(R.id.spinner);
       listView.setAdapter(adapter);
       spinner.setAdapter(adapter);
    }

}

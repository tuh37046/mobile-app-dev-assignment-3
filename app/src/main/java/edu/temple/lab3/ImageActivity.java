package edu.temple.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

       ListView listView = findViewById(R.id.imageViewer);
       Spinner spinner = findViewById(R.id.spinner);
       TextView text = findViewById(R.id.textView);
       listView.setAdapter(adapter);
       spinner.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showPicture(position);
                text.setText(((Pair)parent.getItemAtPosition(position)).first.toString());
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ImageActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();
                text.setText("Selected "+options.get((int) id));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ImageActivity.this, "Deselected item", Toast.LENGTH_SHORT).show();
            }
        });


    }

}

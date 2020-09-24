package com.example.classsix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOne, buttonTwo;
    private Spinner spinner;
    private String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = (Button)findViewById(R.id.buttonOneId);
        buttonTwo = (Button)findViewById(R.id.buttonTwoId);
        spinner = (Spinner)findViewById(R.id.spinnerId);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);

        name = getResources().getStringArray(R.array.country);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

               String text = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected "+text, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.buttonOneId){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("key","one");
            startActivity(intent);


        }
        else if(view.getId()==R.id.buttonTwoId){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("key","two");
            startActivity(intent);

        }

    }
}
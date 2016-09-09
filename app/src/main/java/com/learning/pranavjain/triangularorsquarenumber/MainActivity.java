package com.learning.pranavjain.triangularorsquarenumber;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Remove the previous text when user writes another text.
        final EditText input = (EditText) findViewById(R.id.getInput);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });

        //Set the Output to readonly
        EditText output = (EditText) findViewById(R.id.answer);
        output.setEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get The Input
                EditText input = (EditText) findViewById(R.id.getInput);
                int inputNumber = Integer.parseInt(input.getText().toString());
                Snackbar.make(view, "Added!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                display(view,inputNumber);
            }
        });
    }

    public boolean isTriangular(int inputNumber){

        int triangualarNumber = 1;
        int count = 1;

        while(triangualarNumber < inputNumber){
            count++;
            triangualarNumber = triangualarNumber + count;
        }
        if(triangualarNumber == inputNumber) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isSquare(int inputNumber){

        double squareRoot =  Math.sqrt(inputNumber);

        if ((squareRoot == Math.floor(squareRoot))) {
            return true;
        }else {
            return false;
        }
    }

    public void display(View view,int inputNumber){

        EditText output = (EditText) findViewById(R.id.answer);

        boolean T = isTriangular(inputNumber);
        boolean S = isSquare(inputNumber);

        if(T && S){
            output.setText("Number is Triangular and Square");
        }else if(T){
            output.setText("Number is Triangular");
        }else if(S){
            output.setText("Number is Square");
        }else{
            output.setText("Number is neither Triangular nor Square");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

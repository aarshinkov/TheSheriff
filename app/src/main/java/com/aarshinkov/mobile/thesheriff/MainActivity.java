package com.aarshinkov.mobile.thesheriff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.playersCountSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.players_count, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvPlayerFour = findViewById(R.id.tvPlayerFour);
                EditText etPlayerFour = findViewById(R.id.etPlayerFour);
                TextView tvPlayerFive = findViewById(R.id.tvPlayerFive);
                EditText etPlayerFive = findViewById(R.id.etPlayerFive);

                if (position == 1) {
                    // 4 players
                    tvPlayerFour.setVisibility(View.VISIBLE);
                    etPlayerFour.setVisibility(View.VISIBLE);
                    tvPlayerFive.setVisibility(View.INVISIBLE);
                    etPlayerFive.setVisibility(View.INVISIBLE);
                    etPlayerFive.setText("");
                } else if (position == 2) {
                    // 5 players
                    tvPlayerFour.setVisibility(View.VISIBLE);
                    etPlayerFour.setVisibility(View.VISIBLE);
                    tvPlayerFive.setVisibility(View.VISIBLE);
                    etPlayerFive.setVisibility(View.VISIBLE);
                } else {
                    // 3 players (default)
                    tvPlayerFour.setVisibility(View.INVISIBLE);
                    etPlayerFour.setVisibility(View.INVISIBLE);
                    etPlayerFour.setText("");
                    tvPlayerFive.setVisibility(View.INVISIBLE);
                    etPlayerFive.setVisibility(View.INVISIBLE);
                    etPlayerFive.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }
}
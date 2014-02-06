package com.example.dicecalculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    // Append
    DiceRoll d;
    String ss = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        final TextView s = (TextView)findViewById(R.id.sum_field);
        final TextView frequency = (TextView)findViewById(R.id.frequency__field);
        final TextView size = (TextView)findViewById(R.id.size__field);
        d = new DiceRoll();

        // Assign buttons
        Button twenty = (Button) findViewById(R.id.diceroll_button);
        Button dOperation = (Button ) findViewById(R.id.d_operation);

        // Set text in empty fields
        frequency.setText("1");
        size.setText("20");

        // 1d20 test button
        twenty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                 ss = String.valueOf(d.randomGen(1, 20));
                 s.setText(ss);
            }
        });

        dOperation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ss = String.valueOf(d.randomGen(
                        Integer.parseInt(frequency.getText().toString()),
                        Integer.parseInt(size.getText().toString())));
                s.setText(ss);
            }
        });

        // frequency and size text re-setters
        frequency.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean b) {
                if (frequency.getText().toString().equals("") && !b)
                    frequency.setText("1");
            }
        });

        size.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b) {
                if (size.getText().toString().equals("") && !b)
                    size.setText("20");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}

//By - Abdulla Pathan
package com.pvg.uchiha.stack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private EditText input_txt ;
    private Button push_btn;
    private Button pop_btn;
    private ListView Lv;
    private Stack<Integer> s;
    private Integer input_val;
    private ArrayList<String> inputData;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_txt = (EditText)findViewById(R.id.input_txtField);
        push_btn = (Button)findViewById(R.id.button_push);
        pop_btn = (Button)findViewById(R.id.button_pop);
        Lv = (ListView)findViewById(R.id.stack_view);
        s = new Stack<>();

        adapter = new ArrayAdapter(this,R.layout.activity_listview,s);

        Lv.setAdapter(adapter);

        push_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button_push) {
                    if (String.valueOf(input_val).isEmpty() || String.valueOf(input_val).equals("")) {
                        //EditText is empty
                        Toast.makeText(MainActivity.this, "Input is empty", Toast.LENGTH_SHORT).show();
                    }
                    try {
                        input_val = Integer.valueOf(input_txt.getText().toString());
                        s.push(input_val);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Pushed:" + input_val, Toast.LENGTH_SHORT).show();
                    }
                    catch (NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                    }

                    }
                }

        });
        pop_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button_pop) {
                    int temp = s.pop();
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Popped:" + temp, Toast.LENGTH_SHORT).show();

                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}

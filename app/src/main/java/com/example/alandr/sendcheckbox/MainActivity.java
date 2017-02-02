package com.example.alandr.sendcheckbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView txt1;
    LinearLayout layout_base;
    ArrayList<Integer> checkedlist = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn1 = (Button)findViewById(R.id.btn1);
        txt1 = (TextView)findViewById(R.id.txt1);
        layout_base = (LinearLayout)findViewById(R.id.base_layout);

        for(int i=1;i<=5;i++){
            CheckBox cb = new CheckBox(this);
            cb.setId(Integer.valueOf(i));
            cb.setText("El id es:"+i);
            cb.setOnClickListener(ckListener);
            layout_base.addView(cb);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "";
                for (Integer marcados:checkedlist){

                    cadena = cadena+"\n"+marcados;

                }
                txt1.setText("Los marcados, id:"+cadena);
            }
        });



    }


    private View.OnClickListener ckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int id = view.getId();
            boolean checked = ((CheckBox) view).isChecked();
            if(checked){
                checkedlist.add(id);
            }else{
                checkedlist.remove(new Integer(id));
            }



        }
    };





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

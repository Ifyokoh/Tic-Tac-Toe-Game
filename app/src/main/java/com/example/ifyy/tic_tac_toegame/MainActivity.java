package com.example.ifyy.tic_tac_toegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends ActionBarActivity {

    Button button;
    AlertDialog alertDialog1;
    CharSequence[] values = {" 3 by 3 "," 4 by 4 "," 5 by 5 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.playAlone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseBoardSize();
            }
        });
    }

    public void ChooseBoardSize(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Board Size");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, threeGridActivity.class);
                        MainActivity.this.startActivity(intent);
                    case 1:
                         intent = new Intent(MainActivity.this, fourGridActivity.class);
                        MainActivity.this.startActivity(intent);
                    case 2:
                         intent = new Intent(MainActivity.this, fiveGridActivity.class);
                        MainActivity.this.startActivity(intent);
                }
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

    }

    public void playWithSomeone_click(View v) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("Working on it");
        dlgAlert.setTitle("coming soon");

        dlgAlert.setCancelable(true);

        dlgAlert.create().show();
    }

    public void exit_click(View v) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("Do you really want to exit?");
        dlgAlert.setTitle("Exit");

        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
        dlgAlert.create().show();
    }


}

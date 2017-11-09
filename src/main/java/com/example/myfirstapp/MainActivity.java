package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout); //con esto el decimos cual es el layout grafico, osea donde estan las ID's

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab One");
        Intent home = new Intent(this,
                MainActivity.class);
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Home");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab two");
        Intent devices = new Intent(this, Devices.class);
        tab2.setContent(devices);
        tab2.setIndicator("Devices");
        tabHost.addTab(tab2);
        tabHost.setCurrentTabByTag("Tab One");

        setTitle("Home");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return true;
    }

    public void CreateButton(View view) {

        // Read your drawable from somewhere
        Drawable heladera = getResources().getDrawable(R.drawable.heladera);
        Bitmap bitmap = ((BitmapDrawable) heladera).getBitmap();
        // Scale it to 50 x 50
        Drawable replacer = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 350, 300, true));
        // Set your new, scaled drawable "d"


        ImageButton btn = new ImageButton(this);
        //btn.setText(string);
        btn.setImageDrawable(replacer);
        btn.setBackgroundColor(0xFAFF00A0);
        // Create a LinearLayout element
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        LinearLayout lin = new LinearLayout(this);
        lin.addView(btn);
        lin.setPadding(0,0,20,0);
        linearLayout.addView(lin);

    }

}

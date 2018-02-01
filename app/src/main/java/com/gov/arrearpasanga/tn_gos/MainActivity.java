package com.gov.arrearpasanga.tn_gos;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Content Main");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
           int id = item.getItemId();
            Class fragmentclass;
        if (id == R.id.nav_favorite) {

        } else if (id == R.id.History) {
            Toast.makeText(getApplicationContext(),"History",Toast.LENGTH_LONG).show();
        } else if (id == R.id.Downloads) {
            Toast.makeText(getApplicationContext(),"Downloads",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_feedback) {
           emailshare();
        } else if (id == R.id.nav_about) {
            Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_LONG).show();

        } else if (id == R.id.settings) {

            // Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void emailshare(){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("Email"));
        String[] s={"arrearpasanga@gmail.com"};
        intent.putExtra(intent.EXTRA_EMAIL,s);
        intent.setType("message/rfc822");
        Intent chooser=Intent.createChooser(intent,"Launch Email");
        startActivity(chooser);
    }


    public void mymethod(View view) {
    emailshare();
    }
}

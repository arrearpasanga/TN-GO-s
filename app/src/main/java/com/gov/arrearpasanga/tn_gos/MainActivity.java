package com.gov.arrearpasanga.tn_gos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/*
* Created by
* Joan Louji S
* */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getTitle());
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

    //Navigation Item Click listener---Transcation for pages is done here
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
           int id = item.getItemId();
        android.support.v4.app.Fragment fragment=null;
        if (id == R.id.nav_favorite) {
            fragment=new Favorite();
         }
        else if (id == R.id.History) {
            fragment=new History();
         }
        else if (id == R.id.Downloads) {
             fragment=new Downloads();
         }
        else if (id == R.id.nav_feedback) {
           emailshare();
        }
        else if (id == R.id.nav_about) {
            fragment=new About();
         }
        else if (id == R.id.settings) {
            fragment=new Settings();

        }

        if(fragment!=null){
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment1,fragment);
                fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Intent to Feedback page-- intents to email
    public void emailshare(){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("Email"));
        String[] s={"arrearpasanga@gmail.com"};
        intent.putExtra(intent.EXTRA_EMAIL,s);
        intent.setType("message/rfc822");
        Intent chooser=Intent.createChooser(intent,"Launch Email");
        startActivity(chooser);
    }
    //Intent to feedback page-- intents to email
    public void mymethod(View view)
    {
    emailshare();
    }
}

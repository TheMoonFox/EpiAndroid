package com.example.max.kikooworld;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.max.kikooworld.Shard.AlerteFragment;
import com.example.max.kikooworld.Shard.HomeFragment;
import com.example.max.kikooworld.Shard.ProjectsFragment;
import com.example.max.kikooworld.Shard.ModulesFragment;
import com.example.max.kikooworld.Shard.NotesFragment;
import com.example.max.kikooworld.Shard.PlanningFragment;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int current_view = 1;
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    final intraClient client = new intraClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Token.glob = client;
        Token.Home = this;
        HomeFragment fragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home :
                if (current_view != 1) {
                    current_view = 1;
                    HomeFragment fragment = new HomeFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
                break;
            case R.id.nav_alertes :
                if (current_view != 2) {
                    current_view = 2;
                    AlerteFragment a_fragment = new AlerteFragment();
                    android.support.v4.app.FragmentTransaction a_fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    a_fragmentTransaction.replace(R.id.fragment_container, a_fragment);
                    a_fragmentTransaction.commit();
                }
                break;
            case R.id.nav_notes :
                if (current_view != 3) {
                    current_view = 3;
                    NotesFragment n_fragment = new NotesFragment();
                    android.support.v4.app.FragmentTransaction n_fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    n_fragmentTransaction.replace(R.id.fragment_container, n_fragment);
                    n_fragmentTransaction.commit();
                }
                break;
            case R.id.nav_planning :
                if (current_view != 4) {
                    current_view = 4;
                    PlanningFragment p_fragment = new PlanningFragment();
                    android.support.v4.app.FragmentTransaction p_fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    p_fragmentTransaction.replace(R.id.fragment_container, p_fragment);
                    p_fragmentTransaction.commit();
                }
                break;
            case R.id.nav_messages :
                if (current_view != 5) {
                    current_view = 5;
                    ProjectsFragment me_fragment = new ProjectsFragment();
                    android.support.v4.app.FragmentTransaction me_fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    me_fragmentTransaction.replace(R.id.fragment_container, me_fragment);
                    me_fragmentTransaction.commit();
                }
                break;
            case R.id.nav_modules :
                if (current_view != 6) {
                    current_view = 6;
                    ModulesFragment mo_fragment = new ModulesFragment();
                    android.support.v4.app.FragmentTransaction mo_fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    mo_fragmentTransaction.replace(R.id.fragment_container, mo_fragment);
                    mo_fragmentTransaction.commit();
                }
                break;
            case R.id.nav_disco :
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public intraClient getIntraClient() {
        return this.client;
    }
}

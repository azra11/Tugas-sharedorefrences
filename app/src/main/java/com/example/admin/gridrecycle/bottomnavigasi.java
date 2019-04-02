package com.example.admin.gridrecycle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.admin.gridrecycle.fragment.fragmentklub;

public class bottomnavigasi extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomnavigationview;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottombar);
        bottomnavigationview = findViewById(R.id.bottom);
        loadFragment(new fragmentklub());
        bottomnavigationview.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
        switch (menuitem.getItemId()){
            case R.id.gambar:
                fragment = new fragmentklub();
                break;

            case R.id.judul:
                fragment = new fragmentklub();
                break;
        }
        return loadFragment(fragment);
    }
}

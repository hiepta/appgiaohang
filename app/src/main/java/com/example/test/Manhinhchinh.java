package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Manhinhchinh extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    ListView lv_trasua;
//    ArrayAdapter<String> adapter;
//    ArrayList<String> dsTraSua = new ArrayList<>();
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.nav_item);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState== null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_trangchu);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id_1 = item.getItemId();
        if(id_1 == R.id.nav_trangchu){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        }
        if(id_1 == R.id.nav_timkiem){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TimKiemFragment()).commit();
        }
        if(id_1 == R.id.nav_dangxuat){
            AlertDialog.Builder mydialog = new AlertDialog.Builder(Manhinhchinh.this);
            mydialog.setTitle("Question");
            mydialog.setMessage("Bạn có chắc chắn muốn thoát!!!");
            mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent dangxuat = new Intent(Manhinhchinh.this, MainActivity.class);
                    startActivity(dangxuat);
                }
            });
            mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            mydialog.create().show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Lấy id của các item menu
        int id = item.getItemId();
        if(id == R.id.toolgiohang){
            Toast.makeText(this,"Giỏ hàng",Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.toolbartimkiem){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TimKiemFragment()).commit();
        }
        return true;
    }
}
package com.miapp.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.miapp.mascotas.Fragments.FavoritesFragment;
import com.miapp.mascotas.Fragments.MascotaListFragment;
import com.miapp.mascotas.Fragments.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        List<androidx.fragment.app.Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotaListFragment());
        fragments.add(new FavoritesFragment());
        fragments.add(new ProfileFragment());

        List<String> titles = new ArrayList<>();
        titles.add("Mascotas");
        titles.add("Favoritos");
        titles.add("Perfil");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_contact){
            startActivity(new Intent(this, ContactActivity.class));
            return true;
        } else if(item.getItemId() == R.id.action_about){
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

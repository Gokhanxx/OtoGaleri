/*mainactivity copy yedek*/
package com.example.otogaleri.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.otogaleri.R;
import com.example.otogaleri.others.StaticData;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.otogaleri.databinding.ActivityMainBinding;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    NavigationView navigationView;
    DrawerLayout drawer;
    String navHeaderText;
    TextView navHeaderTextview;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedverial();

        setSupportActionBar(binding.appBarMain.toolbar);
/*        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        drawer = binding.drawerLayout;
        navigationView = binding.navView;

        sharedveriyazd??r();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*a????lcak olan fragment kesin buraya eklenmesi ??art*/
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_deneme)
                .setOpenableLayout(drawer)
                .build();
         navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
         navigationControlButton();
    }

    public void navigationControlButton() {
       //region navigationda a????lan fragmans??z olan itemleri kontrol??n?? sa??lam???? oluyoruz
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                if (item.getItemId() == R.id.cikisyap) {
                    //t??m kaydedilmi?? kodlar?? edit??re aktarm???? olduk
                    editor = sharedPreferences.edit();
                    //verileri silmi?? oluyoruz
                    editor.clear();
                    //kaydetmi?? oluyoruz
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    NavigationUI.onNavDestinationSelected(item, navController);
                    drawer.closeDrawers();
                }
                return false;
            }
        });
        //endregion
    }

    public void sharedverial() {
        //region otomatik giri?? i??in verimizi ald??k
        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        navHeaderText = sharedPreferences.getString("uye_kullaniciadi", null);
        //endregion
    }

    public void sharedveriyazd??r() {
        //region veriyazd??rmas?? (kullan??c??ad??)
        View headerview = navigationView.getHeaderView(0);
        navHeaderTextview = (TextView) headerview.findViewById(R.id.nawHeadertext);
        navHeaderTextview.setText(navHeaderText);
        StaticData.setKullaniciadi(navHeaderText);

        //endregion
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
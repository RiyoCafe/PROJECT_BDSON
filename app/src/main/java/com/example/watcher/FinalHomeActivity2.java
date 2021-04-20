package com.example.watcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import androidx.appcompat.widget.Toolbar ;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class FinalHomeActivity2 extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tabItem1,tabItem2,tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_home2);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabItem1 = (TabItem)findViewById(R.id.tab1);
        tabItem2 = (TabItem)findViewById(R.id.tab2);
        tabItem3 = (TabItem)findViewById(R.id.tab3);
        viewPager = (ViewPager)findViewById(R.id.vPager);
        toolbar=findViewById(R.id.main_page_toolbar);
        setSupportActionBar(toolbar);
        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        menu.findItem(R.id.find_friends_menu).setTitle(Html.fromHtml("<font color='#FF000000'>Settings</font>"));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.find_friends_menu)
        {
            Intent intent=new Intent(FinalHomeActivity2.this, FindFriendsActivity.class);
            startActivity(intent);
        }

        return true;
    }
}
package com.cronocode.materialloginpage;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class Custom_navi extends AppCompatActivity {
    SNavigationDrawer sNavigtionDrawer;
    Class fragmentClass;
    public static Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_navigation);
        sNavigtionDrawer=findViewById(R.id.navigationdrawer);
        List<MenuItem> menuItems=new ArrayList<>();
        menuItems.add(new MenuItem("Home",R.mipmap.ic_launcher_round));
        menuItems.add(new MenuItem("Profile",R.mipmap.ic_launcher_round));
        menuItems.add(new MenuItem("Share",R.mipmap.ic_launcher_round));
        menuItems.add(new MenuItem("About us",R.mipmap.ic_launcher_round));
        menuItems.add(new MenuItem("Log out",R.mipmap.ic_launcher_round));
        sNavigtionDrawer.setMenuItemList(menuItems);

      /*  fragmentClass=NewsFragment.class;

        try {
            fragment=(Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }*/
        if(fragment!=null)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.
                    fade_in,android.R.animator.fade_out)
                    .replace(R.id.framelayout,fragment).commit();
        }
        sNavigtionDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position " + position);

                switch (position) {
                    case 0: {
                        fragmentClass = NewsFragment.class;
                        break;
                    }
                    case 1: {
                        Intent i = new Intent(Intent.ACTION_MAIN);
                        i.setComponent(new ComponentName("com.theindianappguy.sampleprofileui", "com.theindianappguy.sampleprofileui.ProfileActivity"));
                        i.addCategory(Intent.CATEGORY_LAUNCHER);
                        startActivity(i);
                       // fragmentClass = NewsFragment.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = NewsFragment.class;
                        break;
                    }
                    case 3: {
                        fragmentClass = NewsFragment.class;
                        break;
                    }
                    case 4: {
                        fragmentClass = SignUp.class;
                        break;
                    }

                }

                sNavigtionDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener(

                ) {
                    @Override
                    public void onDrawerOpening() {

                    }

                    @Override
                    public void onDrawerClosing() {
                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                        }
                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                                    .replace(R.id.framelayout, fragment).commit();
                        }
                    }

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {

                    }
                });


            }
        });
    }
}


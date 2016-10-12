package com.asmobisoft.coffer;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.asmobisoft.coffer.activity.MoneyTransferActivity;
import com.asmobisoft.coffer.activity.ProfileActivity;
import com.asmobisoft.coffer.adapter.DrawerMenuItem;
import com.asmobisoft.coffer.adapter.DrawerMenuItemAdapter;
import com.asmobisoft.coffer.commonmethod.Utility;
import com.asmobisoft.coffer.fragments.AboutFragment;
import com.asmobisoft.coffer.fragments.BonusPointFragment;
import com.asmobisoft.coffer.fragments.ChangePasswordFragment;
import com.asmobisoft.coffer.fragments.FAQFragment;
import com.asmobisoft.coffer.fragments.MainFragment;
import com.asmobisoft.coffer.fragments.TermsandConditionFragment;
import com.asmobisoft.coffer.fragments.TransectionHistoryFragment;
import com.asmobisoft.coffer.fragments.WalletBalenceFragment;
import com.asmobisoft.coffer.registration.LoginActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity1 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mLvDrawerMenu;
    private DrawerMenuItemAdapter mDrawerMenuAdapter;
    private ActionBar actionBar;
    TextView tvName;
    TextView tvNotifiacton;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setHomeButtonEnabled(false);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mLvDrawerMenu = (ListView) findViewById(R.id.lv_drawer_menu);

        List<DrawerMenuItem> menuItems = generateDrawerMenuItems();
        mDrawerMenuAdapter = new DrawerMenuItemAdapter(getApplicationContext(), menuItems);
        mLvDrawerMenu.setAdapter(mDrawerMenuAdapter);
       //Adding header of list view
        View header = (View)getLayoutInflater().inflate(R.layout.nav_header,null);

        tvName = (TextView)header.findViewById(R.id.profile_name);
        tvNotifiacton = (TextView)header.findViewById(R.id.profile_notification);
        imageView = (ImageView) header.findViewById(R.id.iv_profile_pic);
        mLvDrawerMenu.addHeaderView(header);
        mLvDrawerMenu.setOnItemClickListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        if(savedInstanceState == null){
            setFragment(1, MainFragment.class);
            mToolbar.setTitle("Coffer Dash");
            mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        }

        tvName.setText("Ankur ,Software Engineer at Toshiba");
        tvNotifiacton.setText("You Have 5 Notification");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent i = new Intent(MainActivity1.this, ProfileActivity.class);
                startActivity(i);
                break;
            case 1:
                setFragment(1, MainFragment.class);
                mToolbar.setTitle("Coffer Dash");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 2:
                setFragment(2, BonusPointFragment.class);
                mToolbar.setTitle("Bonus Points");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 3:
                setFragment(3, WalletBalenceFragment.class);
                mToolbar.setTitle("Wallet Balance");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 4:
                setFragment(4, ChangePasswordFragment.class);
                mToolbar.setTitle("Change Password");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 5:
                Intent i1 = new Intent(MainActivity1.this, MoneyTransferActivity.class);
                startActivity(i1);
                break;
            case 6:
                setFragment(6, TermsandConditionFragment.class);
                mToolbar.setTitle("Terms and Conditions");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 7:
                setFragment(7, AboutFragment.class);
                mToolbar.setTitle("About US");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 8:
                setFragment(8, FAQFragment.class);
                mToolbar.setTitle("FAQ");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 9:
                setFragment(9, TransectionHistoryFragment.class);
                mToolbar.setTitle("Transaction History");
                mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
                break;
            case 10:
               //REfer to a Friend
                String shareBody = "Here is the share content body";
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Refer Using !"));

                break;
            case 11:
                //feedback




                break;
            case 12:
                //Logout Functionality

                Typeface externalFont = Typeface.createFromAsset(
                        MainActivity1.this.getAssets(), "fonts/Frank.ttf");
                final Dialog dialog1 = new Dialog(MainActivity1.this);

                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.dialog);
                dialog1.setCancelable(true);

                TextView text1 = (TextView) dialog1.findViewById(R.id.tv_tittle1);
                text1.setText("Coffer IMPORTENT !");
                text1.setTypeface(externalFont, Typeface.BOLD);
                text1.setTextSize(18);

                TextView text = (TextView) dialog1.findViewById(R.id.tv_subtittle);
                text.setText("Are you really want to logout the Coffer App!");
                text.setTextSize(14);
                text.setTypeface(externalFont);

                Button btnCancel = (Button) dialog1.findViewById(R.id.btn_cancel);
                Button btnOK = (Button) dialog1.findViewById(R.id.btn_ok);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            dialog1.dismiss();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                });

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Utility.setPrefsData(MainActivity1.this,"mobile","");
                            Intent i = new Intent(MainActivity1.this, LoginActivity.class);
                            startActivity(i);
                            finish();
                            dialog1.dismiss();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                });

                dialog1.show();

                break;
            }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mLvDrawerMenu)) {
            mDrawerLayout.closeDrawer(mLvDrawerMenu);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void setFragment(int position, Class<? extends Fragment> fragmentClass) {
        try {
            Fragment fragment = fragmentClass.newInstance();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, fragment, fragmentClass.getSimpleName());
            fragmentTransaction.commit();

            mLvDrawerMenu.setItemChecked(position, true);
            mDrawerLayout.closeDrawer(mLvDrawerMenu);
            mLvDrawerMenu.invalidateViews();
        }
        catch (Exception ex){
            Log.e("setFragment", ex.getMessage());
        }
    }

    private List<DrawerMenuItem> generateDrawerMenuItems() {
        String[] itemsText = getResources().getStringArray(R.array.nav_drawer_items);
      //  TypedArray itemsIcon = getResources().obtainTypedArray(R.array.nav_drawer_icons);
        Log.e("MainAc","itemsText.length "+itemsText.length);
        List<DrawerMenuItem> result = new ArrayList<DrawerMenuItem>();
        for (int i = 0; i < itemsText.length; i++) {
            DrawerMenuItem item = new DrawerMenuItem();
            item.setText(itemsText[i]);
         //   item.setIcon(itemsIcon.getResourceId(i, -1));
            result.add(item);
        }
        return result;
    }

}

package com.example.myproject.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myproject.Activities.CitizenLoginFragment;
import com.example.myproject.Activities.PoliceLoginFragment;

public class LoginAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    public LoginAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CitizenLoginFragment tab1 = new CitizenLoginFragment();
                return tab1;
            case 1:
                PoliceLoginFragment tab2 = new PoliceLoginFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

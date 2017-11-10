package com.example.hduar.xatvexo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hduar on 05/11/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TelaConversas telaConversas = new TelaConversas();
                return telaConversas;
            case 1:
                TelaProximos telaProximos = new TelaProximos();
                return telaProximos;
            case 2:
                TelaAmigos telaAmigos = new TelaAmigos();
                return telaAmigos;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

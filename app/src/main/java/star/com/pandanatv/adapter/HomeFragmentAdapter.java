package star.com.pandanatv.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/1.
 */
public class HomeFragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment>mFragments;
    private ArrayList<String> mStrings;

    public void setFragments(ArrayList<Fragment> fragments) {
        mFragments = fragments;
    }

    public void setStrings(ArrayList<String> strings) {
        mStrings = strings;
    }

    public HomeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments==null?0:mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mStrings.get(position);
    }
}

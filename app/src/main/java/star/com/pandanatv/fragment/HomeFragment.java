package star.com.pandanatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

import star.com.pandanatv.R;
import star.com.pandanatv.adapter.HomeInnerFragmentAdapter;

/**
 * Created by Administrator on 2016/10/1.
 */
public class HomeFragment extends Fragment {
    protected View rootView;
    protected TabLayout mHomeInnerTab;
    protected ViewPager mHomeInnerViewpager;
    private String[] mTitles = {"精彩推荐","正在直播","LoL", "炉石传说", "熊猫星秀"};
    private int[] mPictures = {R.drawable.top_tab_shouye_select,R.drawable
            .top_tab_zhengzaizhibo_select,R.drawable
            .top_tab_lol_select,
            R.drawable.top_tab_lushi_select, R
            .drawable.top_tab_panada_select};
    private ImageView mInnerImageView;
    private TextView mInnerTextView;


    public static HomeFragment newInstance(int i) {

        Bundle args = new Bundle();
        args.putInt("state", i);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_fragment_layout, null, false);
        initView(rootView);
        return rootView;
    }


    private void initView(View rootView) {
        mHomeInnerTab = (TabLayout) rootView.findViewById(R.id.home_inner_tab);
        mHomeInnerViewpager = (ViewPager) rootView.findViewById(R.id.home_inner_viewpager);
        HomeInnerFragmentAdapter adapter = new HomeInnerFragmentAdapter(getChildFragmentManager());
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            fragments.add(InnerFragment.newInstance(i));
            strings.add(mTitles[i]);
        }
        adapter.setFragments(fragments);
        adapter.setStrings(strings);
        mHomeInnerViewpager.setAdapter(adapter);
        mHomeInnerTab.setupWithViewPager(mHomeInnerViewpager);
        mHomeInnerTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mHomeInnerTab.setSelectedTabIndicatorHeight(2);//无指示条
        mHomeInnerTab.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorIndicatorColor));
        for (int i = 0; i < mTitles.length; i++) {
            TabLayout.Tab tabAt = mHomeInnerTab.getTabAt(i);
            View inflate = View.inflate(getContext(), R.layout.top_tab_custom_view, null);
            mInnerImageView = (ImageView) inflate.findViewById(R.id.top_tab_custom_image);
            mInnerImageView.setImageResource(mPictures[i]);
            mInnerTextView = (TextView) inflate.findViewById(R.id.top_tab_custom_text);
            mInnerTextView.setText(mTitles[i]);
            tabAt.setCustomView(inflate);
        }
    }
}

package star.com.pandanatv.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import star.com.pandanatv.fragment.HomeFragment;
import star.com.pandanatv.adapter.HomeFragmentAdapter;
import star.com.pandanatv.R;

public class MainActivity extends BaseActivity {

    protected ViewPager mViewpager;
    protected TabLayout mSlidingTabs;
    protected ViewPager mHomeViewpager;
    protected TabLayout mHomeTab;
    protected ImageView mTabCustomImage;
    protected TextView mTabCustomText;

    private String[] mTitles = {"首页", "游戏", "娱乐", "女神", "我的"};
    private int[] mInts={
            R.drawable.home_icon_select,
            R.drawable.game_icon_select,
            R.drawable.yule_icon_select,
            R.drawable.women_icon_select,
            R.drawable.wode_icon_select};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        mHomeViewpager = (ViewPager) findViewById(R.id.home_viewpager);
        mHomeTab = (TabLayout) findViewById(R.id.home_tab);

        HomeFragmentAdapter adapter = new HomeFragmentAdapter(getSupportFragmentManager());
        ArrayList<Fragment> fragments = new ArrayList<>();

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            strings.add(mTitles[i]);
            fragments.add(HomeFragment.newInstance(i));
        }
        adapter.setFragments(fragments);
        adapter.setStrings(strings);
        mHomeViewpager.setAdapter(adapter);

        mHomeTab.setupWithViewPager(mHomeViewpager);

        mHomeTab.setSelectedTabIndicatorHeight(0);//无指示条

        for (int i = 0; i < mTitles.length; i++) {
            TabLayout.Tab tabAt = mHomeTab.getTabAt(i);
            View inflate = View.inflate(this, R.layout.tab_custom_view, null);
           mTabCustomImage= (ImageView) inflate.findViewById(R.id.tab_custom_image);
            mTabCustomText= (TextView) inflate.findViewById(R.id.tab_custom_text);
            mTabCustomText.setText(mTitles[i]);
            mTabCustomImage.setImageResource(mInts[i]);
            tabAt.setCustomView(inflate);
        }

    }
}

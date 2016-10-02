package star.com.pandanatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.stx.xhb.xbanner.XBanner;

import star.com.pandanatv.R;

/**
 * Created by Administrator on 2016/10/2.
 */
public class InnerFragment extends Fragment {
    protected View rootView;
    protected XBanner mInnerXbanner;
    protected GridView mGrid;
    protected ListView mInnerList;

    public static InnerFragment newInstance(int key) {

        Bundle args = new Bundle();
        args.putInt("key", key);
        InnerFragment fragment = new InnerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.inner_fragment_layout, null, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mInnerXbanner = (XBanner) rootView.findViewById(R.id.inner_xbanner);
        mInnerList = (ListView) rootView.findViewById(R.id.inner_list);
        //TODO 设置数据
        int key = getArguments().getInt("key", -1);

    }
}

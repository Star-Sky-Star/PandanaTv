package star.com.pandanatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import star.com.pandanatv.R;

/**
 * Created by Administrator on 2016/10/1.
 */
public class HomeFragment extends Fragment {
    protected View rootView;
    protected TextView mText;


    public static HomeFragment newInstance(int i)
    {

        Bundle args = new Bundle();
        args.putInt("state",i);
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
        mText = (TextView) rootView.findViewById(R.id.text);
        mText.setText(getArguments().getInt("state")+"");
    }
}

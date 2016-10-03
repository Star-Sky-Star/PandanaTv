package star.com.pandanatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import star.com.pandanatv.R;
import star.com.pandanatv.adapter.HomeInnerListAdapter;
import star.com.pandanatv.model.Consts;
import star.com.pandanatv.model.Recom_list_data;
import star.com.pandanatv.model.Recommend_viewpagerData;

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
        // TODO 设置数据
        int key = getArguments().getInt("key", -1);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, Consts.INNER_TOP_RECOM, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson = new Gson();
                Recommend_viewpagerData recommend_viewpagerData = gson.fromJson(result, Recommend_viewpagerData.class);
                List<Recommend_viewpagerData.DataBean> data = recommend_viewpagerData.getData();
                final List<String> imgesUrl = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    imgesUrl.add(data.get(i).getSmallimg());
                }
                mInnerXbanner.setData(imgesUrl);
                mInnerXbanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, View view, int position) {
                        Glide.with(getContext()).load(imgesUrl.get(position)).into((ImageView) view);
                    }
                });
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.e("error", "网络请求错误信息是 " + error.getMessage());
            }
        });

        httpUtils.send(HttpRequest.HttpMethod.GET, Consts.INNER_LIST_DATA, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson=new Gson();
                Recom_list_data recom_list_data = gson.fromJson(result, Recom_list_data.class);
                List<Recom_list_data.DataBean> data = recom_list_data.getData();
                HomeInnerListAdapter adapter = new HomeInnerListAdapter();
                adapter.setDataBeen((ArrayList<Recom_list_data.DataBean>) data);
                mInnerList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(HttpException error, String msg) {
                Log.e("error", "List中网络请求错误信息是 " + error.getMessage());
            }
        });
    }
}

package star.com.pandanatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

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
import star.com.pandanatv.adapter.LolGridItemAdapter;
import star.com.pandanatv.model.Consts;
import star.com.pandanatv.model.LolData;

/**
 * Created by Administrator on 2016/10/3.
 */
public class LolFragment extends Fragment {
    protected View rootView;
    protected XBanner mLolTopVp;
    protected GridView mLolGrid;
    protected SwipeRefreshLayout mLolSwipRefresh;


    public static LolFragment newInstance(int key) {

        Bundle args = new Bundle();
        args.putInt("key",key);
        LolFragment fragment = new LolFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.lol_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mLolTopVp = (XBanner) rootView.findViewById(R.id.lol_top_vp);
        mLolGrid = (GridView) rootView.findViewById(R.id.lol_grid);
        mLolSwipRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.lol_swip_refresh);

        int key = getArguments().getInt("key");
        String url=null;
       if (key==2) {
            url = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=lol&pageno=1&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
        }
        if (key==4){
            url="http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=yzdr&pageno=1&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
        }
            HttpUtils httpUtils=new HttpUtils();
            httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    String result = responseInfo.result;
                    Gson gson=new Gson();
                    LolData lolData = gson.fromJson(result, LolData.class);
                    List<LolData.DataBean.ItemsBean> gridItems = lolData.getData().getItems();
                    List<LolData.DataBean.BannersBean> banners = lolData.getData().getBanners();
                    final List<String> imgesUrl = new ArrayList<>();
                    for (int i = 0; i < banners.size(); i++) {
                        imgesUrl.add(banners.get(i).getBigimg());
                    }
                    mLolTopVp.setData(imgesUrl);
                    mLolTopVp.setmAdapter(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, View view, int position) {
                            Glide.with(getContext()).load(imgesUrl.get(position)).into((ImageView) view);
                        }
                    });
                    LolGridItemAdapter adapter = new LolGridItemAdapter();
                    adapter.setItemsBeen((ArrayList<LolData.DataBean.ItemsBean>) gridItems);
                    mLolGrid.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                @Override
                public void onFailure(HttpException error, String msg) {
                    Log.e("error","LOL错误信息"+error.getMessage());
                }
            });
            mLolSwipRefresh.computeScroll();

    }
}

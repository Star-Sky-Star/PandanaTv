package star.com.pandanatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import star.com.pandanatv.R;
import star.com.pandanatv.adapter.ZhiBoAdapter;
import star.com.pandanatv.model.Consts;
import star.com.pandanatv.model.ZhiboData;

/**
 * Created by Administrator on 2016/10/3.
 */
public class ZhiboFragment extends Fragment {
    protected View rootView;
    protected GridView mZhiboGrid;

    public static ZhiboFragment newInstance(int key) {

        Bundle args = new Bundle();
        args.putInt("key",key);
        ZhiboFragment fragment = new ZhiboFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.zhengzaizhibo_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mZhiboGrid = (GridView) rootView.findViewById(R.id.zhibo_grid);
        int key = getArguments().getInt("key");
        String url=null;
        if (key==1){
           url="http://api.m.panda.tv/ajax_live_lists?pageno=1&pagenum=20&status=2&order=person_num&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
        }
       /* if(key==3){
            url="http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=hearthstone&pageno=1&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
        }*/
            HttpUtils httpUtils=new HttpUtils();
            httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    String result = responseInfo.result;
                    Gson gson=new Gson();
                    ZhiboData zhiboData = gson.fromJson(result, ZhiboData.class);
                    List<ZhiboData.DataBean.ItemsBean> items = zhiboData.getData().getItems();
                    ZhiBoAdapter adapter = new ZhiBoAdapter();
                    adapter.setDataBeen((ArrayList<ZhiboData.DataBean.ItemsBean>) items);
                    mZhiboGrid.setAdapter(adapter);
                }
                @Override
                public void onFailure(HttpException error, String msg) {

                }
            });

    }
}

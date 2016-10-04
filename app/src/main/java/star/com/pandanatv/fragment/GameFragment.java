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

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import star.com.pandanatv.R;
import star.com.pandanatv.adapter.GameAdapter;
import star.com.pandanatv.model.Consts;
import star.com.pandanatv.model.GameData;

/**
 * Created by Administrator on 2016/10/4.
 */
public class GameFragment extends Fragment {
    protected View rootView;
    protected GridView mGameGrid;
    protected SwipeRefreshLayout mSwipGameGrid;

    public static GameFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.game_fragment_layout, null, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mGameGrid = (GridView) rootView.findViewById(R.id.game_grid);
        mSwipGameGrid = (SwipeRefreshLayout) rootView.findViewById(R.id.swip_game_grid);

        HttpUtils httpUtils=new HttpUtils();

        httpUtils.send(HttpRequest.HttpMethod.GET, Consts.GAME, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson=new Gson();
                GameData gameData = gson.fromJson(result, GameData.class);
                List<GameData.DataBean> data = gameData.getData();
                GameAdapter adapter = new GameAdapter();
                adapter.setDataBeen((ArrayList<GameData.DataBean>) data);
                mGameGrid.setAdapter(adapter);

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.e("error",error.getMessage());
            }
        });
    }
}

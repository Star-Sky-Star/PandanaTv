package star.com.pandanatv.adapter;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

import star.com.pandanatv.R;
import star.com.pandanatv.model.LolData;

/**
 * Created by Administrator on 2016/10/3.
 */
public class LolAdapter extends BaseAdapter {
    private ArrayList<LolData.DataBean.ItemsBean> mItemsBeen;

    public void setItemsBeen(ArrayList<LolData.DataBean.ItemsBean> itemsBeen) {
        mItemsBeen = itemsBeen;
    }

    @Override
    public int getCount() {
        return mItemsBeen == null ? 0 : mItemsBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return mItemsBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null || !(view.getTag() instanceof ViewHolder)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lol_layout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        LolGridItemAdapter adapter = new LolGridItemAdapter();
        adapter.setItemsBeen(mItemsBeen);
        viewHolder.mLolGrid.setAdapter(adapter);

        return view;
    }

    static class ViewHolder {
        protected XBanner mLolTopVp;
        protected GridView mLolGrid;
        protected SwipeRefreshLayout mLolSwipRefresh;
        ViewHolder(View rootView) {
            initView(rootView);
        }

        private void initView(View rootView) {
            mLolTopVp = (XBanner) rootView.findViewById(R.id.lol_top_vp);
            mLolGrid = (GridView) rootView.findViewById(R.id.lol_grid);
            mLolSwipRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.lol_swip_refresh);
        }
    }
}

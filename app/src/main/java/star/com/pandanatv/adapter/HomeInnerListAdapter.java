package star.com.pandanatv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import star.com.pandanatv.R;
import star.com.pandanatv.model.Recom_list_data;

/**
 * Created by Administrator on 2016/10/3.
 */
public class HomeInnerListAdapter extends BaseAdapter {
    private ArrayList<Recom_list_data.DataBean> mDataBeen;

    public void setDataBeen(ArrayList<Recom_list_data.DataBean> dataBeen) {
        mDataBeen = dataBeen;
    }

    @Override
    public int getCount() {
        return mDataBeen == null ? 0 : mDataBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null || !(view.getTag() instanceof ViewHolder)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inner_index_list_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BitmapUtils bitmapUtils=new BitmapUtils(viewGroup.getContext());
        bitmapUtils.display(viewHolder.mIndexItemIcon,mDataBeen.get(i).getType().getIcon());
        viewHolder.mIndexItemTitle.setText(mDataBeen.get(i).getType().getCname());
        InnerListGridAdapter adapter = new InnerListGridAdapter();
        adapter.setItemsBeen((ArrayList<Recom_list_data.DataBean.ItemsBean>) mDataBeen.get(i).getItems());
        viewHolder.mListItemGridView.setAdapter(adapter);
        return view;
    }

    static class ViewHolder {
        protected ImageView mIndexItemIcon;
        protected TextView mIndexItemTitle;
        protected GridView mListItemGridView;

        ViewHolder(View rootView) {
            initView(rootView);
        }

        private void initView(View rootView) {
            mIndexItemIcon = (ImageView) rootView.findViewById(R.id.index_item_icon);
            mIndexItemTitle = (TextView) rootView.findViewById(R.id.index_item_title);
            mListItemGridView = (GridView) rootView.findViewById(R.id.list_item_grid_view);
        }
    }
}

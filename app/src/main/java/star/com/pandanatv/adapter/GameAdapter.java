package star.com.pandanatv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import star.com.pandanatv.R;
import star.com.pandanatv.model.GameData;

/**
 * Created by Administrator on 2016/10/4.
 */
public class GameAdapter extends BaseAdapter {
    private ArrayList<GameData.DataBean> mDataBeen;

    public void setDataBeen(ArrayList<GameData.DataBean> dataBeen) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_grid_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTextGameItem.setText(mDataBeen.get(i).getCname());
        BitmapUtils bitmapUtils=new BitmapUtils(viewGroup.getContext());
        bitmapUtils.display(viewHolder.mImageGameItem,mDataBeen.get(i).getImg());
        return view;
    }

    static class ViewHolder {
        protected ImageView mImageGameItem;
        protected TextView mTextGameItem;

        ViewHolder(View rootView) {
            initView(rootView);
        }

        private void initView(View rootView) {
            mImageGameItem = (ImageView) rootView.findViewById(R.id.image_game_item);
            mTextGameItem = (TextView) rootView.findViewById(R.id.text_game_item);
        }
    }
}

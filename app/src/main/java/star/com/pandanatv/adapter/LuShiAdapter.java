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
import star.com.pandanatv.model.LuShiData;
import star.com.pandanatv.model.ZhiboData;

/**
 * Created by Administrator on 2016/10/3.
 */
public class LuShiAdapter extends BaseAdapter {
    private ArrayList<LuShiData.DataBean.ItemsBean> mDataBeen;

    public void setDataBeen(ArrayList<LuShiData.DataBean.ItemsBean> dataBeen) {
        mDataBeen = dataBeen;
    }

    @Override
    public int getCount() {
        return mDataBeen==null?0:mDataBeen.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_inner, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BitmapUtils bitmapUtils=new BitmapUtils(viewGroup.getContext());
        bitmapUtils.display(viewHolder.mImageView,mDataBeen.get(i).getPictures().getImg());
        viewHolder.mPictureDescr.setText(mDataBeen.get(i).getName());
        viewHolder.mIndexSubtitle.setText(mDataBeen.get(i).getUserinfo().getNickName());
        viewHolder.mFavoriteNumber.setText(mDataBeen.get(i).getPerson_num());
        return view;
    }

    static class ViewHolder {
        protected ImageView mImageView;
        protected TextView mPictureDescr;
        protected TextView mIndexSubtitle;
        protected ImageView mInnerImageGuanzhu;
        protected TextView mFavoriteNumber;

        ViewHolder(View rootView) {
            initView(rootView);
        }

        private void initView(View rootView) {
            mImageView = (ImageView) rootView.findViewById(R.id.imageView);
            mPictureDescr = (TextView) rootView.findViewById(R.id.picture_descr);
            mIndexSubtitle = (TextView) rootView.findViewById(R.id.index_subtitle);
            mInnerImageGuanzhu = (ImageView) rootView.findViewById(R.id.inner_image_guanzhu);
            mFavoriteNumber = (TextView) rootView.findViewById(R.id.favorite_number);
        }
    }
}

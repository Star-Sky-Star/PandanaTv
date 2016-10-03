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
import star.com.pandanatv.model.Recom_list_data;

/**
 * Created by Administrator on 2016/10/3.
 */
public class InnerListGridAdapter extends BaseAdapter {
    private ArrayList<Recom_list_data.DataBean.ItemsBean> mItemsBeen;

    public void setItemsBeen(ArrayList<Recom_list_data.DataBean.ItemsBean> itemsBeen) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_inner, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BitmapUtils bitmapUtils=new BitmapUtils(viewGroup.getContext());
        bitmapUtils.display(viewHolder.mImageView,mItemsBeen.get(i).getPictures().getImg());
        viewHolder.mPictureDescr.setText(mItemsBeen.get(i).getName());
        viewHolder.mIndexSubtitle.setText(mItemsBeen.get(i).getUserinfo().getNickName());
        viewHolder.mFavoriteNumber.setText(mItemsBeen.get(i).getPerson_num());
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

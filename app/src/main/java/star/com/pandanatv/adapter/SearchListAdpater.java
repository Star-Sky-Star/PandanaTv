package star.com.pandanatv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import star.com.pandanatv.R;

/**
 * Created by Administrator on 2016/10/4.
 */
public class SearchListAdpater extends BaseAdapter {
    private ArrayList<String> mStrings;

    public void setStrings(ArrayList<String> strings) {
        mStrings = strings;
    }

    @Override
    public int getCount() {
        return mStrings == null ? 0 : mStrings.size();
    }

    @Override
    public Object getItem(int i) {
        return mStrings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null || !(view.getTag() instanceof ViewHolder)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mSerchItemText.setText(mStrings.get(i));
        return view;
    }

    static class ViewHolder {
        protected TextView mSerchItemText;
        protected Button mBtnDeletOne;

        ViewHolder(View rootView) {
            initView(rootView);
        }

        private void initView(View rootView) {
            mSerchItemText = (TextView) rootView.findViewById(R.id.serch_item_text);
            mBtnDeletOne = (Button) rootView.findViewById(R.id.btn_delet_one);

        }
    }
}

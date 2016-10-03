package star.com.pandanatv.activity;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/10/3.
 */
public class CustomGridView extends GridView {
    public CustomGridView(Context context) {
        super(context);
    }
    /**
     * 设置上下不滚动
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_MOVE){
            return true;//true:禁止滚动
        }
        return super.dispatchTouchEvent(ev);
    }
}

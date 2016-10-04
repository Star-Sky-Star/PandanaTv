package star.com.pandanatv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import star.com.pandanatv.R;
import star.com.pandanatv.model.ImageBtnCallBack;

/**
 * Created by Administrator on 2016/10/1.
 */
public  class BaseActivity extends AppCompatActivity {
    protected TextView mCustomActionbarText;
    protected ImageButton mImageButton;
    private ImageBtnCallBack mCallBack;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowCustomEnabled(true);
        supportActionBar.setCustomView(R.layout.custom_actionbar);
        initView();
    }
    private void initView() {
        mCustomActionbarText = (TextView) findViewById(R.id.custom_actionbar_text);
        mImageButton = (ImageButton) findViewById(R.id.imageButton);
        mImageButton.setImageResource(R.drawable.search);
    mImageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // Toast.makeText(BaseActivity.this, "出来效果了", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(BaseActivity.this,SearchActivity.class);
            startActivity(intent);
        }
    });
    }
    public void setTitle(String s) {
        if (s.equals("首页")){
            mCustomActionbarText.setText("");
            mCustomActionbarText.setBackgroundResource(R.drawable.home_banner_bg);
        }else{
            mCustomActionbarText.setBackgroundResource(R.drawable.text_title_actionbar);
            mCustomActionbarText.setText(s);
        }
    }

}

package star.com.pandanatv.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import star.com.pandanatv.R;

/**
 * Created by Administrator on 2016/10/1.
 */
public class BaseActivity extends AppCompatActivity {
    protected TextView mCustomActionbarText;
    protected ImageButton mImageButton;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.hide();
        super.setContentView(R.layout.custom_actionbar);
        super.onCreate(savedInstanceState, persistentState);
        initView();

    }

    private void initView() {
        mCustomActionbarText = (TextView) findViewById(R.id.custom_actionbar_text);
        mImageButton = (ImageButton) findViewById(R.id.imageButton);


    }
}

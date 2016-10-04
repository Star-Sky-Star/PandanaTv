package star.com.pandanatv.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import star.com.pandanatv.DB.RecordsDao;
import star.com.pandanatv.R;
import star.com.pandanatv.adapter.SearchListAdpater;

public class SearchActivity extends Activity implements View.OnClickListener {
    protected ImageButton mBack;
    protected EditText mSearchEdit;
    protected ImageButton mSearchBtn;
    protected ListView mSearchRecord;
    protected TextView mHeadSearchText;
    protected ImageButton mHeadSearchBtn;
    RecordsDao recordsDao;
    private SearchListAdpater mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        mBack = (ImageButton) findViewById(R.id.back);
        mBack.setOnClickListener(SearchActivity.this);
        mSearchEdit = (EditText) findViewById(R.id.search_edit);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);
        mSearchBtn.setOnClickListener(SearchActivity.this);
        mSearchRecord = (ListView) findViewById(R.id.search_record);
        mSearchRecord.addHeaderView(View.inflate(this, R.layout.search_list_head_item, null));
        mHeadSearchText = (TextView) findViewById(R.id.head_search_text);
        mHeadSearchBtn = (ImageButton) findViewById(R.id.head_search_btn);
        mHeadSearchBtn.setOnClickListener(SearchActivity.this);
        recordsDao = new RecordsDao(this);
        List<String> strings = recordsDao.queryAllRecord();
        mAdpater = new SearchListAdpater();
        SearchListAdpater adapter = mAdpater;
        adapter.setStrings((ArrayList<String>) strings);
        mSearchRecord.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            String string = mSearchEdit.getText().toString();
            if (string.equals("")){
                finish();
                return;
            }else{
                recordsDao.addRecords(string);
            }
            mSearchEdit.setText("");
            finish();
        } else if (view.getId() == R.id.search_btn) {
            String string = mSearchEdit.getText().toString();
            recordsDao.addRecords(string);
            mSearchEdit.setText("");
        } else if (view.getId() == R.id.head_search_btn) {
            recordsDao.deleteAllRecords();
            List<String> strings = recordsDao.queryAllRecord();
            mAdpater.setStrings((ArrayList<String>) strings);
            mAdpater.notifyDataSetChanged();
        }
    }
}

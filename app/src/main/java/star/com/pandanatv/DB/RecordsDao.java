package star.com.pandanatv.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/4.
 */
public class RecordsDao {

    RecordSqlHelper recordHelper;

    SQLiteDatabase recordsDb;

    public RecordsDao(Context context) {
        recordHelper = new RecordSqlHelper(context);
    }

    //添加搜索记录
    public void addRecords(String record) {

        if (!isHasRecord(record)){
            recordsDb = recordHelper.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("note", record);
            //添加
            recordsDb.insert("records", null, values);
            //关闭
            recordsDb.close();
        }
    }

    //判断是否含有该搜索记录
    public boolean isHasRecord(String record) {
        boolean isHasRecord = false;
        recordsDb = recordHelper.getReadableDatabase();
        Cursor cursor = recordsDb.query("records", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            if (record.equals(cursor.getString(cursor.getColumnIndexOrThrow("note")))) {
                isHasRecord = true;
            }
        }
        //关闭数据库
        recordsDb.close();
        return isHasRecord;
    }
    //模糊查询
    public List<String> querySimlarRecord(String record){
        String queryStr = "select * from records where note like '%" + record + "%' order by " +
                "note";
        List<String> similarRecords = new ArrayList<>();
        Cursor cursor= recordHelper.getReadableDatabase().rawQuery(queryStr,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("note"));
            similarRecords.add(name);
        }
        return similarRecords;
    }


    //模糊查询
    public List<String> queryAllRecord(){
        String queryStr = "select note from records";
        List<String> similarRecords = new ArrayList<>();
        Cursor cursor= recordHelper.getReadableDatabase().rawQuery(queryStr,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("note"));
            similarRecords.add(name);
        }
        return similarRecords;
    }

    //清空搜索记录
    public void deleteAllRecords() {
        recordsDb = recordHelper.getWritableDatabase();
        recordsDb.execSQL("delete from records");
        recordsDb.close();
    }
}

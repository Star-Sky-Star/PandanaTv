package star.com.pandanatv.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/4.
 */
public class RecordSqlHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="Record.db";
    public static final int DB_VERSION=1;
    public RecordSqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlStr = "CREATE TABLE IF NOT EXISTS records(_id INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, note TEXT);";
        sqLiteDatabase.execSQL(sqlStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

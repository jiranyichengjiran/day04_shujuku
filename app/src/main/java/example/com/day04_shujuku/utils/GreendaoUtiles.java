package example.com.day04_shujuku.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import example.com.day04_shujuku.common.Constants;
import example.com.day04_shujuku.greendao.DaoMaster;
import example.com.day04_shujuku.greendao.DaoSession;

public class GreendaoUtiles {
    private static GreendaoUtiles mInstance;
    private GreendaoUtiles(){

    }
    /*
    * 双重检验锁
    * */
    public static GreendaoUtiles getmInstance(){
        if(mInstance==null)
        {
            synchronized (GreendaoUtiles.class){
                if(mInstance==null)
                {
                    mInstance=new GreendaoUtiles();
                }
            }
        }
        return mInstance;
    }
    /*
    * 初始化GreenDao  直接在Application中进行初始化操作
    * */
    public void initGreenDao(Context context)
    {
        //创建daomaster
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(context,Constants.DB_NNAM);
        SQLiteDatabase db=helper.getWritableDatabase();  //读写数据库
        DaoMaster daoMaster = new DaoMaster(db);
        //创建daosession
        daoSession=daoMaster.newSession();
    }
    private DaoSession daoSession;
    public DaoSession getDaoSession(){
        return daoSession;
    }
}


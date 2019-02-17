package com.example.app_3.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.app_3.common.Contants;
import com.example.greendao.bw.db.DaoMaster;
import com.example.greendao.bw.db.DaoSession;


public class GreenUtils
{
    public static GreenUtils instance;
    private DaoSession daoSession;

    public GreenUtils()
    {

    }
    public static GreenUtils getInstance()
    {
        if( instance == null)
        {
            synchronized (GreenUtils.class)
            {
                if(instance == null)
                {
                    instance = new GreenUtils();
                }
            }
        }
        return instance;
    }
    /**
     * 初始化GreenDao
     */
    public void initGreenDao(Context context)
    {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, Contants.DB_NNAME);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}

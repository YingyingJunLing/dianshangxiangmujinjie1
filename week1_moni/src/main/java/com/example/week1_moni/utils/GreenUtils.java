package com.example.week1_moni.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendao.bw.db.DaoMaster;
import com.example.greendao.bw.db.DaoSession;
import com.example.week1_moni.common.Constants;

public class GreenUtils
{
    public static GreenUtils instance;
    private DaoSession daoSession;

    public static GreenUtils getInstance()
    {
        if(instance == null)
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
    public void initGreenDao(Context context)
    {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,Constants.DB_NNAME);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public DaoSession getDaoSession()
    {
        return daoSession;
    }

}

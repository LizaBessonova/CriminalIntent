package com.bignerdranch.android.supportintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.supportintent.database.SupportBaseHelper;
import com.bignerdranch.android.supportintent.database.SupportCursorWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bignerdranch.android.supportintent.database.SupportDbSchema.*;

public class SupportLab {
    private static SupportLab sSupportLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private List<Support> mSupports;

    public static SupportLab get(Context context){
        if (sSupportLab == null) {
            sSupportLab = new SupportLab(context);
        }
        return sSupportLab;
    }
    private SupportLab(Context context){
        mSupports= new ArrayList<>();

//        mContext = context.getApplicationContext();
//        mDatabase = new SupportBaseHelper(mContext)
//                .getWritableDatabase();
    }

    public void addSupport(Support s){
        mSupports.add(s);
//        ContentValues values = getContentValies(s);
//
//        mDatabase.insert(SupportTable.NAME, null, values);
    }

    public List<Support> getSupports(){
        return mSupports;
//        List<Support> supports = new ArrayList<>();
//        SupportCursorWrapper cursor = querySupports(null,null);
//
//        try{
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()){
//                supports.add(cursor.getSupport());
//            }
//        } finally {
//            cursor.close();
//        }
//        return supports;
    }

    public Support getSupport(UUID id){
        for(Support support : mSupports){
            if (support.getId().equals(id)){
                return support;
            }
        }
        return null;
//        SupportCursorWrapper cursor = querySupports(
//                SupportTable.Cols.UUID + " = ?",
//                new String[] {id.toString()}
//        );
//
//        try {
//            if (cursor.getCount() == 0){
//                return null;
//            }
//            cursor.moveToFirst();
//            return cursor.getSupport();
//        } finally {
//            cursor.close();
//        }
    }

//    public void updateSupport(Support support){
//        String uuidString = support.getId().toString();
//        ContentValues values = getContentValies(support);
//
//        mDatabase.update(SupportTable.NAME, values,
//                SupportTable.Cols.UUID + " = ?",
//                new String[]{ uuidString });
//    }

//    private static ContentValues getContentValies(Support support) {
//        ContentValues values = new ContentValues();
//        values.put(SupportTable.Cols.UUID, support.getId().toString());
//        values.put(SupportTable.Cols.AUTHOR, support.getAuthor().toString());
//        values.put(SupportTable.Cols.RESPONSIBLE, support.getResponsible().toString());
//        values.put(SupportTable.Cols.THEME, support.getTheme().toString());
//        values.put(SupportTable.Cols.CATEGORY, support.getCategory().toString());
//        values.put(SupportTable.Cols.SOLVED, support.isSolved() ? 1:0);
//
//        return values;
//    }

    private SupportCursorWrapper querySupports(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                SupportTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new SupportCursorWrapper(cursor);
    }
}

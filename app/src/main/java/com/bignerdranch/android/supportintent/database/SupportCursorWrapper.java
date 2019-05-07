package com.bignerdranch.android.supportintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.supportintent.Support;

import java.util.UUID;

import static com.bignerdranch.android.supportintent.database.SupportDbSchema.*;

public class SupportCursorWrapper extends CursorWrapper {
    public SupportCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Support getSupport() {
        String uuidString = getString(getColumnIndex(SupportTable.Cols.UUID));
        String author = getString(getColumnIndex(SupportTable.Cols.AUTHOR));
        String responsible = getString(getColumnIndex(SupportTable.Cols.RESPONSIBLE));
        String theme = getString(getColumnIndex(SupportTable.Cols.THEME));
        String category = getString(getColumnIndex(SupportTable.Cols.CATEGORY));
        String isSolved = getString(getColumnIndex(SupportTable.Cols.SOLVED));


        Support support = new Support(UUID.fromString(uuidString));
        support.setAuthor(author);
        support.setResponsible(responsible);
        support.setTheme(theme);
        support.setCategory(category);
        //support.setSolved(isSolved != 0);
        return support;
    }
}

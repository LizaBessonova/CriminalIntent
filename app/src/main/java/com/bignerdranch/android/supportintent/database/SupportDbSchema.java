package com.bignerdranch.android.supportintent.database;

public class SupportDbSchema {
    public static final class SupportTable {
        public static final String NAME = "supports";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String AUTHOR = "author";
            public static final String RESPONSIBLE = "responsible";
            public static final String CATEGORY = "category";
            public static final String THEME = "theme";
            public static final String SOLVED = "solved";
        }
    }
}

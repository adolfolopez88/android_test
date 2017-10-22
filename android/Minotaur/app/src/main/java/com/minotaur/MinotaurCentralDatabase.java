package com.minotaur;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by et on 8/10/17.
 */

public class MinotaurCentralDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "minotaur-central.db";
    private static final int DATABASE_VERSION = 1;

    public MinotaurCentralDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public BeaconInfo getBeacon(String beaconId) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"offsetx", "offsety", "description"};
        String sqlTables = "beacons";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db,
                sqlSelect, "beaconId = ?",
                new String[]{beaconId},
                null, null, null);

        c.moveToFirst();
        BeaconInfo beaconInfo = new BeaconInfo(null, null);
        beaconInfo.setX(c.getDouble(c.getColumnIndexOrThrow("offsetx")));
        beaconInfo.setY(c.getDouble(c.getColumnIndexOrThrow("offsety")));
        beaconInfo.setDescription(c.getString(c.getColumnIndexOrThrow("description")));
        return beaconInfo;
    }
}

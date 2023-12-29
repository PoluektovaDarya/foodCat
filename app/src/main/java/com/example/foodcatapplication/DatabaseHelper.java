package com.example.foodcatapplication;
import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Food_for_cat";
    private static final int DATABASE_VERSION = 1;

    // Таблица
    private static final String TABLE_NAME = "food_cat";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";

    public long id; public String name;
    // Запрос для создания таблицы
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME + " TEXT);";

    // Начальные данные
    private static final String[] INITIAL_DATA = {
            "Acana", "Go Natural", "Grandorf", "Farmina N&D", // для худых
            "Blitz", "Leonardo", "Carnilove", "Probalance", // для средних
            "Eukanuba", "Science Plan", "Brit Care", "Summit", // для толстых
    "Grandorf Adult Cat Sterilized", "Hill’s Science Plan", "Grandorf Rabbit & Turkey гипоаллергенный", "1st Choice для здоровья костей и суставов Senior", // для стерилизованных/кастрированных
    "Brit Care Cat Missy Sterilised", "Almo Nature Adult Sterilised Cat", "ROYAL CANIN Sterilised 7+"}; // для пожилых

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// Создание таблицы
        db.execSQL(TABLE_CREATE);

// Вставка начальных данных
        for (String data : INITIAL_DATA) {
            String insertQuery = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ") VALUES ('" + data + "');";
            db.execSQL(insertQuery);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Обновление базы данных (если необходимо)
    }

   public ClipData.Item getItem(long itemId) {

       return null;
   }


    public DataItem getDataItemById(long itemId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID + "=?",
                new String[]{String.valueOf(itemId)}, null, null, null);

        DataItem dataItem = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {

                dataItem = new DataItem(id, name);
                dataItem.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                dataItem.setName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
            }
            cursor.close();
        }
        db.close();
        return dataItem;
    }
}

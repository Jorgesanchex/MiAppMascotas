package com.miapp.mascotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MascotaDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mascotas.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_MASCOTA = "mascota";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_IMAGEN = "imagenResId";
    private static final String COLUMN_RATING = "rating";

    public MascotaDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_MASCOTA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NOMBRE + " TEXT,"
                + COLUMN_IMAGEN + " INTEGER,"
                + COLUMN_RATING + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MASCOTA);
        onCreate(db);
    }

    // Insertar o actualizar mascota (solo guardamos 5 últimas)
    public void insertOrUpdateMascota(Mascota mascota) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, mascota.getId());
        values.put(COLUMN_NOMBRE, mascota.getNombre());
        values.put(COLUMN_IMAGEN, mascota.getImagenResId());
        values.put(COLUMN_RATING, mascota.getRating());

        // Si ya existe, actualizar
        int updatedRows = db.update(TABLE_MASCOTA, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(mascota.getId())});

        if (updatedRows == 0) { // si no existía, insertar
            db.insert(TABLE_MASCOTA, null, values);
        }

        // Mantener solo 5 últimas mascotas con rating > 0
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ID + " FROM " + TABLE_MASCOTA +
                " ORDER BY " + COLUMN_RATING + " DESC", null);
        if(cursor.getCount() > 5){
            cursor.moveToPosition(4); // Posición 4 = 5ta mascota
            int fifthId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            db.delete(TABLE_MASCOTA, COLUMN_ID + "!=? AND " + COLUMN_RATING + " = 0",
                    new String[]{String.valueOf(fifthId)});
        }
        cursor.close();
        db.close();
    }

    public List<Mascota> getLastFiveMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_MASCOTA,
                null, null, null, null, null,
                COLUMN_RATING + " DESC", "5");

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE));
                int imagen = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGEN));
                int rating = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_RATING));

                Mascota m = new Mascota(id, nombre, imagen);
                m.setRating(rating);
                mascotas.add(m);
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return mascotas;
    }
}

package br.com.imc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public class ImcRepository {
    SQLiteDatabase db;
    public ImcRepository(Context context){
        Conexao cn = new Conexao(context);
        db = cn.getWritableDatabase();
    }

    public void salvar(Imc imc){
        ContentValues valor = new ContentValues();
        valor.put("IMC", imc.getImc());

        db.insert("IMCS",null,valor);


    }

    public ArrayList<Imc> listarTodos(){
        ArrayList<Imc> imcs = new ArrayList<Imc>();
        Cursor cursor = db.rawQuery("SELECT * FROM IMCS",null);
        if (cursor.moveToFirst()){

            do {
                Imc i = new Imc();
                i.setImc(cursor.getString(0));

                imcs.add(i);
            }while (cursor.moveToNext());

        }
        return imcs;
    }

}
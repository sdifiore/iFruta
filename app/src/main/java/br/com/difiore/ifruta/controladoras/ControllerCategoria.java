package br.com.difiore.ifruta.controladoras;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.difiore.ifruta.entidades.Categoria;

public class ControllerCategoria {
    private static DBHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerCategoria(Context context) {
        if (dbHelper == null ) {
            dbHelper = new DBHelper(context);
        }
    }

    public String inserirCategoria (Categoria cat) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("descricaoCategoria", cat.getDescricao());
        resultado = db.insert(DBHelper.TABELA4, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro inserido com sucesso";
        }
        return retorno;
    }

    public String excluirCategoria (Categoria cat) {
        String retorno = "Resgistro excluído com Sucesso";
        String where = "ID = " + cat.getIdCategoria();
        db = dbHelper.getReadableDatabase();
        db.delete(DBHelper.TABELA4,where,null);
        db.close();
        return retorno;
    }
}

package br.com.difiore.ifruta.controladoras;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.difiore.ifruta.entidades.ProdutoInSacola;

public class ControllerPedido {
    private static DBHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerPedido(Context context) {
        if (dbHelper == null ) {
            dbHelper = new DBHelper(context);
        }
    }

    @SuppressLint("Range")
    public ArrayList<ProdutoInSacola> getProdutosInSacola(int idCliente){
        ArrayList<ProdutoInSacola> listaProdutos = new ArrayList<ProdutoInSacola>();
        String selectQuery = "SELECT descricao,quantidade,preco FROM PRODUTOS,SACOLA" +
                " WHERE PRODUTOS.idProduto=SACOLA.idProduto AND SACOLA.idCliente=?";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idCliente)});
        if (cursor.moveToFirst()) {
            do {
                ProdutoInSacola prod = new ProdutoInSacola();
                prod.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
                prod.setQuantidade(Integer.parseInt(cursor.getString(cursor.getColumnIndex("quantidade"))));
                //prod.setQuantidade(1);
                prod.setPreco(Float.parseFloat(cursor.getString(cursor.getColumnIndex("preco"))));
                listaProdutos.add(prod);
            } while (cursor.moveToNext());
        }
        return listaProdutos;
    }

    public String inserirProdutoInSacola(int idCliente,int idProduto) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("idCliente", idCliente);
        valores.put("idProduto", idProduto);
        resultado = db.insert("SACOLA", null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro inserido com sucesso";
        }
        return retorno;
    }}

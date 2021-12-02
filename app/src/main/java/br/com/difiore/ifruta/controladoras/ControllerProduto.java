package br.com.difiore.ifruta.controladoras;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.difiore.ifruta.entidades.Categoria;
import br.com.difiore.ifruta.entidades.Produto;

public class ControllerProduto {
    private static DBHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerProduto(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
    }

    @SuppressLint("Range")
    public Produto getOneProduct(String name){
        Produto produto = new Produto();
        String selectQuery =
                "SELECT idProduto,codProduto,descricao,CATEGORIAS.descricaoCategoria,quantidade,preco " +
                        "FROM PRODUTOS,CATEGORIAS WHERE descricao=? AND CATEGORIAS.idCategoria=PRODUTOS.categoria";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,  new String[]{ name });
        cursor.moveToFirst();
        produto.setIdProduto(Integer.parseInt("" + cursor.getInt(cursor.getColumnIndex("idProduto"))));
        produto.setCodProduto(cursor.getString(cursor.getColumnIndex("codProduto")));
        produto.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
        produto.setCategoria(new Categoria(cursor.getString(cursor.getColumnIndex("descricaoCategoria"))));
        produto.setQuantidade(Integer.parseInt(cursor.getString(cursor.getColumnIndex("quantidade"))));
        produto.setPreco(Float.parseFloat(cursor.getString(cursor.getColumnIndex("preco"))));

        return produto;
    }

    public String inserirProduto(Produto prod) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("CODPRODUTO", prod.getCodProduto());
        valores.put("DESCRICAO", prod.getDescricao());
        valores.put("CATEGORIA", prod.getCategoria().getIdCategoria());
        valores.put("QUANTIDADE", prod.getQuantidade());
        valores.put("PRECO", prod.getPreco());
        resultado = db.insert(DBHelper.TABELA2, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro inserido com sucesso";
        }
        return retorno;
    }

    public String excluirProduto(Produto prod) {
        String retorno = "Resgistro excluído com Sucesso";
        String where = "ID = " + prod.getIdProduto();
        db = dbHelper.getReadableDatabase();
        db.delete(DBHelper.TABELA2, where, null);
        db.close();
        return retorno;
    }

    public String alterarProduto(Produto prod) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro alterado com sucesso";
        String where = "ID = " + prod.getIdProduto();
        valores = new ContentValues();
        valores.put("CODPRODUTO", prod.getCodProduto());
        valores.put("DESCRICAO", prod.getDescricao());
        valores.put("CATEGORIA", String.valueOf(prod.getCategoria()));
        valores.put("QUANTIDADE", prod.getQuantidade());
        valores.put("PRECO", prod.getPreco());
        db.update(DBHelper.TABELA2, valores, where, null);
        db.close();
        return retorno;
    }

    public List<Produto> listarProdutos() {
        List<Produto> listaProdutos = new ArrayList<Produto>();
        String selectQuery = "SELECT * FROM PRODUTOS";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Produto prod = new Produto();
                prod.setIdProduto(Integer.parseInt("" + cursor.getInt(0)));
                prod.setCodProduto(cursor.getString(1));
                prod.setDescricao(cursor.getString(2));
                prod.setCategoria(new Categoria(cursor.getString(3)));
                prod.setQuantidade(Integer.parseInt(cursor.getString(4)));
                prod.setPreco(Float.parseFloat(cursor.getString(5)));
                listaProdutos.add(prod);
            } while (cursor.moveToNext());
        }
        return listaProdutos;
    }
}

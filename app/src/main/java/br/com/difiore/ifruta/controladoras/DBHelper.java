package br.com.difiore.ifruta.controladoras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "iFruta.db";
    private static final int DB_VERSAO = 1;

    public static final String TABELA1 = "CLIENTES";
    public static final String Tabela1_Column_ID = "idCliente";
    public static final String Tabela1_Column_Nome = "nome";
    public static final String Tabela1_Column_Cpf = "cpf";
    public static final String Tabela1_Column_Telefone = "telefone";
    public static final String Tabela1_Column_Endereco = "endereco";
    public static final String Tabela1_Column_Login = "login";
    public static final String Tabela1_Column_Senha = "senha";
    public static final String Tabela1_Column_State = "state";

    private static final String CREATE = "create table " + ClienteDb.TABLE_NAME + "("
            + ClienteDb._Column_ID + "integer primary key autoincrement, "
            + ClienteDb._Column_Nome + "text, "
            + ClienteDb._Column_Cpf + "text, "
            + ClienteDb._Column_Telefone + "text, "
            + ClienteDb._Column_Endereco + "text, "
            + ClienteDb._Column_Login + "text, "
            + ClienteDb._Column_Senha + "text, "
            + ClienteDb._Column_State + "text),";



    public static final String TABELA2 = "PRODUTOS";
    public static final String Tabela2_Column_ID = "idProduto";
    public static final String Tabela2_Column_CodProduto = "codProduto";
    public static final String Tabela2_Column_Descricao = "descricao";
    public static final String Tabela2_Column_Categoria = "categoria";
    public static final String Tabela2_Column_Quantidade = "quantidade";
    public static final String Tabela2_Column_Preco = "preco";

    public static final String TABELA3 = "PEDIDOS";
    public static final String Tabela3_Column_ID = "idPedido";
    public static final String Tabela3_Column_CodPedido = "codPedido";
    public static final String Tabela3_Column_Cliente = "idCliente";
    public static final String Tabela3_Column_Produto = "idProduto";
    public static final String Tabela3_Column_Preco = "preco";

    public static final String TABELA4 = "CATEGORIAS";
    public static final String Tabela4_Column_ID = "idCategoria";
    public static final String Tabela4_Column_Descricao = "descricaoCategoria";

    public static final String TABELA5 = "SACOLA";
    public static final String Tabela5_Column_ID = "idSacola";
    public static final String Tabela5_Column_Cliente = "idCliente";
    public static final String Tabela5_Column_Produto = "idProduto";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE1 = "CREATE TABLE IF NOT EXISTS " + TABELA1 + " (" +
                Tabela1_Column_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                Tabela1_Column_Nome + " VARCHAR, " +
                Tabela1_Column_Cpf + " VARCHAR, " +
                Tabela1_Column_Telefone + " VARCHAR, " +
                Tabela1_Column_Endereco + " VARCHAR, " +
                Tabela1_Column_Login + " VARCHAR, " +
                Tabela1_Column_Senha + " VARCHAR," +
                Tabela1_Column_State + " INTEGER," +
                "FOREIGN KEY (" + Tabela1_Column_ID + ") REFERENCES TABELA3(" + Tabela3_Column_Cliente + "))";
        db.execSQL(CREATE_TABLE1);

        String CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS " + TABELA2 + " (" +
                Tabela2_Column_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                Tabela2_Column_CodProduto + " VARCHAR, " +
                Tabela2_Column_Descricao + " VARCHAR," +
                Tabela2_Column_Categoria + " INTEGER, " +
                Tabela2_Column_Quantidade + " INTEGER," +
                Tabela2_Column_Preco + " FLOAT," +
                "FOREIGN KEY (" + Tabela2_Column_Descricao + ") REFERENCES " + TABELA4 + "(" + Tabela4_Column_ID + "))";

        db.execSQL(CREATE_TABLE2);

        String CREATE_TABLE3 = "CREATE TABLE IF NOT EXISTS " + TABELA3 + " (" +
                Tabela3_Column_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                Tabela3_Column_CodPedido + " VARCHAR, " +
                Tabela3_Column_Cliente + " INTEGER , " +
                Tabela3_Column_Produto + " INTEGER , " +
                Tabela3_Column_Preco + " FLOAT," +
                "FOREIGN KEY (" + Tabela3_Column_ID + ") REFERENCES " + TABELA2 + "(" + Tabela2_Column_ID + "))";
        db.execSQL(CREATE_TABLE3);

        String Sacola = "CREATE TABLE IF NOT EXISTS " + TABELA5 + " (" +
                Tabela5_Column_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                Tabela5_Column_Cliente + " INTEGER , " +
                Tabela5_Column_Produto + " INTEGER , " +
                "FOREIGN KEY (" + Tabela5_Column_Cliente + ") REFERENCES " + TABELA1 + "(" + Tabela1_Column_ID + ")," +
                "FOREIGN KEY (" + Tabela5_Column_Produto + ") REFERENCES " + TABELA2 + "(" + Tabela2_Column_ID + "))";
        db.execSQL(Sacola);


        String CREATE_TABLE4 = "CREATE TABLE IF NOT EXISTS " + TABELA4 + " (" +
                Tabela4_Column_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                Tabela4_Column_Descricao + " VARCHAR)";
        db.execSQL(CREATE_TABLE4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE CLIENTES");
        db.execSQL("DROP TABLE PRODUTOS");
        db.execSQL("DROP TABLE PEDIDOS");
        db.execSQL("DROP TABLE CATEGORIAS");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}

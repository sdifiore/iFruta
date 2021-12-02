package br.com.difiore.ifruta.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.difiore.ifruta.R;
import br.com.difiore.ifruta.controladoras.ControllerCategoria;
import br.com.difiore.ifruta.controladoras.ControllerProduto;
import br.com.difiore.ifruta.controladoras.DBHelper;
import br.com.difiore.ifruta.entidades.Categoria;

public class MainActivity extends AppCompatActivity {

    private EditText login, senha;
    private Button btEntrar, btCadastrarNovo;

    private String stLogin, stSenha;
    private boolean textoPreenchido;
    SQLiteDatabase sqLiteDB;
    DBHelper dbHelper;
    Cursor cursor;
    String tempSenha = "123456";

    public static final String userLogin = "teste";

    private SQLiteDatabase database;

    private ControllerProduto controllerProduto;
    private ControllerCategoria controllerCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
        btEntrar = (Button) findViewById(R.id.btEntrar);
        btCadastrarNovo = (Button) findViewById(R.id.btCadastrarNovo);

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        controllerProduto = new ControllerProduto(this);
        controllerCategoria = new ControllerCategoria(this);

        if (getCurrentUser()) {

            Intent intent = new Intent(MainActivity.this, AreaCliente.class);
            startActivity(intent);
        }

        if(!getFirstInit()) {

            carregarCategorias(database);
            carregarProdutos(database);
        }
        setFirstInit();

        btEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                checarTextoVazio();
                logarCliente();
            }
        });

        btCadastrarNovo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroCliente.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("Range")
    public void logarCliente() {

        if (textoPreenchido) {
            sqLiteDB = dbHelper.getWritableDatabase();
            cursor = sqLiteDB.query(DBHelper.TABELA1, null, " " +
                            DBHelper.Tabela1_Column_Login + "=?", new String[]{stLogin}, null,
                    null, null);

            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    cursor.moveToFirst();
                    tempSenha = cursor.getString(cursor.getColumnIndex(DBHelper.Tabela1_Column_Senha));
                    cursor.close();
                }
            }
            checarResultadoFinal();
        } else {
            Toast.makeText(MainActivity.this, "Por favor insira login ou senha",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void checarTextoVazio() {

        stLogin = login.getText().toString();
        stSenha = senha.getText().toString();

        if (TextUtils.isEmpty(stLogin) || TextUtils.isEmpty(stSenha)) {
            textoPreenchido = false;
        } else {
            textoPreenchido = true;
        }
    }

    public void checarResultadoFinal() {

        if (tempSenha.equalsIgnoreCase(stSenha)) {
            Toast.makeText(MainActivity.this, "Login feito com sucesso",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent (MainActivity.this, AreaCliente.class);
            intent.putExtra(userLogin, stLogin);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Login ou senha incorretos. Tente novamente.",
                    Toast.LENGTH_SHORT).show();
        }
        tempSenha = "NOT_FOUND";
    }

    public void carregarCategorias(SQLiteDatabase db) {

        controllerCategoria.inserirCategoria(new Categoria("FRUTA"));
        controllerCategoria.inserirCategoria(new Categoria("Verdura"));
        controllerCategoria.inserirCategoria(new Categoria("Legumes"));
    }

    public void carregarProdutos(SQLiteDatabase db) {

        String INSERT_MAÇA = "INSERT INTO " + TABELA2 + " (" +
                Tabela2_Column_CodProduto + ", " +
                Tabela2_Column_Descricao + "," +
                Tabela2_Column_Categoria + ", " +
                Tabela2_Column_Quantidade + ", " +
                Tabela2_Column_Preco + ") VALUES ('F001', 'Maçã', 1, 5, 2.99)";
        db.execSQL(INSERT_MAÇA);

        String INSERT_BANANA = "INSERT INTO " + TABELA2 + " (" +
                Tabela2_Column_CodProduto + ", " +
                Tabela2_Column_Descricao + ", " +
                Tabela2_Column_Categoria + ", " +
                Tabela2_Column_Quantidade + ", " +
                Tabela2_Column_Preco + ") VALUES ('F002', 'Banana', 1, 12, 4.99)";
        db.execSQL(INSERT_BANANA);

        String INSERT_COUVE = "INSERT INTO " + TABELA2 + " (" +
                Tabela2_Column_CodProduto + ", " +
                Tabela2_Column_Descricao + ", " +
                Tabela2_Column_Categoria + ", " +
                Tabela2_Column_Quantidade + ", " +
                Tabela2_Column_Preco + ") VALUES ('V001', 'Couve', 2, 10, 1.99)";
        db.execSQL(INSERT_COUVE);

        String INSERT_RABANETE = "INSERT INTO " + TABELA2 + " (" +
                Tabela2_Column_CodProduto + ", " +
                Tabela2_Column_Descricao + ", " +
                Tabela2_Column_Categoria + ", " +
                Tabela2_Column_Quantidade + ", " +
                Tabela2_Column_Preco + ") VALUES ('V002', 'Rabanete', 2, 8, 3.99)";
        db.execSQL(INSERT_RABANETE);

        String INSERT_LENTILHA = "INSERT INTO " + TABELA2 + " (" +
                Tabela2_Column_CodProduto + ", " +
                Tabela2_Column_Descricao + ", " +
                Tabela2_Column_Categoria + ", " +
                Tabela2_Column_Quantidade + ", " +
                Tabela2_Column_Preco + ") VALUES ('L001', 'Lentilha', 3, 10, 8.99)";
        db.execSQL(INSERT_LENTILHA);
    }

    private Boolean getCurrentUser() {

        SharedPreferences sharedPreferences = getSharedPreferences("loged", Context.MODE_PRIVATE);
        int defaultValue = -1;
        return sharedPreferences.getLong("currentUser",defaultValue) != -1 ;
    }

    private void setFirstInit() {

        SharedPreferences sharedPreferences = getSharedPreferences("first", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("init", 0);
        editor.apply();
    }

    private Boolean getFirstInit() {

        SharedPreferences sharedPreferences = getSharedPreferences("first", Context.MODE_PRIVATE);
        int defaultValue = -1;
        return sharedPreferences.getInt("init",defaultValue) == 0;
    }
}

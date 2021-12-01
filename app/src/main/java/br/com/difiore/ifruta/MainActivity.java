package br.com.difiore.ifruta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btReloadDb= (Button) findViewById(R.id.btReloadDb);
        btReloadDb.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                resetDb();
            }
        });
    }

    private void resetDb() {
        Intent reloadDb = new Intent(this, ReloadDbActivity.class);
        startActivity(reloadDb);
    }
}

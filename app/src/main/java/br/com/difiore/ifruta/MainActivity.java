package br.com.difiore.ifruta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btProduct = (Button) findViewById(R.id.btProduct);
        btProduct.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                System.out.println("Button Produto");
            }
        });
    }
}

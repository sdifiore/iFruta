package br.com.difiore.ifruta;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class JsonConsumer extends AsyncTask<String, Void, List<Post>> {

    private Context context;
    private ListView listView;
}

        @Override
            protected void onPreExecute(){
            dialog = ProgressDialog.show(context, "Um instante, reiniciando banco com valores padrão...");
        }
    }

    @Override
    protected List<Post> doInBackground(String... strings) {
        return null;
    }
}

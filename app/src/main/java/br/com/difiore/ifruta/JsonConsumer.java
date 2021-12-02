package br.com.difiore.ifruta;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class JsonConsumer extends AsyncTask<String, Void, List<Post>> {

    private ProgressDialog dialog;
    private ListView listView;
    private Context context;

    public JsonConsumer(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected List<Post> doInBackground(String... strings) {
        return null;
    }
}

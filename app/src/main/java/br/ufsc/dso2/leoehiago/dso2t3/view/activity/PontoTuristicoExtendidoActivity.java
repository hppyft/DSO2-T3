package br.ufsc.dso2.leoehiago.dso2t3.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontoTuristicoExtendidoPresenterImpl;

public class PontoTuristicoExtendidoActivity extends AppCompatActivity {

    public static final String ID_KEY = "id_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            int id = intent.getIntExtra(ID_KEY, -1);
            if (id != -1) {
                PontoTuristicoExtendidoPresenterImpl.getInstance().setPTID(id);
            }
        }
        setContentView(R.layout.activity_ponto_turistico_extendido);
    }
}
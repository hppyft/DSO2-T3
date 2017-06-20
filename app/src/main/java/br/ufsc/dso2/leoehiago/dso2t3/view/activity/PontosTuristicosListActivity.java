package br.ufsc.dso2.leoehiago.dso2t3.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontosTuristicosListFragmentImpl;

public class PontosTuristicosListActivity extends AppCompatActivity {

    public static final String PONTOS_TURISTICOS_LIST_FRAG = "pontos_turisticos_list_frag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos_turisticos_list);
        getFragmentManager().putFragment(savedInstanceState, PONTOS_TURISTICOS_LIST_FRAG, new PontosTuristicosListFragmentImpl());
    }
}

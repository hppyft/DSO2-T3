package br.ufsc.dso2.leoehiago.dso2t3.view.activity;

import static br.ufsc.dso2.leoehiago.dso2t3.presenter.PontosTuristicoesListPresenterImpl.PT_ID;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontoTuristicoExtendidoFragmentImpl;

public class PontoTuristicoExtendidoActivity extends AppCompatActivity {

    private static final String PONTO_TURISTICO_EXTENDIDO_FRAG = "ponto_turistico_extendido_frag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponto_turistico_extendido);
        PontoTuristicoExtendidoFragmentImpl fragment = new PontoTuristicoExtendidoFragmentImpl();
        fragment.mPresenter.setPTID(getIntent().getIntExtra(PT_ID, 1));
        getFragmentManager().putFragment(savedInstanceState, PONTO_TURISTICO_EXTENDIDO_FRAG, fragment);

    }
}
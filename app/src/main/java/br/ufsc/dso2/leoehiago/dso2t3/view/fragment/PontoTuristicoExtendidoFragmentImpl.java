package br.ufsc.dso2.leoehiago.dso2t3.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontoTuristicoExtendidoPresenter;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontoTuristicoExtendidoPresenterImpl;

public class PontoTuristicoExtendidoFragmentImpl extends Fragment {

    public final PontoTuristicoExtendidoPresenter mPresenter;
    //TODO Colocar os itens de layout

    public PontoTuristicoExtendidoFragmentImpl() {
        mPresenter = new PontoTuristicoExtendidoPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ponto_turistico_extendido, container, false);

        //TODO Instanciar os itens de layout

        PontoTuristico pontoTuristico = mPresenter.getPontoTuristico();

        //TODO Setar valores dos campos

        //TODO Colocar onClick na geolocalizaocao

        return view;
    }
}

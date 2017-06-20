package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.view.activity.PontoTuristicoExtendidoActivity;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontosTuristicosListFragmentImpl;

public class PontosTuristicoesListPresenterImpl implements PontosTuristicoesListPresenter {

    public static final String PT_ID = "pt_id";
    private PontosTuristicosListFragmentImpl mFragment;

    public PontosTuristicoesListPresenterImpl(PontosTuristicosListFragmentImpl fragment) {
        mFragment = fragment;
    }

    @Override
    public List<PontoTuristico> getList() {
        //TODO Pegar lista do BD
        List<PontoTuristico> list = new ArrayList<>();

        if (list.isEmpty()) {
            createInitialValues();
            //TODO Pegar novamente a lista do BD
        }

        return list;
    }

    private void createInitialValues() {
        //TODO Criar dumbdata e adicionar no BD
    }

    @Override
    public void onPontoTuristicoClicked(Integer id) {
        Intent intent = new Intent(mFragment.getActivity(), PontoTuristicoExtendidoActivity.class);
        intent.putExtra(PT_ID, id);
        mFragment.getActivity().startActivity(intent);
    }
}

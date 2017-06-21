package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import static br.ufsc.dso2.leoehiago.dso2t3.view.activity.PontoTuristicoExtendidoActivity.ID_KEY;

import android.content.Intent;

import br.ufsc.dso2.leoehiago.dso2t3.database.DatabaseHelper;
import br.ufsc.dso2.leoehiago.dso2t3.view.activity.PontoTuristicoExtendidoActivity;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontosTuristicosListFragmentImpl;

public class PontosTuristicoesListPresenterImpl implements PontosTuristicoesListPresenter {

    private PontosTuristicosListFragmentImpl mFragment;
    private static PontosTuristicoesListPresenterImpl instance;
    private int listNumber;
    private static final int LIST_ALL = 0;
    private static final int LIST_FAVORITOS = 1;

    private PontosTuristicoesListPresenterImpl() {
        listNumber = 0;
    }

    public static PontosTuristicoesListPresenterImpl getInstance() {
        if (instance == null) {
            instance = new PontosTuristicoesListPresenterImpl();
        }
        return instance;
    }

    public void setFragment(PontosTuristicosListFragmentImpl fragment) {
        mFragment = fragment;
    }

    @Override
    public void setList() {
        switch (listNumber) {
            case LIST_ALL:
                mFragment.setList(new DatabaseHelper(mFragment.getContext()).getAll());
                break;
            case LIST_FAVORITOS:
                mFragment.setList(new DatabaseHelper(mFragment.getContext()).getFavoritos());
                break;
        }
    }

    @Override
    public void onPontoTuristicoClicked(Integer id) {
        Intent intent = new Intent(mFragment.getActivity(), PontoTuristicoExtendidoActivity.class);
        intent.putExtra(ID_KEY, id);
        mFragment.getActivity().startActivity(intent);
    }

    @Override
    public void showFavoritosClicked() {
        listNumber = LIST_FAVORITOS;
        mFragment.setList(new DatabaseHelper(mFragment.getContext()).getFavoritos());
    }

    @Override
    public void showAllClicked() {
        listNumber = LIST_ALL;
        mFragment.setList(new DatabaseHelper(mFragment.getContext()).getAll());
    }

    public void onFavoritosChanged() {
        setList();
    }
}

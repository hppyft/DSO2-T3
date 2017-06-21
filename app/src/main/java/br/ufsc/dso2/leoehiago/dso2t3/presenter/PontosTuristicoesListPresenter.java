package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontosTuristicosListFragmentImpl;

public interface PontosTuristicoesListPresenter {
    void onPontoTuristicoClicked(Integer id);

    void showFavoritosClicked();

    void showAllClicked();

    void setFragment(PontosTuristicosListFragmentImpl pontosTuristicosListFragment);

    void setList();
}

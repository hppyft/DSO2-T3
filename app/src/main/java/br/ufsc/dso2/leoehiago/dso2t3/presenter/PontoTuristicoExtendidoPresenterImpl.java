package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import br.ufsc.dso2.leoehiago.dso2t3.database.DatabaseHelper;
import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontoTuristicoExtendidoFragmentImpl;

public class PontoTuristicoExtendidoPresenterImpl implements PontoTuristicoExtendidoPresenter {

    private Integer ptID;
    private PontoTuristicoExtendidoFragmentImpl mFragment;
    private static PontoTuristicoExtendidoPresenterImpl instance;

    private PontoTuristicoExtendidoPresenterImpl() {
    }

    public static PontoTuristicoExtendidoPresenterImpl getInstance() {
        if (instance == null) {
            instance = new PontoTuristicoExtendidoPresenterImpl();
        }
        return instance;
    }

    public void setPTID(Integer id) {
        ptID = id;
    }

    public void setFragment(PontoTuristicoExtendidoFragmentImpl fragment) {
        mFragment = fragment;
    }

    @Override
    public void onFavoritoChanged(boolean b) {
        DatabaseHelper db = new DatabaseHelper(mFragment.getActivity());
        db.updateFavorito(ptID, b);
        PontosTuristicoesListPresenterImpl.getInstance().onFavoritosChanged();
    }

    @Override
    public PontoTuristico getPontoTuristico() {
        return new DatabaseHelper(mFragment.getActivity()).getSinglePT(ptID);
    }
}

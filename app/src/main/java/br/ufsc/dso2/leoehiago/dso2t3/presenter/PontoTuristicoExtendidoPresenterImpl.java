package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import android.os.Parcel;

import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontoTuristicoExtendidoFragmentImpl;

public class PontoTuristicoExtendidoPresenterImpl implements PontoTuristicoExtendidoPresenter {

    private Integer ptID;
    private final PontoTuristicoExtendidoFragmentImpl mFragment;

    public PontoTuristicoExtendidoPresenterImpl(PontoTuristicoExtendidoFragmentImpl fragment) {
        mFragment = fragment;
    }

    public void setPTID(Integer id) {
        ptID = id;
    }

    @Override
    public PontoTuristico getPontoTuristico() {
        //TODO Pegar ponto turistico do BD baseado no ptID e retorna-lo
        return new PontoTuristico(Parcel.obtain());
    }
}

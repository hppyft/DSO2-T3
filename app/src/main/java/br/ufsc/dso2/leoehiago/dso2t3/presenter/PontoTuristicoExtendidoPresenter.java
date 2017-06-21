package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.view.fragment.PontoTuristicoExtendidoFragmentImpl;

public interface PontoTuristicoExtendidoPresenter {
    PontoTuristico getPontoTuristico();

    void setPTID(Integer id);

    void setFragment(PontoTuristicoExtendidoFragmentImpl fragment);

    void onFavoritoChanged(boolean b);
}

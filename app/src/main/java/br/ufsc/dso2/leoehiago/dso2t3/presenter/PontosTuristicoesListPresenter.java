package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import java.util.List;

import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;

public interface PontosTuristicoesListPresenter {
    List<PontoTuristico> getList();

    void onPontoTuristicoClicked(Integer id);
}

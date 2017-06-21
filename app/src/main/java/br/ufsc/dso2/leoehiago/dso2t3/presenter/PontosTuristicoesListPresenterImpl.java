package br.ufsc.dso2.leoehiago.dso2t3.presenter;

import android.content.Intent;
import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.dso2.leoehiago.dso2t3.R;
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

        return getDumbPTList();
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

    private static List<PontoTuristico> createDumbPTList() {
        PontoTuristico pontoTuristico = new PontoTuristico();
        pontoTuristico.nome = "Ponte Hercilio Luz";
        pontoTuristico.descricao = "É uma ponte localizada no" +
                "blablablabla pq blablallba aipeiaeipe ahiaehaehifei" +
                "afhohioefaiohef aefhiefihia hioaefhioef";
        pontoTuristico.ehFavorito = false;
        pontoTuristico.geoLocalizacao = "-27.5938571,-48.5680622";
        pontoTuristico.horarioFuncionamento = "Segunda a sexta das 10:00 " +
                "as 12:00 e das 13:00 as 18:00. Sábados e Domingos das 13:00 as 16:00.";
        pontoTuristico.imgResId = R.drawable.ponte_hercilio_luz_maior;
        pontoTuristico.imgResumoResId = R.drawable.ponte_hercilio_luz;
        pontoTuristico.valorEntrada = 15.00;
        pontoTuristico.id = 1;

        List<PontoTuristico> list = new ArrayList<>();
        list.add(pontoTuristico);
        return list;
    }

    private static List<PontoTuristico> DumbPTList;

    public static List<PontoTuristico> getDumbPTList() {
        if (DumbPTList == null || DumbPTList.isEmpty()) {
            DumbPTList = createDumbPTList();
        }
        return DumbPTList;
    }
}

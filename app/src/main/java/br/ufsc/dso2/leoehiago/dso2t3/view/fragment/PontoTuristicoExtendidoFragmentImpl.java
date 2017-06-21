package br.ufsc.dso2.leoehiago.dso2t3.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.model.util.ResUtil;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontoTuristicoExtendidoPresenter;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontoTuristicoExtendidoPresenterImpl;

public class PontoTuristicoExtendidoFragmentImpl extends Fragment {

    public final PontoTuristicoExtendidoPresenter mPresenter;
    private CheckBox mFavorito;
    private ImageView mFoto;
    private TextView mNome;
    private TextView mValor;
    private AppCompatButton mLocalizacao;
    private TextView mHorario;
    private TextView mDescricao;

    public PontoTuristicoExtendidoFragmentImpl() {
        mPresenter = PontoTuristicoExtendidoPresenterImpl.getInstance();
        mPresenter.setFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ponto_turistico_extendido, container, false);

        mFavorito = (CheckBox) view.findViewById(R.id.favorito_checkbox);
        mFoto = (ImageView) view.findViewById(R.id.foto_view);
        mNome = (TextView) view.findViewById(R.id.nome_view);
        mValor = (TextView) view.findViewById(R.id.valor_view);
        mLocalizacao = (AppCompatButton) view.findViewById(R.id.localizacao_view);
        mHorario = (TextView) view.findViewById(R.id.horario_view);
        mDescricao = (TextView) view.findViewById(R.id.descricao_view);

        final PontoTuristico pontoTuristico = mPresenter.getPontoTuristico();

        mFavorito.setChecked(pontoTuristico.ehFavorito);
        mFavorito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mPresenter.onFavoritoChanged(b);
            }
        });
        mFoto.setImageDrawable(getResources().getDrawable(ResUtil.getDrawable(getActivity().getApplication(), pontoTuristico.img)));
        mNome.setText(pontoTuristico.nome);
        mValor.setText(String.format("R$ %s", pontoTuristico.valorEntrada));
        mLocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse((String.format("geo:%s?q=%s", pontoTuristico.geoLocalizacao, pontoTuristico.nome)));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mHorario.setText(pontoTuristico.horarioFuncionamento);
        mDescricao.setText(pontoTuristico.descricao);

        return view;
    }
}

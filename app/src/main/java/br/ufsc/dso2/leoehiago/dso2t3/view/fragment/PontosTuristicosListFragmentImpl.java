package br.ufsc.dso2.leoehiago.dso2t3.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.model.adapter.PontosTuristicosListAdapter;
import br.ufsc.dso2.leoehiago.dso2t3.model.listener.OnPontoTuristicoClickedListener;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontosTuristicoesListPresenter;
import br.ufsc.dso2.leoehiago.dso2t3.presenter.PontosTuristicoesListPresenterImpl;

public class PontosTuristicosListFragmentImpl extends Fragment implements OnPontoTuristicoClickedListener {

    private PontosTuristicoesListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private PontosTuristicosListAdapter mAdapter;

    public PontosTuristicosListFragmentImpl() {
        super();
        mPresenter = new PontosTuristicoesListPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pontos_turisticos_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.pontos_turisticos_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PontosTuristicosListAdapter(getActivity(), this);
        mAdapter.setList(mPresenter.getList());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onPontoTuristicoClicked(Integer id) {
        mPresenter.onPontoTuristicoClicked(id);
    }
}

package br.ufsc.dso2.leoehiago.dso2t3.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.dso2.leoehiago.dso2t3.R;
import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;
import br.ufsc.dso2.leoehiago.dso2t3.model.listener.OnPontoTuristicoClickedListener;

public class PontosTuristicosListAdapter extends RecyclerView.Adapter<PontosTuristicosListAdapter.ViewHolder> {

    private final OnPontoTuristicoClickedListener mListener;
    public List<PontoTuristico> mList;

    public PontosTuristicosListAdapter(OnPontoTuristicoClickedListener listener) {
        mListener = listener;
        mList = new ArrayList();
    }

    @Override
    public PontosTuristicosListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_ponto_turistico, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PontosTuristicosListAdapter.ViewHolder holder, int position) {
        final PontoTuristico pontoTuristico = mList.get(position);
        holder.mIconeResmoView.setImageResource(pontoTuristico.imgResId);
        holder.mNomeResumoView.setText(pontoTuristico.nome);
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPontoTuristicoClicked(pontoTuristico.id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIconeResmoView;
        public TextView mNomeResumoView;
        public View mLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mIconeResmoView = (ImageView) itemView.findViewById(R.id.img_resumo_pt);
            mNomeResumoView = (TextView) itemView.findViewById(R.id.nome_resumo_pt);
            mLayout = itemView.findViewById(R.id.item_view);
        }
    }
}

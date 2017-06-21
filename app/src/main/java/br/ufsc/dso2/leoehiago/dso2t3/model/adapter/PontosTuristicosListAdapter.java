package br.ufsc.dso2.leoehiago.dso2t3.model.adapter;

import android.app.Application;
import android.content.Context;
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
import br.ufsc.dso2.leoehiago.dso2t3.model.util.ResUtil;

public class PontosTuristicosListAdapter extends RecyclerView.Adapter<PontosTuristicosListAdapter.ViewHolder> {

    private final OnPontoTuristicoClickedListener mListener;
    private List<PontoTuristico> mList;
    private Context mContext;
    private Application mApplication;

    public PontosTuristicosListAdapter(Context context, OnPontoTuristicoClickedListener listener, Application application) {
        mApplication = application;
        mContext = context;
        mListener = listener;
        mList = new ArrayList();
    }

    @Override
    public PontosTuristicosListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_ponto_turistico, parent, false);
        return new PontosTuristicosListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PontosTuristicosListAdapter.ViewHolder holder, int position) {
        final PontoTuristico pontoTuristico = mList.get(position);
        holder.mIconeResmoView.setImageResource(ResUtil.getDrawable(mApplication, pontoTuristico.imgResumo));
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

    public void setList(List<PontoTuristico> list) {
        this.mList = list;
        notifyDataSetChanged();
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

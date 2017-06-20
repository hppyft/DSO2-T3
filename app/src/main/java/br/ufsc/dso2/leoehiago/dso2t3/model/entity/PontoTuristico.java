package br.ufsc.dso2.leoehiago.dso2t3.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class PontoTuristico implements Parcelable {

    public Integer id;
    public String nome;
    public String descricao;
    public String horarioFuncionamento;
    public long valorEntrada;
    public String geoLocalizacao;
    public int imgResId;
    public boolean ehFavorito;

    public PontoTuristico(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        horarioFuncionamento = in.readString();
        valorEntrada = in.readLong();
        geoLocalizacao = in.readString();
        imgResId = in.readInt();
        ehFavorito = in.readByte() != 0;
    }

    public static final Creator<PontoTuristico> CREATOR = new Creator<PontoTuristico>() {
        @Override
        public PontoTuristico createFromParcel(Parcel in) {
            return new PontoTuristico(in);
        }

        @Override
        public PontoTuristico[] newArray(int size) {
            return new PontoTuristico[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(descricao);
        parcel.writeString(horarioFuncionamento);
        parcel.writeLong(valorEntrada);
        parcel.writeString(geoLocalizacao);
        parcel.writeInt(imgResId);
        parcel.writeByte((byte) (ehFavorito ? 1 : 0));
    }
}

package br.ufsc.dso2.leoehiago.dso2t3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.dso2.leoehiago.dso2t3.model.entity.PontoTuristico;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String NOME_BD = "dso2_t3_database";
    public static final int VERSION_BD = 1;
    private static final String PT_TABLE = "pt_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_DESCRICAO = "descricao";
    public static final String COLUMN_HORARIO_FUNCIONAMENTO = "horario_funcionamento";
    public static final String COLUMN_VALOR_ENTRADA = "valor_entrada";
    public static final String COLUMN_GEO_LOCALIZACAO = "geo_localizacao";
    public static final String COLUMN_IMG_RESUMO = "img_resumo";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_FAVORITO = "favorito";

    public static final int COLUMN_ID_INDEX = 0;
    public static final int COLUMN_NOME_INDEX = 1;
    public static final int COLUMN_DESCRICAO_INDEX = 2;
    public static final int COLUMN_HORARIO_FUNCIONAMENTO_INDEX = 3;
    public static final int COLUMN_VALOR_ENTRADA_INDEX = 4;
    public static final int COLUMN_GEO_LOCALIZACAO_INDEX = 5;
    public static final int COLUMN_IMG_RESUMO_INDEX = 6;
    public static final int COLUMN_IMG_INDEX = 7;
    public static final int COLUMN_FAVORITO_INDEX = 8;

    public DatabaseHelper(Context context) {
        super(context, NOME_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + PT_TABLE + "( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOME + " TEXT, " +
                COLUMN_DESCRICAO + " TEXT, " +
                COLUMN_HORARIO_FUNCIONAMENTO + " TEXT, " +
                COLUMN_VALOR_ENTRADA + " REAL, " +
                COLUMN_GEO_LOCALIZACAO + " TEXT, " +
                COLUMN_IMG_RESUMO + " TEXT, " +
                COLUMN_IMG + " TEXT, " +
                COLUMN_FAVORITO + " INTEGER)";

        sqLiteDatabase.execSQL(createTable);

        String insertFirstRows = "INSERT INTO " + PT_TABLE + " ( " +
                COLUMN_NOME + ", " +
                COLUMN_DESCRICAO + ", " +
                COLUMN_HORARIO_FUNCIONAMENTO + ", " +
                COLUMN_VALOR_ENTRADA + ", " +
                COLUMN_GEO_LOCALIZACAO + ", " +
                COLUMN_IMG_RESUMO + ", " +
                COLUMN_IMG + ", " +
                COLUMN_FAVORITO + ")" +
                "VALUES ( " +
                "\"Mercado Público\", " +
                "\"Coração do centro histórico de Florianópolis, o Mercado Público Municipal de Florianópolis é diversão garantida. Com seus box de venda de peixe fresco, lojas de roupas, bares e "
                + "restaurantes típicos, atrai intelectuais, boêmios e artistas. Aos sábados à tarde vira ponto de encontro dos amantes do samba.\", "
                +
                "\"Lojas de segunda a sexta-feira das 9h às 19h e bares até as 22h, e sábados das 9h às 12h, bares até as 22h.\", "
                +
                "0.00, " +
                "\"-27.5972335,-48.5530904\", " +
                "\"mercado_resumo\", " +
                "\"mercado\", " +
                "0 ), " +

                "( " +
                "\"Ponte Hercílio Luz\", " +
                "\"Principal cartão postal de Florianópolis, a Ponte Hercílio Luz foi construída entre os anos 1922 e 1926. Até sua inauguração em 1926, os cerca de 40 mil habitantes de Florianópolis"
                + " dependiam de balsas para realizar a travessia entre a porção insular e a porção continental.\", "
                +
                "\"Todos os dias, 24h ao dia\", " +
                "0.00, " +
                "\"-27.593911,-48.565866\", " +
                "\"ponte_resumo\", " +
                "\"ponte\", " +
                "0 ), " +

                "( " +
                "\"Teatro Álvaro de Carvalho\", " +
                "\"O Teatro Álvaro de Carvalho foi inaugurado em 7 de setembro de 1875, no dia em que o Brasil comemorava 53 anos de independência. Inicialmente, ganhou o nome de Teatro Santa Isabel,"
                + " em homenagem à princesa, já demonstrando o pendor dos habitantes pela monarquia. Em 1894, o lugar serviu de prisão aos simpatizantes do imperador em uma reação do Governo "
                + "Federal à Revolução Federalista, que culminou no Massacre de Anhatomirim. Desde então, o Teatro Álvaro de Carvalho leva o nome do primeiro dramaturgo de Santa Catarina.\", "
                +
                "\"Todos os dias das 13h às 19h.\", "
                +
                "0.00, " +
                "\"-27.5956182,-48.5484232\", " +
                "\"teatro_resumo\", " +
                "\"teatro\", " +
                "0 ), " +

                "( " +
                "\"Museu do Homem do Sambaquí\", " +
                "\"O Museu do Homem do Sambaqui tem grande importância para o estudo da evolução dos costumes humanos e do próprio homem. Nele, estão expostos quase 200 esqueletos em surpreendente "
                + "estado de conservação, com idades estimadas entre 1.055 e 1.552 anos. O Museu também conta com uma ala de zoologia, na qual há animais de várias espécies conservados através da "
                + "taxidermia. O acervo ainda apresenta arte sacra, numismática (moedas e cédulas), fósseis com até 225 milhões de anos, utensílios indígenas e outros materiais.\", "
                +
                "\"Terça a sexta 7h30 - 11h30, 13h30 - 17h30\", " +
                "0.00, " +
                "\"-27.5889138,-48.5540351\", " +
                "\"museu_resumo\", " +
                "\"museu\", " +
                "0 ), " +

                "( " +
                "\"Ilha do Campeche\", " +
                "\"A Ilha do Campeche é daqueles lugares que não dá pra esquecer de conhecer em Floripa. Para conhecer a ilha é preciso ir até a Praia da Armação, onde se pega uma pequena embarcação "
                + "na associação local de pescadores. O trajeto leva 40 minutos e custa R$ 40, ida e volta. A permanência na ilha dura em torno de quatro horas; nesse período, você pode fazer "
                + "caminhadas, almoçar em um dos dois restaurantes da ilha ou se deliciar na praia.\", "
                +
                "\"Todos os dias, 24h ao dia\", " +
                "80.00, " +
                "\"-27.6950471,-48.4679427\", " +
                "\"ilha_resumo\", " +
                "\"ilha\", " +
                "0 );";

        sqLiteDatabase.execSQL(insertFirstRows);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    private List<PontoTuristico> getPontosTuristicos(String selection, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<PontoTuristico> list = new ArrayList<>();
        Cursor cursor = db.query(PT_TABLE, null, selection, selectionArgs, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            PontoTuristico pt = createPTFromCursor(cursor);
            list.add(pt);
        }
        return list;
    }

    public List<PontoTuristico> getAll() {
        return getPontosTuristicos(null, null);
    }

    public List<PontoTuristico> getFavoritos() {
        String[] args = {"1"};
        return getPontosTuristicos(COLUMN_FAVORITO + "=?", args);
    }

    public void updateFavorito(Integer id, boolean ehFavorito) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = {Integer.toString(id)};
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_FAVORITO, ehFavorito);
        db.update(PT_TABLE, values, COLUMN_ID + "=?", args);
    }

    private PontoTuristico createPTFromCursor(Cursor cursor) {
        PontoTuristico pt = new PontoTuristico();
        pt.id = cursor.getInt(COLUMN_ID_INDEX);
        pt.nome = cursor.getString(COLUMN_NOME_INDEX);
        pt.descricao = cursor.getString(COLUMN_DESCRICAO_INDEX);
        pt.horarioFuncionamento = cursor.getString(COLUMN_HORARIO_FUNCIONAMENTO_INDEX);
        pt.valorEntrada = cursor.getDouble(COLUMN_VALOR_ENTRADA_INDEX);
        pt.geoLocalizacao = cursor.getString(COLUMN_GEO_LOCALIZACAO_INDEX);
        pt.imgResumo = cursor.getString(COLUMN_IMG_RESUMO_INDEX);
        pt.img = cursor.getString(COLUMN_IMG_INDEX);
        pt.ehFavorito = cursor.getInt(COLUMN_FAVORITO_INDEX) > 0;
        return pt;
    }

    public PontoTuristico getSinglePT(Integer ptID) {
        String[] args = {Integer.toString(ptID)};
        return getPontosTuristicos(COLUMN_ID + "=?", args).get(0);
    }
}

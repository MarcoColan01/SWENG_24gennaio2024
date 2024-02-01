package it.unimi.di.sweng.esame.presenter;

public record Data(int giorno, int mese, int anno) {
    public static Data creaData(String data){
        String[] app = data.split("/");
        int giorno = Integer.parseInt(app[0]);
        int mese = Integer.parseInt(app[1]);
        int anno = Integer.parseInt(app[2]);
        return new Data(giorno, mese, anno);
    }
}

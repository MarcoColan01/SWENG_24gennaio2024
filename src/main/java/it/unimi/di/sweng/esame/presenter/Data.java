package it.unimi.di.sweng.esame.presenter;

import org.jetbrains.annotations.NotNull;

public record Data(int giorno, int mese, int anno) implements Comparable<Data>{
    public static Data creaData(String data){
        String[] app = data.split("/");
        int giorno = Integer.parseInt(app[0]);
        int mese = Integer.parseInt(app[1]);
        int anno = Integer.parseInt(app[2]);
        return new Data(giorno, mese, anno);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(giorno < 10 ? String.format("0%d", giorno) : giorno).append("/");
        sb.append(mese < 10 ? String.format("0%d", mese) : mese).append("/");
        sb.append(anno).append("/");
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    @Override
    public int compareTo(@NotNull Data o) {
        return 0;
    }
}

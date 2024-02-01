package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import org.jetbrains.annotations.NotNull;

public record Data(int giorno, int mese, int anno) implements Comparable<Data>{
    public static Data creaData(String data){
        if(!data.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$"))
            throw new IllegalArgumentException("incorrect data format (correct format: dd/mm/yyyy)");
        String[] app = data.split("/");
        int giorno = Integer.parseInt(app[0]);
        int mese = Integer.parseInt(app[1]);
        int anno = Integer.parseInt(app[2]);
        Data date = new Data(giorno, mese, anno);
        Data dataAttuale = new Data(1,1,2024);
        if(date.compareTo(dataAttuale) < 0) throw new IllegalArgumentException("forecast date cannot be in the past");
        return date;
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
    public int compareTo(@NotNull Data other) {
        int res = Integer.compare(anno, other.anno);
        if(res != 0) return res;
        res = Integer.compare(mese, other.mese);
        if(res != 0) return res;
        return Integer.compare(giorno, other.giorno);
    }
}

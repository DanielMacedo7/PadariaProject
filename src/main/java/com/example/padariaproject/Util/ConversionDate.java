package com.example.padariaproject.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversionDate {

    public static Date converterData(String dataBrasileira) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");

        try{
            
            return formatoBrasileiro.parse(dataBrasileira);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }


    public static String formatarData(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");

        // Formatação da data no formato brasileiro
        return formatoBrasileiro.format(data);
    }

}

package com.example.fandomoviesproject.ayuda;


public class AyudaModel implements AyudaContract.Model {

    public static String TAG = AyudaModel.class.getSimpleName();

    String ayudaText = "¿Tienes problemas con la App?\n" +
            "\n" +
            "No dudes en contactar con nuestro equipo de soporte técnico " +
            "indicando el problema sucedido para que lo podamos solventar " +
            "lo antes posible.\n" +
            "\n" +
            "\n" +
            "Teléfono: +34 785392927";

    @Override
    public String fetchAyudaData() {
        return ayudaText;
    }


}

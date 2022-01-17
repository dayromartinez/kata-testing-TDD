package com.sofka.tdd.testingCalculator.Calculadora;

public class CalculadoraStrings {

    private String cadena = null;

    public CalculadoraStrings(){

    }

    public CalculadoraStrings(String cadena) {
        this.cadena = cadena;
    }

    public int stringCalculator(String cadena){

        int resultado = 0;

        if(cadena.equals("")){
            resultado = resultado;
        }else if(cadena.length() == 1){
            resultado = Integer.parseInt(cadena);
        }else if(cadena.length() == 3){
            resultado = sumasencilla(cadena);
        }
        return resultado;
    }

    private int sumasencilla(String cadena){

        int resultado = 0;
        System.out.println(cadena.indexOf(","));
        String[] numeros = cadena.split(",");
        int numero1 = Integer.parseInt(numeros[0]);
        int numero2 = Integer.parseInt(numeros[1]);
        resultado = numero1 + numero2;
        return resultado;
    }


    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}

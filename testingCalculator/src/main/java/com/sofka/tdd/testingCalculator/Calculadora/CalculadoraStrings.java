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
        int tresNumeros = sumaTresNumeros(cadena);

        if(cadena.equals("")) {
            resultado = resultado;
        }else if(cadena.length() == 1){
            resultado = Integer.parseInt(cadena);
        }else if(tresNumeros != 0){
            resultado = tresNumeros;
        }else if(Integer.parseInt(cadena) < 0) {
            throw new IllegalArgumentException("Numero negativo");
        }else if(cadena.contains(",")){
            resultado = sumasencillaComa(cadena);
        }else if(cadena.contains("\n")){
            resultado = sumasencillaSaltoLinea(cadena);
        }
        return resultado;
    }

    private int sumasencillaComa(String cadena){

        int resultado = 0;
        String[] numeros = cadena.split(",");
        int numero1 = Integer.parseInt(numeros[0]);
        int numero2 = Integer.parseInt(numeros[1]);
        resultado = numero1 + numero2;
        return resultado;
    }

    private int sumasencillaSaltoLinea(String cadena){
        int resultado = 0;
        String[] numeros = cadena.split("\n");
        int numero1 = Integer.parseInt(numeros[0]);
        int numero2 = Integer.parseInt(numeros[1]);
        resultado = numero1 + numero2;
        return resultado;
    }

    private int sumaTresNumeros(String cadena){

        int resultado = 0;

        String[] caracteres = {",", " ", "#", "/", "\n"};

        for (int i = 0; i < caracteres.length; i++) {
            if(cadena.contains(caracteres[i])){
                var numeros = cadena.split(caracteres[i]);
                if(numeros.length == 3){
                  resultado = Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1]) + Integer.parseInt(numeros[2]);
                  break;
                }
            }
        }
        return resultado;
    }


    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}

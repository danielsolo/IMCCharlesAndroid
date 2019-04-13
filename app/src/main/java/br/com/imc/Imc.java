package br.com.imc;



public class Imc {

    private double peso;
    private double altura;
    private double imc;


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public double setImc(String v1, String v2) {
        double n1 = Double.parseDouble(v1.getText().toString());
        double n2 = Double.parseDouble(v2.getText().toString());
        imc = n1 / (Math.pow(n2,2));
        return imc;
    }
}

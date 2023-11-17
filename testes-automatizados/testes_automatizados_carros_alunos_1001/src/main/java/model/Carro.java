package model;

import java.util.Objects;

public class Carro {
    private String cor;
    private String marca;
    private String modelo;
    private Boolean ligado;
    private Integer velocidadeAtual;
    private Integer velocidadeMaxima;
    private Boolean trancado;

    public Carro(String cor, String marca, String modelo, Integer velocidadeMaxima) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0;
        this.ligado = false;
        this.trancado = true;
    }

    public void ligar() throws Exception {
        if (this.ligado == false){
            this.ligado = true;
        } else {
            throw new Exception("O carro já está ligado!");
        }
    }

    public void trancar() {
        if(trancado == true) {
            System.out.println("Já está trancado");
        } else {
            trancado = true;
        }
    }

    public void destrancar() {
        if(trancado == false) {
            System.out.println("Já está destrancado");
        } else {
            trancado = false;
        }
    }

    public void desligar() throws Exception {
        if (this.velocidadeAtual == 0){
            if (this.ligado == true){
                this.ligado = false;
            } else {
                throw new Exception("O carro já está desligado!");
            }
        } else {
            throw new Exception("O carro está em movimento!");
        }
    }

    public void acelerar(Integer velocidade) throws Exception {
        if (this.ligado == true){
            if(velocidade < 0) {
                // Exception - desvio de uma regra ou de um padrão convencionalmente aceito.
                throw new Exception("A aceleracao não pode ser menor que zero!");
            }
            if (this.velocidadeMaxima == velocidade + velocidadeAtual) {
                this.velocidadeAtual = this.velocidadeMaxima;
            } else if (this.velocidadeMaxima > velocidade + velocidadeAtual) {
                this.velocidadeAtual = velocidade + velocidadeAtual;
            } else {
                throw new Exception("A velocidade atual não pode ultrapassar a velocidade máxima!");
            }
        } else {
            throw new Exception("O carro está desligado!");
        }
    }

    public void frear(Integer velocidade) throws Exception {
        if (this.ligado == true){
            if(this.velocidadeAtual - velocidade == 0) {
                this.velocidadeAtual = 0;
            } else if (this.velocidadeAtual - velocidade > 0) {
                this.velocidadeAtual = this.velocidadeAtual - velocidade;
            } else {
                throw new Exception("Você não pode frear uma velocidade menor que zero!");
            }
        } else {
            throw new Exception("O carro está desligado!");
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public Integer getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public Boolean getTrancado() {
        return trancado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro)) return false;
        Carro carro = (Carro) o;
        return Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "cor='" + cor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ligado=" + ligado +
                ", velocidadeAtual=" + velocidadeAtual +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", trancado=" + trancado +
                '}';
    }
}

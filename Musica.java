package ado2;

import java.util.Scanner;

public class Musica {
    
    private String nome, artista;
    private double duracao;
    private int codigo;
    
    
    /**
     * Retorna o valor do atributo nome
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Atribui um valor ao atributo nome
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor do atributo artista
     * @return String
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Atribui um valor ao atributo nome
     * @param artista String
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * Retorna o valor do atributo duração
     * @return double
     */
    public double getDuracao() {
        return duracao;
    }

    /**
     * Atribui um valor ao atributo duração
     * @param duracao double
     */
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    /**
     * Retorna o valor do atributo codigo
     * @return int
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Atribui um valor ao atributo codigo
     * @param codigo int
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

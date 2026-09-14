package inimigo;

import personagem.*;

public class Inimigo {
    public String nome;
    public String tipo;
    public int vida;
    public int dano;
    
    public Inimigo( String nome, String tipo, int vida, int dano ) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.dano = dano; 
    }
    
    public void atacar(Personagem personagem) { 
        personagem.receberDano(dano);
        System.out.println( nome + " atacou " + personagem.nome + " causando " + dano + " de dano." );
    } 
    
    public boolean estaVivo() { return vida > 0; }
} 
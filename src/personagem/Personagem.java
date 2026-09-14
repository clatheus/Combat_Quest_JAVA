package personagem;

import java.util.ArrayList; 

import inimigo.*;
import item.*;

public class Personagem {
    public String nome; 
    public int vida; 
    public int ouro; 
    public ArrayList<Item> inventario = new ArrayList<>();
    
    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.ouro = 0; 
    }

    public void atacar(Inimigo inimigo) {
        inimigo.vida -= 10;
        System.out.println( nome + " atacou " + inimigo.nome + " causando 10 de dano." ); 
    }
    
    public void receberDano(int dano) { vida -= dano; }
    public void adicionarItem(Item item) { inventario.add(item); }

    public void mostrarStatus() {
        System.out.println("Personagem: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Ouro: " + ouro);
        System.out.println("Itens: " + inventario.size()); 
    } 
} 
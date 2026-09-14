package item;

/**
 * @brief Classe Item, elementos imutáveis que circulam entre inventários.
 * 
 * @author Julia de Medeiros Borba
 */

public class Item { 
    public String nome; 
    public String tipo;
    public int valor;
    
    public Item(String nome, String tipo, int valor) {
        this.nome = nome; 
        this.tipo = tipo; 
        this.valor = valor; 
    }
} 
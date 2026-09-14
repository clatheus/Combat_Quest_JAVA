package recompensa;

/**
 * @brief Classe da Recompensa, extensão da classe Item
 * 
 * @author Julia de Medeiros Borba
 */


import item.*;

public class Recompensa extends Item {
    private int id; /// ID que determina que missão forneceu o item

    /// Construtor Padrão
    public Recompensa(String descricao, TipoItem tipo, Raridade raridade, int valor, int id) {
        super(descricao, tipo, raridade, valor);
        this.id = id;
    }

    /// Getters
    public int getID() { return id; }
}
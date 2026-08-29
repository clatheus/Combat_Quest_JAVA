package inventario;

/**
 * @brief Classe Inventário, colecão que agrega itens e protege a capacidade máxima
 * 
 * @author Julia de Medeiros Borba
 */

import item.Item;
import java.util.List;
import java.util.ArrayList;

public class Inventario {
    /// Atributos do inventário
    private int capacidade = 3;                          /// Capacidade máxima do inventário
    private final List<Item> itens = new ArrayList<>();  /// ArrayList que guarda os itens do inventário

    /// Construtor padrão
    public Inventario(){
        this.addItem(new Item("Espada Padrão", Item.TipoItem.ARMA, Item.Raridade.COMUM, 0));
    }

    /**
     * Adiciona itens ao inventário
     * 
     * @param item O item a ser adicionado ao inventário
     * 
     * @return true se o item foi adicionado, false se o invetário está cheio
     */
    public boolean addItem(Item item) {
        if (itens.size() < capacidade) {
            return itens.add(item);
        }
        return false;
    }

    /**
     * Remove itens do inventário
     * 
     * @param idx O índice do item a ser removido do inventário
     */
    public void removeItem(int idx){
        itens.remove(idx);
    }

    /**
     * Aumenta a capacidade do inventário
     * 
     * @param plus Número pelo qual a capacidade do inventário vai expandir
     */
    public void addCapacidade(int plus)    { this.capacidade += plus;   }
    
    /// Getters
    public List<Item> getItens ()          { return List.copyOf(itens); }
    public int getCapacidade()             { return capacidade;         }

}
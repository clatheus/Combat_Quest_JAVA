package inventario;

import item.Item;
import java.util.List;
import java.util.ArrayList;

public class Inventario {
    private int capacidade = 3;
    private final List<Item> itens =
        new ArrayList<>();

    public Inventario(){
        this.addItem(new Item("Espada Padrão", Item.TipoItem.ARMA, Item.Raridade.COMUM, 0, 0, 0));
    }
    
    public List<Item> itens ()             {return List.copyOf(itens);}
    public int getCapacidade()             {return capacidade;        }
    public void addCapacidade(int plus)    {this.capacidade += plus;  }

    public boolean addItem(Item item) {
        if (itens.size() < capacidade) {
            return itens.add(item);
        }
        return false; // Inventário cheio
    }

    public void removeItem(int idx){
        itens.remove(idx);
    }
    
}

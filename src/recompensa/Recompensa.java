package recompensa;

import item.*;

public class Recompensa extends Item {
    private int id;

    public Recompensa(String descricao, TipoItem tipo, Raridade raridade, int valor, int id) {
        super(descricao, tipo, raridade, valor);
        this.id = id;
    }

    // Getters
    public int getID() { return id; }
}
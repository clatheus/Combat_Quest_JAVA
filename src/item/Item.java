package item;

public class Item {

    public enum Raridade {
        COMUM,
        RARO,
        EPICO
    }

    public enum TipoItem {
        ARMADURA,
        ARMA,
        CONSUMIVEL,
        CONSUMIVELUNICO,
        INVENTÁRIO,
        MOEDA
    }

    private String descricao;
    private final TipoItem tipo;
    private final Raridade raridade;
    private final int valor;

    public Item(String descricao, TipoItem tipo, Raridade raridade, int valor) {
    this.descricao = descricao;
    this.tipo = tipo;
    this.raridade = raridade;
    this.valor = valor;
    }
    
    // Getters
    public String   getDescricao() { return descricao; }
    public TipoItem getTipo()      { return tipo;      }
    public Raridade getRaridade()  { return raridade;  }
    public int      getValor()     { return valor;     }
}
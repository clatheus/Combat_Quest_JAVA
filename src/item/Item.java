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
    MOEDA
    }

    private String descricao;
    private TipoItem tipo;
    private Raridade raridade;
    private int energia;
    private int ataque;
    private int defesa;

    public Item(String descricao, TipoItem tipo, Raridade raridade, int energia, int ataque, int defesa) {
    this.descricao = descricao;
    this.tipo = tipo;
    this.raridade = raridade;
    this.energia = energia;
    this.ataque = ataque;
    this.defesa = defesa;
    }
    
    public String   getDescricao() { return descricao; }
    public TipoItem getTipo()      { return tipo;      }
    public Raridade getRaridade()  { return raridade;  }
    public int      getEnergia()   { return energia;   }
    public int      getAtaque()    { return ataque;    }
    public int      getDefesa()    { return defesa;    }
}
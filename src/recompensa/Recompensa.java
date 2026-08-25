package recompensa;

public final class Recompensa {
    private String descricao;
    private int energia;
    private int ataque;
    private int defesa;

    public Recompensa() {}

    public Recompensa(String descricao, int energia, int ataque, int defesa) {
    this.descricao = descricao;
    this.energia = energia;
    this.ataque = ataque;
    this.defesa = defesa;
    }
    
    public String getDescricao() { return descricao; }
    public int    getEnergia()   { return energia;   }
    public int    getAtaque()    { return ataque;    }
    public int    getDefesa()    { return defesa;    }
}
public class Recompensa {
    private final String descricao;
    private final int energia;
    private final int ataque;
    private final int defesa;

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
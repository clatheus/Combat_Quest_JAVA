public class Personagem {
    private int pontos = 0;
    private int energia_atual = 0;
    private int energia = 0;
    private int ataque = 0;
    private int defesa = 0;
    private int missoes_concluidas = 0;
    private String nome = "";

    Personagem(String n) {
        this.nome = n;
        this.energia = 5;
    }

    public void concluir_missao() {
        this.missoes_concluidas++;
    }

    public void morreu(){
        this.missoes_concluidas = -1;
    }

    public void ganhar_recompensa(Recompensa recomp) {
        this.energia += recomp.getEnergia();
        this.ataque += recomp.getAtaque();
        this.defesa += recomp.getDefesa();
    }

    // Getters 
    public int get_pontos() { return pontos; }
    public String get_nome() { return nome; }
    public int get_energia() { return energia; }
    public int get_ataque() { return ataque; }
    public int get_defesa() { return defesa; }
    public int get_missoes_concluidas() { return missoes_concluidas; }
}
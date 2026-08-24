public class Aventureiro {
    private int pontos = 0;
    private int energia_atual = 0;
    private int energia = 0;
    private int ataque = 0;
    private int defesa = 0;
    private int missoes_concluidas = 0;
    private String nome = "";

    Aventureiro(String n) {
        this.nome = n;
    }

    public void restaurar_vida(int cura) {
        energia_atual = Math.min(energia, energia_atual + cura);
    }

    public void restaurar_vida(boolean total){
        if (total){
            energia_atual = energia;
        }
    }

    public void sofrer_dano(int dano){
        energia_atual = Math.max(0, energia_atual - dano);
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
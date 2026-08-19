public final class Missão {
 private final String nome;
 private boolean morto;
 private int defesa;
 private int ataque;
 private int energia;
 private Recompensa recompensa;

 public Missão(String nome, int defesa, int ataque, int energia, Recompensa reward) {
   this.nome = nome;
   this.defesa = defesa;
   this.ataque = ataque;
   this.energia = energia;
   this.recompensa = reward;
   this.morto = false;
 }

 public void Levar_dano(int dano) {
    int danoreal = dano * (1 / this.defesa);

    this.energia -= danoreal;

    if (this.energia <= 0){
      this.morto = True;
    }
 }

 public String get_nome() { return nome; }
 public int get_energia() { return energia; }
 public int get_ataque() { return ataque; }
 public int get_defesa() { return defesa; }
 public boolean obito() { return morto; }
}
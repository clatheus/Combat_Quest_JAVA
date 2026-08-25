package missao;

import recompensa.Recompensa;

public final class Missao {
 private final String nome;
 private boolean morto;
 private int defesa;
 private int ataque;
 private int energia;
 private Recompensa recompensa;

 public Missao(String nome, int defesa, int ataque, int energia, Recompensa reward) {
   this.nome = nome;
   this.defesa = defesa;
   this.ataque = ataque;
   this.energia = energia;
   this.recompensa = reward;
   this.morto = false;
 }

 public void levar_dano(int dano) {
    double danoreal = dano * (10 / this.defesa);

    this.energia -= (int) danoreal;

    if (this.energia <= 0){
      this.morto = true;
    }
 }

 public String get_nome() { return nome; }
 public int get_energia() { return energia; }
 public int get_ataque() { return ataque; }
 public int get_defesa() { return defesa; }
 public boolean obito() { return morto; }
 public Recompensa get_Recompensa() { return  recompensa; }
}
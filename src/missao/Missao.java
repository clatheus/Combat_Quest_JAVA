package missao;

/**
 * @brief Classe da Missão, responsável por gerir os inimigos enfrentados pelo jogador e cuidar do estado do jogo
 * 
 * @author Annita Aquino Freitas
 */

import recompensa.Recompensa;

public final class Missao {
 /// Possiveis estados da missão.
 public enum Estado{
   NAO_INICIADA,
   EM_PROGRESSO,
   FUGA,
   CONCLUIDA,
   FALHA
 }

 private final String nome;         /// Nome do inimigo.
 private int defesa;                /// Atributo de defesa do inimigo.
 private int ataque;                /// Atributo de ataque do inimigo.
 private int energia;               /// Atributo de energia do inimigo.
 private Estado estado;             /// Controla o estado da missão.
 private Recompensa recompensa;     /// Recompensa a ser fornecida pelo inimigo.

 /// Construtor padrão
 public Missao(String nome, int defesa, int ataque, int energia, Recompensa reward) {
   this.nome = nome;
   this.defesa = defesa;
   this.ataque = ataque;
   this.energia = energia;
   this.recompensa = reward;
   this.estado = Estado.NAO_INICIADA;
 }

  /**
   * Dá dano ao inimigo baseado no ataque do personagem e na defesa do inimigo e evita
   * que o inimigo se cure.
   * 
   * @param dano O ataque do personagem
   */
 public void LevarDano(int dano) {
    if (dano <= 0 ){
      return;
    }

    double danoreal;

    if (this.defesa > 0 && this.defesa < 10){
      danoreal = dano * (10 / this.defesa);
    } else {
      danoreal = dano;
    }

    this.energia = Math.max(0, energia - (int) danoreal);

    if (this.energia <= 0){
      this.estado = Estado.CONCLUIDA;
    }
 }

 /// Mudanças de estado
 public void AceitarMissao()  { if (this.estado == Estado.NAO_INICIADA) { this.estado = Estado.EM_PROGRESSO; }}
 public void VitoriaInimiga() { if (this.estado == Estado.EM_PROGRESSO) { this.estado = Estado.FALHA;        }}
 public void Fugir()          { if (this.estado == Estado.EM_PROGRESSO) { this.estado = Estado.FUGA;         }}
 public void VitoriaJogador() { if (this.estado == Estado.EM_PROGRESSO) { this.estado = Estado.CONCLUIDA;    }}
 public void ResetaMissão()   { if (this.estado == Estado.FUGA)         { this.estado = Estado.NAO_INICIADA;  }}

 /// Getters
 public String getNome()           { return nome;                       }
 public int getEnergia()           { return energia;                    }
 public int getAtaque()            { return ataque;                     }
 public int getDefesa()            { return defesa;                     }
 public Estado getEstado()         { return estado;                     }
 public boolean Obito()            { return estado == Estado.CONCLUIDA; }
 public Recompensa getRecompensa() { return recompensa;                }
}
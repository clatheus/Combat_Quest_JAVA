package missao;

/**
 * @brief Classe da Missão, responsável por gerir os inimigos enfrentados pelo jogador e cuidar do estado do jogo
 * 
 * @author Annita Aquino Freitas
 */

import item.*;
import inimigo.*;
import personagem.Personagem;

public class Missao {
  public String titulo;
  public String descricao;
  public boolean concluida;
  public Inimigo alvo;
  public Item recompensa;
  public int ouroRecompensa;

  public Missao(String titulo, String descricao, Inimigo alvo, Item recompensa, int ouroRecompensa) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.alvo = alvo;
    this.recompensa = recompensa;
    this.ouroRecompensa = ouroRecompensa;
  }

  public void concluir(Personagem personagem) {
    concluida = true;
    personagem.ouro += ouroRecompensa;
    personagem.adicionarItem(recompensa);
    System.out.println("Missão concluída: " + titulo);
  }
}
import java.util.Scanner;

/**
 * @brief Programa principal, responsável por juntar todas as classes e atributos.
 * 
 * @author Matheus Lucheze Lopes
 */

import aventureiro.Aventureiro;
import item.Item;
import missao.Missao;
import missao.Missao.Estado;
import recompensa.Recompensa;

public class Main {

    /// Programa principal
    public static void main(String[] args) {
        Aventureiro p = new Aventureiro("Caipora");
        Scanner scanner_legal = new Scanner(System.in);

        p.restaurar_vida_total();

        System.out.println("=============== COMBAT QUEST ===============");
        System.out.println("Aventureiro: " + p.getNome());

        while (!p.morto() && p.getMissoesConcluidas() < 3) {
            p.restaurar_vida_total();
            Missao inimigoAtual = null;

            if (p.getMissoesConcluidas() == 0) {
                Recompensa rw = new Recompensa("Poção Pequena", Item.TipoItem.CONSUMIVELUNICO, Item.Raridade.COMUM, 100, 1);
                inimigoAtual = new Missao("Slime", 1, 2, 80, rw);
                loop_luta(p, inimigoAtual, scanner_legal);

            } else if (p.getMissoesConcluidas() == 1) {
                Recompensa rw = new Recompensa("Espada Sombria", Item.TipoItem.ARMA, Item.Raridade.RARO, 20, 2);
                inimigoAtual = new Missao("Goblin", 1, 5, 100, rw);
                loop_luta(p, inimigoAtual, scanner_legal);

            } else if (p.getMissoesConcluidas() == 2) {
                Recompensa rw = new Recompensa("Capa Carmesim", Item.TipoItem.ARMADURA, Item.Raridade.EPICO, 5, 3);
                inimigoAtual = new Missao("Vampiro", 2, 8, 350, rw);
                loop_luta(p, inimigoAtual, scanner_legal);
            }

            if (inimigoAtual.getEstado() == Estado.CONCLUIDA) {
                System.out.println("\nBoa " + p.getNome() + "! Você detonou nessa missão!");
                p.ganhar_recompensa(inimigoAtual.getRecompensa());
                p.concluir_missao();
            } else if (inimigoAtual.getEstado() == Estado.FALHA) {
                p.morreu();
                System.out.println("\nVocê foi derrotado(a)...");
                break;
            } else if (inimigoAtual.getEstado() == Estado.FUGA) {
                System.out.println("\nFugiu da batalha. Descanse um pouco antes de atacar novamente.");
                p.restaurar_vida_total();
            }

            inimigoAtual.ResetaMissão();
        }

        if (p.getMissoesConcluidas() == 3) {
            System.out.println("\nParabéns! Você é um(a) verdadeiro(a) guerreiro(a)!");
        } else {
            System.out.println("\nQue pena! Mais sorte próxima vez guerreiro(a).");
        }

        scanner_legal.close();
    }

    public static void loop_luta(Aventureiro p, Missao inimigo, Scanner scanner_legal) {
        System.out.println("\n============================================");
        System.out.println("Lute contra: " + inimigo.getNome());

        inimigo.AceitarMissao();

        while (inimigo.getEstado() == Estado.EM_PROGRESSO) {
            System.out.println("\n[Status " + p.getNome() + "] HP: " + p.getEnergia() + " | ATQ: " + p.getAtaque() + " | DEF: " + p.getDefesa());
            System.out.println("[Status " + inimigo.getNome() + "] HP: " + inimigo.getEnergia() + " | ATQ: " + inimigo.getAtaque());
            System.out.println("Escolha sua ação: ");
            System.out.println("1. Atacar");
            System.out.println("2. Fugir");

            String acao = scanner_legal.nextLine();

            if (acao.equals("1")) {
                int temp = calcula_dano(p.getAtaque(), inimigo.getDefesa());

                System.out.println("\n" + p.getNome() + " ataca!");
                System.out.println(p.getNome() + " causa " + temp + " de dano!");

                inimigo.LevarDano(p.getAtaque());

                if (inimigo.Obito()) {
                    inimigo.VitoriaJogador();
                    return;
                }

                temp = calcula_dano(inimigo.getAtaque(), p.getDefesa());

                System.out.println(inimigo.getNome() + " contra-ataca e causa " + temp + " de dano!");
                p.levar_dano(inimigo.getAtaque());

                if (p.morto()) {
                    inimigo.VitoriaInimiga();
                    return;
                }

            } else if (acao.equals("2")) {
                inimigo.Fugir();
                return;
            } else {
                System.out.println("Ação inválida! Você perdeu o turno.");

                int temp = calcula_dano(inimigo.getAtaque(), p.getDefesa());

                System.out.println(inimigo.getNome() + " ataca e causa " + temp + " de dano!");
                p.levar_dano(inimigo.getAtaque());

                if (p.morto()) {
                    inimigo.VitoriaInimiga();
                    return;
                }
            }
        }
    }

    public static int calcula_dano(int ataque, int defesa){
    double danoreal = ataque * (10 / defesa);

    return (int) danoreal;}
}



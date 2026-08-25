import java.util.Scanner;

import aventureiro.Aventureiro;
import item.Item;
import missao.Missao;
import recompensa.Recompensa;

public class Main {

    public static void main(String[] args) {
        Aventureiro p = new Aventureiro("Caipora");
        Scanner scanner_legal = new Scanner(System.in);

        p.restaurar_vida_total();

        System.out.println("=============== COMBAT QUEST ===============");
        System.out.println("Aventureiro: " + p.get_nome());

        while (!p.morto() && p.get_missoes_concluidas() < 3) {
            int resultado = -1;
            Missao inimigoAtual = null;

            if (p.get_missoes_concluidas() == 0) {
                Recompensa rw = new Recompensa("Poção Pequena", Item.TipoItem.CONSUMIVEL, Item.Raridade.COMUM, 10, 1);
                inimigoAtual = new Missao("Slime", 1, 2, 10, rw);
                resultado = loop_luta(p, inimigoAtual, scanner_legal);

            } else if (p.get_missoes_concluidas() == 1) {
                Recompensa rw = new Recompensa("Espada de Sombria", Item.TipoItem.ARMA, Item.Raridade.RARO, 10, 2);
                inimigoAtual = new Missao("Goblin", 2, 5, 20, rw);
                resultado = loop_luta(p, inimigoAtual, scanner_legal);

            } else if (p.get_missoes_concluidas() == 2) {
                Recompensa rw = new Recompensa("Capa Carmesim", Item.TipoItem.ARMADURA, Item.Raridade.EPICO, 5, 3);
                inimigoAtual = new Missao("Vampiro", 5, 10, 100, rw);
                resultado = loop_luta(p, inimigoAtual, scanner_legal);
            }

            if (resultado == 0) {
                System.out.println("\nBoa " + p.get_nome() + "! Você detonou nessa missão!");
                p.ganhar_recompensa(inimigoAtual.get_Recompensa());
                p.concluir_missao();
            } else if (resultado == 1) {
                p.morreu();
                System.out.println("\nVocê foi derrotado(a)...");
                break;
            } else if (resultado == 2) {
                System.out.println("\nFugiu da batalha. Descanse um pouco antes de atacar novamente.");
                p.restaurar_vida_total();
            }
        }

        if (p.get_missoes_concluidas() == 3) {
            System.out.println("\nParabéns! Você é um(a) verdadeiro(a) guerreiro(a)!");
        }

        scanner_legal.close();
    }

    public static int loop_luta(Aventureiro p, Missao inimigo, Scanner scanner_legal) {
        System.out.println("\n============================================");
        System.out.println("Lute contra: " + inimigo.get_nome());

        while (!inimigo.obito() && p.get_energia() > 0) {
            System.out.println("\n[Status " + p.get_nome() + "] HP: " + p.get_energia() + " | ATQ: " + p.get_ataque() + " | DEF: " + p.get_defesa());
            System.out.println("[Status " + inimigo.get_nome() + "] HP: " + inimigo.get_energia() + " | ATQ: " + inimigo.get_ataque());
            System.out.println("Escolha sua ação: ");
            System.out.println("1. Atacar");
            System.out.println("2. Fugir");

            String acao = scanner_legal.nextLine();

            if (acao.equals("1")) {
                System.out.println("\n" + p.get_nome() + " ataca!");
                inimigo.Levar_dano(p.get_ataque());

                if (inimigo.obito()) {
                    return 0;
                }

                System.out.println(inimigo.get_nome() + " contra-ataca e causa " + inimigo.get_ataque() + " de dano!");
                p.levar_dano(inimigo.get_ataque());

                if (p.get_energia() <= 0) {
                    return 1;
                }

            } else if (acao.equals("2")) {
                return 2;
            } else {
                System.out.println("Ação inválida! Você perdeu o turno.");
            }
        }

        return p.get_energia() > 0 ? 0 : 1;
    }
}
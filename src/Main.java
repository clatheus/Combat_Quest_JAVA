import java.util.Scanner;
import aventureiro.Aventureiro;
import missao.Missao;
import recompensa.Recompensa;

public class Main {
    public static int loop_luta(Aventureiro p, Missao m, Scanner scanner_legal){
        //retorna 0 se ganhar, 1 se perder e 2 se fugir
        p.restaurar_vida_total();

        while (!m.obito()){
            if (p.get_energia() <= 0){
                return 1;
            }

            char op = scanner_legal.next().charAt(0);

            // Se a -> ataque, r -> run, i -> acessa o inventario de consumiveis
            if (op == 'a' || op == 'A') {
                m.levar_dano( p.get_ataque() );
                p.levar_dano( m.get_ataque() );
            }
        }
        
        return 0;
    }

    public static void main(String[] Args) {
        Aventureiro p = new Aventureiro("Caipora");
        Scanner scanner_legal = new Scanner(System.in);

        while (!p.morto() && p.get_missoes_concluidas() != 3){
            int resultado = -1;
            Recompensa rw = new Recompensa();

            if (p.get_missoes_concluidas() == 0) {
                rw = new Recompensa("ha", 1, 1, 1);
                Missao inimigo1 = new Missao("Slime", 1, 2, 10, rw);

                resultado = loop_luta(p, inimigo1, scanner_legal);
            } else if (p.get_missoes_concluidas() == 1) {
                rw = new Recompensa("ha", 1, 1, 1);
                Missao inimigo2 = new Missao("Goblin", 2, 5, 40, rw);
                
            } else if (p.get_missoes_concluidas() == 2) {
                rw = new Recompensa("ha", 1, 1, 1);
                Missao inimigo3 = new Missao("Ogro", 4, 7, 100, rw);
            }

            if (resultado == 0){
                p.ganhar_recompensa(rw);
                p.concluir_missao();
            } else if (resultado == 1) {
                p.morreu();
            } else if (resultado == 2){
                //todo run method
            }
        }

    } 
}

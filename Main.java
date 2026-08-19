public class Main {
    public boolean loop_luta(Personagem p, Missao m, Scanner scanner_legal){
        while (!m.obito()){

        }
    }

    public static void main(String[] Args) {
        Personagem p = new Personagem("Caipora");
        Scanner scanner_legal = new Scanner(System.in);

        while (p.get_missoes_concluidas() != -1){
            boolean resultado;

            if (p.get_missoes_concluidas == 0){
                Recompensa rw = new Recompensa("ha", 1, 1, 1);
                Missao inimigo1 = new Missao("Slime", 1, 2, 10, rw);

                boolean resultado = loop_luta(p, inimigo1, scanner_legal);
            } else if (p.get_missoes_concluidas == 1) {
                Recompensa rw = new Recompensa("ha", 1, 1, 1)
                Missao inimigo2 = new Missao("Goblin", 1, 5, 40, rw)
                
            } else if (p.get_missoes_concluidas == 2) {
                Recompensa rw = new Recompensa("ha", 1, 1, 1)
                Missao inimigo3 = new Missao("Ogro", 1, 7, 100, rw)
            }

            if (resultado){
                p.concluir_missao();
            } else {
                p.morreu();
            }
        }

    } 
}

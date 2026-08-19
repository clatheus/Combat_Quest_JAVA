public class Main {
    public boolean loop_luta(Personagem p, Missão m){

    }

    public static void main(String[] Args) {
        Personagem p = new Personagem("Caipora");

        while (p.get_missoes_concluidas() != -1){
            if (p.get_missoes_concluidas == 0){
                Recompensa rw = new Recompensa("ha", 1, 1, 1)
                Missão inimigo1 = new Missão("Slime", 1, 2, 10, rw)

                //loop de pedir p atacar aqui  
            } else if (p.get_missoes_concluidas == 1) {
                Recompensa rw = new Recompensa("ha", 1, 1, 1)
                Missão inimigo2 = new Missão("Goblin", 1, 5, 40, rw)
                
            } else if (p.get_missoes_concluidas == 2) {
                Recompensa rw = new Recompensa("ha", 1, 1, 1)
                Missão inimigo3 = new Missão("Ogro", 1, 7, 100, rw)
            }
        }

    } 
}

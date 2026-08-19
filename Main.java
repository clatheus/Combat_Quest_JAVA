public class Main {
    public static void main(String[] Args) {
        Personagem p = new Personagem("Caipora");

        while (p.get_missoes_concluidas() != -1){
            if (p.get_missoes_concluidas == 0){
                Missão inimigo1 = new Missão("Slime", 1, 2, 10)
                //loop de pedir p atacar aqui  
            } else if (p.get_missoes_concluidas == 1) {
                Missão inimigo2 = new Missão("Goblin", 1, 5, 40)
                //loop de pedir p atacar
            } else if (p.get_missoes_concluidas == 2) {
                Missão inimigo3 = new Missão("Ogro", 1, 7, 100)
            }
        }

    } 
}

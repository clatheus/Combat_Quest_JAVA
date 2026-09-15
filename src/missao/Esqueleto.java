package missao;
import recompensa.*;

public class Esqueleto extends Missao {
    public Esqueleto(String nome, int defesa, int ataque, int energia, Recompensa reward) {
        super(nome, defesa, ataque, energia, reward);
    }

    @Override 
    public void mensagemDeAtaque() {
        System.out.println("O esqueleto maldito te perfura com uma flecha!");
    }
}

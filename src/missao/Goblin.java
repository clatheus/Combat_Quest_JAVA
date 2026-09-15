package missao;
import recompensa.Recompensa;

public class Goblin extends Missao {
    public Goblin(String nome, int defesa, int ataque, int energia, Recompensa reward) {
        super(nome, defesa, ataque, energia, reward);
    }

    @Override 
    public void atacarAventureiro() {
        System.out.println("O goblin ardiloso te atinge com uma adaga!");
    }
}

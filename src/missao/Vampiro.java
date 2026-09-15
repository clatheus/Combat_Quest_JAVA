package missao;
import recompensa.*;

public class Vampiro extends Missao {
    public Vampiro(String nome, int defesa, int ataque, int energia, Recompensa rw) {
        super(nome, defesa, ataque, energia, rw);
    }

    @Override 
    public void atacarAventureiro() {
        System.out.println("O vampiro sedento te da uma sugada!");
    }
}

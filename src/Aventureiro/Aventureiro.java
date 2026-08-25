package aventureiro;

import java.util.ArrayList;
import recompensa.Recompensa;
import item.*;
import missao.Missao;
import inventario.*;

public class Aventureiro {
    private int pontos = 0;
    private boolean morto = false;
    private int energia_maxima = 50;
    private int energia = 5;
    private int ataque = 2;
    private int defesa = 2;
    private int missoes_concluidas = 0;
    private String nome = "";
    private Inventario bolsa;
    private ArrayList<Missao> missoes = new ArrayList<>();

    public Aventureiro(String n) {
        nome = n;
        bolsa = new Inventario();
    }

    // Evita do aventureiro ter mais energia que a energia máxima limite.
    public void curar(int cura) {
        energia = Math.min(energia_maxima, energia + cura);
    }

    public void restaurar_vida_total(){
        energia = energia_maxima;
    }

    // Evita do aventureiro ficar com a energia negativa.
    public void levar_dano(int dano){
        energia = Math.max(0, energia - dano);
    }

    public void concluir_missao() {
        missoes_concluidas++;
    }

    public void morreu(){
        morto = true;
    }

    public void ganhar_recompensa(Recompensa recomp) {
        System.out.print("Parabéns! Você ganhou um(a)");
        System.out.print(recomp.getDescricao());
        System.out.print('\n');

        if (recomp.getTipo() == Item.TipoItem.CONSUMIVEL || recomp.getTipo() == Item.TipoItem.CONSUMIVELUNICO){
            System.out.print("HP ");
            System.out.print(energia);
            System.out.print(" -> ");
            energia += recomp.getValor();
            System.out.println(energia);
        }

        if (recomp.getTipo() == Item.TipoItem.ARMA){
            System.out.print("ATQ ");
            System.out.print(ataque);
            System.out.print(" -> ");
            ataque += recomp.getValor();
            System.out.println(ataque);
        }

        if (recomp.getTipo() == Item.TipoItem.ARMADURA){
            System.out.print("DEF ");
            System.out.print(defesa);
            System.out.print(" -> ");
            defesa += recomp.getValor();
            System.out.println(defesa);
        }
    }

    // Getters 
    public boolean morto() { return morto; }
    public int get_pontos() { return pontos; }
    public String get_nome() { return nome; }
    public int get_energia() { return energia; }
    public int get_ataque() { return ataque; }
    public int get_defesa() { return defesa; }
    public int get_missoes_concluidas() { return missoes_concluidas; }
}
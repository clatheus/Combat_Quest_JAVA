package aventureiro;

/**
 * @brief Classe Aventureiro, controla os atributos do personagem e compõe o próprio inventário.
 * 
 * @author Marcus Vinícius de Lima Souza
 */

import recompensa.Recompensa;
import item.*;
import inventario.*;

public class Aventureiro {
    /// Atributos padrão do aventureiro
    private boolean morto = false;          /// Determina se o aventureiro está vivo ou não
    private int energia_maxima = 50;        /// Energia máxima do aventureiro
    private int energia = 50;               /// Energia atual do aventureiro
    private int ataque = 2;                 /// Ataque do aventureiro
    private int defesa = 2;                 /// Defesa do aventureiro
    private int missoes_concluidas = 0;     /// Número de missões concluidas pelo aventureiro
    private String nome = "";               /// Nome do aventureiro
    private Inventario bolsa;               /// Inventário do aventureiro

    /// Construtor padrão
    public Aventureiro(String n) {
        nome = n;
        bolsa = new Inventario();
    }

    /**
     * Cura o aventureiro, evitando que o aventureiro tenha mais energia que a energia máxima limite
     * ou que leve dano.
     * 
     * @param cura O valor pelo qual o aventureiro vai ser curado
     */
    public void curar(int cura) {
        if (cura <= 0){
            return;
        }

        energia = Math.min(energia_maxima, energia + cura);
    }

    /// Cura o aventureiro para sua vida total
    public void restaurar_vida_total(){
        energia = energia_maxima;
    }

    /**
     * Dá dano ao aventureiro baseado em sua defesa, evitando que ele se cure ou que sua energia seja
     * um número negativo.
     * 
     * @param dano O valor de dano infligido pelo inimigo antes de ser calculado com a defesa.
     */
    public void levar_dano(int dano){
        if (dano <= 0){
            return;
        }

        double danoreal;

        if (defesa > 0 && defesa < 10){
            danoreal = dano * (10.0 / defesa);
        } else {
            danoreal = dano;
        }

        energia = Math.max(0, energia - (int) danoreal);

        if (energia == 0) { morreu(); }
    }

    /// Aumenta o número de missões concluidas
    public void concluir_missao() {
        missoes_concluidas++;
    }

    /// Muda morto para true se o personagem tiver morrido
    public void morreu(){
        morto = true;
    }

    /**
     * Atualiza os atributos do aventureiro e adiciona a recompensa ao inventário caso possivel.
     * 
     * @param recomp A recompensa a ser recebida.
     */
    public void ganhar_recompensa(Recompensa recomp) {
        System.out.print("Parabéns! Você ganhou um(a)");
        System.out.print(recomp.getDescricao());
        System.out.print('\n');

        if (recomp.getTipo() == Item.TipoItem.CONSUMIVEL || recomp.getTipo() == Item.TipoItem.CONSUMIVELUNICO){
            System.out.print("HP ");
            System.out.print(energia_maxima);
            System.out.print(" -> ");
            energia_maxima += recomp.getValor();
            System.out.println(energia_maxima);
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

        if (recomp.getTipo() == Item.TipoItem.CONSUMIVELUNICO){
            System.out.println("Você consumiu a/o " + recomp.getDescricao());
        } else {
            if (bolsa.addItem(recomp)){
                System.out.println(recomp.getDescricao() + " foi adicionado(a) ao seu inventário!");
            } else {
                System.out.println(recomp.getDescricao() + " não foi adicionado(a) ao seu inventário pois seu inventário está cheio!");
                System.out.println("Você ainda pode desfrutar das melhorias do item mesmo assim!");
            }
        }
    }

    // Getters 
    public boolean morto()             { return morto;              }
    public String getNome()            { return nome;               }
    public int getEnergia()            { return energia;            }
    public int getAtaque()             { return ataque;             }
    public int getDefesa()             { return defesa;             }
    public int getMissoesConcluidas()  { return missoes_concluidas; }
    public Inventario getInventario()  { return bolsa;              }
}
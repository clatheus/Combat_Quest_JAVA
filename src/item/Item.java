package item;

/**
 * @brief Classe Item, elementos imutáveis que circulam entre inventários.
 * 
 * @author Julia de Medeiros Borba
 */

public class Item {

    /// Possiveis raridades dos itens
    public enum Raridade {
        COMUM,
        RARO,
        EPICO
    }

    /// Tipos de item existentes
    public enum TipoItem {
        ARMADURA,           /// Aumenta a defesa do personagem
        ARMA,               /// Aumenta o ataque do personagem
        CONSUMIVEL,         /// Aumenta a energia atual do personagem, pode ser usado repetidamente
        CONSUMIVELUNICO,    /// Aumenta a energia máxima do personagem, pode ser usado apenas uma vez e não pode ser guardado
        INVENTÁRIO,         /// Aumenta a capacidade do inventário, pode ser usado apenas uma vez e não pode ser guardado
        MOEDA               /// Utilizado para troca, ainda não implementado no jogo
    }

    /// Atributos do item:
    private String descricao;           /// Descrição do item
    private final TipoItem tipo;        /// Tipo do item
    private final Raridade raridade;    /// Raridade do item
    private final int valor;            /// Int valor, que vai mudar de significado de acordo com o tipo do item

    /// Construtor padrão
    public Item(String descricao, TipoItem tipo, Raridade raridade, int valor) {
    this.descricao = descricao;
    this.tipo = tipo;
    this.raridade = raridade;
    this.valor = valor;
    }
    
    // Getters
    public String   getDescricao() { return descricao; }
    public TipoItem getTipo()      { return tipo;      }
    public Raridade getRaridade()  { return raridade;  }
    public int      getValor()     { return valor;     }
}
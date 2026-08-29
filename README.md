# Introdução
Esse projeto é uma implementação de um jogo simples de aventura chamado "Combat Quest", feito inteiramente em java e pelos integrantes deste grupo, sem a utilização de bibliotecas externas.

# Autores e Divisão

## Annita Aquino Freitas
### Classes:
Missão e Inventário
### Responsabilidades:
Desenvolvimento da lógica de controle de estado das missões e do gerenciamento do inventário do jogador.
### Conceitos de OO Aplicados:
Enum (Estado): Criado para gerenciar o ciclo de vida e a situação da missão (NAO_INICIADA, EM_PROGRESSO, FUGA, CONCLUIDA, FALHA).
Agregação: Implementada na classe Inventario por meio da coleção List<Item>, permitindo armazenar e gerenciar itens sem destruir a existência lógica do item em si.
Encapsulamento e Validação: Proteção contra capacidade excedida no inventário (addItem) e manipulação de estado interna.

## Julia de Medeiros Borba
### Classes:
Item e Recompensa.
### Responsabilidades:
Modelagem da hierarquia de itens e recompensas do jogo, além da padronização e documentação técnica de todo o código.
### Conceitos de OO Aplicados:
Herança: A classe Recompensa estende a classe base Item (extends Item), reaproveitando todos os seus atributos e adicionando o identificador próprio (id). 
Enums (TipoItem e Raridade): Definidos para categorizar os tipos de equipamentos/consumíveis e as raridades existentes no jogo.
Documentação (Doxygen): Inclusão de tags como @brief, @param e @author em todas as classes para geração de documentação técnica formal.

## Marcus Vinícius de Lima Souza
### Classes:
Aventureiro
### Responsabilidades:
Implementação da classe principal do jogador, responsável por gerenciar vida, combate, atributos de status e progressão.
### Conceitos de OO Aplicados:
Composição: O Aventureiro cria e possui de forma direta a sua própria instância de Inventario (bolsa = new Inventario()), atrelando o tempo de vida do inventário ao próprio personagem. 
Associação: Interação com a classe Recompensa através do método ganhar_recompensa(), atualizando dinamicamente os atributos de ataque, defesa e vida.
Alteração de Estado e Sobrecarga: Métodos dedicados para manipular a vida e o status do personagem (curar(), restaurar_vida_total(), levar_dano()) com validações de limites mínimos e máximos. 

## Matheus Lucheze Lopes
### Classes:
Main
### Responsabilidades:
Construção da interface via console, controle do loop de combate e integração de todas as partes do sistema.
### Conceitos de OO Aplicados:
Integração do Domínio OO: Demonstração prática do uso de associação entre Aventureiro, Missao e Recompensa durante a execução da aventura solo. 
Métodos Auxiliares Estáticos: Implementação de loop_luta() e calcula_dano() para orquestrar os turnos de combate e atualizar os estados dos objetos em tempo real. 

# Link para o projeto
Você pode acessar diretamente o repositório deste projeto no GitHub clicando [aqui!](https://github.com/clatheus/Combat_Quest_JAVA)
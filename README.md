# 🏢 Sistema de Locação de Veículos - Car Rental Control

## 🎯 O que o projeto faz?

O sistema simula um módulo automatizado para gerenciamento e controle de locação de veículos. O operador registra inicialmente os metadados do veículo corporativo (**Modelo**, **Placa** e **Preço da Diária**). Em seguida, a aplicação abre um menu interativo que permite **exibir de forma formatada os detalhes e status atual do carro**, realizar a **simulação financeira do valor total de aluguel por dias de permanência**, e **confirmar a locação em tempo real** modificando de forma segura o estado interno do objeto para impedir duplicidade de aluguel.

### 🔄 Fluxo da Aplicação
```text
[ Registro do Veículo ] ➔ [ Menu de Opções ] ➔ [ Exibição de Dados / Simulação / Locação Direta ] ➔ [ Atualização de Estado ]
```

---

## 🎨 Design do Código (Como as classes conversam)

Este projeto foi construído utilizando os pilares da **Orientação a Objetos (POO)** e o conceito de **Encapsulamento**. A lógica de negócios é gerenciada por uma máquina de estados baseada em um menu `while` e estrutura de seleção `switch-case` na classe principal, enquanto a modelagem e persistência de dados ficam isoladas de forma privada na classe de entidade. Veja a arquitetura limpa do fluxo:

```text
       ┌────────────────────────┐
       │   main.java (Control)  │ (Lê entradas do terminal e despacha comandos)
       └───────────┬────────────┘
                   │
                   ▼ (Instanciação de Objeto)
       ┌────────────────────────┐
       │   Carro.java (Entity)  │ (Encapsula Atributos: modelo, placa, precoDiaria, alugado)
       └───────────┬────────────┘
                   │
         ┌─────────┴─────────┬─────────────────┐
         ▼                   ▼                 ▼
   [Exibir Detalhes]  [Simular Aluguel]  [Confirmar Locação]
   (Usa toString())  (calcularAluguel())  (alugarCarro() altera state)
```

### 📋 Mapeamento de Classes e Métodos

| Classe / Método | O que ela faz no código? |
| :--- | :--- |
| 🚀 `main.java` | É a classe controladora. Gerencia a interface via console do usuário, o menu dinâmico e invoca os métodos da entidade. |
| 🚗 `Carro.java` | É a classe de entidade. Representa o molde abstrato do veículo, protegendo os atributos com modificadores de acesso `private`. |
| ⚙️ `alugarCarro()` | Método booleano que valida o status interno do veículo. Altera o estado para `true` apenas se o carro estiver disponível. |
| 🧮 `calcularAluguel()` | Método matemático que recebe a quantidade de dias informada no terminal e calcula o custo com base no preço da diária. |
| 📝 `toString()` | Sobrescrita do método padrão para renderizar uma ficha resumida contendo o layout formatado do veículo e seu status técnico. |

---

## 🧠 Conceitos de Programação Praticados

* **Paradigma de Orientação a Objetos (POO):** Criação e instanciação de objetos reais na memória a partir de uma classe construtora personalizada, superando o uso de variáveis soltas.
* **Princípio do Encapsulamento:** Uso de atributos privados combinados com métodos acessores (`Getters` e `Setters`) para controlar e restringir de forma segura como os dados externos alteram o objeto.
* **Máquina de Estados de Objeto:** Alteração dinâmica e persistente de um comportamento primitivo (`boolean alugado`), que passa a ditar a resposta lógica de outros blocos do sistema após ser modificado.

---

## 💻 Exemplo Prático de Uso

Imagine a seguinte simulação de um veículo sendo cadastrado, simulado para locação e alugado diretamente pelo console:

```text
========== Alguel de Carro ===========
Qual o modelo do carro: 
Civic Sport
Qual a placa do carro: 
BRA2E19
Qual o preço da diária desse veículo: 
150.00

Opção 1 - Exibir Detalhes 
Opção 2 - Simular Aluguel 
Opção 3 - Confirmar Locação 
Opção 4 - Sair do programa
Escolha uma opção: 1
Modelo: Civic Sport | Placa: BRA2E19 | Diária: 150.00 | Status: Disponível

Opção 1 - Exibir Detalhes 
Opção 2 - Simular Aluguel 
Opção 3 - Confirmar Locação 
Opção 4 - Sair do programa
Escolha uma opção: 2
Quantos dias a pessoa quer alugar? 
5
Valor total do aluguel: R\$ 750.00

Opção 1 - Exibir Detalhes 
Opção 2 - Simular Aluguel 
Opção 3 - Confirmar Locação 
Opção 4 - Sair do programa
Escolha uma opção: 3
✅ Carro alugado com sucesso!

Opção 1 - Exibir Detalhes 
Opção 2 - Simular Aluguel 
Opção 3 - Confirmar Locação 
Opção 4 - Sair do programa
Escolha uma opção: 1
Modelo: Civic Sport | Placa: BRA2E19 | Diária: 150.00 | Status: Alugado

Opção 1 - Exibir Detalhes 
Opção 2 - Simular Aluguel 
Opção 3 - Confirmar Locação 
Opção 4 - Sair do programa
Escolha uma opção: 4
Saindo do sistema...
```

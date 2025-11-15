# 📊 **Questão 1 — Sistema de Cálculo de Risco (Strategy Pattern)**

## 📌 **Descrição da Questão**

O objetivo é desenvolver um sistema para uma empresa financeira que realiza diferentes tipos de análise de risco.  
Os algoritmos utilizados — *Value at Risk (VaR)*, *Expected Shortfall (ES)* e *Stress Testing* — devem:

- Ser **intercambiáveis em tempo de execução**
- Compartilhar um **contexto financeiro complexo**
- Ser selecionáveis **sem que o cliente conheça seus detalhes internos**
- Permitir **extensibilidade** (novos algoritmos podem ser adicionados)

O foco da questão é aplicar corretamente **Design Patterns** e **Princípios SOLID**.

---

# 🧠 **Padrão Utilizado: Strategy**

Para resolver o problema, foi aplicado o **Strategy Pattern**, cujo objetivo principal é:

> “Definir uma família de algoritmos, encapsulá-los individualmente e torná-los intercambiáveis.”

Essa descrição se encaixa *exatamente* no problema proposto.

### ✔️ **Por que o Strategy é o padrão ideal para este caso?**

- Permite trocar o algoritmo de risco **em tempo de execução**  
- Desacopla o cliente (`RiskCalculator`) das implementações concretas  
- Facilita a inclusão de novos algoritmos sem alterar código existente (**OCP**)  
- Encapsula variações do comportamento (cada cálculo de risco) em classes próprias  
- Permite compartilhar o mesmo contexto (`RiskContext`) entre todas as estratégias  
- Mantém o código organizado, testável e extensível  

---

# 🧩 **Arquitetura Implementada**

A estrutura foi organizada em pastas para maior clareza:

```
src/
 ├── App.java
 ├── core/
 │    ├── RiskContext.java
 │    ├── RiskCalculator.java
 │    └── RiskAlgorithmType.java
 └── strategies/
      ├── RiskCalculationStrategy.java
      ├── VarRiskStrategy.java
      ├── ExpectedShortfallStrategy.java
      ├── StressTestingStrategy.java
      └── RiskStrategyFactory.java
```

---

# 🧱 **Aplicação dos Princípios SOLID**

### ✔ **S — Single Responsibility (SRP)**  
Cada classe possui um único motivo para mudar.

### ✔ **O — Open/Closed (OCP)**  
Novos algoritmos podem ser adicionados sem alterar código existente.

### ✔ **L — Liskov Substitution (LSP)**  
Todas as estratégias podem substituir umas às outras.

### ✔ **I — Interface Segregation (ISP)**  
Interface enxuta e específica.

### ✔ **D — Dependency Inversion (DIP)**  
O cliente depende de abstrações e não de implementações concretas.

---

# ⚙️ **Como Executar**

No VSCode:

1. Abra a pasta raiz do projeto.  
2. Abra `src/App.java`.  
3. Execute com **Run Java** ou `Ctrl + F5`.

---

# 📌 **Saída Esperada no Console**

```
[VaR] Estimated Value at Risk: 14249.78
[ES] Expected Shortfall: 17100.00
[Stress Testing] Portfolio under stress: 700000.00
```

---

# 🏁 **Conclusão**

A aplicação do **Strategy Pattern** atendeu perfeitamente aos requisitos, garantindo:

- Flexibilidade  
- Extensibilidade  
- Baixo acoplamento  
- Arquitetura limpa e profissional  


# 📘 Projeto — Avaliação Bimestral de Padrões de Projeto (Design Patterns)

Este repositório contém as implementações completas das quatro questões da **Avaliação Prática – 2º Bimestre**, aplicando múltiplos **Padrões de Projeto (Design Patterns)**, princípios **SOLID**, arquitetura limpa e boas práticas de engenharia de software.

Cada questão foi desenvolvida com:
- Estrutura organizada em pacotes
- README individual (nas pastas de cada questão)
- Explicações detalhadas sobre o padrão usado
- Código funcional em Java
- Abordagem profissional e extensível

---

# 🧩 **Questão 1 — Strategy Pattern (Cálculo de Risco Financeiro)**

### 🎯 Objetivo
Desenvolver um sistema capaz de alternar, em tempo de execução, entre diferentes algoritmos de cálculo de risco financeiro:
- Value at Risk (VaR)
- Expected Shortfall (ES)
- Stress Testing

### 🧠 Padrão Utilizado: **Strategy**
Foi utilizado o **Strategy Pattern** porque:
- Permite alternância dinâmica entre algoritmos
- Evita condicionais extensas
- Separa regras de cálculo em classes independentes
- Facilita extensões futuras

### 🏗 Pontos importantes:
- `RiskContext` compartilhado entre estratégias  
- `RiskCalculator` desacoplado das implementações  
- `RiskStrategyFactory` para criação estruturada  
- Código aderente ao SRP, OCP e DIP  

---

# 🧩 **Questão 2 — Adapter Pattern (Integração com Sistema Bancário Legado)**

### 🎯 Objetivo
Conectar um sistema moderno de processamento de transações com uma API bancária legada baseada em:
- `HashMap<String, Object>`
- Codificação especial de moeda (USD=1, EUR=2, BRL=3)
- Campos obrigatórios inexistentes na interface moderna

### 🧠 Padrão Utilizado: **Adapter (Bidirecional)**
Permite converter:
- Formato moderno → legado  
- Formato legado → moderno  

### 🏗 Pontos importantes:
- Suporte a "campos obrigatórios" adicionados dinamicamente  
- Conversão numérica de moedas  
- Cliente totalmente desacoplado do legado  
- Arquitetura segura e extensível  

---

# 🧩 **Questão 3 — State Pattern (Controle de Usina Nuclear)**

### 🎯 Objetivo
Modelar os estados de uma usina nuclear:
- DESLIGADA  
- OPERACAO_NORMAL  
- ALERTA_AMARELO  
- ALERTA_VERMELHO  
- EMERGENCIA  
- MANUTENCAO  

Com regras rígidas de transição, como:
- ALERTA_AMARELO → ALERTA_VERMELHO somente após 30s de perigo  
- EMERGENCIA somente depois de ALERTA_VERMELHO  
- Estados unidirecionais e bidirecionais  
- Prevenção de looping perigoso  
- Modo de MANUTENÇÃO sobreescrevendo transições  

### 🧠 Padrão Utilizado: **State**
Cada estado possui:
- Lógica própria
- Validações específicas
- Controle explícito de transições

### 🏗 Pontos importantes:
- Maquinário crítico modelado com segurança  
- Código organizado e aderente a SRP, OCP e LSP  
- Simulação realista de funcionamento de reator  

---

# 🧩 **Questão 4 — Chain of Responsibility + Circuit Breaker + Rollback**

### 🎯 Objetivo
Validar uma NF-e aplicando múltiplas validações:
1. XML contra XSD  
2. Certificado Digital  
3. Regras Fiscais  
4. Banco de Dados (duplicidade + rollback)  
5. Consulta SEFAZ  

Com requisitos adicionais:
- Execução condicional (3 e 5 só executam se anteriores passarem)
- Circuit Breaker após 3 falhas
- Timeout por validador
- Rollback para operações realizadas por validadores intermediários

### 🧠 Padrão Utilizado: **Chain of Responsibility**
- Encadeamento claro entre validadores
- Fluxo flexível e expansível

### 🛡 Recursos Avançados:
- Circuit Breaker p/ proteger o sistema
- Rollback reverso das operações
- Controle total de fluxo
- Monitoramento por contexto

---

# 📁 Estrutura Geral do Repositório

```
/questao1
/questao2
/questao3
/questao4
README.md 
```

Cada questão contém:
- Código-fonte  
- README individual  
- Justificativa do padrão  
- Explicações do funcionamento  

---

# 🧠 Tecnologias e Práticas Utilizadas

- Java (VSCode / JDK 17+)  
- Padrões de Projeto (GoF)  
- Princípios SOLID  
- Arquitetura modular  
- Simulações realistas  
- Tratamento de exceções, fallback e transições seguras  

---

# 🎓 Conclusão

Este projeto demonstra domínio sólido de:
- Padrões de projeto clássicos  
- Arquitetura orientada a objetos  
- Aplicação prática de SOLID  
- Integração com sistemas legados e críticos  
- Implementação de fluxos complexos  

Cada questão foi construída como um **sistema realista**, modular e extensível — adequado a contexto profissional e acadêmico.

---


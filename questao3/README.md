# ☢️ Questão 3 — Sistema de Controle de Usina Nuclear (State Pattern)

## 📌 Descrição Geral

Nesta questão, foi solicitado o desenvolvimento de um **sistema de controle de estados de uma usina nuclear**, com regras complexas de transição e condições de segurança rigorosas.  
O sistema deve ser capaz de representar vários estados operacionais e garantir que transições perigosas não ocorram.

Os estados possíveis são:

- **DESLIGADA**
- **OPERACAO_NORMAL**
- **ALERTA_AMARELO**
- **ALERTA_VERMELHO**
- **EMERGENCIA**
- **MANUTENCAO** (modo especial)

---

# 🧠 Padrão de Projeto Utilizado: STATE

O **State Pattern** foi aplicado porque o problema exige:

- Comportamentos diferentes para cada estado  
- Regras específicas de transição  
- Prevenção de transições inválidas  
- Evolução independente dos estados  
- Extensibilidade e manutenção facilitada  

Cada estado possui sua **própria classe**, com lógica interna isolada.  
Isso evita estruturas condicionais gigantescas (ex: `if`, `switch`) no código principal.

---

# 🧩 Estrutura de Arquitetura

```
src/
 ├── App.java
 ├── core/
 │     ├── NuclearReactor.java
 │     ├── ReactorState.java
 │     ├── ReactorData.java
 │     ├── StateType.java
 │     └── MaintenanceMode.java
 └── states/
       ├── EstadoDesligado.java
       ├── EstadoOperacaoNormal.java
       ├── EstadoAlertaAmarelo.java
       ├── EstadoAlertaVermelho.java
       └── EstadoEmergencia.java
```

---

# 🔍 Regras e Funcionamento

As regras implementadas são:

### ▶ **1. OPERACAO_NORMAL → ALERTA_AMARELO**
- Quando **temperatura > 300°C**

### ▶ **2. ALERTA_AMARELO → ALERTA_VERMELHO**
- Quando **temperatura > 400°C**  
- Por **mais de 30 segundos**

### ▶ **3. ALERTA_VERMELHO → EMERGENCIA**
- Quando **sistema de resfriamento falhar**

### ▶ **4. EMERGENCIA só ocorre se antes houve ALERTA_VERMELHO**
- Risco crítico de segurança  
- Evita transições diretas indevidas

### ▶ **5. Modo MANUTENÇÃO**
- Sobrescreve temporariamente qualquer estado normal  
- Impede transições normais enquanto ativo  
- Simula inspeções e intervenções humanas

---

# 🧱 Aplicação dos Princípios SOLID

### ✔ SRP  
Cada estado tem uma responsabilidade: gerenciar sua própria lógica.

### ✔ OCP  
É possível adicionar novos estados sem alterar os existentes.

### ✔ LSP  
Qualquer estado pode substituir outro desde que siga a interface base.

### ✔ ISP  
A interface `ReactorState` é enxuta e específica.

### ✔ DIP  
O reator depende de abstrações (State), não de implementações concretas.

---

# 🖥️ Exemplo de Execução

Simulação gerada pelo `App.java`:

```
Estado atual: DESLIGADA
Ligando para operação normal...
Estado atual: OPERACAO_NORMAL
Estado atual: ALERTA_AMARELO
Estado atual: ALERTA_VERMELHO
Estado atual: EMERGENCIA
🚨 REATOR EM EMERGÊNCIA! PROCEDIMENTOS IMEDIATOS NECESSÁRIOS!
```

---

# 🚀 Conclusão

O uso do **State Pattern** permitiu:

- Modelar fielmente o comportamento complexo da usina  
- Isolar regras de cada estado  
- Prevenir transições perigosas  
- Facilitar manutenção e extensões futuras  
- Criar um sistema robusto, seguro e modular  

Essa abordagem é usada frequentemente em sistemas críticos (ex.: aviação, energia nuclear), onde **falhas de transição podem resultar em danos severos**.

---

# 📎 Autor  
Implementação orientada a padrões de projeto, engenharia de software e sistemas críticos.

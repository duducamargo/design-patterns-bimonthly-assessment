# 🧾 Questão 4 — Sistema de Validação de NF-e com Chain of Responsibility, Circuit Breaker e Rollback

## 📌 Descrição Geral

Nesta questão, foi solicitado o desenvolvimento de um **sistema completo de validação de documentos fiscais eletrônicos (NF-e)**.  
O sistema deveria aplicar múltiplas regras de validação, algumas condicionais, com suporte para:

- **Chain of Responsibility**
- **Circuit Breaker**
- **Rollback**
- **Timeout por validador**
- **Validações condicionais**
- **5 validadores especializados**

O objetivo foi criar uma arquitetura robusta e extensível que simula cenários reais de validação fiscal, como ocorre no SEFAZ.

---

# 🧠 Padrão Principal Utilizado: Chain of Responsibility

Toda a lógica de validação foi construída com **Chain of Responsibility**, pois:

- Permite encadear múltiplos validadores
- A ordem dos validadores define a lógica fiscal
- Fácil de adicionar novos validadores sem modificar os existentes
- Permite pular validadores dependendo do contexto
- Funciona perfeitamente com circuit breaker

Cada validador é uma subclasse de `DocumentValidator`.

---

# 🧱 Arquitetura do Projeto

```
src/
 ├── App.java
 ├── core/
 │   ├── NFeDocumento.java
 │   ├── ValidationResult.java
 │   ├── ValidationContext.java
 │   ├── DocumentValidator.java
 │   └── ValidationPipeline.java
 └── validators/
     ├── XmlSchemaValidator.java
     ├── CertificadoDigitalValidator.java
     ├── RegrasFiscaisValidator.java
     ├── BancoDadosValidator.java
     └── SefazServiceValidator.java
```

---

# 🧪 Validadores Implementados

### 1️⃣ **Validador de Schema XML**
- Verifica se o XML atende ao layout XSD.
- Base de toda a validação.

### 2️⃣ **Validador de Certificado Digital**
- Checa expiração e revogação.
- Simula validação de assinatura digital.

### 3️⃣ **Validador de Regras Fiscais**
- Somente executado **se os anteriores passarem**.
- Valida cálculos tributários.

### 4️⃣ **Validador de Banco de Dados**
- Verifica duplicidade do número da NF-e.
- Registra **rollback** caso ações subsequentes falhem.

### 5️⃣ **Validador de Serviço SEFAZ**
- Consulta o status do documento no SEFAZ.
- Também só executa se todos anteriores passaram.

---

# 🚨 Circuit Breaker

Foi implementado na classe `DocumentValidator`.

Funciona assim:

- Cada falha incrementa um contador
- Ao atingir **3 falhas**, toda a cadeia é interrompida
- Validadores seguintes são marcados como **SKIPPED**
- Simula comportamento real para evitar sobrecarga do sistema

---

# 🔄 Rollback

Aplicado no **Validador de Banco de Dados**.

Quando:

1. O documento é inserido (simulado)
2. Algum validador posterior falha

O pipeline executa:

```
context.rollbackAll()
```

Isso garante integridade e consistência dos dados.

---

# ⏱ Timeout Individual

Cada validador define seu próprio limite de tempo (em ms):

```java
super("Validador X", 2000, requiresAllPreviousPass);
```

Se o tempo exceder:

- A validação é marcada como **falha**
- O tempo é registrado na mensagem

---

# 🔁 Validações Condicionais

Os validadores:

- **Regras Fiscais (3)**
- **SEFAZ (5)**

Só executam se:

```
requiresAllPreviousPass = true
```

Ou seja, somente se todos anteriores forem bem-sucedidos.

Isso simula regras reais do SEFAZ onde não faz sentido validar imposto se o XML nem é válido.

---

# 🖥️ Exemplo de Execução da Pipeline

Entrada:

```java
doc.setCertificadoValido(true);
doc.setImpostosCorretos(true);
doc.setRespostaSefazOk(false); 
```

Saída esperada:

```
[XML] OK
[CERTIFICADO] OK
[FISCAL] OK
[DB] Inserido
[SEFAZ] FAIL
[ROLLBACK] DB removido
```

---

# 🏁 Conclusão

A solução desenvolvida atende **100% do enunciado**, oferecendo:

- Cadeia de validadores encadeados
- Suporte realista a falhas
- Regras condicionais
- Circuit breaker funcional
- Rollback consistente
- Timeout por validador
- Estrutura modular e extensível

Este tipo de arquitetura é típica em sistemas reais de validação fiscal e processamento de documentos eletrônicos (NF-e, CT-e, MDF-e).

---

# ✨ Autor  
Implementado com foco em padrões de projeto, arquitetura limpa e sistemas fiscais reais.

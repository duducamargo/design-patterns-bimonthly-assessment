# 🏦 Questão 2 — Integração com Sistema Bancário Legado (Adapter Pattern)

## 📌 Descrição do Problema

Sua empresa precisa integrar um sistema moderno de processamento de transações com um **sistema bancário legado**, cuja interface é complexa e antiquada.

O objetivo é converter chamadas da interface moderna:

```
autorizar(String cartao, double valor, String moeda)
```

para o formato aceito pelo sistema legado:

```
processarTransacao(HashMap<String, Object> parametros)
```

Além disso:

- O legado possui **campo obrigatório** (`canal`) que não existe na interface moderna.
- O legado utiliza **códigos numéricos para moedas** (USD=1, EUR=2, BRL=3).
- É necessário implementar integração **bidirecional**, convertendo respostas do legado para o formato moderno.

---

# 🎯 Objetivo

Construir um **Adapter bidirecional** que faça a ponte entre o sistema moderno e o legado, permitindo chamadas compatíveis sem alterar o código do legado.

---

# 🧠 Padrão Utilizado: Adapter Pattern

O **Adapter** foi utilizado para:

- Converter interfaces incompatíveis.
- Permitir que o sistema moderno utilize o legado **sem conhecer seus detalhes internos**.
- Adicionar campos obrigatórios exigidos pelo legado.
- Converter respostas do legado para o modelo moderno.
- Preservar o legado sem modificações (importante em sistemas bancários reais).

---

# 🧩 Arquitetura do Projeto

```
src/
 ├── App.java
 ├── moderno/
 │    ├── ProcessadorTransacoes.java
 │    └── RespostaTransacao.java
 ├── legado/
 │    ├── SistemaBancarioLegado.java
 │    └── RespostaLegada.java
 └── adapter/
      └── ProcessadorTransacoesAdapter.java
```

---

# 🧱 Aplicação dos Princípios SOLID

### ✔ SRP — Single Responsibility
Cada classe tem uma responsabilidade clara:
- O adapter converte chamadas.
- O legado processa.
- O moderno define a interface do cliente.

### ✔ OCP — Open/Closed
Podemos adicionar novos conversores ou novos sistemas legados sem modificar os atuais.

### ✔ LSP — Liskov Substitution
O adapter é totalmente intercambiável com qualquer implementação moderna.

### ✔ ISP — Interface Segregation
A interface moderna é limpa, sem dependências de detalhes legados.

### ✔ DIP — Dependency Inversion
O código moderno depende de **abstrações**, não de implementações concretas.

---

# 🔄 Funcionamento do Adapter

## Moderno → Legado

O método moderno:

```
autorizar(cartao, valor, moeda)
```

é convertido em:

```
HashMap
└── cartao
└── valor
└── moeda (convertida para código numérico)
└── canal (campo obrigatório do legado)
```

## Legado → Moderno

O retorno:

```
RespostaLegada{sucesso, codigo, mensagem}
```

é convertido para:

```
RespostaTransacao{sucesso, codigoAutorizacao, mensagem}
```

---

# 🌐 Conversão de moedas para o legado

| Moeda | Código |
|-------|--------|
| USD   | 1      |
| EUR   | 2      |
| BRL   | 3      |
| Outro | 0      |

---

# 🖥️ Exemplo de Execução

### Entrada (moderna):

```
autorizar("1234-5678-9999-0000", 2500.00, "USD");
```

### Saída esperada:

```
[LEGADO] Processando com parâmetros: {cartao=1234..., valor=2500.0, moeda=1, canal=E-COMMERCE}
Resposta (moderna): RespostaTransacao{sucesso=true, codigoAutorizacao='a13b9c42', mensagem='Transação aprovada.'}
```

### Quando o valor excede o limite:

```
Resposta (moderna): RespostaTransacao{sucesso=false, codigoAutorizacao='null', mensagem='Transação recusada: valor acima do limite.'}
```

---

# 🚀 Conclusão

A solução utiliza corretamente o **Adapter Pattern** para:

- Unificar duas interfaces incompatíveis.
- Proteger o sistema moderno de detalhes do legado.
- Incluir campos obrigatórios e regras específicas (como códigos de moeda).
- Transformar respostas em ambos os sentidos.

O design é limpo, extensível, aderente ao SOLID e adequado para cenários reais de integração bancária.

---

# 📎 Autor
Implementado com foco em padrões de projeto e integração corporativa.

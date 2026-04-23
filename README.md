# Validador de Senhas

Um projeto simples em Java que demonstra uma abordagem limpa e moderna para a validação de senhas, evitando a complexidade e a poluição visual de múltiplos blocos `if` aninhados ou sequenciais.

## 🚀 O Problema

Muitas vezes, algoritmos de validação de dados (como senhas) acabam se tornando extensos e difíceis de manter devido ao uso excessivo de condições `if`:

```java
// Exemplo de código clássico, porém difícil de manter:
if (senha.length() < 8) { return "Erro..."; }
if (!senha.matches(".*\\d.*")) { return "Erro..."; }
// ... e assim por diante.
```

## 💡 A Solução

Este projeto utiliza os recursos da **Stream API do Java 8+**, **Lambdas (`java.util.function.Predicate`)** e **Records (Java 14+)** para criar um mecanismo de validação declarativo e extensível.

### Arquitetura

1. **`RegraDeSenha` (Record):**
   Um encapsulamento simples que armazena a lógica de validação (`Predicate<String>`) e a respectiva mensagem de erro caso a validação falhe.

2. **`ValidadorSenha` (Classe Abstrata):**
   Recebe uma lista de regras em seu construtor e expõe o método `validar(String senha)`. Em vez de fazer "ifs" sequenciais, a classe usa a Stream API para testar a senha contra todas as regras cadastradas. Caso a senha falhe em alguma regra, a mensagem de erro é mapeada e coletada numa lista de forma elegante:
   ```java
   return regras.stream()
       .filter(regra -> !regra.validacao().test(senha))
       .map(RegraDeSenha::mensagemDeErro)
       .toList();
   ```

3. **`ValidadorSenhaPadrao`:**
   Classe que estende `ValidadorSenha` e inicializa as regras de negócio padrão da aplicação, passando-as para a classe "pai" (superclasse):
   - Mínimo de 8 caracteres.
   - Pelo menos um número.
   - Pelo menos uma letra minúscula.
   - Pelo menos uma letra maiúscula.
   - Pelo menos um caractere especial.

## ⚙️ Como executar

1. Certifique-se de ter o **Java (JDK)** instalado em sua máquina.
2. Navegue até o diretório `src`:
   ```bash
   cd src
   ```
3. Compile a aplicação:
   ```bash
   javac App.java
   ```
4. Execute a classe principal `App`:
   ```bash
   java App
   ```
5. O programa aguardará entradas no console. Digite diferentes senhas e pressione Enter para ver o resultado das validações. Pressione Enter em uma linha vazia (ou feche o console) para encerrar o programa.

---
Desenvolvido como exercício de boas práticas de programação em Java
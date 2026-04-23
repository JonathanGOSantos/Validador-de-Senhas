public class ValidadorSenhaPadrao extends ValidadorSenha {
  public ValidadorSenhaPadrao() {
    super(
        new RegraDeSenha(senha -> senha.length() >= 8, "ter um tamanho mínimo de 8 caracteres"),
        new RegraDeSenha(senha -> senha.matches(".*\\d.*"), "adicionar um número"),
        new RegraDeSenha(senha -> senha.matches(".*[a-z].*"), "adicionar uma letra minuscula"),
        new RegraDeSenha(senha -> senha.matches(".*[A-Z].*"), "adicionar uma letra maiúscula"),
        new RegraDeSenha(senha -> senha.matches(".*[\\W_].*"), "adicionar um caractere especial"));
  } 
}

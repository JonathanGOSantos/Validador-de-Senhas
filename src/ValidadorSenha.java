import java.util.List;

public abstract class ValidadorSenha {
  protected final List<RegraDeSenha> regras;

  public ValidadorSenha(RegraDeSenha... regras) {
    this.regras = List.of(regras);
  }

  public List<String> validar(String senha) {
    if (senha == null) {
      return List.of("A senha não pode ser nula.");
    }

    return regras.stream()
        .filter(regra -> !regra.validacao().test(senha))
        .map(RegraDeSenha::mensagemDeErro)
        .toList();
  }
}

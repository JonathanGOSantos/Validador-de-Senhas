import java.util.function.Predicate;

public record RegraDeSenha(Predicate<String> validacao, String mensagemDeErro) {
}
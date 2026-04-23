import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ValidadorSenha validador = new ValidadorSenhaPadrao();
        String in;
        while (!(in = read.nextLine()).isBlank()) {
            var resultado = validador.validar(in);
            if (resultado.isEmpty()) {
                System.out.println("Senha válida.");
            } else {
                System.out.printf("Senha fraca, falta %s.\n", resultado.stream().collect(Collectors.joining(", ")));
            }
        }
        read.close();
    }
}
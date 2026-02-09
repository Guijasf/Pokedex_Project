package View;

import java.util.Scanner;

public class PokedexView {
    private Scanner scanner = new Scanner(System.in);

    public String pedirPokemon() {
        System.out.println("\n--- POKÈDEX DIGITAL ---");
        System.out.print("Digite o nome/ID ou 'sair': ");
        return scanner.nextLine();
    }

    public void mostrarPokemon(String info) {
        System.out.println("\n[DADOS ENCONTRADOS]");
        System.out.println(info);
        System.out.println("---------------------\n");
    }

    public void erro(String msg) {
        System.out.print("(!) " + msg);
    }
}

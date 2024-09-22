// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
// Nome: Murillo Cardoso Ferreira RA: 10418082
// Nome: Pietro Zanaga Neto RA: 10418574

/* Referencias
  arvore binária em java: https://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749
  
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = -1; // Inicializando fora do loop
        Scanner sc = new Scanner(System.in);

        do {
            // Impressão do Menu
            System.out.println("###MENU DO PROGRAMA###");

            System.out.println("|-------------------------------------------------------------|\n");
            System.out.println("| 1. Entrada da expressão aritmética na notação infixa.       |\n");
            System.out.println("| 2. Criação da árvore binária de expressão aritmética.       |\n");
            System.out.println("| 3. Exibição da árvore binária de expressão aritmética.      |\n");
            System.out.println("| 4. Cálculo da expressão (realizando o percurso da árvore).  |\n");
            System.out.println("| 5. Encerramento do programa.                                |\n");
            System.out.println("|-------------------------------------------------------------|\n");
            System.out.print("Digite a opção desejada: ");

            try {
                opcao = sc.nextInt(); // Leitura da opção

                switch (opcao) {
                    case 1: // Entrada da expressão aritmética na notação infixa.
                        // Código para a opção 1
                        System.out.println("Opção 1 selecionada.");
                        break;

                    case 2: // Criação da árvore binária de expressão aritmética.
                        // Código para a opção 2
                        System.out.println("Opção 2 selecionada.");
                        break;

                    case 3: // Exibição da árvore binária de expressão aritmética.
                        // Código para a opção 3
                        System.out.println("Opção 3 selecionada.");
                        break;

                    case 4: // Cálculo da expressão.
                        // Código para a opção 4
                        System.out.println("Opção 4 selecionada.");
                        break;

                    case 5: // Encerramento do programa.
                        System.out.println("Fechando o programa...");
                        break;

                    default: // Caso a opção seja inválida
                        System.out.println("Opção inválida. Digite novamente.\n");
                        break;
                }

            } catch (InputMismatchException e) { 
                // Trata o caso em que a entrada não é um número, por exemplo "a"
                System.out.println("Entrada inválida! Por favor, insira um número.");
                sc.next(); // Limpa o buffer de entrada
            }
        } while (opcao != 5);

        sc.close(); // Fecha o Scanner no final
    }
}


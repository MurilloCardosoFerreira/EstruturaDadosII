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
        int opcao = 0;  // Inicializa a variável opcao com um valor padrão
        Scanner sc = new Scanner(System.in);
        String expression = null; // Armazenará a expressão infixa
        ExpressionTree tree = null; // Armazenará a árvore binária

        do {
            // Impressão do Menu
            System.out.println("### MENU DO PROGRAMA ###");
            System.out.println("|-------------------------------------------------------------|");
            System.out.println("| 1. Entrada da expressão aritmética na notação infixa.       |");
            System.out.println("| 2. Criação da árvore binária de expressão aritmética.       |");
            System.out.println("| 3. Exibição da árvore binária de expressão aritmética.      |");
            System.out.println("| 4. Cálculo da expressão (realizando o percurso da árvore).  |");
            System.out.println("| 5. Encerramento do programa.                                |");
            System.out.println("|-------------------------------------------------------------|");
            System.out.print("Digite a opção desejada: ");

            // Verifica se a entrada é um número inteiro
            try {
                opcao = sc.nextInt();
                sc.nextLine();  // Consumir nova linha

                switch (opcao) {
                    case 1: // Entrada da expressão aritmética na notação infixa
                        System.out.println("Digite a expressão aritmética na notação infixa: ");
                        expression = sc.nextLine();  // Captura a expressão do usuário
                        break;

                    case 2: // Criação da árvore binária de expressão aritmética
                        if (expression == null) {
                            System.out.println("Por favor, insira uma expressão aritmética primeiro (opção 1).");
                        } else {
                            tree = new ExpressionTree();
                            if (tree.buildTree(expression)) {  // Constrói a árvore
                                System.out.println("Árvore binária de expressão criada.");
                            }
                        }
                        break;

                    case 3: // Exibição da árvore binária de expressão aritmética
                        if (tree == null) {
                            System.out.println("Árvore não criada. Selecione a opção 2 primeiro.");
                        } else {
                            tree.printTree();  // Exibe a árvore nos três percursos
                        }
                        break;

                    case 4: // Cálculo da expressão
                        if (tree == null) {
                            System.out.println("Árvore não criada. Selecione a opção 2 primeiro.");
                        } else {
                            System.out.println("Resultado da expressão: " + tree.evaluate());
                        }
                        break;

                    case 5: // Encerramento do programa
                        System.out.println("Fechando o programa...");
                        sc.close();
                        break;

                    default:
                        System.out.println("Opção inválida. Digite novamente.");
                        System.out.println();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.nextLine(); // Limpa o buffer do scanner
            }
        } while (opcao != 5);
    }
}

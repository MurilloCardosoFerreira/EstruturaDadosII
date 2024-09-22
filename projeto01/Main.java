// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
// Nome: Murillo Cardoso Ferreira RA: 10418082
// Nome: Pietro Zanaga Neto RA: 10418574

/* Referencias
  arvore binária em java: https://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749
  
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int opcao;
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
      System.out.println("Digite a opção desejada: ");
      opcao = sc.nextInt();


      switch (opcao) {
        case 1: // Entrada da expressão aritmética na notação infixa.
          // Código para a opção 1

        case 2: // Criação da árvore binária de expressão aritmética.
          //Código para a opção 2

        case 3: // Exibição da árvore binária de expressão aritmética.
          //Código para a opção 3

        case 4:
          //Código para a opção 4

        case 5:
          System.out.println("Fechando o programa...");
          break;

        default:
          System.out.println("Opção inválida. Digite novamente.");
          System.out.println("\n");
          break;
      }
    } while (opcao != 5);
    
    sc (close)
  }
}

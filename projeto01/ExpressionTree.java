// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
// Nome: Murillo Cardoso Ferreira RA: 10418082
// Nome: Pietro Zanaga Neto RA: 10418574

/* Referencias

*/
import java.util.Stack;

public class ExpressionTree {
    private Node root;

    // Construtor padrão
    public ExpressionTree() {
        this.root = null;
    }

    // Método para construir a árvore a partir da expressão infixa
    public boolean buildTree(String expression) {
        if (!isValidExpression(expression)) {
            System.out.println("Expressão inválida, voltando ao menu.");
            return false;
        }

        Stack<Node> operandStack = new Stack<>();
        Stack<Node> operatorStack = new Stack<>();

        // Remove espaços e prepara a expressão
        expression = expression.replaceAll("\\s+", "");

        // Convertendo a expressão infixa para pós-fixa (notação RPN) e construindo a árvore
        String[] tokens = tokenize(expression);
        for (String token : tokens) {
            if (isNumeric(token)) {
                operandStack.push(new OperandNode(token));
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek().value)) {
                    Node operator = operatorStack.pop();
                    operator.right = operandStack.pop();
                    operator.left = operandStack.pop();
                    operandStack.push(operator);
                }
                operatorStack.push(new OperatorNode(token));
            } else if (token.equals("(")) {
                operatorStack.push(new OperatorNode(token));
            } else if (token.equals(")")) {
                while (!operatorStack.peek().value.equals("(")) {
                    Node operator = operatorStack.pop();
                    operator.right = operandStack.pop();
                    operator.left = operandStack.pop();
                    operandStack.push(operator);
                }
                operatorStack.pop(); // Remove '('
            }
        }

        // Finalizando a construção
        while (!operatorStack.isEmpty()) {
            Node operator = operatorStack.pop();
            operator.right = operandStack.pop();
            operator.left = operandStack.pop();
            operandStack.push(operator);
        }

        root = operandStack.pop();
        return true;
    }

    // Verifica se a expressão é válida
    private boolean isValidExpression(String expression) {
        int balance = 0;  // Contador de parênteses balanceados
        boolean lastWasOperator = true;  // Se o último foi operador, o próximo não pode ser operador

        // Remove espaços da expressão
        expression = expression.replaceAll("\\s+", "");

        // Verifica tokens e formato
        String[] tokens = tokenize(expression);
        for (String token : tokens) {
            if (token.equals("(")) {
                balance++;
                lastWasOperator = true;
            } else if (token.equals(")")) {
                balance--;
                if (balance < 0) return false;  // Mais fechamentos do que aberturas
                lastWasOperator = false;
            } else if (isOperator(token)) {
                if (lastWasOperator) return false;  // Dois operadores seguidos
                lastWasOperator = true;
            } else if (isNumeric(token)) {
                lastWasOperator = false;
            } else {
                return false;  // Token desconhecido
            }
        }

        // Expressão só é válida se os parênteses estão balanceados e o último token não é operador
        return balance == 0 && !lastWasOperator;
    }

    // Método para exibir a árvore
    public void printTree() {
        if (root == null) {
            System.out.println("A árvore não foi construída.");
            return;
        }

        System.out.println("Pre-order:");
        printPreOrder(root);
        System.out.println("\nIn-order:");
        printInOrder(root);
        System.out.println("\nPost-order:");
        printPostOrder(root);
    }

    // Método para avaliar a expressão
    public float evaluate() {
        if (root == null) {
            throw new IllegalStateException("Árvore não foi criada.");
        }
        return root.visitar();
    }

    // Método para percorrer a árvore em pré-ordem
    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    // Método para percorrer a árvore em ordem
    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }

    // Método para percorrer a árvore em pós-ordem
    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Método auxiliar para tokenizar a expressão
    private String[] tokenize(String expression) {
        return expression.split("(?<=[-+*/()])|(?=[-+*/()])");
    }

    // Método auxiliar para verificar se um token é um número
    private boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método auxiliar para verificar se um token é um operador
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Método auxiliar para obter a precedência do operador
    private int precedence(String operator) {
        switch (operator) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return -1;
        }
    }
}

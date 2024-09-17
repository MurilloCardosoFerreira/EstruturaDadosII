public class OperatorNode extends Node {

    public OperatorNode(String value) {
        super(value);
    }

    @Override
    public float visitar() {
        float leftValue = left.visitar();
        float rightValue = right.visitar();

        switch (value) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/": return leftValue / rightValue;
            default: throw new IllegalArgumentException("Operador inválido: " + value);
        }
    }
}

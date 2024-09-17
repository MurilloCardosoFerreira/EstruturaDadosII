public class OperandNode extends Node {
    private float number;

    public OperandNode(String value) {
        super(value);
        this.number = Float.parseFloat(value);
    }

    @Override
    public float visitar() {
        return this.number;
    }
}

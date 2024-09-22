// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
// Nome: Murillo Cardoso Ferreira RA: 10418082
// Nome: Pietro Zanaga Neto RA: 10418574

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

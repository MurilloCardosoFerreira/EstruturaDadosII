// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
//
//

/* Referencias

*/

abstract class Node {
  abstract float evaluate();
}

class OperandoNode extends Node {
  private float valor;

  public OperandoNode(float valor) {
    this.valor = valor;
  }

  @Override
  public float evaluate() {
    return valor;
  }

  @Override
  public String toString(){
    return Float.toString(valor);
  }
}

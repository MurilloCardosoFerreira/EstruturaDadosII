// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
// Nome: Murillo Cardoso Ferreira RA: 10418082
// Nome: Pietro Zanaga Neto RA: 10418574

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

class OperadorNode extends Node {
  private char operador;
  private Node esquerda;
  private Node direita;

  public OperadorNode(char operador, Node esquerda, Node direita) {
    this.operador = operador;
    this.esquerda = esquerda;
    this.direita = direita;
  }

  @Override
  public float evaluate(){
    float lado_Esquerdo = esquerda.evaluate();
    float lado_Direito = direita.evaluate();

    switch (operador) {
      case '+': return lado_Esquerdo + lado_Direito;
      case '-': return lado_Esquerdo - lado_Direito;
      case '*': return lado_Esquerdo * lado_Direito;
      case '/':
        if (lado_Direito == 0) throw new ArithmeticException("Divisão por zero");
        return lado_Esquerdo / lado_Direito;
      default: throw new IllegalArgumentException("Operador inválido");
    }
  }

  @Override
  public String toString(){
    return Character.toString(operador);
  }
}

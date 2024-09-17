// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
// Nome: Murillo Cardoso Ferreira RA: 10418082
// Nome: Pietro Zanaga Neto RA: 10418574

/* Referencias

*/
public abstract class Node {
    String value;
    Node left, right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Método visitado pelos percursos da árvore
    public abstract float visitar();
}

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Stack();

        pilha.push("Um");
        pilha.push(2);
        pilha.push(true);
        pilha.push("Quatro");
        pilha.push(5);

        for (int i = 0; i < pilha.getSize(); i++) {
            System.out.print(pilha.getObject(i) + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println(pilha.peek());

        System.out.println();

        pilha.pop();

        for (int i = 0; i < pilha.getSize(); i++) {
            System.out.print(pilha.getObject(i) + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println(pilha.peek());
    }
}
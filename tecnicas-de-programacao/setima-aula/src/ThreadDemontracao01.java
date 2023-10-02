import java.util.List;

public class ThreadDemontracao01 {
    public static void main(String[] args) {
        System.out.println("Hello world");

/*        MinhaThread minhaThread = new MinhaThread("Nome");
        minhaThread.start();
        MinhaThread minhaThread1 = new MinhaThread("Nome1");
        minhaThread1.start();
        MinhaThread minhaThread2 = new MinhaThread("Nome2");
        minhaThread2.start();
        MinhaThread minhaThread3 = new MinhaThread("Nome3");
        minhaThread3.start();
        MinhaThread minhaThread4 = new MinhaThread("Nome4");
        minhaThread4.start();*/

        String nome = "Nome";
        List<MinhaTarefa> tarefas = List.of(new MinhaTarefa(nome + "1"), new MinhaTarefa(nome + "2"), new MinhaTarefa(nome + "3"));
        for (MinhaTarefa tarefa:tarefas) {
            Thread thread = new Thread(tarefa);
            thread.start();
        }

    }
}

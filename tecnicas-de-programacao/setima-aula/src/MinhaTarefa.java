public class MinhaTarefa implements Runnable{
    private String nome;

    public MinhaTarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        for (int i = 1; i < 7; i++) {
            System.out.println("Hello world " + this.nome + " número de execuções " + i);
        }
    }

}

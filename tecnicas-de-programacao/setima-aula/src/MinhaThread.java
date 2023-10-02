public class MinhaThread extends Thread{
    public MinhaThread(String nome) {
        super.setName(nome);
    }

    @Override
    public void run() {
        System.out.println(super.getName());
    }
}

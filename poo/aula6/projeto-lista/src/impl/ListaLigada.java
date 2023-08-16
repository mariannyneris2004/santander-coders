package impl;

import contrato.Lista;

public class ListaLigada extends Lista {
    private int size;
    private int ultimo;
    private Elemento primeiro;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(Object obj) {
        Elemento primeiro = new Elemento(obj);
        if (size == 0){
            this.primeiro = primeiro;
            size++;
        } else {
            Elemento elemento = this.primeiro;
            while (elemento.getProximo() != null){
                elemento = elemento.getProximo();
            }

            Elemento novoElemento = new Elemento(obj);
            elemento.setProximo(novoElemento);
            size++;
        }
    }

    @Override
    public Object get(int idx) {
        Elemento elemento = this.primeiro;
        for (int i = 0; i < idx; i++) {
            elemento = elemento.getProximo();
        }
        return elemento.getObj();
    }

    class Elemento{
        private Object obj;
        private Elemento proximo;

        public Elemento(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public Elemento getProximo() {
            return proximo;
        }

        public void setProximo(Elemento proximo) {
            this.proximo = proximo;
        }
    }
}

package impl;

import contrato.Lista;

public class ListaLigada extends Lista {

    private int size;
    private Elemento primeiro;
    private Elemento ultimo;

    @Override
    public void add(Object obj) {
        Elemento primeiro = new Elemento(obj);
        if (size == 0) {
            this.primeiro = primeiro;
            this.ultimo = primeiro;
            size++;
        } else {
            Elemento novoElemento = new Elemento(obj);
            this.ultimo.setProximo(novoElemento);

            this.ultimo = novoElemento;
            size++;
        }
    }

    @Override
    public void remove(int idx) {
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == 0) {
            this.primeiro = this.primeiro.getProximo();
            this.size--;
            return;
        }

        Elemento elemento = this.primeiro;
        for (int i = 0; i < idx - 1; i++) {
            elemento = elemento.getProximo();
        }
        elemento.setProximo(elemento.getProximo().getProximo());
        this.size--;
    }

    @Override
    public Object get(int idx) {
        Elemento elemento = this.primeiro;
        for (int i = 0; i < idx; i++) {
            elemento = elemento.getProximo();
        }
        return elemento.getObj();
    }

    @Override
    public int size() {
        return size;
    }

    class Elemento {
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
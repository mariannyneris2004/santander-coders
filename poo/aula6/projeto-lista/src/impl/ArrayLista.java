package impl;

import contrato.Lista;

import java.util.ArrayList;

public class ArrayLista extends Lista {

    private int size;
    private Object[] array;

    public ArrayLista() {
        this.array = new Object[10];
    }

    @Override
    public void add(Object obj) {
        if (size == this.array.length) {
            resize();
        }

        this.array[size] = obj;
        size++;
    }

    @Override
    public Object get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Posicao inexistente");
        }
        return this.array[idx];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int idx) {

        // 1. primeiro verificar o indice (indexOutOfBoundException)
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. for do idx recebido ate penultima posicao
        for (int i = idx; i < this.size - 1; i++) {

            // 3. apos o idx - add [idx + 1]
            this.array[i] = this.array[i+1];
        }

        // 4. remover ultimo para nao ficar duplicado (null)
        this.array[this.size - 1] = null;

        // 5. decrementa o size
        size--;
    }

    private void resize() {
        Object[] novoArray = new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            novoArray[i] = this.array[i];
        }
        this.array = novoArray;
    }
}
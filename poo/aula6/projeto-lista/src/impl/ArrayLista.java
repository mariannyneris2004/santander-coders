package impl;

import contrato.Lista;

import java.util.ArrayList;

public class ArrayLista extends Lista {
    private Object[] array;
    private int size;

    public ArrayLista() {
        this.array = new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object obj) {
        this.array[size] = obj;
        size++;
    }

    @Override
    public Object get(int idx) {
        if (idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException("Posição inexistente.");
        }
        return this.array[idx];
    }
}

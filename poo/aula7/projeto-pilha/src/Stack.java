import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack extends Pilha{
    private List<Object> stack;
    private int size = 0;

    public Stack() {
        this.stack = new LinkedList<>();
    }

    @Override
    public void push(Object obj) {
        this.stack.add(0, obj);
        size++;
    }

    @Override
    public Object pop() {
        if (this.stack.size() > 0){
            size--;
            return this.stack.remove(0);
        }
        return null;
    }

    @Override
    public Object peek() {
        if (this.stack.size() > 0){
            return this.stack.get(0);
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object getObject(int id){
        return stack.get(id);
    }
}

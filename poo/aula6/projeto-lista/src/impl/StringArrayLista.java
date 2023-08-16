package impl;

public class StringArrayLista extends ArrayLista{

    public void add(String str){
        super.add(str);
    }

    @Override
    public String get(int idx){
        return (String) super.get(idx);
    }
}

package util;

import java.util.ArrayList;
import java.util.List;

import entities.Butaca;;

@SuppressWarnings("hiding")
public class Butacas<Butaca> {
	
    private List<Butaca> lista = null;
    private Integer maxSize1 = null;
    
    /*public Butacas<Butaca> (Integer maxSize) {
        this.maxSize1 = maxSize1;
        lista = new ArrayList<Butaca>();
    }*/
    
    public void add(Butaca obj) {
        if(lista.size() >= maxSize1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        lista.add(obj);
    }
    
    public Butaca get(Integer index) {
        if(index > maxSize1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        return lista.get(index);
    }

    public Integer size() {
        return lista.size();
    }
}  
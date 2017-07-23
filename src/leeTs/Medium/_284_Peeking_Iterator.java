package leeTs.Medium;

import java.util.LinkedList;
import java.util.Iterator;

public class _284_Peeking_Iterator implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		Iterator<Integer> iterator = list.iterator();
		
	}
	LinkedList<Integer> list;
	public _284_Peeking_Iterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    list = new LinkedList<>();
	    while(iterator.hasNext())
	        list.add(iterator.next());
	        
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.getFirst();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int target = list.getFirst();
	    list.poll();
	    return target;
	}

	@Override
	public boolean hasNext() {
	    return list.size() > 0;
	}
	
	public void remove() {
		
	}

}

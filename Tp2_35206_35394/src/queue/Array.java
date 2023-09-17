package queue;

import java.util.ArrayList;


public abstract class Array {
	public ArrayList<Object> dates;
	public Array() {
		dates = new ArrayList();
	}
	
	static Array empty() {
		return new EmptyArray();
	}

	static Array compound() {
		return new CompoundArray();
	}
	
	public abstract boolean isEmpty();
	
	public abstract Array add( Object  cargo );
	
	public abstract Object take();
	
	public abstract Object head();
	
	public abstract int size();
}

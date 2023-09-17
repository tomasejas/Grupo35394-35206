package queue;

public class CompoundArray extends Array {
	
	public boolean isEmpty() {
		return false; 
	}
	public Array add(Object cargo) {
		dates.add(cargo);
		return this;
	}
	public Object take() {
		return dates.remove(0);
	}
	public Object head() {
		return dates.get(0);
	}
	public int size() {
		return dates.size();
	}

}

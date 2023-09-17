package queue;
public class Queue {

public Array array;
	public Queue() {
		this.array = Array.empty();
	}
  public boolean isEmpty() {
	  return array.isEmpty();
	}

	public Queue add( Object  cargo ) {
		if (array.size() == 0) {
		this.array = array.compound();
		}
		array.add(cargo);
        return this;
	}

	public Object take() {
		Object object = array.take();
		if (array.size() == 0){
			this.array = array.empty();	
		}
		return object;
	}

	public Object head() {
		return array.head();
	}

	public int size() {
		return array.size();
	}

}

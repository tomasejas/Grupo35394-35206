package queue;

public class EmptyArray extends Array {

	public static String QueueIsEmpty = "Queue is empty";
	public boolean isEmpty() {
		return true; 
	}
	public Array add( Object  cargo ) {
		return this;
	}
	public Object take() {
		throw new RuntimeException(QueueIsEmpty);
	}
	public Object head() {
		throw new RuntimeException(QueueIsEmpty);
	}
	public int size() {
		return 0;
	}
	
}

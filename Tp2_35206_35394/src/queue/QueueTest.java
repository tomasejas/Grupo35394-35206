package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

public static String Second = "Second";
public static String First = "First";
public static String Something = "Something";

@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( new Queue().add( Something ).isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( Something, new Queue().add( Something ).head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    assertTrue( addAndTakeSomething().isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    assertEquals( Something, addSomething().take() );
  }


  @Test public void test06QueueBehavesFIFO() {
    Queue queue = addFirstAndSecond();

    assertEquals( queue.take(), First );
    assertEquals( queue.take(), Second );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    assertEquals( addFirstAndSecond().head(), First );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    assertEquals( 1, addSomething().size() );
    addSomething().head();
    assertEquals( 1, addSomething().size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, addFirstAndSecond().size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    assertThrowsLike(()-> new Queue().take(), EmptyArray.QueueIsEmpty );
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    assertThrowsLike(()-> addAndTakeSomething().take(), EmptyArray.QueueIsEmpty ); 
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    assertThrowsLike(()-> new Queue().head(), EmptyArray.QueueIsEmpty );   
  }
  private void assertThrowsLike( Executable executable, String message ) {
	    assertEquals( message, 
	                  assertThrows( Exception.class, executable )
	                   .getMessage() );
  }
  private Queue addSomething() {
		Queue queue = new Queue();
	    queue.add( Something );
		return queue;
	}
  private Queue addFirstAndSecond() {
		Queue queue = new Queue();
	    queue.add( First );
	    queue.add( Second );
		return queue;
    }
  private Queue addAndTakeSomething() {
		Queue queue = new Queue();
	    queue.add( Something );
	    queue.take();
		return queue;
  	}
}  
package testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import queue_delegate.FifoQueue;
import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<Integer> myIntQueue2;

	@BeforeEach
	void setUp() {
		myIntQueue = new FifoQueue<Integer>();
		myIntQueue2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown(){
		myIntQueue = null;
		myIntQueue2 = null;
	}

	/**
	 * Test append två tomma köer
	 */
	@Test
	void testAppendEmptyQueues() {
		assertTrue(myIntQueue.isEmpty(), "Wrong result from empty of queue");
		assertEquals(0, myIntQueue.size(), "Wrong size of empty queue");
		myIntQueue.append(myIntQueue2);
		assertEquals(0, myIntQueue.size());
	}

	
	@Test
	void test2() {
		myIntQueue.offer(1);
		myIntQueue2.append(myIntQueue);
		assertEquals(1, myIntQueue2.size(), "Wrong size after append");

		int element = 1;
        Iterator<Integer> iter = myIntQueue2.iterator();

        while (iter.hasNext()) {
            assertEquals(element, iter.next());
            element ++;
        }
	}

	/**
	 * Test a single offer followed by a single poll.
	 */
	@Test
	void test3() {
		myIntQueue.offer(1);
		myIntQueue.append(myIntQueue2);
		assertEquals(1, myIntQueue.size(), "Wrong size after append");
		int element = 1;
        Iterator<Integer> iter = myIntQueue.iterator();

        while (iter.hasNext()) {
            assertEquals(element, iter.next());
            element ++;
        }
	}

	/**
	 * Test peek of empty queue.
	 */
	@Test
	void test4() {
		
		// List<FifoQueue> queues = new ArrayList<>();
		// queues.add(myIntQueue);
		// queues.add(myIntQueue2);
	//Storlek
		for (int i = 1; i<6; i++) {
			myIntQueue.offer(i);
		}
		assertEquals(5, myIntQueue.size());

		for (int i = 6; i<11; i++) {
			myIntQueue2.offer(i);
		}
		assertEquals(5, myIntQueue2.size());

		myIntQueue.append(myIntQueue2);
		assertEquals(10, myIntQueue.size());

		//Ordning
		int element = 1;
		Iterator<Integer> iter = myIntQueue.iterator();

		while (iter.hasNext()) {
			assertEquals(element, iter.next());
			element ++;
		}
	}

	/**
	 * Test poll of empty queue.
	 */
	@Test
	void test5() {
		assertThrows(IllegalArgumentException.class, () ->myIntQueue.append(myIntQueue));
	}
}

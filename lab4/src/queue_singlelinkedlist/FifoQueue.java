package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> p = new QueueNode<E>(e);
        if(size == 0) { 
			last = p;
			last.next = p;
			
        } else {
            p.next = last.next;
            last.next = p;
			last = p;
        }
        size++;
        return true;
	}
	// 	QueueNode<E> p = new QueueNode<E>(e);

	// 	if(last == null){
	// 		p.next = p;
	// 		//last.next = last;
	// 	}else{
	// 		p.next = last.next;
	// 		last.next = p;  
	// 	}
	// 	last = p;
	// 	size++;
	// 	return true;
	// }
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
			if(size == 0) {
				return null;
			}
			return last.next.element;
		}
	// 	if(last == null){
	// 		return null;
	// 	}
	// 	QueueNode<E> p = last.next;
	// 	p = p.next;
	// 	return p.element;
	// }

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (size > 1) {
			E e = last.next.element; //spara elementet
	
			QueueNode<E> first = last.next; 
			QueueNode<E> newFirst = first.next; //Previosuly second
	
			last.next = newFirst;
			size --;
			return e;
		} else if (size == 1) {
			E e = last.element;
			last = null;
	
			size --;
			return e;
		}
		return null;
	}
		// if(size == 0) {
        //     return null;
        // }
        // QueueNode<E> first = last.next;
        // last.next = first.next;
		
        // size--;
        // return first.element;
	
		// Test STring toMakeQueueEmpty funkar ej
		
		// if(last == null){
		// 	return null;
		// }
		// QueueNode<E> toDelete = last.next;
		// last.next = toDelete.next;
		// toDelete.next = null;	
		// size--;
		// return toDelete.element;
		// }
	//Test pollofempty teststring funkar inte
	// 	size--;
	// 	QueueNode<E> toDelete = last;
	// 	if(last == null || last.next == last){
	// 		last = null;
	// 		return toDelete.element;
	// 	}
	// 	toDelete = last.next;
	// 	last.next = toDelete.next;
	// 	toDelete.next = null;
		
	// 	return toDelete.element;
	// }

/**
            * Appends the specified queue to this queue
            * post: all elements from the specified queue are appended
            * to this queue. The specified queue (q) is empty after the call.
            * @param q the queue to append
            * @throws IllegalArgumentException if this queue and q are identical
            */
			public void append(FifoQueue<E> q){
				if(q.equals(this)){						//Om q är lika med kön
					throw new IllegalArgumentException();
				}

				Iterator<E> itr = q.iterator();
				while(itr.hasNext()){			//vi vill iterera genom kön
					QueueNode<E> newLast = new QueueNode<>(itr.next()); //skapar ny nod med element från q

					if(last != null){ 				//Måste kolla om denna kön INTE är tom annars nullpointerexception
						QueueNode<E> first = last.next;

						last.next = newLast;
						last = newLast;
						last.next = first;	
					}else{							//om den är tom
						last = newLast;
						last.next = newLast;
						
					}
					size++;
				}
			}
				// if(this.last == q.last){
				// 	throw new IllegalArgumentException();
				// }
				// while(q.size != 0){
				// 	offer(q.poll());
				// }

			

	/**	
	 * 
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		/* Konstruktor */
		private QueueIterator() {
			
			if(size != 0){
				pos = last.next;
			}else{
				pos = null;
			}
			
		}
		public boolean hasNext() {
			return pos != null;                      
		}
		public E next() {
			if(hasNext()){
				E elem = pos.element;
				if(pos == last){
					pos = null;
				}else{
					pos = pos.next;	
				}
				return elem;
			}else{
				throw new NoSuchElementException();
			}
		}
		// 	if(!hasNext()){								//om inga element
		// 		throw new NoSuchElementException();
		// 	}
		// 	QueueNode<E> p = pos.next;
		// 	if(pos.next.equals(last.next) || last.next.equals(last)){ //om ett element
		// 		pos = null;
		// 	}else{
		// 		pos = pos.next;								//fler än ett element
		// 	}
		// 	return p.element;
		// }
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			this.element = x;
			this.next = null;
		}
	}
	public static void main(String[] args) {

        FifoQueue<Integer> queue = new FifoQueue<>();
		FifoQueue<Integer> queue2 = new FifoQueue<>();
		queue.offer(100);
		queue.offer(200);
		queue.offer(300);
		queue2.offer(400);
		queue2.offer(500);
		queue2.offer(600);

		queue.append(queue2);

		int count = queue.size;
		Iterator<Integer> itr = queue.iterator();

		while(count != 0){
		System.out.println(itr.next());
			count--;
		}
		
		System.out.println(queue.size());
	}
}

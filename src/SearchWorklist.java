/*Class that implements SearchWorklist as a Stack and a Queue.*/

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

class StackWorklist implements SearchWorklist {
	
	Stack<Square> stack = new Stack<Square>();
	
	@Override
	public void add(Square c) {
		this.stack.push(c);
	}
	
	@Override
	public Square remove() {
		Square temp = this.stack.peek();
		this.stack.pop();
		return temp;
	}
	
	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
}

class QueueWorklist implements SearchWorklist {
	
	Queue<Square> queue = new LinkedList<>();
	
	
	@Override
	public void add(Square c) {
		this.queue.add(c);
	}
	
	@Override
	public Square remove() {
		Square temp = this.queue.peek();
		this.queue.remove(temp);
		return temp;
	}
	
	@Override
	public boolean isEmpty() {
		return this.queue.size() == 0;
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}

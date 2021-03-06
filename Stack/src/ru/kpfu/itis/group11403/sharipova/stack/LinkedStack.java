package  ru.kpfu.itis.group11403.sharipova.stack;
import java.util.Iterator;



public class LinkedStack<T> implements MyStack<T> {
	private Item first;
	private int size;
	private void setFirst(Item first) {
		this.first = first;
	}
	private Item getFirst() {
		return first;
	}

	private class Item {
		private T obj;

		private Item next;

		public Item getNext() {
			return next;
		}

		public void setNext(Item next) {
			this.next = next;
		}

		public T getObj() {
			return obj;
		}

		public void setObj(T obj) {
			this.obj = obj;
		}		
	}
	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>(){
			private int cursor=0;
			Item current;
			@Override
			public boolean hasNext() {

				return cursor<size;
			}

			@Override
			public T next() {
				if(cursor==0){
					current=first;
					
				}
				else{
					current=current.getNext();
				}
				cursor++;
				return (T)current.getObj();
				
			}

		};
	}

	@Override
	public T pop() {
		T t=first.getObj();
		setFirst(first.getNext());
		size--;
		return t;
	}

	@Override
	public T push (T item) {
		Item addedItem = new Item();
		addedItem.setObj(item);

		if (first==null){
			first= new Item();
			first.setObj(item);
		}
		
		else{
			Item temp=first;
			setFirst(addedItem);
			first.setNext(temp);
		}
		size++;
		return item;
	}

	@Override
	public T peek() {
		return (T)first.getObj();
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (first==null){
			return true;
		}
		return false;
	}

}

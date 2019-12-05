package LinkedList;
/**
 * Class Element
 * defines an object of type DoublyLinkedList
 * 
 * @author Fabian Vogt
 * @version 1.0
 */
public class DoublyLinkedList<Type> {
	
	private Element<Type> first;
	private Element<Type> last;
	private int length;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	
	public DoublyLinkedList(Type data) {
		this.insertLast(data);
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<String> shoppingList = new DoublyLinkedList<String>();
		shoppingList.insertLast("Wasser");
		shoppingList.insertLast("Obst");
		shoppingList.insertLast("Nudeln");
		shoppingList.insertLast("Reis");
		shoppingList.insertLast("Gemüse");
		
		shoppingList.insertFirst("Bier");
	
		shoppingList.remove(2);
		
		shoppingList.remove(shoppingList.getElement(4));
		
		DoublyLinkedList<String> shoppingList2 = new DoublyLinkedList<String>();
		shoppingList2.insertLast("Deo");
		shoppingList2.insertLast("Seife");
		
		shoppingList.appendAfter(shoppingList2);
		
		DoublyLinkedList<String> shoppingList3 = new DoublyLinkedList<String>();
		shoppingList3.insertLast("Zucker");
		shoppingList3.insertLast("Salz");
		
		shoppingList.appendBefore(shoppingList3);
		
		System.out.println("Wichtig: " + shoppingList.getElement(0).toString());
		System.out.println(shoppingList.toString());
	}
	/**
	 * Class Element
	 * defines an element of a DoublyLinkedList
	 * 
	 * @author Fabian Vogt
	 * @version 1.0
	 */
	public static class Element<Type> {
		private Element<Type> next;	
		private Element<Type> prev;
		private Type data; 
		
		public Element(Type data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		@Override
		public String toString() {
			return this.data.toString();
		}
		public Element<Type> getNext() {
			return this.next;
		}
		public Element<Type> getPrev() {
			return this.prev;
		}
	}
	/**
	 * checks if this list is empty
	 * 
	 * @return boolean True if empty, otherwise false
	 */
	public boolean isEmpty() {
		return this.length == 0;
	}
	/**
	 * returns the length of this list
	 * 
	 * @return this.length list length
	 */
	public int length() {
		return this.length;
	}
	/**
	 * appends another DoublyLinkedList after this one
	 * 
	 * @param l DoublyLinkedList to append after this one
	 * 
	 * @return this Extended list
	 */
	public DoublyLinkedList<Type> appendAfter(DoublyLinkedList<Type> l) {
		this.last.next = l.first;
		this.length += l.length();
		return this;
	}
	/**
	 * appends another DoublyLinkedList before this one
	 * 
	 * @param l DoublyLinkedList to append before this one
	 * 
	 * @return this Extended list
	 */
	public DoublyLinkedList<Type> appendBefore(DoublyLinkedList<Type> l) {
		Element<Type> thisOldFirst = this.first;
		Element<Type> otherOldLast = l.last;
		this.first = l.first;
		thisOldFirst.prev = l.last;
		otherOldLast.next = thisOldFirst;
		this.length += l.length();
		return this;		
	}
	/**
	 * inserts a new object at first position
	 * 
	 * @param data Object to be inserted
	 * 
	 * @return element New list element which contains input object
	 */
	public Element<Type> insertFirst(Type data) {
		Element<Type> element = new Element<Type>(data);
		if (isEmpty()) {
			this.last = element;
		} else {
			this.first.prev = element;
		}
		element.next = this.first;
		this.first = element;
		this.length++;
		return element;
	}
	/**
	 * inserts a new object at last position
	 * 
	 * @param data Object to be inserted
	 * 
	 * @return element New list element which contains input object
	 */
	public Element<Type> insertLast(Type data) {
		Element<Type> element = new Element<Type>(data);
		if (isEmpty()) {
			this.first = element;
		} else {
			this.last.next = element;
		}
		element.prev = this.last;
		this.last = element;
		this.length++;
		return element;
	}
	/**
	 * returns first element of this list
	 * 
	 * @return this.first First element
	 */
	public Type getFirst() {
		return this.first.data;
	}
	/**
	 * returns last element of this list
	 * 
	 * @return this.last Last element
	 */
	public Type getLast() {
		return this.last.data;
	}
	/**
	 * returns element at specified index
	 * 
	 * @return element Element at index
	 */
	public Type get(int index) {
		if(index == 0) {
			return this.first.data;
		} else if(this.first.next == null) {
			return null;
		} else {
			return get(index-1, this.first.next);
		}
	}
	private Type get(int index, Element<Type> check) {
		if(index == 0) {
			return check.data;
		} else if(check.next == null) {
			return null;
		} else {
			return get(index-1, check.next);
		}
	}
	public Element<Type> getElement(int index) {
		if(index == 0) {
			return this.first;
		} else if(this.first.next == null) {
			return null;
		} else {
			return getElement(index-1, this.first.next);
		}
	}
	private Element<Type> getElement(int index, Element<Type> check) {
		if(index == 0) {
			return check;
		} else if(check.next == null) {
			return null;
		} else {
			return getElement(index-1, check.next);
		}
	}
	/**
	 * inserts a new object after an existing list element
	 * 
	 * @param data Object to be inserted
	 * @param predecessor Predecessing list element
	 * 
	 * @return element New list element which contains input object
	 */
	public Element<Type> insert(Type data, Element<Type> predecessor) {
		Element<Type> element = new Element<Type>(data);
		if (this.first == null || predecessor == null) {
			element.next = this.first;
			this.first = element;
		} else {
			element.next = predecessor.next;
			predecessor.next = element;
		}
		this.length++;
		return element;
	}
	/**
	 * removes a list element at given index
	 * 
	 * @param index Index of list element to be removed
	 * 
	 * @return boolean Indicator showing if removement of element was successful
	 */
	public boolean remove(int index) {
		Element<Type> e = this.getElement(index-1);
		if (e == null)
			return false;
		e.next = e.next.next;
		this.length--;
		return true;
	}
	/**
	 * removes a list element after another given element
	 * 
	 * @param predecessor Predecessor of list element to be removed
	 * 
	 * @return boolean Indicator showing if removement of element was successful
	 */
	public boolean remove(Element<Type> predecessor) {
		if (this.length == 0) {
			return false;
		}
		if (predecessor == null) {
			this.first = this.first.next;
			this.length--;
			return true;
		} else if (predecessor.next != null) {
			predecessor.next = predecessor.next.next;
			this.length--;
			return true;
		} else
			return false;
	}
	/**
	 * deletes the entire list
	 *
	 */
	public void deleteList() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	/**
	 * converts this list into a String
	 * 
	 * @return s This list as a String
	 */
	public String toString() {
		Element<Type> help = this.first;
		String s = "(";
		while (help != null && help.next != null) {
			s = s + help.data + ", ";
			help = help.next;
		}
		if (help != null) {
			s = s + help.data + ")";
		}
		return s;		
	}
}

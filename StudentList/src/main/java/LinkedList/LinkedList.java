package LinkedList;

/**
 * Class LinkedList
 * defines an object of type LinkedList
 * 
 * @author Fabian Vogt
 * @version 1.0
 */
public class LinkedList<Type> {
	
	public LinkedList() {
		this.first = null;
	}
	
	public LinkedList(Type data) {
		this.first= new Element<Type>(data);
	}
	
	public static void main(String[] args) {
		LinkedList<String> shoppingList = new LinkedList<String>();
		shoppingList.insertLast("Wasser");
		shoppingList.insertLast("Obst");
		shoppingList.insertLast("Nudeln");
		shoppingList.insertLast("Reis");
		shoppingList.insertLast("Gemüse");
		
		shoppingList.insertFirst("Bier");
	
		shoppingList.remove(2);
		
		shoppingList.remove(shoppingList.getElement(4));
		
		LinkedList<String> shoppingList2 = new LinkedList<String>();
		shoppingList2.insertLast("Deo");
		shoppingList2.insertLast("Seife");
		
		shoppingList.appendAfter(shoppingList2);
		
		LinkedList<String> shoppingList3 = new LinkedList<String>();
		shoppingList3.insertLast("Zucker");
		shoppingList3.insertLast("Salz");
		
		shoppingList.appendBefore(shoppingList3);
		
		System.out.println("Wichtig: " + shoppingList.getElement(0).toString());
		System.out.println(shoppingList.toString());
	}
	
	/**
	 * Class Element
	 * defines an element of a LinkedList
	 * 
	 * @author Fabian Vogt
	 * @version 1.0
	 */
	public static class Element<Type> {
		public Element<Type> next;		
		public Type data;
		
		public Element(Type data) {
			this.data = data;
			this.next = null;
		}
		@Override
		public String toString() {
			return this.data.toString();
		}
	}
	
	private Element<Type> first;
	/**
	 * appends another LinkedList after this one
	 * 
	 * @param l LinkedList to append after this one
	 * 
	 * @return this Extended list
	 */
	public LinkedList<Type> appendAfter(LinkedList<Type> l) {
		this.getLast().next = l.first;
		return this;
	}
	/**
	 * appends another LinkedList before this one
	 * 
	 * @param l LinkedList to append before this one
	 * 
	 * @return this Extended list
	 */
	public LinkedList<Type> appendBefore(LinkedList<Type> l) {
		Element<Type> help = this.first;
		this.first = l.first;
		this.getLast().next = help;
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
		if (this.first == null) {
			this.first = element;
		} else {
			element.next = this.first;
			this.first = element;
		}
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
		if(this.first == null) {
			this.first = element;
		} else {
			this.getLast().next = element;
		}
		return element;
	}
	/**
	 * returns first element of this list
	 * 
	 * @return this.first First element
	 */
	public Element<Type> getFirst() {
		return this.first;
	}
	/**
	 * returns last element of this list
	 * 
	 * @return element Last element
	 */
	public Element<Type> getLast() {
		if(this.first.next == null) {
			return this.first;
		} else {
			return getLast(this.first.next);
		}
	}
	private Element<Type> getLast(Element<Type> predecessor) {
		if(predecessor.next == null) {
			return predecessor;
		} else {
			return getLast(predecessor.next);
		}
	}
	/**
	 * returns element at specified index
	 * 
	 * @return element Element at index
	 */
	public Element<Type> getElement(int index) {
		if(index == 0) {
			return this.first;
		} else if(this.first.next == null) {
			return null;
		} else {
			return getElement(index-1, this.first.next);
		}
	}
	private Element<Type> getElement(int index, Element<Type> element) {
		if(index == 0) {
			return element;
		} else if(element.next == null) {
			return null;
		} else {
			return getElement(index-1, element.next);
		}
	}
	/**
	 * returns current length of this list
	 * 
	 * @return lengthCounter List length
	 */
	public int getLength() {
		if(this.first == null) {
			return 0;
		} else {
			return getLength(1, this.first.next);
		}
	}
	private int getLength(int lengthCounter, Element<Type> element) {
		if(element == null) {
			return lengthCounter;
		} else {
			return getLength(lengthCounter+1, element.next);
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
	public Element<Type> insertAfter(Type data, Element<Type> predecessor) {
		Element<Type> element = new Element<Type>(data);
		if (this.first == null || predecessor == null) {
			element.next = this.first;
			this.first = element;
		} else {
			element.next = predecessor.next;
			predecessor.next = element;
		}
		return element;
	}
	/**
	 * removes a list element after another given element
	 * 
	 * @param predecessor Predecessor of list element to be removed
	 * 
	 * @return boolean Indicator showing if removement of element was successful
	 */
	public boolean remove(Element<Type> predecessor) {
		if (this.first == null) 
			return false;
		if (predecessor == null) 
			this.first = this.first.next;
		else if (predecessor.next != null) 
			predecessor.next = predecessor.next.next;
		return true;
	}
	/**
	 * removes a list element at given index
	 * 
	 * @param index Index of list element to be removed
	 * 
	 * @return boolean Indicator showing if removement of element was successful
	 */
	public boolean remove(int index) {
		Element<Type> e = this.getElement(index -1);
		if (e == null) 
			return false;
		e.next = e.next.next;
		return true;
	}
	/**
	 * deletes the entire list
	 *
	 */
	public void deleteList() {
		this.first = null;
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
			s = s + help.data.toString() + ", ";
			help = help.next;
		}
		if (help != null) {
			s = s + help.data.toString() + ")";
		}
		return s;		
	}
	
}

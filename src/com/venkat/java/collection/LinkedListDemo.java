package com.venkat.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*LinkedList : 
 * 1.Underlying data structure for LinkedList is DoubleLinkedList.
 * 2.Insertion order is preserved
 * 3.Duplicate objects are allowed
 * 4.Heterogeneous objects are allowed
 * 5.Null insertion is possible */
public class LinkedListDemo {

	public static void main(String[] args) {
		
		List list = new LinkedList(); // LinkedList does not implements RandomAccess interface
		list.add("test");  // if our requirement is insertion or deletion or updation LinkedList is best suitable
		list.add("test");  //duplicates are allowed
		list.add("1");
		list.add(null); //null insertion is allowed
		list.add(45.3); //Heterogeneous objects are allowed
		list.add(null);
		list.add(null);
		System.out.println(list); // [test, test, 1, null, 45.3, null, null] - insertion order is preserved
		//Collections.sort(list); // With null - NullpointerException & without null - ClasscastException
		
		List fruitList = new LinkedList();
		fruitList.add("Orange");
		fruitList.add("Banana");
		fruitList.add("Apple");
		
		fruitList.addFirst("Watermilon");
		fruitList.addLast("Grapes");
		
		System.out.println("List before Sort : "+fruitList); // List before Sort : [Watermilon, Orange, Banana, Apple, Grapes]
		
		Collections.sort(fruitList);
		
		System.out.println(fruitList);  // [Apple, Banana, Orange]
		
		Collections.reverse(fruitList);
		
		System.out.println(fruitList);  // [Orange, Banana, Apple] 
	}

}

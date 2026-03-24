package com.venkat.java.collection;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

/* Vector : Everything is same as ArrayList except thread safe . All methods of Vector is thread safe ( all methods are synchronized ) 
 * 1.Underlying data structure for ArrayList is Resizable Array or Growable Array
 * 2.Insertion order is preserved
 * 3.Duplicate objects are allowed
 * 4.Heterogeneous objects are allowed
 * 5.Null insertion is possible */
public class VectorDemo {

	public static void main(String[] args) {
		
		List list = new Vector(); // default initial capacity - 10 . Vector implements RandomAccess interface
		list.add("test");  // if our requirement is retrieval ArrayList is best suitable
		list.add("test");  //duplicates are allowed
		list.add("1");
		list.add(null); //null insertion is allowed
		list.add(45.3); //Heterogeneous objects are allowed
		list.add(null);
		list.add(null);
		System.out.println(list); // [test, test, 1, null, 45.3, null, null] - insertion order is preserved
		//Collections.sort(list); // With null - NullpointerException & without null - ClasscastException
		
		Vector fruitList = new Vector();
		fruitList.add("Orange");
		fruitList.add("Banana");
		fruitList.add("Apple");
		
		Collections.sort(fruitList);
		
		System.out.println(fruitList);  // [Apple, Banana, Orange]
		
		Collections.reverse(fruitList);
		
		System.out.println(fruitList);  // [Orange, Banana, Apple] 
	}

}

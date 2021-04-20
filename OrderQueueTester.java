import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Order Up
// Course: CS 300 Fall 2020
//
// Author: Elgini Neci
// Email: neci@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class runs all the tests for the other classes
 * 
 * @author elgini
 *
 */
public class OrderQueueTester {

  public static boolean OrderIteratorTeseter() {
    Order o1 = new Order("a", 1);
    Order o2 = new Order("b", 2);
    Order o3 = new Order("c", 3);
    Order o4 = new Order("d", 4);
    LinkedOrder list1 = new LinkedOrder(o1);
    LinkedOrder list2 = new LinkedOrder(o2);
    LinkedOrder list3 = new LinkedOrder(o3);
    LinkedOrder list4 = new LinkedOrder(o4);
    list1.setNext(list2);
    list2.setNext(list3);
    list3.setNext(list4);
    OrderIterator iterator1 = new OrderIterator(list1);

    if (iterator1.hasNext() == false) { // tests if the hasNext works
      return false;
    }

    // Test if the next method is point at the right node
    if (!iterator1.next().equals(o1)) {

      return false;
    }
    if (!iterator1.next().equals(o2)) {

      return false;
    }
    if (!iterator1.next().equals(o3)) {

      return false;
    }
    if (!iterator1.next().equals(o4)) {

      return false;
    }
    return true;

  }

  public static boolean isEmptyTester() {
    Order.resetIDGenerator();
    Order o1 = new Order("a", 1);
    OrderQueue list = new OrderQueue();

    if (!list.isEmpty()) {// tests when the list is actually empty
      return false;
    }
    list.enqueue(o1);
    if (list.isEmpty()) { // tests when the list isn't actually empty
      return false;
    }
    return true;

  }

  public static boolean peekTester() {
    Order.resetIDGenerator();
    OrderQueue list = new OrderQueue();
    Order o1 = new Order("a", 1);
    Order o2 = new Order("b", 2);
    list.enqueue(o1);
    if (!list.peek().equals(o1)) { //tests if the peek is pointing at the right order
      return false;
    }
    return true;
  }


  public static boolean enqueueTester() {
    Order.resetIDGenerator();
    Order o1 = new Order("a", 1);
    Order o2 = new Order("b", 2);
    Order o3 = new Order("c", 3);
    Order o4 = new Order("d", 4);
    OrderQueue list = new OrderQueue();
    list.enqueue(o1);
    list.enqueue(o2);
    list.enqueue(o3);
    list.enqueue(o4);
    String expected = "1001: a (1) -> 1002: b (2) -> 1003: c (3) -> 1004: d (4) -> END";
    String actual = list.toString();
    if (!expected.equals(actual)) { //test if the list contains all the orders
     
      return false;
    }
    return true;
  }
  
  
  public static boolean dequeueTester() {
    Order.resetIDGenerator();
    Order o1 = new Order("a", 1);
    Order o2 = new Order("b", 2);
    Order o3 = new Order("c", 3);
    Order o4 = new Order("d", 4);
    OrderQueue list = new OrderQueue();
    list.enqueue(o1);
    list.enqueue(o2);
    list.enqueue(o3);
    list.enqueue(o4);
    
    //tests after removing the front is the object in front equal to the order is supposed to be
    list.dequeue();
    if(!list.peek().equals(o2)) {
      return false;
    }
    list.dequeue();
    if(!list.peek().equals(o3)) {
      return false;
    }
    list.dequeue();
    if(!list.peek().equals(o4)) {
      return false;
    }
    return true;
  }


  public static boolean runAllTests() {
    return isEmptyTester() && OrderIteratorTeseter() && peekTester() && enqueueTester()&& dequeueTester() ;
  }

  public static void main(String[] args) {
    System.out.print(runAllTests());
  }
}

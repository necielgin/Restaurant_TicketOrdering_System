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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implement the interface QueueADT<Order>
 * 
 * @author elgini
 *
 */
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {

  private LinkedOrder front; // a reference to the LinkedOrder at the front of the queue
  private LinkedOrder back; // a reference to the LinkedOrder at the back of the queue
  private int size = 0; // track the number of Orders currently in the queue

  /**
   * Creates and returns a new OrderIterator beginning with the current value of front
   * 
   * @return a new OrderIterator beginning with the current value of front
   */
  public Iterator<Order> iterator() {
    OrderIterator iterator = new OrderIterator(front);
    return iterator;

  }

  /**
   * Adds a new LinkedOrder containing newElement to the back of the queue, updating the size
   * variable and front/back references appropriately
   * 
   */
  @Override
  public void enqueue(Order newElement) {
    LinkedOrder order = new LinkedOrder(newElement);
    if (front == null) {
      front = order;
      back = order;
      size++;
    } else {
      back.setNext(order);
      back = order;
      size++;
    }


  }


  /*
   * Removes the next LinkedOrder from the front of the queue and returns its Order, updating the
   * size variable and front/back references appropriately
   */
  @Override
  public Order dequeue() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("There is no order to remove");
    } else {
      LinkedOrder temp = front;
      if (front == back) {
        front = back = null;
        size--;
      } else {
        front = front.getNext();
        size--;
      }
      return temp.getOrder();
    }

  }

  /**
   * Returns the Order from the LinkedOrder at the front of the queue without removing the
   * LinkedOrder from the queue Throws a NoSuchElementException if the queue is empty
   * 
   * @return the Order from the LinkedOrder at the front of the queue
   */
  @Override
  public Order peek() throws NoSuchElementException {
    if (front == null) {
      throw new NoSuchElementException("There is no order to remove");
    } else {
      LinkedOrder order = front;
      return order.getOrder();
    }

  }


  /**
   * Returns true if and only if the queue is empty
   * 
   * @return true if and only if the queue is empty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Creates and returns a String representation of this OrderQueue using an enhanced-for loop. For
   * example, a queue with three Orders might look like this: 1001: fries (2) -> 1002: shake (1) ->
   * 1003: burger (3) -> END
   *
   * @return A String representation of the queue
   */
  @Override
  public String toString() {
    if (this.size == 0)
      return "";
    String qString = "";
    for (Order o : this) {
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }

}

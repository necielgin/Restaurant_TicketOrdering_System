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
 * OrderIterator implements the Iterator<Order> interface
 * 
 * @author elgini neci
 *
 */
public class OrderIterator implements Iterator<Order> {
  private LinkedOrder current; // the LinkedOrder that we are currently using

  /**
   * Constructor, initializes current to the provided starting LinkedOrder
   * 
   * @param start
   */
  public OrderIterator(LinkedOrder start) {
    this.current = start;
  }

  /**
   * Returns true if and only if the iteration has more orders
   * 
   * @return true if and only if the iteration has more orders
   */
  public boolean hasNext() {
    return current != null;
  }

  /**
   * Throws a NoSuchElementException with a descriptive error message if the iteration does not have
   * more orders to return. Otherwise returns the next Order and updates the current field
   * appropriately.
   * 
   * @return the next Order and updates the current field appropriately.
   * @throws NoSuchElementException
   */
  public Order next() throws NoSuchElementException {
    if (current == null) {
      throw new NoSuchElementException("There is no next");
    } else {
      Order data = current.getOrder();
      current = current.getNext();
      return data;
    }
  }
}

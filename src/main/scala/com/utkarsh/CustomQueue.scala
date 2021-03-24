//code by utkarsh.
package com.utkarsh

import scala.collection.immutable.List

class CustomQueue[+T](inputList: List[T]) {


  //--- T is the type parameter of Class
  //--- U is the type parameter of method
  // using lower bound type
  // to add element to the queue
  def enqueue[U >: T](inputElement: U): CustomQueue[U] =
      new CustomQueue[U](inputList :+ inputElement) //adding element to the list



  //to remove first element from the queue
  def dequeue[U >: T]: CustomQueue[U] = {
    if (inputList.isEmpty)
    {
      throw new NoSuchElementException
    }
    else
      {
        new CustomQueue[U](inputList.tail)
      }
  }

  //to check queue is empty or not
  def isQueueEmpty: Boolean = inputList.isEmpty

  // to get the first element from the queue
  def getFront: T = {
    if (inputList.isEmpty)
    {
      throw new NoSuchElementException
    }
    else
      {
        inputList.head
      }

  }

  //overriding the toString method to convert the list of queue to String .
  override def toString: String = inputList.toString


}

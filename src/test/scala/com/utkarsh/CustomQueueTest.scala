//code by utkarsh.
package com.utkarsh

import org.scalatest.flatspec.AnyFlatSpec

class CustomQueueTest extends AnyFlatSpec {

  //scalastyle:off magic.number

  //test cases for method enqueue
  "enqueue operation in CustomQueue " should " add the given element to the queue " in {
    val inputQueue = new CustomQueue[Int](List(10))
    assert(inputQueue.enqueue(11).toString == List(10,11).toString())
  }

  "enqueue operation in CustomQueue " should " add the given element to the queue with type String " in {
    val inputQueue = new CustomQueue[String](List("Hello", "Utkarsh", "How", "are"))
    assert(inputQueue.enqueue("you").toString ==
      List("Hello", "Utkarsh", "How", "are", "you").toString())
  }




  //negative test case for enqueue
  "it " should "add elements on correct position in queue " in
  {
    val inputQueue = new CustomQueue[Double](List(1.4, 1.3, 1.5))
    assert(inputQueue.enqueue(1.6).toString !=
      List(1.4, 1.3, 1.6, 1.5 ).toString())
  }



  //Test cases for method dequeue
  "dequeue operation in CustomQueue " should " remove first element from the input queue " in {
    val inputQueue = new CustomQueue[Int](List(1, 2, 3, 4, 5, 6, 7))

    assert(inputQueue.dequeue.toString == List(2, 3, 4, 5, 6, 7).toString())
  }

  "dequeue operation in CustomQueue " should " remove first element from the input queue for any type parameter" in {
    val inputQueue = new CustomQueue[String](List("Utkarsh" , "is" , "smart"))
    assert(inputQueue.dequeue.toString == List( "is" , "smart").toString())
  }

  //negative test case for dequeue
  "dequeue operation in CustomQueue " should " remove first element correctly from the input queue for any type parameter" in {
    val inputQueue = new CustomQueue[String](List("Utkarsh" , "is" , "smart"))
    assert(inputQueue.dequeue.toString != List("Utkarsh" , "is" ).toString())
  }


  it should "throw NoSuchElementException when try to remove element from a empty list " in
    {
      assertThrows[NoSuchElementException]
        {
          val inputQueue = new CustomQueue[String](List())
          inputQueue.dequeue
        }

    }


  //test case for isQueueEmpty
  "isEmpty method " should "return true when list is empty " in
  {
    val inputQueue = new CustomQueue[String]( List())
    assert(inputQueue.isQueueEmpty == true)
  }

  "isEmpty method " should "return false when list is not empty " in
    {
      val inputQueue = new CustomQueue[String]( List("hello " , "utkarsh"))
      assert(inputQueue.isQueueEmpty == false)
    }


  //test cases for getting first element
  "getFront method " should "return first element from the queue " in
  {
    val inputQueue = new CustomQueue[Int]( List(123,456,432,455))
    assert(inputQueue.getFront == 123)
  }

  it should "throw NoSuchElementException when try to get first element from a empty list " in
    {
      assertThrows[NoSuchElementException]
        {
          val inputQueue = new CustomQueue[String](List())
          inputQueue.getFront
        }

    }

  //negative test case
  "getFront method " should "return first element from the queue correctly " in
  {
    val inputQueue = new CustomQueue[String]( List("hey" , "how" ,"are" ,"you"))
    assert(inputQueue.getFront != "how")
  }



}

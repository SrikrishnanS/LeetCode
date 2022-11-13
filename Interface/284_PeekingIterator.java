/*
284. Peeking Iterator

Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.

Implement the PeekingIterator class:

PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
int next() Returns the next element in the array and moves the pointer to the next element.
boolean hasNext() Returns true if there are still elements in the array.
int peek() Returns the next element in the array without moving the pointer.
Note: Each language may have a different implementation of the constructor and Iterator, but they all support the int next() and boolean hasNext() functions.

*/

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer>
{
	  private Integer next;
    private Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator)
  {
	    // initialize any member here.
        this.next = iterator.next();
        this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
  {
        return this.next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
  {
	    Integer value = next;

        next = iterator.hasNext() ? iterator.next() : null;
        return value;
	}

	@Override
	public boolean hasNext()
  {
	    return (this.next != null);
	}
}

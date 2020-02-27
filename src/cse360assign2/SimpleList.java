/**
 * Author:		Andrew Smith
 * Class ID:	102
 * Assignment:	2
 * Description:	This class creates an int array of length 10 and the methods
 * 				can add an elements, remove an element, return the number of
 * 				elements, return the list as a string, or search the array
 * 				for a certain value and return its index.
 */

package cse360assign2;
import java.util.Arrays;

/**
 * SimpleList contains two private variables: a 10-index int array and a
 * count variable that stores the number of integers in the array.
 */
public class SimpleList
{
	private int[] list = new int[10];
	private int count = 0;
	
	/**
	 * Constructor method that initializes the 10-index array and sets count
	 * to 0.
	 */
	public SimpleList()
	{
		final int arraySize = 10;
		list = new int[arraySize];
		count = 0;
	}
	
	/**
	 * Adds a new element into the array and moves all other elements
	 * over by 1.  If the array was already full, list size will be
	 * increased by 1.5 times and then the new element will be added.
	 * 
	 * @param  newElement  an integer to add into the array
	 */
	public void add(int newElement)
	{
		if(count == list.length)
		{
			int[] newList = Arrays.copyOf(list, list.length + list.length / 2);
			list = newList;
		}
		if(count == 0)
		{
			list[0] = newElement;
		}
		else
		{
			for(int index = list.length - 1; index > 0; index--)
			{ // iterate backwards so overwritten variables aren't a problem
				list[index] = list[index - 1];
			}
			
			list[0] = newElement;
		}
		
		if(count < list.length)
		{
			count++;
		}
		
	}
	
	/**
	 * Removes an element from the array and then shifts all elements
	 * to the right of it to the left.  Count is updated.
	 * 
	 * @param  removeElement  an integer to remove from the array
	 */
	public void remove(int removeElement)
	{
		int removedIndex = search(removeElement);
		
		for(int index = removedIndex; index < count - 1; index++)
		{
			list[index] = list[index + 1];
		}
		
		if(count > 0)
		{
			count--;
		}
		if(count > 0 && count < (list.length * 3) / 4)
		{
			int[] newList = Arrays.copyOf(list, (list.length * 3) / 4);
			list = newList;
		}
	}
	
	/**
	 * Returns the value of the count variable.
	 * 
	 * @return  the number of elements currently in the array
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Returns the elements in the array as a string with spaces between
	 * them.  There is no space before the first element or after the last.
	 * 
	 * @return  elements of the array as a string
	 */
	public String toString()
	{
		String allElements = "";
		
		for(int index = 0; index < count; index++)
		{
			if(index == 0)
			{
				allElements = list[index] + "";
			}
			else
			{
				allElements = allElements + " " + list[index];
			}
		}
		
		return allElements;
	}
	
	/**
	 * Searches the list for the input integer and returns the index.  If
	 * the integer does not exist in the array, return -1.
	 * 
	 * @param   elementToFind  the integer to search for
	 * @return  the index of the integer
	 */
	public int search(int elementToFind)
	{
		for(int index = 0; index < count; index++)
		{
			if(list[index] == elementToFind)
			{
				return index;
			}
		}
		
		return -1;
	}
	
	/**
	 * Appends a new element to the end of the list.  If the list is already
	 * full, the size is increased by 1.5 times and then the element is
	 * appended.  Increases count by 1.
	 * 
	 * @param newElement
	 */
	public void append(int newElement)
	{
		if(count == list.length)
		{
			int[] newList = Arrays.copyOf(list, list.length + list.length / 2);
			list = newList;
		}
		list[count] = newElement;
		count++;
	}
	
	/**
	 * Returns the first element of the list.  If there is nothing in the list,
	 * return -1.
	 * 
	 * @return
	 */
	public int first()
	{
		if(count == 0) return -1;
		else return list[0];
	}
	
	/**
	 * Returns the last element of the list.  If there is nothing in the list,
	 * return -1.
	 * 
	 * @return
	 */
	public int last()
	{
		if(count == 0) return -1;
		else return list[count - 1];
	}
	
	/**
	 * Returns the number of vacant spots in the list.
	 * 
	 * @return
	 */
	public int size()
	{
		return list.length - count;
	}
}

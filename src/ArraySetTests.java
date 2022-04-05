/**
 * @author Olivia Pitcl
 * 
 * Test class for my ArraySet class.
 * 
 * Note that there is partial branch coverage for
 * lambda that I use to test my exceptions.
 * 
 * CHANGE ITERATOR TO PUBLIC IN ORDER TO TEST
 */


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;


class ArraySetTests {
	
	@Test
	public void Test_IsEmptyTrue() {
		ArraySet<Integer> mySet = new ArraySet<>();
		assertEquals(true, mySet.isEmpty());
	}
	
	@Test
	public void Test_IsEmptyFalse() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		assertEquals(false, mySet.isEmpty());
	}
	
	@Test
	public void Test_AddNullObj() {
		ArraySet<Integer> mySet = new ArraySet<>();
		assertEquals(false, mySet.add(null));
	}
	

	@Test
	public void Test_AddObj() {
		ArraySet<Integer> mySet = new ArraySet<>();
		assertEquals(true, mySet.add(2));
	}
	
	@Test
	public void Test_AddAlreadyContains() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		assertEquals(false, mySet.add(2));
	}
	
	@Test
	public void Test_AddOver10() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		mySet.add(2);
		mySet.add(35);
		mySet.add(16);
		mySet.add(25);
		mySet.add(53);
		mySet.add(87);
		mySet.add(86);
		mySet.add(9);
		mySet.add(94);
		mySet.add(84);
		assertEquals(false, mySet.add(2));
	}
	
	@Test
	public void Test_Size() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		mySet.add(2);
		mySet.add(35);
		mySet.add(16);
		mySet.add(25);
		mySet.add(53);
		mySet.add(87);
		mySet.add(86);
		mySet.add(9);
		mySet.add(94);
		mySet.add(84);
		assertEquals(15, mySet.size());
	}
	
	@Test
	public void Test_AddAll() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		List<Integer> nums = Arrays.asList(12, 51, 26, 7, 442);
		assertEquals(true, mySet.addAll(nums));
	}
	
	@Test
	public void Test_AddAllAgain() {
		ArraySet<Integer> mySet = new ArraySet<>();
		List<Integer> nums = Arrays.asList(12, 51, 26, 7, 442);
		mySet.addAll(nums);
		assertEquals(false, mySet.addAll(nums));
	}
	
	@Test
	public void Test_AddAllEmpty() {
		ArraySet<Integer> mySet = new ArraySet<>();
		List<Integer> nums = new ArrayList<>();
		assertEquals(false, mySet.addAll(nums));
	}
	
	@Test
	public void Test_ContainsNullObj() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(15);
		assertEquals(false, mySet.contains(null));
	}
	
	@Test
	public void Test_ContainsEmpty() {
		ArraySet<Integer> mySet = new ArraySet<>();
		assertEquals(false, mySet.contains(15));
	}
	
	@Test
	public void Test_NotContainsObj() {
		ArraySet<Integer> mySet = new ArraySet<>();
		List<Integer> nums = Arrays.asList(12, 51, 26, 7, 442);
		mySet.addAll(nums);
		assertEquals(false, mySet.contains(40));
	}
	
	@Test
	public void Test_ContainsObj() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		assertEquals(true, mySet.contains(51));
	}
	
	@Test
	public void Test_ContainsAllTrue() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		assertEquals(true, mySet.containsAll(otherSet));
	}
	
	@Test
	public void Test_ContainsAllFalse() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(2);
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		assertEquals(false, mySet.containsAll(otherSet));
	}
	
	@Test
	public void Test_Clear() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		ArraySet<Integer> emptySet = new ArraySet<>();
		mySet.clear();
		assertEquals(emptySet, mySet);
	}
	
	@Test
	public void Test_EqualsTrue() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(2);
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		boolean my = mySet.equals(otherSet);
		assertEquals(true, my);
	}
	
	@Test
	public void Test_EqualsFalseDifferentElement() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		mySet.add(513);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(2);
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		otherSet.add(515);
		boolean my = mySet.equals(otherSet);
		assertEquals(false, my);
	}
	
	@Test
	public void Test_EqualsFalseDifferentSize() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(2);
		boolean my = mySet.equals(otherSet);
		assertEquals(false, my);
	}
	
	@Test
	public void Test_EqualsNotSet() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		ArrayList<Integer> otherSet = new ArrayList<>();
		otherSet.add(2);
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		boolean my = mySet.equals(otherSet);
		assertEquals(false, my);
	}
	
	@Test
	public void Test_Remove() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		mySet.remove(2);
		assertEquals(mySet, otherSet);
	}
	
	@Test
	public void Test_RemoveNull() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		assertEquals(false, mySet.remove(null));
	}
	
	@Test
	public void Test_RemoveAllNoChange() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(99);
		otherSet.add(87);
		otherSet.add(14);
		otherSet.add(20);
		otherSet.add(52);
		assertEquals(false, mySet.removeAll(otherSet));
	}
	
	@Test
	public void Test_RemoveAllSomeCommon() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(99);
		otherSet.add(87);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(52);
		mySet.removeAll(otherSet);
		ArraySet<Integer> answer = new ArraySet<>();
		answer.add(2);
		answer.add(12);
		answer.add(31);
		answer.add(51);
		boolean result = mySet.equals(answer);
		assertEquals(true, result);
	}
	
	@Test
	public void Test_RemoveNotContains() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		assertEquals(false, mySet.remove(100));
	}
	
	@Test
	public void Test_RetainAllNoCommonComponents() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(99);
		otherSet.add(87);
		otherSet.add(14);
		otherSet.add(20);
		otherSet.add(52);
		mySet.retainAll(otherSet);
		assertEquals(true, mySet.isEmpty());
	}
	
	
	@Test
	public void Test_RetainAllSomeOverlap() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		HashSet<Integer> otherSet = new HashSet<>();
		otherSet.add(99);
		otherSet.add(87);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(52);
		mySet.retainAll(otherSet);
		ArraySet<Integer> answer = new ArraySet<>();
		answer.add(1);
		answer.add(24);
		assertEquals(true, mySet.equals(answer));
	}
	
	
	@Test
	public void Test_IteratorHasNextTrue() {
		ArraySet<Integer> mySet = new ArraySet<>();
		Iterator i = mySet.iterator();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		assertEquals(true, i.hasNext());
	}
	
	@Test
	public void Test_IteratorHasNextFalse() {
		ArraySet<Integer> mySet = new ArraySet<>();
		Iterator i = mySet.iterator();
		mySet.add(2);
		Integer next = (Integer) i.next();
		assertEquals(false, i.hasNext());
	}
	
	@Test
	public void Test_IteratorRemove() {
		ArraySet<Integer> mySet = new ArraySet<>();
		Iterator i = mySet.iterator();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		i.next();
		i.remove();

		ArraySet<Integer> otherSet = new ArraySet<>();
		otherSet.add(12);
		otherSet.add(31);
		otherSet.add(1);
		otherSet.add(24);
		otherSet.add(51);
		assertEquals(otherSet, mySet);
	}
	
	@Test
	public void Test_IteratorRemoveException() {
		ArraySet<Integer> mySet = new ArraySet<>();
		Iterator i = mySet.iterator();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		assertThrows(IllegalStateException.class, () -> i.remove());
	}
	
	@Test
	public void Test_toArray() {
		ArraySet<Integer> mySet = new ArraySet<>();
		mySet.add(2);
		mySet.add(12);
		mySet.add(31);
		mySet.add(1);
		mySet.add(24);
		mySet.add(51);
		Integer[] arr = {2, 12, 31, 1, 24, 51, null, null, null, null};
		boolean result = Arrays.equals(arr, mySet.toArray());
		assertEquals(true, result);
	}

}

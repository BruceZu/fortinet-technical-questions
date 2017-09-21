package com.fortinet.cc.question3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fortinet.cc.question3.FindKGroups;

public class FindKGroupsTest {

	@Test
	public void testEmptyList() {
		List<Integer> list = new ArrayList<Integer>();
		boolean result = FindKGroups.separate(list, 3);
		assertTrue(result == false);
	}
	
	@Test
	public void testKZero() {
		List<Integer> list = new ArrayList<Integer>();
		boolean result = FindKGroups.separate(list, 0);
		assertTrue(result == false);
	}
	
	@Test
	public void testKOne() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(6);
		boolean result = FindKGroups.separate(list, 1);
		assertTrue(result == true);
	}
	
	@Test
	public void testKGreaterThanListSize() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);		
		boolean result = FindKGroups.separate(list, 2);
		assertTrue(result == false);
	}
	
	@Test
	public void testKEqualsListSize() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(3);
		boolean result = FindKGroups.separate(list, 3);
		assertTrue(result == true);
	}
	
	@Test
	public void testValidInput() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(2);
		list.add(8);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(7);
		boolean result = FindKGroups.separate(list, 4);
		assertTrue(result == true);
	}
	
	@Test
	public void testInvalidInput() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		list.add(8);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(7);
		boolean result = FindKGroups.separate(list, 4);
		assertTrue(result == false);
	}

}

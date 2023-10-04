package com.mohit.corejava.list;

import java.util.AbstractList;
import java.util.List;

public class AbstractListDemo extends AbstractList<Integer> {
	private int size;

	public AbstractListDemo(int size) {
		this.size = size;
	}

	@Override
	public Integer get(int index) {
		return index;
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		List<Integer> list = new AbstractListDemo(5);
		for (int i : list) {
			System.out.println(i);
		}
	}
}


package ru.kpfu.itis.group11403.sharipova.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;




public class MyHashMap<V, K> implements MyMap<V, K> {
	public MyHashMap(int capacity) {
		elements = new Object[capacity];
	}
	private class Node implements Entry<K,V>{
		private V value;
		private K key;
		private Node next;
		public V getValue() {
			return value;
		}
		public V setValue(V value) {
			V temp = value;
          this.value = value;
          return temp;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node( K key, V value) {
			super();
			this.value = value;
			this.key = key;
		}

	}
	private int size;

	private Object[] elements;


	public int getIndex(Object key) {
        return Math.abs(key.hashCode() % elements.length);
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public V put(K key, V value) {
		if (key==null){
			throw new NullPointerException("key is null");
		}
		int index=getIndex(key);
		Node node= (Node) elements[index];
		if (node==null){
			elements[index]=new Node(key, value);
			size++;
			return value;
		}
		if (node.key.equals(key)){
			node.value=value;
			return value;
		}
		while(node.getNext()!=null){
			node=node.getNext();
			if (node.key.equals(key)){
				node.value=value;
				return value;
			}
			
		}
		node.setNext(new Node(key, value));
		size++;
		return value;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public boolean containsKey(Object key) {
		int index=getIndex(key);		
		Node node=(Node)elements[index];
		if (node==null){
			return false;
		}
		if (node.key.equals(key)){
			return true;
		}
		while(node.getNext()!=null){
			if (node.getNext().key.equals(key)){
				return true;
			}
			node=node.getNext();
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i]==null) continue;
			Node node=(Node)elements[i];
			if (node.value==null && value==null || node.value.equals(value)){
				return true;
			}
			while(node.getNext()!=null){
				node=node.getNext();
				if (node.value==null && value==null 
						||node.value.equals(value)){
					return true;
				}
				
			}
			
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int index=getIndex(key);
		if (elements[index]==null){
			return null;
		}
		Node node=(Node)elements[index];
		if (node.key.equals(key)){
			return node.value;
		}
		while(node.getNext()!=null){
			node=node.getNext();
			if (node.key.equals(key)){
				return node.value;
			}
		}
		return null;
	}



	@Override
	public V remove(Object key) {
		if (!containsKey(key)){
            return null;
        }
		int index=getIndex(key);
		Node node=(Node)elements[index];
		if (node==null){
			return null;
		}
		if (node.key.equals(key)){
			V removedV=node.value;
			elements[index]=node.getNext();
			size--;
			return removedV;
		}
		Node prev=node;
		node=node.getNext();
		V removedV=null;
		while(node!=null){
			
			if (node.key.equals(key)){
				removedV=node.value;
				prev.setNext(node.getNext());
			}
			prev=node;
			node=node.getNext();
			size--;
		}
		return removedV;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		 for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
	            put(entry.getKey(), entry.getValue());
	        }
	}

	@Override
	public void clear() {
		size = 0;
		elements = new Object[elements.length];
	}

	@Override
	public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {

            for(Node node = (Node) elements[i]; node != null; node = node.next) {
                keySet.add(node.key);
            }

        }

        return keySet;
	}

	@Override
	public Collection<V> values() {
		   List<V> listValues = new ArrayList<>();
	        for (int i = 0; i < elements.length; i++) {

	            for(Node node = (Node) elements[i]; node != null; node = node.next) {
	                listValues.add(node.value);
	            }

	        }

	        return listValues;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Entry<K,V>> entrySet = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {

            for(Node node = (Node) elements[i]; node != null; node = node.next) {
                entrySet.add(node);
            }

        }

        return entrySet;

	}
//	private class NodeEntry implements Entry<K,V>{
//
//		@Override
//		public K getKey() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public V getValue() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public V setValue(V value) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
////        private Node node;
////
////        public NodeEntry(Node node) {
////            this.node = node;
//        }
//
//        @Override
//        public K getKey() {
//            return node.getKey();
//        }
//
//        @Override
//        public V getValue() {
//            return node.getValue();
//        }
//
//        @Override
//        public V setValue(V value) {
//            V temp = node.value;
//            node.value = value;
//            return temp;
//        }
    

}

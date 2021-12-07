package model;

import java.util.ArrayList;

public class NodeScore {

	private int key;
	private ArrayList<Player> value;
	
	private NodeScore left;
	private NodeScore right;
	
	public NodeScore getLeft() {
		return left;
	}
	public void setLeft(NodeScore left) {
		this.left = left;
	}
	public NodeScore getRight() {
		return right;
	}
	public void setRight(NodeScore right) {
		this.right = right;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public ArrayList<Player> getValue() {
		return value;
	}
	public void setValue(ArrayList<Player> value) {
		this.value = value;
	}
	public NodeScore(int key) {
		
		this.key = key;
		this.value = new ArrayList<>();
	}
	
	public void insert(int key2, Player value) {
		// TODO Auto-generated method stub
		if(key<this.key) {
			if(this.left==null) {
				this.left= new NodeScore(key2);
				this.left.getValue().add(value);
			}else {
				this.left.insert(key2, value);
			}
		}else if(key>this.key) {
			if(this.right==null) {
				this.right=  new NodeScore(key2);
				this.right.getValue().add(value);
				
			}else {
				this.right.insert(key2, value);
			}
		}else {
			this.getValue().add(value);
		}
	}
}

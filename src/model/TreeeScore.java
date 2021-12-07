package model;

public class TreeeScore {

private NodeScore root;

private String out;
	
	public void add(int key,Player value ) {
		if(root==null) {
			root= new NodeScore(key);
		}else {
			root.insert(key,value);
		}
		
	}
	
	public void treggerInOrder() {
		inOrder(root);
	}

	private void inOrder(NodeScore root2) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return;
		}
		
		inOrder(root.getLeft());
		out+= root.getKey();
		inOrder(root.getRight());
	}
	
	public NodeScore search(NodeScore node, int key) {
		if(node==null) {
			return null;
			
		}
		if(key==node.getKey()) {
			return node;
		}
		if(key<node.getKey()) {
			return search(node.getLeft(),key);
		}else {
			return search(node.getRight(),key);
		}
	}
	
	public void triggerMaxLevel() {
		int level= getMaxLevel(root,1);
		out= String.valueOf(level);
	}

	private int getMaxLevel(NodeScore root2, int i) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return i-1;
		}else {
			int A= getMaxLevel(root.getLeft(),i+1);
			int B= getMaxLevel(root2.getRight(), i+1);
			return Math.max(A, B);
		}
		

	}
	
	public NodeScore getMin(NodeScore current){
		if (current.getLeft() == null) {
			return current;
		} else {
			return getMin(current.getLeft());
		}
	}
	
	public NodeScore getMax(NodeScore current) {
		if (current.getRight() == null) {
			return current;
		}else {
			return getMax(current.getRight());
		}
	}
	
	public void triggerDelete(int key) {
		if (root != null){
			root = delete(root, key);
		}
	}
		
	public NodeScore delete(NodeScore current, int key){
		
		if (current.getKey() == key){
			if (current.getLeft() == null && 
					current.getRight() == null){
				return null;
			} else if (current.getLeft() != null && 
					current.getRight() != null) {
				NodeScore succesor = getMin(current.getRight());
				NodeScore newRightTree = delete(current.getRight(), succesor.getKey());
				
				succesor.setLeft(current.getLeft());
				succesor.setRight(newRightTree);

				return succesor;
			} else if (current.getLeft() != null) {
				return current.getLeft();
			} else {
				return current.getRight();
			}
			
		} else if (key < current.getKey()){
			NodeScore newLeftTree = delete(current.getLeft(), key);
			current.setLeft(newLeftTree);
		} else {
			NodeScore newRightTree = delete(current.getRight(), key);
			current.setRight(newRightTree);
		}
		
		return current;
	}
	
	public TreeeScore() {
		
	}
	
	
}

package model;

public class TreeName {
	
	private NodeName root;
	private String out;
	
	public TreeName(){
		
	}
	
	public void insert(String key, Player value) {
		if(root==null) {
			root= new NodeName(key,value);
		}else {
			root.insert(key,value);
		}
		
	}
	
	public NodeName triggerSearch(String key) {
		return search(root,key);
	}
	
	
	public NodeName search(NodeName name, String key) {
		if(name==null) {
			return null;
		}
		if(key.equals(name.getKey())) {
			return name;
		}
		if(key.compareTo(name.getKey())<0) {
			return search(name.getIzq(),key);
		}else {
			return search(name.getDer(),key);
		}
	}
	
	public void treggerInorder() {
		inOrder(root);
	}

	public String inOrder(NodeName root2) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return null; 
		}
		inOrder(root2.getIzq());
		out += root2.getKey();
		inOrder(root2.getDer());
		return out;
	}
	
	public NodeName buscarTrigger(String name) {
		return buscar(root, name);
	}

	private NodeName buscar(NodeName root2, String name) {
		if(root2==null) {
			return null;
		}
		if(name.equals(root2.getKey())) {
			return root2;
		}
		if(name.compareTo(root2.getKey())<0) {
			return buscar(root2.getIzq(),name);
		}else {
			return buscar(root2.getDer(),name);
		}
	}
	
	public String triggerMaxLevel() {
		int level = getMaxLevel(root,1);
		out= String.valueOf(level);
		return out;
	}

	private int getMaxLevel(NodeName root2, int i) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return i-1;
		}else {
			int A= getMaxLevel(root2.getDer(), i+1);
			int B= getMaxLevel(root2.getIzq(), i+1);
			
			return Math.max(A, B);
		}
		
	}
	
	public void triggerDelete(String name) {
		if(root!=null) {
			root= delete(root,name);
		}
	}

	private NodeName delete(NodeName root2, String name) {
		// TODO Auto-generated method stub
		if (root2.getKey().equals(name)){
			if (root2.getIzq() == null && 
					root2.getDer() == null){
				return null;
			} else if (root2.getIzq() != null && 
					root2.getDer() != null) {
				NodeName succesor = getMin(root2.getDer());
				NodeName newRightTree = delete(root2.getDer(), succesor.getKey());
				
				succesor.setIzq(root2.getIzq());
				succesor.setDer(newRightTree);

				return succesor;
			} else if (root2.getIzq() != null) {
				return root2.getIzq();
			} else {
				return root2.getDer();
			}
			
		} else if (name.compareTo(root2.getKey())<0){
			NodeName newLeftTree = delete(root2.getIzq(), name);
			root2.setIzq(newLeftTree);
		} else {
			NodeName newRightTree = delete(root2.getDer(), name);
			root2.setDer(newRightTree);
		}
		
		return root2;
		
		
	}

	private NodeName getMin(NodeName der) {
		// TODO Auto-generated method stub
		if(der.getIzq()==null) {
			return der;
		}else {
			return getMin(der.getIzq());
		}
		
		
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}

	
}

package model;

public class NodeName {

	private String key;
	private Player value;
	
	private NodeName izq;
	private NodeName der;
	
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Player getValue() {
		return value;
	}
	public void setValue(Player value) {
		this.value = value;
	}
	public NodeName getIzq() {
		return izq;
	}
	public void setIzq(NodeName izq) {
		this.izq = izq;
	}
	public NodeName getDer() {
		return der;
	}
	public void setDer(NodeName der) {
		this.der = der;
	}
	public NodeName(String key, Player value ) {
		
		this.key = key;
		this.value = value;
	
	}
	public void insert(String key2, Player value2) {
		// TODO Auto-generated method stub
		if(key2.compareTo(this.key)<0) {
			if(this.izq==null) {
				this.izq= new NodeName(key2,value2);
			}else {
				this.izq.insert(key2, value2);
			}
		}else if(key2.compareTo(this.key)>0) {
			if(this.der==null) {
				this.der= new NodeName(key2,value2);
				
			}else {
				this.der.insert(key2, value2);
			}
		}
	}
	
	
	
	
}

package modelo_estrutura;

public class Deck {

	/* Class "Deck":
	 * This Class is a Data Structure's Model from a Deck (Double-Ended Queue);
	 * It have three attributes:
	 * - "first": It's a Cell-Type attribute that points to the first Cell-Type object on the Queue.
	 * - "last": It's a Cell-Type attribute that points to the last Cell-Type object on the Queue.
	 * - "length": As that name says, it's the length of the Queue
	 * 
	 * Plus, this Data Structure have the following Methods:
	 * - ".pushOnBegin()"
	 * - ".pushOnEnd()"
	 * - ".popOnBegin()"
	 * - ".popOnEnd()"
	 * - ".peekOnBegin()"
	 * - ".peekOnEnd()"
	 * - ".length()"
	 * 
	 * To avoid long commentaries, there is more information about the Methods on them.
	 * ~~Uriel A. de Oliveira LasHeras
	 */
	
	//Atributos:
	
	private Cell first = null;
	private Cell last = null;
	
	private int length = 0;
	
	//M�todos:
	public void pushOnBegin(Object info){
		/* Method ".pushOnBegin()":
		 * This method inserts an element on the begin of the Queue.
		 */
		
		Cell newCell = new Cell(null, this.first, info);
		this.first.setAnt(newCell);
		this.first = newCell;
		setLength(getLength() + 1);
		
	}
	
	public void pushOnEnd(Object info){
		/*Method ".pushOnEnd()":
		 * This method inserts an element on the end of the Queue.
		 */
		
		Cell newCell = new Cell(this.last, null, info);
		this.last.setProx(newCell);
		this.last = newCell;
		setLength(getLength() + 1);
		
	}
	
	public void popOnBegin(){
		/* Method ".popOnBegin()":
		 * This method removes an element on the begin of the Queue.
		 */
		
		this.first = this.first.getProx();
		this.first.setAnt(null);
		setLength(getLength() - 1);
		
	}
	
	public void popOnEnd(){
		/* Method ".popOnEnd()":
		 * This method removes an element on the end of the Queue.
		 */
		
		this.last = this.last.getAnt();
		this.last.setProx(null);
		setLength(getLength() - 1);
		
	}
	
	public Object peekOnBegin(){
		/* Method ".peekOnBegin()":
		 * This method returns the Object-Type "info" from the Cell-Type object that this Cell-Type
		 * "first" points to. 
		 */
		
		return this.first.getInfo();
	}
	
	public Object peekOnEnd(){
		/* Method ".peekOnEnd()":
		 * This method returns the Object-Type "info" from the Cell-Type object that this Cell-Type
		 * "last" points to. 
		 */
		
		return this.last.getInfo();
	}
	
	public int length(){
		/* Method ".length()":
		 * This method returns the Int-Type variable "length" of this Queue, that represents the length of
		 * the Queue.
		 */
		
		return this.length();
		
	}
	
	//Gets n' Sets:

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}

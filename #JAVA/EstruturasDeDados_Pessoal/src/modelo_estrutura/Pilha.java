package modelo_estrutura;
/* Class "Pilha":
* This Class is a Data Structure's Model from a Stack;
* It have two attributes:
* - "last": It's a Cell-Type attribute that points to the last Cell-Type object on the Stack.
* - "length": As that name says, it's the length of the Stack.
* 
* Plus, this Data Structure have the following Methods:
* - ".push()"
* - ".pop()"
* - ".peek()"
* - ".find()"
* - ".length()"
* - ".toString()"
* 
* To avoid long commentaries, there is more information about the Methods on themselves.
* ~~Uriel A. de Oliveira LasHeras
*/
public class Pilha {
    
    private Cell last = null;
    private int length = 0;
    
    public void push(Object info){
        /* ".push()" Method:
        This method adds a new element to the Stack.
        Notice that the element is aways added on the begin of the queue, never on the
        midle or in the end, following the project of this data structure.
        */
        Cell newCell = new Cell(null, this.last, info);
        
        if (this.last != null){
            this.last.setProx(newCell);
        }
        
        this.last = newCell;
        this.length++;
    }
    
    public void pop(){
        /* ".pop()" Method:
        This method removes an element from the Stack.
        Notice that it's removed aways from the end, followind the LIFO rule from
        this data structure's project.
        */
        this.last = this.last.getAnt();
        this.length--;
    }
        
    public Object peek(){
        /* ".peek()" Method:
        This method returns the value of the information holded by the last element
        of this queue. Notice that it aways returns the value of the last, never from
        any other element, following the project of this data structure.
        */
        return this.last.getInfo();
        
    }
    
    public Object find(int position){
        /* ".find()" Method:
        This method returns the information holded by an element at any position of
        this queue. Notice that, different from the ".peek()" method, it returns based
        on the element's position.
        */
        Cell findCell = this.last;
        
        for(int i = 0; i<=position-1; i++){
            
            findCell = findCell.getProx();
            
        }
        
        return findCell.getInfo();
    }
    
    public int length(){
        /* ".length()" Method
        This method returns the "length" attribute, that is the length of the queue.
        */
        return this.length;
        
    }
    
    @Override
    public String toString(){
        /* ".toString()" Method:
        This method returns a String with all values in this Queue.
        */
        Cell act = this.last;
        String returns = "[";
        
        for(int i = 0; i<=this.length-1; i++){
        
            returns = returns + act.getInfo();
            act = act.getAnt();
        
        }
        returns = returns + "]\n";
        return returns; 
    }
    
}

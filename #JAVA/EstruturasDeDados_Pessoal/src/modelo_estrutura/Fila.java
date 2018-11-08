package modelo_estrutura;
/* Class "Fila":
* This Class is a Data Structure's Model from a Queue;
* It have three attributes:
* - "first": It's a Cell-Type attribute that points to the first Cell-Type object on the Queue.
* - "last": It's a Cell-Type attribute that points to the last Cell-Type object on the Queue.
* - "length": As that name says, it's the length of the Queue
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
public class Fila {
    
    private Cell first = null;
    private Cell last = this.first;
    private int length = 0;
    
    public void push(Object info){
        /* ".push()" Method:
        This method adds a new element to the Queue.
        Notice that the element is aways added on the end of the queue, never on the
        midle or in the begin, following the project of this data structure.
        */
        Cell newCell = new Cell(null, this.last, info);
        
        if (this.first == null){
            this.first = newCell;
        }else{
            this.last.setProx(newCell);
        }
        this.last = newCell;
    
        this.length++;
        
    }
    
    public void pop(){
        /* ".pop()" Method:
        This method removes an element from the Queue.
        Notice that it's removed aways from the begin, followind the FIFO rule from
        this data structure's project.
        */
        this.first = this.first.getProx();
        this.length--;
    }
        
    public Object peek(){
        /* ".peek()" Method:
        This method returns the value of the information holded by the first element
        of this queue. Notice that it aways returns the value of the first, never from
        an element on the midle or the last, following the project of this data structure.
        */
        return this.first.getInfo();
        
    }
    
    public Object find(int position){
        /* ".find()" Method:
        This method returns the information holded by an element at any position of
        this queue. Notice that, different from the ".peek()" method, it returns based
        on the element's position, whatever if it is the first or the last.
        */
        Cell findCell = this.first;
        
        for(int i = 0; i<=position-1; i++){
            
            findCell = findCell.getProx();
            
        }
        
        return findCell.getInfo();
    }
    
    public int legth(){
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
        Cell act = this.first;
        String returns = "[";
        
        for(int i = 0; i<=this.length-1; i++){
        
            returns = returns + act.getInfo();
            act = act.getProx();
        
        }
        returns = returns + "]\n";
        return returns; 
    }
    
}

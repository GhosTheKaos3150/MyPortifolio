package modelo_estrutura;
/* Class "Cell":
* This is an Assistant-Class from all the Data Structure's Classes of this code.
* It can be used at any structures that needs a Double-Linked Data-Cell.
* 
* Bellow, you will find attributes and methods that will support this Class.
* There are the following attributes:
* - "ant": It's a Cell-Type attribute that points to a Cell-Type object before this on the Queue.
* - "prox": It's a Cell-Type attribute that points to a Cell-Type object after this on the Queue.
* - "info": It's a Object-Type attribute that will points to any data-value. It's supposed to be the
* value of this cell's information.
* 
* Also, there is a Constructor and some getters and setters. At this point, i suppose that you, as a
* programmer, may know what it means. So i'll leave you here.
* See ya soon!
* 
* ~~Uriel A. Oliveira LasHeras
*/
public class Cell {
   
    private Cell prox = null;
    private Cell ant = null;
    private Object informacao = null;
    
    public Cell(Cell prox, Cell ant, Object info){
        this.prox = prox;
        this.ant = ant;
        this.informacao = info;
    }
    
    public void setProx (Cell p){
        this.prox = p;
    }
    
    public Cell getProx(){
        return this.prox;
    }
    
    public void setAnt(Cell a){
        this.ant = a;
    }
    
    public Cell getAnt(){
        return this.ant;
    }
    
    public void setInfo(Object i){
        this.informacao = i;
    }
    
    public Object getInfo(){
        return this.informacao;
    }
}

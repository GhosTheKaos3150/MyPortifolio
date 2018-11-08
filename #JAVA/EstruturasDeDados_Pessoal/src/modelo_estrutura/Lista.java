package modelo_estrutura;

/* Class "Lista":
* This Class is a Data Structure's Model from a Double-Linked List;
* It have three attributes:
* - "first": It's a Cell-Type attribute that points to the first Cell-Type object on the Queue.
* - "last": It's a Cell-Type attribute that points to the last Cell-Type object on the Queue.
* - "length": As that name says, it's the length of the Queue
* 
* Plus, this Data Structure have the following Methods:
* - ".add()"
* - ".addAtEnd()"
* - ".remove()"
* - ".removeAtEnd()"
* - ".find()"
* - ".length()"
* - ".toString()"
* 
* To avoid long commentaries, there is more information about the Methods on themselves.
* ~~Uriel A. de Oliveira LasHeras
 */
public class Lista {

    //Attributes
    private Cell first = null;
    private Cell last = null;

    private int length = 0;

    //Methods
    public void add(Object info) {
        /* ".add()" Method
        This method adds a new element in the begin of the list.
         */
        Cell newCell = new Cell(this.first, null, info);

        if (length == 0) {
            this.last = newCell;
            this.first = newCell;
        } else {
            this.first.setAnt(newCell);
            this.first = newCell;
        }
        length++;

    }

    public void addAtEnd(Object info) {
        /* ".addAtEnd()" Method
        This method adds a new element in the end of the list.
         */
        Cell newCell = new Cell(null, this.last, info);
        if (length == 0) {
            this.last = newCell;
            this.first = newCell;

        } else {

            this.last.setProx(newCell);
            this.last = newCell;

        }

        length++;

    }

    public void add(int place, Object info) {
        /* ".add()" Method [overcharged]
        This method adds a new element at any point of this list. Notice that, if the
        desired position is the first or the last, it will call the ".add()" or ".addAtEnd()"
        instead.
        
        Also, it uses a method to reduce the memory's cosume, where i divide the whole list
        in two. If the number "place" is near to the first element, it will start from there.
        Else, it will starts to search from the end. I think that it's just smarter that way.
         */
        Cell act;

        if (place == 0) {
            this.add(info);
        } else if (place == this.length) {
            this.addAtEnd(info);
        } else {

            if (place <= (this.length-1) / 2) {

                act = this.first;
                for (int i = 0; i < place-1; i++) {

                    act = act.getProx();

                }

                Cell newCell = new Cell(act.getProx(), act, info);

                act.setProx(newCell);
                act = newCell.getProx();
                act.setAnt(newCell);

            } else {

                act = this.last;
                for (int i = length; i > place+1; i--) {

                    act = act.getAnt();

                }

                Cell newCell = new Cell(act, act.getAnt(), info);

                act.setAnt(newCell);
                act = newCell.getAnt();
                act.setProx(newCell);

            }

        }

        length++;

    }

    public void remove() {
        /* ".remove()" Method
        This method remove an element in the begin of the list.
         */
        this.first = this.first.getProx();
        this.first.setAnt(null);

        length--;

    }

    public void removeAtEnd() {
        /* ".removeAtEnd()" Method
        This method removes an element in the end of the list.
         */
        this.last = this.last.getAnt();
        this.last.setProx(null);

        length--;

    }

    public void remove(int place) {
        /* ".remove()" Method [overcharged]
            This method removes an element at any position of this list. Notice that, like in
            the ".add()" overcharged method, if this position is the first or the last, it'll
            call the better method for it.

            Also, like the ".add()" overchaged method, i diveded the list in two. If the number
            "place" is near to the first element, it will start from there. Else, it will starts
            from the end of the list.

            Again, i think this way is just very smart and simple.
            I'm proud of myself.
         */
        
        Cell act = this.first;
        Cell ant = act;
        
        if (place <= (this.length-1)/2){
            
            for (int i = 0; i <= place-1; i++){
            
                 ant = act;
                 act = act.getProx();
            
            }
        
            act = act.getProx();
            act.setAnt(ant);
            ant.setProx(act);
            
        }else{
            
            for (int i = length-1; i >= place+1; i++){
                
                
                ant = act;
                act = act.getAnt();
                
            }
            
            act = act.getAnt();
            act.setProx(ant);
            ant.setAnt(act);
            
        }
        
        
        length--;

    }

    public Object find(int place) {
        /* ".find()" Method
        This method returns the value of the information from the element you want to find.
        
        Again, as you can see, i used the same strategy from the ".add()" and ".remove()"
        overcharged methods. If it's near to the first element, it starts from the first.
        Else, it starts from the end.
        
        It's a very simply code, but full of proud.
        I just can't believe that I had this idea.
        ...I'm proud. It's like a son, ya' know?
         */
        Cell act;

        if (place > length) {
            System.out.print("Não existe elementos nessa posição");
            return null;
        } else {

            if (place <= length / 2) {

                act = this.first;
                for (int i = 0; i == place; i++) {

                    act = act.getProx();

                }

            } else {

                act = this.last;
                for (int i = length; i == place; i++) {

                    act = act.getAnt();

                }

            }

            return act.getInfo();

        }

    }

    public int length() {
        /* ".length()" Method
        This method returns the length of this list.
         */
        return this.length;

    }

    @Override
    public String toString() {
        /* ".toString()" Method:
        This method returns a String with all values in this Queue.
         */
        Cell act = this.first;
        String returns = "[";

        for (int i = 0; i <= this.length - 1; i++) {

            returns = returns + act.getInfo();
            act = act.getProx();

        }
        returns = returns + "]\n";
        return returns;
    }
}

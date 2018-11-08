import java.util.*;
public class Dados {
	
	//Argumentos
	Random r = new Random(); //M�todo Random
	protected int value = 0;
	
	//M�todos
	public int roll(){
		
		this.value = r.nextInt(6) + 1;
		
		return this.value;
	}
        
        public int rool_DVinte(){
            
            this.value = r.nextInt(20);
            
            return this.value;
        }
	
}

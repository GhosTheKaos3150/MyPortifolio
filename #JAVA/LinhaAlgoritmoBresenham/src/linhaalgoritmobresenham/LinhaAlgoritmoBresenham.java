package linhaalgoritmobresenham;
import ClasseMatriz.ClasseMatriz;
import java.util.Scanner;

public class LinhaAlgoritmoBresenham {

    public static void main(String[] args) {
       

        ClasseMatriz mtx = new ClasseMatriz();
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Bem vindo!");
        
        while (true) {            
            
            mtx.setLine();
            
            boolean x = true;
            while ( x == true ) {                
                
                System.out.println("Deseja encerrar a aplicação?[s\\n]");
                String a = sc.next();
                a = a.toLowerCase();
                
                switch (a) {
                    case "s":
                        System.exit(0);
                        break;
                    case "n":
                        x = false;
                        mtx.clearMatriz();
                        break;
                    default:
                        System.out.println("Por favor, responda \"s\" ou \"n\".");
                }
            }
            
        }
        
    }
    
}

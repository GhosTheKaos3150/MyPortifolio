package alura_estudosobreexceções;

public class Alura_EstudoSobreExceções {

    public static void main(String[] args) {
        
        int x = 0;
        MetodoUm(x);
    }
    
    public static void MetodoUm (int x){
        System.out.println("Inicio Metodo 1!");
        int a = x++;
        try {
            
            MetodoDois(a);
            
        } catch (NovaExceçãoUnchecked e) {
            
            System.out.println(e.getMessage());
        }
        System.out.println("Fim Metodo 1!");
    }
    
    public static void MetodoDois (int x) throws NovaExceçãoUnchecked{
        System.out.println("Inicio Metodo 2!");
        int a = x++;
        try {
            
            MetodoTres(a);
        
        } catch (ArithmeticException e) {
            
            System.out.println(e.getMessage());
        
        }
        
        /*MetodoTres(a);*/
        
        throw new NovaExceçãoUnchecked("Cabala");
        //System.out.println("Fim Metodo 2!");
    }
    
    public static void MetodoTres (int x){
        System.out.println("Inicio Metodo 3!");
        int a = x/0;
        System.out.println("Fim Metodo 3!");
        
    }
    
}

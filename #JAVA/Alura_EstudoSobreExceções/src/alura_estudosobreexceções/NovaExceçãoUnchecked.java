package alura_estudosobreexceções;

public class NovaExceçãoUnchecked extends Exception{
    
    public NovaExceçãoUnchecked (String msg){
        /*
        O que faz?
        - Recebe parâmetro "msg" do tipo String
        - Envia para a Superclasse "RuntimeException", para definir a mensagem 
        que será exibida pela exceção.
        */
        super(msg);
    }
    
}

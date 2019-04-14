package ClasseMatriz;
import java.util.Arrays;
import java.util.Scanner;
import java.math.MathContext;

public class ClasseMatriz {
    
    Scanner sc = new Scanner (System.in);
    
    private int [][] Matriz = new int[50][50];
    private int positA[] = new int[2];
    private int positB[] = new int[2];
    
    public ClasseMatriz(){
    
        System.out.println("Aguarde enquanto populamos a Matriz...");
        
        for (int i = 0; i < 50; i++){
            for (int j = 0; j <50; j++){
                
                this.Matriz[i][j] = 0;
                
            }
        }
        
        for (int i = 0; i<2; i++){
            this.positA[i] = 0;
            this.positB[i] = 0;
        }
        
        this.printMatriz();
        
    }

    public void setLine (){
        
        System.out.println("Digite posição inicial A:");
        this.positA[0] = sc.nextInt();
        this.positA[0]--;
        System.out.println("Digite posição inicial B:");
        this.positB[0] = sc.nextInt();
        this.positB[0]--;
        System.out.println("Digite posição final A:");
        this.positA[1] = sc.nextInt();
        this.positA[1]--;
        System.out.println("Digite posição final B:");
        this.positB[1] = sc.nextInt();
        this.positB[1]--;
        
        this.calculoBresenham(this.positA[0], this.positA[1], this.positB[0], this.positB[1]);
        
    }
    
    private void calculoBresenham (int x1, int x2, int y1, int y2){
    
        int dx = x2 - x1;
        int dy = y2 - y1;
        int aux1 = 2*dy;
        int aux2 = 2*dy - 2*dx;
        int decisao = 2*dy-dx;
//        double Dm = dy/dx;
        int x = x1, y = y1;
        
//        int octant = this.getOctant(x1, y1, x2, y2, Dm);
//        
//        switch (octant){
//            case 0:
//                x = x1;
//                y = y1;
//                break;
//            case 1:
//                x = y1;
//                y = x1;
//                break;
//            case 2:
//                x = -1*y1;
//                y = x1;
//                break;
//            case 3:
//                x = -1*x1;
//                y = y1;
//                break;
//            case 4:
//                x = -x1;
//                y = -y1;
//                break;
//            case 5:
//                x = -y1;
//                y = -x1;
//                break;
//            case 6:
//                x = y1;
//                y = -x1;
//                break;
//            case  7:
//                x = x1;
//                y = -y1;
//                break;
//        }
        
        this.Matriz[x][y] = 1;
        
        while (x < x2 || y < y2){
            
            if (decisao <= 0){
                decisao += aux1;
                x++;
            } else {
                decisao += aux2;
                x++;
                y++;
            }
            
            this.Matriz[x][y] = 1;
            
        }
        
        this.printMatriz();
        
    }
    
//    private int getOctant(int Px1, int Py1, int Px2, int Py2, double Dm){
//        
//        if (Px1 < Px2  &&  (Dm >= 0 || Dm <=1)){
//            return 0;
//            
//        } else if (Py1 < Py2  &&  Dm > 1){
//            return 1;
//            
//        } else if (Py1 < Py2  &&    Dm < -1){
//            return 2;
//            
//        } else if (Px2 < Px1  &&  (Dm <=0 || Dm >=-1)){
//            return 3;
//            
//        } else if (Px2 < Px1  &&  (Dm >=0 || Dm <=1)){
//            return 4;
//            
//        } else if (Py2 < Py1  &&  Dm > 1){
//            return 5;
//            
//        } else if (Py2 < Py1  &&  (Dm < -1)){
//            return 6;
//            
//        } else if (Px1 < Px2  &&  (Dm <= 0  || Dm >= -1)){
//            return 7;
//            
//        }
//        
//        return 0;
//        
//    }
    
    public void getMatriz() {
        this.printMatriz();
    }

    public double getPositA(int pos) {
        return positA[pos];
    }

    public double getPositB(int pos) {
        return positB[pos];
    }
    
    private void printMatriz(){
        System.out.println("Printando Matriz...");
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    
                    System.out.print(Matriz[i][j] + " ");
                    
                }
                System.out.println();
            }
    }
    
    public void clearMatriz(){
        for (int i = 0; i < 50; i++){
            for (int j = 0; j <50; j++){
                
                this.Matriz[i][j] = 0;
                
            }
        }
    }
    
}

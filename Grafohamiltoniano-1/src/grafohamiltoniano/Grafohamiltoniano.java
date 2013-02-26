/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafohamiltoniano;

/**
 *
 * @author desteban.yepes
 */
public class Grafohamiltoniano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int matrizAdy[][] = new int[4][4];
        
        //Casita
//        matrizAdy[0][1] = 5;
//        matrizAdy[1][0] = 5;
//        matrizAdy[0][4] = 3;
//        matrizAdy[4][0] = 3;
//        matrizAdy[1][2] = 1;   
//        matrizAdy[2][1] = 1;
//        matrizAdy[2][3] = 1;   
//        matrizAdy[3][2] = 1;
//        matrizAdy[4][3] = 1;
//        matrizAdy[3][4] = 1;
//        

//        
        //libro
//        matrizAdy[0][1] = 1;
//        matrizAdy[1][2] = 1;   
//        matrizAdy[2][3] = 1;   
//        matrizAdy[2][4] = 1;   
//        matrizAdy[3][4] = 1;
//        matrizAdy[4][0] = 1;
//        matrizAdy[4][1] = 1;
//        matrizAdy[4][3] = 1;
//////        
//        matrizAdy[1][0] = 1;
//        matrizAdy[2][1] = 1;   
//        matrizAdy[3][2] = 1;   
//        matrizAdy[4][2] = 1;   
//        matrizAdy[4][3] = 1;
//        matrizAdy[0][4] = 1;
//        matrizAdy[1][4] = 1;
//        matrizAdy[3][4] = 1;
//      
        
        //para TSP
//        matrizAdy[0][1] = 20;
//        matrizAdy[1][0] = 20;
//        matrizAdy[0][3] = 35;
//        matrizAdy[3][0] = 35;
//        matrizAdy[0][2] = 42;
//        matrizAdy[2][0] = 42;
//        matrizAdy[1][2] = 30;
//        matrizAdy[2][1] = 30;
//        matrizAdy[1][3] = 34;
//        matrizAdy[3][1] = 34;
//        matrizAdy[2][3] = 12;
//        matrizAdy[3][2] = 12;
        
        //OTRO PARA TSP
        matrizAdy[0][1] = 1;
        matrizAdy[0][2] = 5;
        matrizAdy[0][3] = 4;
        matrizAdy[1][0] = 7;
        matrizAdy[1][2] = 3;
        matrizAdy[1][3] = 1;
        matrizAdy[2][0] = 5;
        matrizAdy[2][1] = 3;
        matrizAdy[2][3] = 2;
        matrizAdy[3][0] = 4;
        matrizAdy[3][1] = 1;
        matrizAdy[3][2] = 2;
        
        //moñito
//        matrizAdy[0][2] = 1;
//        matrizAdy[2][0] = 1;
//        matrizAdy[0][1] = 1;
//        matrizAdy[1][0] = 1;
//        matrizAdy[1][2] = 1;
//        matrizAdy[2][1] = 1;
//        matrizAdy[0][3] = 1;
//        matrizAdy[3][0] = 1;
//        matrizAdy[0][4] = 1;
//        matrizAdy[4][0] = 1;
//        matrizAdy[4][3] = 1;
//        matrizAdy[3][4] = 1;
//////////
////////        Suficientes prueba = new Suficientes();
////////        prueba.condicion1(matrizAdy);
////////        prueba.condicion2();
////////        prueba.condicion3();
////////
////////        Necesarias prueba2 = new Necesarias();
////////        boolean blablabla = prueba2.tieneverticedecorte(matrizAdy);
////////        
////////        
////////        
////////        
////////
////////        //Imprimir La matriz OJO
////////        for (int i = 0; i < matrizAdy.length; i++) {
////////            for (int j = 0; j < matrizAdy.length; j++) {
////////                System.out.print(Integer.toString(matrizAdy[i][j]));
////////
////////            }
////////            System.out.println();
////////        }
        
        
            camino caminoh = new camino();
        caminoh.producto(matrizAdy);
    }
}

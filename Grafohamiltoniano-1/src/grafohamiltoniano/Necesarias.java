/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafohamiltoniano;

/**
 *
 * @author desteban.yepes
 */
public class Necesarias {

    int matrizaux[][];
    int matrizaux1[][];
    int vectordecomponentes[];
    int numcomp = 1;
    int k = 1;
    int exclusion = 0;

    public boolean esConexo(int Grafo[][]) {
        exclusion = 1;
        numcomp = 1;
        k = 1;
        boolean respuesta = true;
        matrizaux = Grafo;
        int iguales = 0;
        int vertices = Grafo.length;
        int compConexas[] = new int[vertices];
        int existe = 0;

        for (int n = 1; n < vertices; n++) {
            if (Grafo[0][n] == 1) {
                compConexas[k] = n;
                k++;
            }
        }

        if (k == 1) {
            for (int h = 1; h < vertices; h++) {
                for (int o = 1; o < vertices; o++) {
                    if (Grafo[h][o] == 1) {
                        compConexas[0] = h;
                        compConexas[k] = o;
                        k++;
                    }
                }
                if (k != 1) {
                    numcomp++;
                    h = vertices + 1;
                }
            }
        } 
        
        for (int i = 1; i <= k - 1; i++) {
            int variable = compConexas[i];

            for (int j = variable + 1; j < vertices; j++) {

                if (Grafo[variable][j] == 1) {
                    for (int p = 0; p < k; p++) {
                        if (j == compConexas[p]) {
                            existe = 1;
                        }
                    }
                    if (existe == 0) {
                        compConexas[k] = j;
                        k++;
                    }
                }
                existe = 0;
            }
        }
    
        vectordecomponentes = compConexas;
        System.out.println("Valor K es "+ k);
        System.out.println("grafo .len" + Grafo.length);
        
        if (k < Grafo.length) {
            respuesta = false;
            // Miramos cuantas componentes existen
            vectordecomponentes = compConexas;

            for (int m = 0; m <= Grafo.length - 1; m++) {
                iguales = 0;
                for (int g = 0; g < vectordecomponentes.length -1; g++) {

                    if (m == vectordecomponentes[g]) {
                        iguales = 1;
                    }
                }

                if (iguales == 0) {
//                    vectordecomponentes[k] = m;
                    numerodecomponentes(m);
                }
            }
        }
        exclusion = 0;
        return respuesta;

    }

    public int numerodecomponentes(int i) {
        int existe = 0;
        int vertices = matrizaux.length;
        int variable = i;
        //vectordecomponentes[k] = variable;
        k++;
        for (int j = variable + 1; j < vertices; j++) {
            if (matrizaux[variable][j] == 1) {
                for (int p = 0; p < k - 1; p++) {
                    if (j == vectordecomponentes[p]) {
                        existe = 1;
                    }
                }
                if (existe == 0) {
                    vectordecomponentes[k] = j;
                    k++;
                    for (int d = j; d <= k - 1; d++) {
                        int variable2 = vectordecomponentes[d];

                        for (int jj = variable2 + 1; jj < vertices; jj++) {

                            if (matrizaux[variable2][jj] == 1) {
                                for (int pp = 0; pp < k; pp++) {
                                    if (jj == vectordecomponentes[pp]) {
                                        existe = 1;
                                    }
                                }
                                if (existe == 0) {
                                    vectordecomponentes[k] = jj;
                                    k++;
                                }
                            }
                            existe = 0;
                        }
                    }
                }
            }
            existe = 0;
        }
        return numcomp;
    }

    public boolean tieneverticedecorte(int Grafo[][]) {
        boolean respuesta2 = false;
        int ii = 0;
        int jj = 0;
        boolean esconex = esConexo(Grafo);
        if (esconex == true)
        {
        int a = numcomp;               
        System.out.println("Valor a " + a);
        int matrizaux2[][]= new int[Grafo.length-1][Grafo.length-1];
        matrizaux1 = Grafo;
        for (int g =0 ; g< Grafo.length;g++) // control
        {
            
        for (int i = 0; i < Grafo.length; i++) {
               if(i>g){
                   ii=i-1;          
               }else ii=i;
               
            for (int j = 0; j < Grafo.length; j++) {
                if(j>g){
                   jj=j-1;          
               }else jj=j;   
                if (g!=i){
                  if (g!=j){
                      if(g==0){
                          matrizaux2[i-1][j-1] = matrizaux1[i][j];
                          System.out.print(Integer.toString(matrizaux2[i-1][j-1]));                    
                      }else
                      {
                          matrizaux2[ii][jj] = matrizaux1[i][j];
                          System.out.print(Integer.toString(matrizaux2[ii][jj]));                 
                      }
       
                  }
              }
            }       
                 System.out.println("");
          }
 
           //System.out.println("el valor del vector de comp es " + vectordecomponentes.length);
           for(int u =0; u<vectordecomponentes.length;u++){
            vectordecomponentes[u]=0;
            }
            numcomp=0;
            boolean auxb = esConexo(matrizaux2); 
              if (auxb == false){
                System.out.println("el vertice " + g +" es un vertice de corte");
                return true;
            }
           
            
            int b = numcomp;
            System.out.println("valor b " + b);
            if (b > a) {
                System.out.println("el vertice " + g +" es un vertice de corte");
                return true;
            }else {
            System.out.println("el vertice " + g +" no es un vertice de corte");
            
            }
            
          
        }
        
      }
        return respuesta2;
    }
}

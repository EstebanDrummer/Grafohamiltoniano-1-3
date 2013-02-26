/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafohamiltoniano;

import java.math.BigInteger;

/**
 *
 * @author caugusto.salazar
 */
public class camino {

    
    String vari;
    String varj;
    String con1;
    String con2;
    String concat;
    String concat2;
    String caract;
    boolean sihayciclos;
    boolean sihaycaminos;
    
    int caract1;
    int vertices;
    int maximo;
    int controlador;
    int mas;
    int cuantosCiclos;
    
    
    
    public void producto(int Grafo[][]) {

        BigInteger matrizM[][] = new BigInteger[Grafo.length][Grafo.length];
        BigInteger matrizMactual[][] = new BigInteger[Grafo.length][Grafo.length];
        BigInteger matrizManterior[][] = new BigInteger[Grafo.length][Grafo.length];
        BigInteger matrizCaminos[][] = new BigInteger[Grafo.length][Grafo.length];
        
      
        int primero, segundo;
        String tipo;
        String termino;
        int element;

        vertices = Grafo.length - 1;

        matrizM = inicializarMatriz(matrizM);
        matrizMactual = inicializarMatriz(matrizMactual);
        matrizManterior = inicializarMatriz(matrizManterior);
        matrizCaminos = inicializarMatriz(matrizCaminos);

        //obtenemos las matrices M y M1


        for (int i = 0; i < Grafo.length; i++) {
            for (int j = 0; j < Grafo.length; j++) {
                if (Grafo[i][j] != 0) {
                    vari = String.valueOf(i + 1);
                    varj = String.valueOf(j + 1);
                    concat = vari + varj;
                    matrizManterior[i][j] = BigInteger.valueOf(Long.parseLong(concat));
                    matrizM[i][j] = BigInteger.valueOf(Long.parseLong(varj));
                }
            }
        }


        //imprime m  
        System.out.println("La matriz M es:");
        imprimirmatriz(matrizM);
        System.out.println("La matriz M 1 es:");
        imprimirmatriz(matrizManterior);

        for (int n = 2; n <= vertices; n++) {
            // multiplicamos M por MAnterior y la guardamos en Mactual
            for (int i = 0; i < Grafo.length; i++) {
                for (int j = 0; j < Grafo.length; j++) {
                    for (int k = 0; k < Grafo.length; k++) {

                        //miramos que sean diferentes de cero en la mtriz 
                        // System.out.println(" comparo "+i+j+k);
                        if (matrizManterior[i][k].compareTo(BigInteger.ZERO) != 0 & matrizM[k][j].compareTo(BigInteger.ZERO) != 0) {

                            // observamos que no exista letras en comun
                            // primero se compara los terminos
                            varj = String.valueOf(matrizM[k][j]);
                            vari = String.valueOf(matrizManterior[i][k]);


                            element = cuantosterminos(vari);


                            for (int m = 0; m < element; m++) {
                                termino = demeElemento(vari, m);

                                for (int l = 0; l < termino.length(); l++) {
                                    caract = Character.toString(termino.charAt(l));

                                    if (varj.equals(caract)) {
                                        // ponemos un cero en algo

                                        if (matrizMactual[i][j].compareTo(BigInteger.ZERO) != 0) {
                                            //matrizMactual[i][j]= BigInteger.valueOf(0);

                                            //termino="";
                                            l = termino.length();
                                        } else {
                                            matrizMactual[i][j] = BigInteger.valueOf(0);
                                            l = termino.length();
                                        }


                                    } else {
                                        // se concatena y el valor se guarda en algo. algo se actualiza a medida que se realiza las comparaciones.
                                        if (l == termino.length() - 1) {
                                            concat = termino + varj;
                                            if (matrizMactual[i][j].compareTo(BigInteger.ZERO) == 0) {
                                                matrizMactual[i][j] = BigInteger.valueOf(Long.parseLong(concat));
                                            } else {

                                                if (controlador == 0) {
                                                    controlador = 1;
                                                    concat2 = String.valueOf(matrizMactual[i][j]) + mas;
                                                    concat = concat2 + termino + varj;
                                                    BigInteger bi = new BigInteger(concat);
                                                    matrizMactual[i][j] = bi;

                                                } else {
                                                    concat2 = String.valueOf(matrizMactual[i][j]);
                                                    concat = concat2 + termino + varj;
                                                    matrizMactual[i][j] = BigInteger.valueOf(Long.parseLong(concat));

                                                }
                                            }
                                        }

                                    }
                                }
                                controlador = 0;
                            }
                        }

                    }
                    controlador = 0;
                    //segundo si son diferentes se concatenan de lo contrario no jejeje
                } //controlador=0;


            }
            System.out.println();
            // pasamos la actual a la anterior y ponemos la actual en cero
            System.out.println("LA MATRIZ M "+n+" ES:");
            for (int i = 0; i < matrizMactual.length; i++) {
                for (int j = 0; j < matrizMactual.length; j++) {
                    System.out.print(matrizMactual[i][j] + "  ");
                    matrizManterior[i][j] = matrizMactual[i][j];
                    matrizMactual[i][j] = BigInteger.valueOf(0);
                }
                System.out.println();
            }

        }

        //comprabaremos el ultimo

        for (int i = 0; i < Grafo.length; i++) {
            for (int j = 0; j < Grafo.length; j++) {
                for (int k = 0; k < Grafo.length; k++) {
                  if(i==j){
                    if (matrizManterior[i][k].compareTo(BigInteger.ZERO) != 0 & matrizM[k][j].compareTo(BigInteger.ZERO) != 0) {

                        // observamos que no exista letras en comun
                        // primero se compara los terminos
                        varj = String.valueOf(matrizM[k][j]);
                        vari = String.valueOf(matrizManterior[i][k]);


                        element = cuantosterminos(vari);


                        for (int m = 0; m < element; m++) {
                            termino = demeElemento(vari, m);

                            for (int l = 0; l < termino.length(); l++) {
                                caract = Character.toString(termino.charAt(l));


                                // se concatena y el valor se guarda en algo. algo se actualiza a medida que se realiza las comparaciones.
                                if (l == termino.length() - 1) {
                                    concat = termino + varj;
                                    if (matrizMactual[i][j].compareTo(BigInteger.ZERO) == 0) {
                                        matrizMactual[i][j] = BigInteger.valueOf(Long.parseLong(concat));
                                    } else {

                                        if (controlador == 0) {
                                            controlador = 1;
                                            concat2 = String.valueOf(matrizMactual[i][j]) + mas;
                                            concat = concat2 + termino + varj;
                                            BigInteger bi = new BigInteger(concat);
                                            matrizMactual[i][j] = bi;

                                        } else {
                                            concat2 = String.valueOf(matrizMactual[i][j]);
                                            concat = concat2 + termino + varj;
                                            matrizMactual[i][j] = BigInteger.valueOf(Long.parseLong(concat));

                                        }
                                    }
                                }


                            }
                            controlador = 0;
                        }
                    }
                  }
                }
                controlador = 0;

            }


        }
        System.out.println();

        //IMRPIME LA MATRIZ
System.out.println("LA MATRIZ M "+Grafo.length+" ES:");
        for (int i = 0; i < matrizMactual.length; i++) {
            for (int j = 0; j < matrizMactual.length; j++) {
                System.out.print(matrizMactual[i][j] + "  ");
                matrizCaminos[i][j] = matrizManterior[i][j];
                matrizManterior[i][j] = matrizMactual[i][j];
                matrizMactual[i][j] = BigInteger.valueOf(0);
            }
            System.out.println();
        }

        // almacenamos en el vector sumas los ciclos

        // Imprimimos los caminos  
        
        sihaycaminos=hayCiclosoCaminos(matrizCaminos);
        
        if (sihaycaminos == true) {
            tipo = "camino";
            imprimeLista(matrizCaminos, tipo);
        } else {
            System.out.println("NO HAY CAMINOS EN EL GRAFO");
        }
        
        
        cuantosCiclos=cuantosCiclos(matrizManterior);
        
        sihayciclos = hayCiclosoCaminos(matrizManterior);
        // Ciclo de menor peso
        int ciclos[]=new int[cuantosCiclos];    
        int sumas[] = new int[cuantosCiclos];
        
        ciclos=vectorCiclos(matrizManterior,cuantosCiclos);
        
        if (sihayciclos == true) {
            tipo = "ciclo";
            imprimeLista(matrizManterior, tipo);
            for (int i = 0; i < ciclos.length; i++) {
                varj = String.valueOf(ciclos[i]);
                for (int j = 0; j < varj.length() - 1; j++) {
                    primero = Integer.parseInt(Character.toString(varj.charAt(j)));
                    segundo = Integer.parseInt(Character.toString(varj.charAt(j + 1)));
                    sumas[i] = sumas[i] + Grafo[primero - 1][segundo - 1];
                    if (maximo < sumas[i]) {
                        maximo = sumas[i];
                    }
                }
            }TSP(sumas, ciclos);
        } else {System.out.println();
            System.out.println("NO HAY CICLOS EN EN GRAFO");
        }
//       for (int i = 0; i < ciclos.length; i++) {
//       System.out.println("Ciclo"+ciclos[i]+"con suma"+sumas[i]);
//       }
           
        System.out.println();
        System.out.println("Gracias por su tiempo");
    }
    
    
    public BigInteger[][] inicializarMatriz(BigInteger matriz[][]){
    
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
               matriz[i][j]= BigInteger.valueOf(0);
            }
            
        }
        return matriz;
    }
    
    public int cuantosterminos(String elemento) {
        int cantidad = 1;
        int escero;
        for (int l = 0; l < elemento.length(); l++) {
            escero = Integer.parseInt(Character.toString(vari.charAt(l)));
            //System.out.println("variable es:"+vari.charAt(l));
            if (escero == 0) {
                cantidad++;
            }
        }

        return cantidad;
    }
    
    public int cuantosCiclos(BigInteger matrix[][]) {
        int cantidadCiclos = 0;
        int element;
        int terminos = 0;
        //String termino;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].compareTo(BigInteger.ZERO) != 0) {
                    vari = String.valueOf(matrix[i][j]);
                    element = cuantosterminos(vari);
                    cantidadCiclos = cantidadCiclos + element;
                }
            }
        }
        return cantidadCiclos;
    }
    
    
    public String demeElemento(String elemento,int ll){
    String cadena="";
    int cantidad=0;
    int elem;
    
    
    if(ll==0){
       
        for (int l = 0; l < elemento.length(); l++){
        elem = Integer.parseInt(Character.toString(elemento.charAt(l))); 
            if (elem != 0) {
                cadena = cadena + Integer.toString(elem);
               // System.out.println("variable es:" + elemento.charAt(l));
            } else {
                l = elemento.length();
            }
        }
    }else{
        
        for (int l = 0; l <= elemento.length(); l++) {
            elem = Integer.parseInt(Character.toString(vari.charAt(l)));
            //System.out.println("deme elemento voy aqui con "+ll+"con elem "+elem);
           // System.out.println("variable es:" + vari.charAt(l));
            if (elem == 0) {
              //  System.out.println("deme elemento voy aqui con "+ll+"encontre un cero");
                cantidad++;
              //System.out.println("deme elemento voy aqui con "+ll+"encontre un cero, y cantidad es "+cantidad);
                if(cantidad==ll){l++;
                    while (l < elemento.length()) {
                       // System.out.println("entre al while ");
                        
                        elem = Integer.parseInt(Character.toString(elemento.charAt(l)));l++;
                        if (elem != 0) {
                            cadena = cadena + Integer.toString(elem);//System.out.println("Encontre la cadena "+cadena);
                          // System.out.println("variable es:" + elemento.charAt(l));
                        } else {
                            l = elemento.length();
                            
                       // System.out.println("Encontre la cadena "+cadena);
                        }
                        
                    }
                }
            }
        }
        
        
    }
    
    return cadena;
    }
    
    //imprimeMatrices
    public void imprimirmatriz(BigInteger matrix[][]){
        
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                   System.out.print(matrix[i][j] + "  ");
                }
                System.out.println();
            }System.out.println();
    }
    public int [] vectorCiclos(BigInteger matrix[][], int cantidad){
        int element;
        String termino;
        int ciclos[]=new int[cantidad];
        int contador=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].compareTo(BigInteger.ZERO) != 0) {

                    vari = String.valueOf(matrix[i][j]);
                    element = cuantosterminos(vari);
                    for (int m = 0; m < element; m++) {
                        termino = demeElemento(vari, m);
                        //System.out.println("en la posicion " + i + j + " Se encuentra el " + contador + ": " + termino);
                        ciclos[contador]=Integer.parseInt(termino);
                        contador++;
                    }
                }
            }
        } return ciclos;
    
    }
    //Muestra caminos o ciclos
    public void imprimeLista(BigInteger matrix[][], String tipo) {
        int element;
        String termino;
        System.out.println(" ");
        System.out.println("Los " + tipo + "s son:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].compareTo(BigInteger.ZERO) != 0) {

                    vari = String.valueOf(matrix[i][j]);
                    element = cuantosterminos(vari);
                    for (int m = 0; m < element; m++) {
                        termino = demeElemento(vari, m);
                        System.out.println("en la posicion " + i + j + " Se encuentra el " + tipo + ": " + termino);

                    }
                }
            }
        }
    }
    
    public boolean hayCiclosoCaminos(BigInteger matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].compareTo(BigInteger.ZERO) != 0) {
                    return true;
                }
            }
        }

        return false;
    }
  
    //Muestra el ciclo de menor peso
    public void TSP(int sumas[], int vector[]) {

        int resultado = sumas[0];
        int ciclo = 0;
        for (int i = 0; i < sumas.length; i++) {
            if (sumas[i] <= maximo & sumas[i] > 0) {
                resultado = sumas[i];
                maximo=sumas[i];
                ciclo = i;
            }
        }
        System.out.println("");
        System.out.println("Ciclo de menor peso es " + vector[ciclo] + "con un costo de " + resultado);
    }
    
}
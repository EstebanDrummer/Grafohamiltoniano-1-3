/*
 Esta clase me establece si un grafo cumple las codiciones suficientes para que un 
 grafo sea hamiltoniano
 */
package grafohamiltoniano;

import java.util.ArrayList;

/**
 *
 *  desteban.yepes
 */
public class Suficientes {

    int matSuf[][];
    int vertices;
    int aristas;
    ArrayList<Integer> grados;

    public boolean condicion1(int Grafo[][]) {
        matSuf = Grafo;
        vertices = matSuf.length;
        if (vertices >= 3) {
            boolean respuesta1 = false;
            gradosVertices();
            float vertice = (float) (vertices);
            float condicion = vertice / 2;

            for (int k = 0; k < vertices; k++) {
                if ((float) (grados.get(k)) >= condicion) {
                    respuesta1 = true;
                    System.out.println("Cumple Condicion Suficiente 1");
                } else {

                    System.out.println(" No Cumple Condicion Suficiente 1, el vetice " + k + " con grado: " + grados.get(k) + " es menor a n/2 = " + condicion);
                }
            }

            return respuesta1;
        } else {
            System.out.println("No Cumple");
            return false;
        }
    }

    public boolean condicion2() {

        if (vertices >= 3) {
            boolean respuesta2 = true;
            contarAristas();
            float arista = (float) (aristas);
            float vertice = (float) (vertices);
            System.out.println("aristas  " + arista);
            float condicion = (float) (((0.5) * (vertice - 1) * (vertice - 2)) + 2);
            if (arista < condicion) {
                respuesta2 = false;
                System.out.println("No cumple Condicion Suficiente 2");
            } else {
                System.out.println("Cumple la Condicion Suficiente 2");
            }
            return respuesta2;
        } else {
            return false;
        }
    }

    public boolean condicion3() {
        if (vertices >= 3) {
            boolean respuesta3 = false;
         
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (matSuf[i][j] == 0 & (i!=j)) {
                        if ((grados.get(i) + grados.get(j)) >= vertices) {
                            System.out.println("Cumple Condicion Suficiente 3" + i +j);
                            return true;
                        }
                        else{
                            System.out.println("No Cumple Condicion Suficiente 3");
                            return false;
                        }
                    }
                }

            }
            return respuesta3;
        } else {
            return false;
        }
    }
    
    public void gradosVertices() {
        grados = new ArrayList();
        int grade;

        for (int i = 0; i < vertices; i++) {
            grade = 0;
            for (int j = 0; j < vertices; j++) {
                if (i != j) {
                    if (matSuf[i][j] == 1) {
                        grade++;
                    }
                }

            }
            grados.add(grade);
            System.out.println("grados del vertice: " + i + "  " + grados.get(i));
        }

    }

    public void contarAristas() {
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matSuf[i][j] == 1) {
                    count++;
                }
            }
        }
        aristas = count / 2;
    }
}

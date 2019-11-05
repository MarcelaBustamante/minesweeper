import metodos.Punto;
import metodos.Utilidades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static metodos.Utilidades.mostrarTablero;
import static metodos.Utilidades.muestraResultado;

public class App {
    public static void main(String[] args) {
        Utilidades u=new Utilidades();

        File file = new File("src/main/buscaminas.txt");
        BufferedReader br;
        int columnas=0, filas=0, minas=0;
        int[][] tablero = new int[0][0];
        int[][] visitados = new int[0][0];

        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            int linea = 0;
            String[] values;

            while ((st = br.readLine()) != null) {
                System.out.println(st);
                if(linea == 0){
                    values = st.split(",");
                    filas = Integer.parseInt(values[0]);
                    columnas = Integer.parseInt(values[1]);
                    minas = Integer.parseInt(values[2]);
                    tablero = new int[filas][columnas];
                    visitados = new int[filas][columnas];
                }
                else{
                    values = st.split(" ");
                    for(int x = 0; x < columnas; x++){
                        tablero[linea-1][x] = values[x].equals("X") ? -1 : Integer.parseInt(values[x]);
                        visitados[linea-1][x] = 0;
                    }
                }
                linea++;

            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Filas:" + filas);
        System.out.println("Columnas:" + columnas);
        System.out.println("Minas:" + minas);

        mostrarTablero(tablero);

        System.out.println();

        //	mostrarTablero(visitados);
        int etapa = 0;
        int f=0;
        int c=0;
        List<Punto> sol = new ArrayList<Punto>();
        List<Punto> res = new ArrayList<Punto>();
        Punto p = new Punto(0,0);
        u.buscamina(tablero,visitados,0,minas,f,c,sol,res,tablero.length,tablero[0].length);
        System.out.println("El resultado es");
        muestraResultado(sol);

        System.out.println();
        mostrarTablero(visitados);
    }
}

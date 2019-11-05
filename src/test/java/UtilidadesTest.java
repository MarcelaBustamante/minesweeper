import metodos.Punto;
import metodos.Utilidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesTest  {

    /*
    *1011
    *1110
    *0001
    * */
    int[][] visitado;
    int[][] m;
    int[][] v;
    int columna;
    int fila;
    private final Utilidades util= new Utilidades();
    List<Punto> solucion;

    @BeforeEach
    void init(){

        solucion=new ArrayList<Punto>();
         this.visitado = new int[][] { {1,0,1,1}, {1,1,1,0}, {0,0,0,1} };
         this.m=new int[][]{
                 {1,-1,1,0},{1,1,1,0},{0,0,0,0},{0,0,0,0}};
         this.v=new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
         solucion.add(new Punto(0,0));
         solucion.add(new Punto(1,3));

         }



    @Test
    @DisplayName("Prueba metodo cantidad de no visitados" )
    void cantNoVisitados(){
        assertEquals(5,util.cantNoVisitados(this.visitado));
    }

    @Test
    @DisplayName("Prueba metodo adyacentes Caso 1: no es una  cero")
    void buscarAdyacentesNoCero(){
        fila=columna=0;
        util.destapaAdyacentes(this.m,this.v,fila,columna,4,4);
        assertEquals(1,visitado[fila][columna]);
    }

    @Test
    @DisplayName("Prueba metodo adyacentes Caso 1: no es  cero")
    void buscarAdyacentesCero(){
        fila=columna=3;
        util.destapaAdyacentes(this.m,this.v,fila,columna,4,4);
        assertEquals(2,util.cantNoVisitados(this.v));
    }

    @Test
    @DisplayName("Prueba minimo")
    void miniTest(){
        assertEquals(2,util.min(5,2));
    }

    @Test
    @DisplayName("Prueba maximo")
    void maxTest(){
        assertEquals(5,util.max(5,2));
    }

    @Test
    @DisplayName("Prueba setVisitados")
    void setVisitadosTest(){
        util.setVisitados(this.visitado);
        assertTrue(visitado[0][0]==0);
    }

    @Test
    @DisplayName("Prueba eliminar")
        void eliminarTest(){
            util.eliminar(solucion,visitado);
            assertTrue(visitado[0][0]==0);
        }

}

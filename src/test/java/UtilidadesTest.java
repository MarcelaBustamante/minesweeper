import metodos.Utilidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesTest  {

    /*
    *1011
    *1110
    *0001
    * */
    int[][] m;
    private final Utilidades util= new Utilidades();

    @BeforeEach
    void init(){
         this.m = new int[][] { {1,0,1,1}, {1,1,1,0}, {0,0,0,1} };
    }

    @Test
    void cantNoVisitados(){
        assertEquals(5,util.cantNoVisitados(this.m));
    }

}

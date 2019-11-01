package metodos;

public class Utilidades {
    /**
     * Esta función recibe la matriz de visitados (las casillas tienen valor 1) y no visitados(las casillas tienen valor
     * 0) y devuelve la cantidad de los no visitados
     * @param ubicaciones
     * @return cant
     */
    public  int cantNoVisitados(int[][] ubicaciones) {
        int cant=0;
        for (int i = 0; i < ubicaciones.length; i++) {
            for (int j = 0; j < ubicaciones[i].length; j++) {
                if(ubicaciones[i][j]==0){
                    cant++;
                }
            }
        }
        return cant;
    }
}

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
    
    public static void mostrarTablero(int[][] tablero) {
		for(int[] x : tablero){
			for(int y : x){
				System.out.print(y + " ");
			}
			System.out.println();
		}

    }

    public static void destapaAdyacentes(int[][] tablero, int[][] visitados, int fila, int columna) {
    	
    	if(tablero[fila][columna] == 0) {
    		visitados[fila][columna] = 1;
    		if(columna - 1 >= 0 && visitados[fila][columna-1]==0) {
    			destapaAdyacentes(tablero, visitados, fila, columna-1);
    			if(fila - 1 != 0 && visitados[fila-1][columna-1]==0 && tablero[fila-1][columna-1] != 0) {
    				visitados[fila-1][columna-1] = 1;
    			}
    			if(fila + 1 != tablero.length && visitados[fila+1][columna-1] == 0 && tablero[fila+1][columna-1] != 0) {
    				visitados[fila-1][columna-1] = 1;
    			}
    		}
    		if(columna + 1 < tablero[fila].length && visitados[fila][columna+1] == 0) {
    			destapaAdyacentes(tablero, visitados, fila, columna+1);
    			if(fila - 1 != 0 && visitados[fila-1][columna+1]==0 && tablero[fila-1][columna+1] != 0) {
    				visitados[fila-1][columna+1] = 1;
    			}
    			if(fila + 1 != tablero.length && visitados[fila+1][columna+1] == 0 && tablero[fila+1][columna+1] != 0) {
    				visitados[fila+1][columna+1] = 1;
    			}    			
    		}
    		if(fila - 1 >= 0 && visitados[fila-1][columna]==0) {
    			destapaAdyacentes(tablero, visitados, fila-1, columna);
    		}
    		if(fila+ 1 < tablero.length && visitados[fila+1][columna]==0) {
    			destapaAdyacentes(tablero, visitados, fila+1, columna);
    		}   			
    	} else {
    		visitados[fila][columna] = 1;

    	}
    }
    
}

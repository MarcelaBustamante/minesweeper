package metodos;

import java.util.ArrayList;
import java.util.List;

import Buscaminas.Punto;

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
    
	public static void buscamina(int[][] tablero,int[][] visitados,int etapa, int cantMinas, int fila, int columna, List<Punto> solucion){
		
		List<Punto> resultado = new ArrayList<Punto>();
		
		int n = tablero.length;
		int m = tablero[n-1].length;
		
		int fin = n*m;
		Punto pto = new Punto();
		
		while(etapa <= fin) {
			int contenidoCasilla = tablero[fila][columna];
			if (contenidoCasilla != -1) {
				if (cantNoVisitados(visitados) == cantMinas) {
					if(resultado.lastIndexOf(null) < solucion.lastIndexOf(null)) {
						solucion = copySolucion(resultado);
					}
					etapa++;
				} else {
					if(visitados[fila][columna] == 0) {
						destapa(tablero,visitados,fila,columna);
						pto.setFila(fila);
						pto.setColumna(columna);
						resultado.add(pto);
					}
					if(columna < m) {
						columna++;
					} else {
						if(fila < n) {
							fila++;
							columna = 0;
						} else {
							fila = 0;
							columna = 0;
						}
					}
					buscamina(tablero,visitados,etapa,cantMinas,fila,columna,solucion);
				}
			}
			etapa++;
			resultado = new ArrayList<Punto>();
			visitados[fila][columna] = 0;
			fila = pto.getFila();
			columna = pto.getColumna();
			if(visitados[fila][columna] != 0) {
				if(columna < m) {
					columna++;
				} else {
					if(fila < n) {
						fila++;
						columna = 0;
					} else {
						fila = 0;
						columna = 0;
					}
				}				
			}
			if(tablero[fila][columna] == -1) {
				if(columna < m) {
					columna++;
				} else {
					if(fila < n) {
						fila++;
						columna = 0;
					} else {
						fila = 0;
						columna = 0;
					}
				}				
			}
			pto = new Punto();
		}
	}
	
	public static void muestraResultado(List<Punto> pto) {
		int i=0;
		while(pto !=null) {
			System.out.println(pto.get(i).toString());
			i++;
		}	
	}
	
	
	@SuppressWarnings("null")
	public static List<Punto> copySolucion(List<Punto> o){
		List<Punto> resultado = null;
		int i=0;
		while(!o.isEmpty()) {
			resultado.add(o.get(i));
			i++;
		}
		return resultado;
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

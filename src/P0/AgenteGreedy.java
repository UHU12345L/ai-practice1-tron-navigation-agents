package P0;

public class AgenteGreedy {
	 //agente greedy (agente que lo sabe todo) carga grid entero en memoria, hacer matriz que represente el mundo y coger la casilla mas cercana a la salida
    //no tiene porque dar solucion, coordenadas de la meta a salida, posicion actual, comprobar esTransitable y meter en array, distancia manhattan (casillas de inicio a fin, transitables)
    //tomar menor distancia meta |x1-x2|+|y1-y2| 1 donde me quiero mover, 2 salida (1 donde estoy, 2 meta) (x es filas, y es columnas)

	public String pensar(Entorno mapa2) {
	 	int af = mapa2.agenteF;
        int ac = mapa2.agenteC;
        int finalC=mapa2.metaC;
        int finalF=mapa2.metaF;
        int menorDistancia=0;
        
        int contar=4;
        // Array fijo de máximo 4 opciones, contador n para saber cuántas hay
        String[] opciones = new String[contar];
        int[] distancias = new int[4]; // distancia Manhattan de cada opción a la meta
        int n = 0;
  
        //en es transitable meto la formula |x1-x2|+|y1-y2| para cada caso, meter en copia
        if (mapa2.esTransitable(af - 1, ac)) { 
        	opciones[n] = "N";
            distancias[n] = Math.abs((af - 1) - finalF) + Math.abs(ac - finalC);
        	n++; 
        }
        
        if (mapa2.esTransitable(af + 1, ac)) {
        	opciones[n] = "S";
            distancias[n] = Math.abs((af + 1) - finalF) + Math.abs(ac - finalC);
        	n++; 
        }
        
        if (mapa2.esTransitable(af, ac + 1)) { 
        	opciones[n] = "E"; 
            distancias[n] = Math.abs(af - finalF) + Math.abs((ac + 1) - finalC);
        	n++; 
        }
        
        if (mapa2.esTransitable(af, ac - 1)) { 
        	opciones[n] = "O";
            distancias[n] = Math.abs(af - finalF) + Math.abs((ac - 1) - finalC);
        	n++; 
        }

        if (n == 0) {
        	//opciones[n] = "N"; no hago esto para que salte mensaje crash
        	return "Z";
        }
        
        for (int i = 1; i < n; i++) {
            if (distancias[i] < distancias[menorDistancia]) {
            	menorDistancia = i;
            }
        }

        String accion = opciones[menorDistancia];
        System.out.println("Greedy → acción: " + accion + " (distancia: " + distancias[menorDistancia] + ")");
        
        return accion;
}


}
	 
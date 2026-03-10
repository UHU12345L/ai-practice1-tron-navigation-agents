package P0;
import java.util.*;
import P0.Entorno;

class AgenteReactivo {
	//mirar transitables y meterlas en array
	//elegir una accion al azar
	//devolver esa accion
	// TAREA 1: Completar lógica reactiva
	// Usar mapa.esTransitable(...) para mirar N, S, E, O
	// Añadir a 'opciones' las direcciones válidas
	//agente reactivo: metodo pensar para posiciones, tomar posicion en la que estoy, mirar posiciones alrededor, me quedo con las posiciones que puedo visitar
	//usando esTransitable, actual segun percibe el entorno, si solo una posicion psible va a esa, si tiene varias posiles se mueve 
    //aleatoriamente a una de ellas (no hacer if...va hacia...)


	 public String pensar(Entorno mapa) {
		 	int af = mapa.agenteF;
	        int ac = mapa.agenteC;

	        int contar=4;
	        // Array fijo de máximo 4 opciones, contador n para saber cuántas hay
	        String[] opciones = new String[contar];
	        int n = 0;

	        if (n==contar) {
	        	contar+=4;
	        }
	        if (mapa.esTransitable(af - 1, ac)) { 
	        	opciones[n] = "N";
	        	n++; 
	        }
	        
	        if (mapa.esTransitable(af + 1, ac)) {
	        	opciones[n] = "S";
	        	n++; 
	        }
	        
	        if (mapa.esTransitable(af, ac + 1)) { 
	        	opciones[n] = "E"; 
	        	n++; 
	        }
	        
	        if (mapa.esTransitable(af, ac - 1)) { 
	        	opciones[n] = "O";
	        	n++; 
	        }

	        if (n == 0) {
	        	//opciones[n] = "N"; no hago esto para que salte mensaje crash
	        	return "Z";
	        }

	        // Elegir índice aleatorio entre 0 y n-1 (solo las posiciones rellenas)
	        Random rand = new Random();
	        String accion = opciones[rand.nextInt(n)];

	        System.out.println("Opciones válidas: " + n + ", Elegida: " + accion);
	        return accion;
	    }
	 
	 
	 
	}
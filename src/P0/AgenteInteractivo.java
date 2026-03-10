package P0;
//import java.util.Scanner; igual
import java.util.*;
import P0.Entorno;

public class AgenteInteractivo{
	Scanner scanner = new Scanner(System.in);
	public String pensar(Entorno entorno) {
		//recibe entorno, pensar (decidir accion) y retornarla 
	 	// el primer agente es interactivo: pedir por teclado hacia donde mover
	 	//comprobar esTransitable con lo que me pasan por teclado, si lo es realizo la accion
	 	//lo llama Tron.java cada ciclo del bucle de simulacion
	 	
	 	String accion = "N"; 
	 	boolean tran=false;
	 	//bucle hasta que introduzca movimiento valido
	 	do {
	 		System.out.println("Introduce accion (N/S/E/O): ");
	 		String meter=scanner.nextLine();
	 	
	 		//coordenadas actuales del agente
	 		int af=entorno.agenteF;
	 		int ac=entorno.agenteC;
	 		
	 		//simulo movimiento para despues comprobar si casilla de destino es valida
	 		if (meter.equals("N")){
	 			af--;
	 		}
	 		if (meter.equals("S")){
	 			af++;
	 		}
	 		if (meter.equals("E")){
	 			ac++;
	 		}
	 		if (meter.equals("O")){
	 			ac--;
	 		}

	 		if(!entorno.esTransitable(af, ac)) {
	 			System.out.println("No se puede hacer esa accion: ");
	 		}
	 		else {
	 			accion=meter;
	 			tran=true; //salir de bucle
	 		}
	 	
	 	} while (!tran); 
	 	
	 	
	 	return accion; //retorna accion al bucle principal de Tron
	 }
}

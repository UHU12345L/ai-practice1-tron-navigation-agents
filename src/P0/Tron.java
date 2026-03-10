package P0;
import java.util.*;

import P0.Entorno;

public class Tron {
// --- MAPAS DE PRUEBA ---
    
    // Mapa trampa: La casilla (1,1) al Este lleva a un callejón sin salida
    static final String MAPA_CALLEJON =
            "#########\n" +
            "#A      #\n" + 
            "# ##### #\n" + 
            "# #   # #\n" + 
            "#     S #\n" +
            "#########";

    static final String MAPA_GRANDE =
            "####################\n" +
            "#A  #              #\n" +
            "# # # ###### ##### #\n" +
            "# #   #      #     #\n" +
            "# ##### ###### ### #\n" +
            "#     #        #   #\n" +
            "# ### ######## # # #\n" +
            "#   #          #   #\n" +
            "# ############## S #\n" +
            "####################";

    public static void main(String[] args) throws InterruptedException {

        // 1. SELECCIONAR MAPA
        // String mapaActual = MAPA_CALLEJON;
        String mapaActual = MAPA_GRANDE;

        Entorno juego = new Entorno(mapaActual);
        
        // 2. SELECCIONAR AGENTE (Descomenta el que quieras usar) 
        //AgenteInteractivo agente = new AgenteInteractivo(); 
        AgenteReactivo agente = new AgenteReactivo();
        //AgenteDeliberativo agente = new AgenteDeliberativo();
         System.out.println(agente);
         
        System.out.println("--- Inicio de la Simulación ---");
        boolean juegoActivo = true;
        int ciclos = 0;

        //cada iteracion es un turno de juego, 300 para evitar bucles infinitos
        while (juegoActivo && ciclos < 300) {
            System.out.println("\n\n--- Ciclo " + ciclos + " ---");
            juego.dibujar(); //mostrar estado actual del mapa

            // El agente piensa
            String accion = agente.pensar(juego);
            
            if (accion == null) {
                System.out.println("Agente decide no moverse (o entrada inválida).");
                continue; 
            }

            System.out.println("Agente decide: " + accion);
            
            // Mover
            boolean exito = juego.moverAgente(accion);

            // Verificar estado
            if (!exito) {
                
                    System.out.println(">>> ¡CRASH! El agente se ha estrellado.");
                    juegoActivo = false;
               
            } else if (juego.hemosGanado()) {
                System.out.println(">>> ¡VICTORIA! Meta alcanzada.");
                juego.dibujar();
                juegoActivo = false;
            }

            // Pausa 
            
             Thread.sleep(300); 
           
            ciclos++;
        }
    }
    
    //agente reactivo: metodo pensar para posiciones, tomar posicion en la que estoy, mirar posiciones alrededor, me quedo con las posiciones que puedo visitar
    //usando esTransitable, actual segun percibe el entorno, si solo una posicion psible va a esa, si tiene varias posiles se mueve 
    //aleatoriamente a una de ellas (no hacer if...va hacia...)
    
    //agente deliberativo tiene dos subagentes, tiene una especie de meoria donde puede ver dos movimientos mas alla
    //de los que puede realizar, hay que calcular las posiciones relativas de la matriz viendo que sean transitables
    //si una de las acciones de uno o dos movimientos me lleva a la S cojo esa. primer agente: cojo la que tenga mas huecos posibles
    //(si hacia N tengo dos huecos y hacia O tengo uno, voy hacia N)
    //segundo agente: recuerda que casillas he visitado, va obteniendo representacion del mundo y acordandose de por donde ha pasado (tener una propia matriz para representar info)
    // Mantener inercia: si estoy yendo hacia abajo la prioritaria es ir hacia abajo
    
    
    //agente greedy (agente que lo sabe todo) carga grid entero en memoria, hacer matriz que represente el mundo y coger la casilla mas cercana a la salida
    //no tiene porque dar solucion, coordenadas de la meta a salida, posicion actual, comprobar esTransitable y meter en array, distancia manhattan (casillas de inicio a fin, transitables)
    //tomar menor distancia meta |x1-x2|+|y1-y2| 1 donde me quiero mover, 2 salida (creo)
}

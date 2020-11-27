package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

//import sockets.Conexion;

public class Cliente extends Conexion
{
    public Cliente(String HOST) throws IOException{super("cliente", HOST);} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
        	Scanner teclado = new Scanner(System.in);
        	
        	System.out.println("Introduzca su nombre (este nombre será visible para todos los demás usuarios de la aplicación):");
        	
        	String nombre_cliente = teclado.nextLine();
        	
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán tantos mensajes como uno quiera
            while(true)
            {
            	System.out.println("Introduzca mensaje:");
            	String mensaje=teclado.nextLine();
            	
            	if(mensaje.equalsIgnoreCase("Salir")) 
            	{
            		//Se escribe en el servidor usando su flujo de datos
                    salidaServidor.writeUTF("El cliente ha cerrado la conexion.");
            		break;
            	}
            	else
            	{
            		//Se escribe en el servidor usando su flujo de datos
                    salidaServidor.writeUTF(nombre_cliente + ": " + mensaje + "\n");
            	}
            	
                
            }

            cs.close();//Fin de la conexión
            
            teclado.close();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
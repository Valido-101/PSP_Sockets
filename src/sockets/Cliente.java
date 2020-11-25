package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

import sockets.Conexion;

public class Cliente extends Conexion
{
    public Cliente(String HOST) throws IOException{super("cliente", HOST);} //Se usa el constructor para cliente de Conexion

    public void startClient() //M�todo para iniciar el cliente
    {
        try
        {
        	Scanner teclado = new Scanner(System.in);
        	
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviar�n dos mensajes
            while(true)
            {
            	System.out.println("Introduzca mensaje:");
            	String mensaje=teclado.nextLine();
            	
            	if(mensaje.equalsIgnoreCase("Salir")) 
            	{
            		break;
            	}
            	else
            	{
            		//Se escribe en el servidor usando su flujo de datos
                    salidaServidor.writeUTF(mensaje + "\n");
            	}
            	
                
            }

            cs.close();//Fin de la conexi�n
            
            teclado.close();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
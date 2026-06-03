package ejercicio1;
import SingleThreadTCPServer.*;

import java.io.PrintWriter;
import java.util.Collections;

public class RepeatServer extends SingleThreadTCPServer{

    @Override
    public void handleMessage(String message, PrintWriter out) {
        if (!(comprobarArgumentos(message, out))) return;
        String[] args = message.split(" ");
        String aux;
        if (args.length == 2){
            aux = args[0].repeat(Integer.parseInt(args[1]));
        }
        else{
            int cantidad = Integer.parseInt(args[1]);
            aux = String.join(args[2], Collections.nCopies(cantidad, args[0]));
        }
        out.println(aux);
    }

    private boolean comprobarArgumentos(String message, PrintWriter out) {
        String[] args = message.split(" ");
        if (args.length < 2) {
            out.println("No se pasarom argumentos");
            return false;
        }
        if (args[0].isEmpty() ||  args[1].isEmpty()) {
            out.println("Argumentos invalidos");
            return false;
        }
        try{
            int num = Integer.parseInt(args[1]);
            if (num < 1){
                out.println("El numero debe ser mayor a cero");
                return false;
            }
        }
        catch (NumberFormatException e){
            out.println("El numero de repeticiones es invalido");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new RepeatServer().startLoop(args);
    }
}

package ejercicio1;
import SingleThreadTCPServer.*;

import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.stream.Collectors;

public class PasswordServer extends SingleThreadTCPServer {
    private SecureRandom random = new SecureRandom();

    @Override
    public void handleMessage(String message, PrintWriter out) {
        String[] msj = message.split(" ");
        if (msj.length < 3 ) { out.println("Debes pasar al menos 3 parametros separados por un espacio"); return;}
        if (msj[0].isEmpty() || msj[1].isEmpty() ||  msj[2].isEmpty()) {out.println("Debe haber al menos una letra, un digito y un caracter especial"); return;}
        out.println(generarContrasenia(msj[0], msj[1], msj[2]));
    }

    private String generarContrasenia(String letras, String numeros, String especiales){
        StringBuilder sb = new StringBuilder();
        sb.append(letras.charAt(0));
        sb.append(numeros.charAt(0));
        sb.append(especiales.charAt(0));
        String aux = letras + numeros;
        for (int i = 3; i < 8; i++) sb.append(charAleatorio(aux));
        Collections.shuffle(sb.toString()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()), random);
        return sb.toString();
    }

    private char charAleatorio(String s){
        return s.charAt(random.nextInt(s.length()));
    }

    public static void main(String[] args) {
        new PasswordServer().startLoop(args);
    }
}

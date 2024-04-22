import java.security.Key;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.SecretKey;

public class CriptografiaVernam {

    private static String chave;

    public static void gerarChave(int comprimento) {
        StringBuilder sb = new StringBuilder(comprimento);
        Random random = new Random();

        for (int i = 0; i < comprimento; i++) {
            char caractereAleatorio = (char) (random.nextInt(128));
            sb.append(caractereAleatorio);
        }

        chave =  sb.toString();
    }
     // Método para cifrar uma mensagem usando a cifra de Vernam
     public static String cifrar(String mensagem) {

       
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);
            // Garante que a chave seja repetida, se necessário
            char chaveChar = chave.charAt(i % chave.length());
            // XOR para cifrar
            char cifrado = (char) (caractere ^ chaveChar);
            resultado.append(cifrado);
        }

        return resultado.toString();
    }

    // Método para decifrar uma mensagem cifrada usando a cifra de Vernam
    public static String decifrar(String mensagemCifrada) {
        
        // Como Vernam é simétrico, cifrar e decifrar são os mesmos
        return cifrar(mensagemCifrada);
    }
}

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class CriptografiaAES {
    
    private static SecretKey chave;
    private static String mensagem;
    private static String mensagemCifrada;

    public static void gerarChave() throws Exception  {
        
            KeyGenerator geradorDeChaves = KeyGenerator.getInstance("AES");
            geradorDeChaves.init(128);
            chave = geradorDeChaves.generateKey();
            
             
    }

    public static  String cifrar(String textoAberto) throws Exception{
        byte[] bytesMensagemCifrada;

        Cipher cifrador;

        //Encripta mensagem
        mensagem = textoAberto;

        
            cifrador = Cipher.getInstance("AES");

            cifrador.init(Cipher.ENCRYPT_MODE, chave);

            bytesMensagemCifrada = cifrador.doFinal(mensagem.getBytes());

            mensagemCifrada = Base64.getEncoder().encodeToString(bytesMensagemCifrada);

            return mensagemCifrada;

        
    }

    public static String decifrar(String textoCifrado) throws Exception{
        //Decriptação
        byte [] bytesMensagemCifrada =Base64.getDecoder().decode(textoCifrado);

        Cipher decriptador;

        
            decriptador = Cipher.getInstance("AES");

            decriptador.init(Cipher.DECRYPT_MODE, chave);

            byte[] bytesMensagemDecifrada = decriptador.doFinal(bytesMensagemCifrada);

            String mensagemDecifrada = new String(bytesMensagemDecifrada);

   
            mensagem = mensagemDecifrada;
            return mensagem;
    }
}

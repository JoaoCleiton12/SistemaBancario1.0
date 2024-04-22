import java.security.NoSuchAlgorithmException;

public class Criptografia {
    
    private static CriptografiaAES aes;
    private static CriptografiaVernam vernam;
    private static String textoCifradoVernam;
    private static String textoCifradoAes;
    private static String textodecifradoVernam;
    private static String textodecifradoAes;

    public static String cifrar(String texto) {
        
        //gera chave vernam
        vernam.gerarChave(20);

        //gera chave aes
        try {
            aes.gerarChave();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //cifra mensagem usando vernam
        textoCifradoVernam = vernam.cifrar(texto);

        //cifra mensagem cifrada por vernam usando AES
        try{
            textoCifradoAes = aes.cifrar(textoCifradoVernam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return textoCifradoAes;
    
    }

    public static String decifrar(String textoCifrado){
        
        //decifra o AES
        try {
            textodecifradoAes = aes.decifrar(textoCifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //decifra o vernam
        textodecifradoVernam = vernam.decifrar(textodecifradoAes);

        return textodecifradoVernam;
    }
}
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        SistemaBancario sistema = new SistemaBancario();
        
        int entrada = 0;

        while (entrada != 3) {
        
        System.out.println("|********************************|");
        System.out.println("|--------------------------------|");
        System.out.println("|###Escolha o que deseja fazer###|");
        System.out.println("|--------------------------------|");
        System.out.println("|Fazer Login - 1                 |");
        System.out.println("|Criar conta - 2                 |");
        System.out.println("|Sair        - 3                 |");
        System.out.print(" Digite: ");
        entrada = scanner.nextInt();
        System.out.println("|********************************|");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("/////////////////////////////////////////////");
        System.out.println();
        System.out.println();
        System.out.println();

        //Se for fazer login
        if (entrada == 1) {
            
            System.out.println("|--------------------------------|");
            System.out.println("|############ Login #############|");
            System.out.println("|--------------------------------|");
            System.out.print("|Numero da conta: ");
            scanner.nextLine();
            String numConta = scanner.nextLine();
            
            System.out.print("|Senha: ");
            String senha = scanner.nextLine();
            

            //Concatena as mensagens
            String numContaEsenha = numConta+ " " +senha;

            String textoCifrado = sistema.encriptar.cifrar(numContaEsenha);

           
             //na verdade aqui eu vou chamar autenticar mensagens
            if (sistema.autenticarMensagens(textoCifrado)) {
            //fazer um laço de repetição para caso ele tente logar e erre a senha
            //e para caso ele n tenha uma conta ele possa criar e depois logar
                
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("/////////////////////////////////////////////");
                System.out.println();
                System.out.println();
                System.out.println();


                System.out.println("|********************************|");
                System.out.println("|#####  Login bem sucedido ######|");


                int escolha = 0;

                while (escolha != 6) {
                    System.out.println("|********************************|");
                    System.out.println("|--------------------------------|");
                    System.out.println("|Saque ........................ 1|");
                    System.out.println("|Depósito ..................... 2|");
                    System.out.println("|Transferência ................ 3|");
                    System.out.println("|Saldo ........................ 4|");
                    System.out.println("|Investimento ................. 5|");
                    System.out.println("|Sair ......................... 6|");

                    System.out.print("|Digite: ");
                    escolha = scanner.nextInt();

                    System.out.println("|--------------------------------|");
                    System.out.println("|********************************|");
                    System.out.println();
                    System.out.println();
                    System.out.println("////////////////////////////////////////////////");
                    System.out.println();
                    System.out.println();

                    //caso o usuário escolha fazer um saque
                    if (escolha == 1) {
                        System.out.println("|********************************|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|############# Saque ############|");
                        System.out.println("|--------------------------------|");
                        System.out.print("|Valor: ");
                        double saque = scanner.nextDouble();
                        sistema.saque(numConta, saque);
                        System.out.println("|--------------------------------|");
                        System.out.println("|********************************|");
                        System.out.println();
                        System.out.println();
                        System.out.println("////////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();
                    }
                    //caso o usuário escolha fazer um depósito
                    if(escolha == 2){
                        System.out.println("|********************************|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|########### Depósito ###########|");
                        System.out.println("|--------------------------------|");
                        System.out.print("|Valor: ");
                        double deposito = scanner.nextDouble();
                        sistema.deposito(numConta, deposito);
                        System.out.println("|--------------------------------|");
                        System.out.println("|********************************|");
                        System.out.println();
                        System.out.println();
                        System.out.println("////////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();
                    }
                    //caso o usuário escolha fazer uma transferência
                    if (escolha == 3) {
                        System.out.println("|********************************|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|######### Transferência ########|");
                        System.out.println("|--------------------------------|");
                        System.out.print("|Conta Origem: ");
                        scanner.nextLine();
                        String numContaOrigem = scanner.nextLine();
                        System.out.print("|Conta destino: ");
                        String numContaDestino = scanner.nextLine();
                        System.out.print("|Valor: ");
                        double valorTransferencia = scanner.nextDouble();
                        System.out.print("|Senha: ");
                        scanner.nextLine();
                        String senhaContaOrigem = scanner.nextLine();

                        //como eu ja autentiquei la em cima
                        //posso so comparar se a senha digitada bate com a senha digitada antes
                        if (numContaOrigem.equals(numConta)) {
                            if (senha.equals(senhaContaOrigem)) {
                                if (sistema.saldo(numContaOrigem) > valorTransferencia) {
                                    sistema.transferência(numContaOrigem, numContaDestino, valorTransferencia);
                                }else{
                                    System.out.println("|Saldo insuficiente");
                                    System.out.println("|Saldo atual: "+sistema.saldo(numContaEsenha));
    
                                }
                                
                            }
                            else{
                                System.out.println(" ###Senha inválida###");
                            }
                        }
                        else{
                            System.out.println(" ###Conta inválida###");
                        }
                    


                        //talvez tenha que autenticar para verificar se a senha esta correta
                        System.out.println("|--------------------------------|");
                        System.out.println("|********************************|");
                        System.out.println();
                        System.out.println();
                        System.out.println("////////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();
                    }
                    //caso o usuário escolha ver o saldo
                    if(escolha == 4){
                        System.out.println("|********************************|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|############# Saldo ############|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|Saldo: R$"+sistema.saldo(numConta));
                        
                        System.out.println("|--------------------------------|");
                        System.out.println("|********************************|");
                        System.out.println();
                        System.out.println();
                        System.out.println("////////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();
                    }
                    //caso o usuário escolha fazer um investimento
                    if(escolha == 5){
                        System.out.println("|********************************|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|######### Investimentos ########|");
                        System.out.println("|--------------------------------|");
                        System.out.println("|Ver");
                        System.out.println("|Poupança ..................... 1|");
                        System.out.println("|Renda fixa ................... 2|");
                        System.out.println("|Digite: ");
                        int escolhaInvestimento = scanner.nextInt();
                        System.out.println("|--------------------------------|");
                        System.out.println("|********************************|");
                        System.out.println();
                        System.out.println();
                        System.out.println("////////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();

                        if (escolhaInvestimento == 1) {
                            //Aqui so vou chamar a funcao investimento e ver quanto esta rendendo
                            System.out.println("|********************************|");
                            System.out.println("|--------------------------------|");
                            System.out.println("|########### Poupança ###########|");
                            System.out.println("|--------------------------------|");
                            sistema.investimentos(numConta, escolhaInvestimento);
                            System.out.println("|--------------------------------|");
                            System.out.println("|********************************|");
                            System.out.println();
                            System.out.println();
                            System.out.println("////////////////////////////////////////////////");
                            System.out.println();
                            System.out.println();
                            
                        }
                        if (escolhaInvestimento == 2) {
                            //aqui vou poder escolher quanto vou investir
                            //Aqui so vou chamar a funcao investimento e ver quanto esta rendendo
                            System.out.println("|********************************|");
                            System.out.println("|--------------------------------|");
                            System.out.println("|########## Renda fixa ##########|");
                            System.out.println("|--------------------------------|");
                            sistema.investimentos(numConta, escolhaInvestimento);
                            System.out.println("|--------------------------------|");
                            System.out.println("|********************************|");
                            System.out.println();
                            System.out.println();
                            System.out.println("////////////////////////////////////////////////");
                            System.out.println();
                            System.out.println();
                        }
                    }
                }

                
                
            }else{
                System.out.println();
                System.out.println("|Numero da conta        |");
                System.out.println("|Ou senha inválida      |");
                System.out.println("|-----------------------|");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("/////////////////////////////////////////////");
                System.out.println();
                System.out.println();
                System.out.println();
                
            }
            

        }
        //Se for criar uma conta
        else if (entrada == 2) {
            System.out.println("|********************************|");
            System.out.println("|--------------------------------|");
            System.out.println("|######### Criar conta ##########|");
            System.out.println("|--------------------------------|");
            System.out.print("|Nome completo: ");
            scanner.nextLine();
            String nome = scanner.nextLine();
            System.out.print("|CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("|Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("|Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("|Senha: ");
            String senhaCriada = scanner.nextLine();
            sistema.criarContaCorrente(nome, cpf, endereco, telefone, senhaCriada);
            System.out.println("|--------------------------------|");
            System.out.println("|********************************|");
            System.out.println();
            System.out.println();
            System.out.println("////////////////////////////////////////////////");
            System.out.println();
            System.out.println();            
        }

       

    }
  }
}

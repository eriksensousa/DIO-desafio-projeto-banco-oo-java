/*
 * Desafio de Projeto - Criando um Banco Digital com Java e Orientação à Objetos
 * Bootcamp Java Cognizant da DIO
 * Especialista da DIO: Venilton Falvo Jr (Tech Lead, Digital Innovation One)
 * #teamJavaCog
 */
package br.com.dio.model;

/**
 * Projeto: dio-desafio-projeto-banco
 * <p>
 * Esta classe representa a entidade Conta Corrente no domínio definido no Desafio de Projeto.
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 31/12/2021
 * Hora: 14:43
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Agencia agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }

    @Override
    public void imprimirSaldo() {

        System.out.println("\n=============================================================");
        System.out.println("                Saldo :: Conta Corrente");
        System.out.println("=============================================================");
        imprimirInformacoesDaConta();
        System.out.println("=============================================================");
    }

}

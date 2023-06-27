/*
 * Desafio de Projeto - Criando um Banco Digital com Java e Orientação à Objetos
 * Bootcamp Java Cognizant da DIO
 * Especialista da DIO: Venilton Falvo Jr (Tech Lead, Digital Innovation One)
 * #teamJavaCog
 */
package br.com.dio.main;

import br.com.dio.model.Agencia;
import br.com.dio.model.Banco;
import br.com.dio.model.Cliente;
import br.com.dio.model.Conta;

/**
 * Projeto: dio-desafio-projeto-banco
 * <p>
 * Classe principal do Desafio de Projeto.
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 31/12/2021
 * Hora: 13:46
 */
public class MainBanco {

    public static void main(String[] args) {

        Banco dioBank = new Banco();
        dioBank.imprimeRelatorio();

        Agencia agencia = dioBank.criarAgencia();
        dioBank.imprimeRelatorio();
        agencia.imprimeRelatorio();

        Cliente clienteAna = new Cliente("Ana");
        Cliente clienteJoao = new Cliente("João");
        Cliente clienteMaria = new Cliente("Maria");

        Conta contaPoupancaAna = agencia.criarConta(clienteAna, Conta.TIPO_CONTA_POUPANCA);
        Conta contaCorrenteJoao = agencia.criarConta(clienteJoao, Conta.TIPO_CONTA_CORRENTE);
        Conta contaPoupancaMaria = agencia.criarConta(clienteMaria, Conta.TIPO_CONTA_CORRENTE);

        agencia.imprimeRelatorio();

        contaPoupancaAna.depositar(50);
        contaPoupancaAna.imprimirSaldo();

        contaCorrenteJoao.depositar(5000);
        contaCorrenteJoao.imprimirSaldo();

        contaCorrenteJoao.transferir(1200, contaPoupancaMaria);
        contaCorrenteJoao.imprimirSaldo();

        contaPoupancaMaria.imprimirSaldo();


    }
}

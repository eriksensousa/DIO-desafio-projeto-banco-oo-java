/*
 * Desafio de Projeto - Criando um Banco Digital com Java e Orientação à Objetos
 * Bootcamp Java Cognizant da DIO
 * Especialista da DIO: Venilton Falvo Jr (Tech Lead, Digital Innovation One)
 * #teamJavaCog
 */
package br.com.dio.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Projeto: dio-desafio-projeto-banco
 * <p>
 * <p> Esta classe representa a entidade Agência no domínio definido no Desafio de Projeto.
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 31/12/2021
 * Hora: 12:39
 */

public class Agencia {

    private static int NUMERO_CONTAS = 1;

    @Getter private final int numero;
    @Getter private final List<Conta> contas;

    public Agencia(int numero) {
        this.numero = numero;
        contas = new ArrayList<>();
    }

    /**
     * Cria uma nova conta, caso não exista uma cadastrada para o cliente informado, e então
     * atribui o número dessa conta.
     * @param cliente O cliente da nova conta.
     * @param tipo O tipo de conta que será criada.
     * @return Uma conta já cadastrada, ou uma nova conta para o cliente informado.
     */
    public Conta criarConta(Cliente cliente, int tipo) {
        Conta conta = getConta(cliente);
        if (conta == null) {
            if (tipo == Conta.TIPO_CONTA_POUPANCA) {
                conta = new ContaPoupanca(NUMERO_CONTAS++, this, cliente);
            } else if (tipo == Conta.TIPO_CONTA_CORRENTE) {
                conta = new ContaCorrente(NUMERO_CONTAS++, this, cliente);
            } else {
                throw new RuntimeException("Tipo de conta informado não é válido!");
            }

            contas.add(conta);
        }
        return conta;
    }

    /**
     * Pega uma conta cadastrada com base no cliente.
     * @param cliente O cliente que será pesquisado nas contas.
     * @return Uma conta, se já foi cadastrada, ou nulo se não foi.
     */
    public Conta getConta(Cliente cliente) {
        for (Conta conta : contas) {
            if (conta.getCliente().equals(cliente)) return conta;
        }
        return null;
    }

    /**
     * Imprime um relatório com todas as contas cadastradas para essa agência.
     */
    public void imprimeRelatorio() {

        System.out.println("\n=============================================================");
        System.out.println("            Agência " + numero + " :: Relatório de Contas");
        System.out.println("=============================================================");

        if (contas.isEmpty()) {
            System.out.println("\tEssa Agências não tem contas cadastradas ainda.");
        } else {
            for (Conta conta : contas) {
                System.out.println("\t" + conta);
            }
        }
        System.out.println("=============================================================\n");
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "numero: " + numero +
                ", contas: " + contas.size() +
                '}';
    }
}

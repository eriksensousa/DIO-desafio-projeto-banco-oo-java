/*
 * Desafio de Projeto - Criando um Banco Digital com Java e Orientação à Objetos
 * Bootcamp Java Cognizant da DIO
 * Especialista da DIO: Venilton Falvo Jr (Tech Lead, Digital Innovation One)
 * #teamJavaCog
 */
package br.com.dio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Projeto: dio-desafio-projeto-banco
 * <p>
 * Esta classe representa a entidade Conta no domínio definido no Desafio de Projeto.
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 31/12/2021
 * Hora: 12:42
 */
@NoArgsConstructor
public abstract class Conta {

    public static final int TIPO_CONTA_POUPANCA = 0;
    public static final int TIPO_CONTA_CORRENTE = 1;

    @Getter protected int numero;
    @Getter protected Agencia agencia;
    @Getter protected Cliente cliente;
    @Getter private double saldo;


    public Conta(int numero, Agencia agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    /**
     * Método utilizado para sacar um valor da conta.
     * <p>
     * Caso não tenha saldo suficiente, será lançada uma exceção para informar ao cliente.
     *
     * @param valor Quantia que o cliente deseja sacar.
     */
    public void sacar(double valor) {
        if (saldo - valor < 0) {
            throw new RuntimeException("Não tem saldo suficiente na conta para efetuar essa operação");
        }
        saldo -= valor;
    }

    /**
     * Método utilizado para depositar um valor na conta.
     *
     * @param valor Quantia que será acrescida ao saldo da conta.
     */
    public void depositar(double valor) {
        saldo += valor;
    }

    /**
     * Método utilizado para transferir um valor da conta atual para uma conta de destino.
     * <p>
     * Caso a conta de destino não tenha sido informada ou é a conta de origem, será lançada
     * uma exceção para informar ao cliente.
     *
     * @param valor        Quantia que será sacada da conta atual e transferida para a conta de destino.
     * @param contaDestino A conta que receberá a transferência.
     */
    public void transferir(double valor, Conta contaDestino) {
        if (contaDestino == null || this.equals(contaDestino)) {
            throw new RuntimeException("A conta informada não é válida!");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    /**
     * Imprime as informações comuns de todos os tipos de contas.
     */
    protected void imprimirInformacoesDaConta(){
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Data/Hora da operação: " + formataData.format(new Date()));
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + agencia.getNumero());
        System.out.println("Conta  : " + numero);
        System.out.printf("Saldo  : R$ %.2f", saldo);
        System.out.println();
    }

    public abstract void imprimirSaldo();

    @Override
    public String toString() {
        return "Conta{" +
                "numero:" + numero +
                ", agencia:" + agencia.getNumero() +
                ", cliente: " + cliente.getNome() +
                '}';
    }
}

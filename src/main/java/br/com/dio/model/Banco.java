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
 * <p> Esta classe representa a entidade Banco no domínio definido no Desafio de Projeto.
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 31/12/2021
 * Hora: 12:26
 */

public class Banco {

    private static int NUMERO_AGENCIA = 1;
    public static final String NOME_BANCO = "DIO BANK";

    @Getter private final List<Agencia> agencias;

    public Banco() {
        agencias = new ArrayList<>();
    }

    /**
     * Cria uma nova agência, se ainda não existir uma com o número atual.
     * @return Uma agência já cadastrada ou uma nova agência.
     */
    public Agencia criarAgencia() {
        Agencia agencia = getAgencia(NUMERO_AGENCIA);
        if (agencia == null) {
            agencia = new Agencia(NUMERO_AGENCIA++);
            agencias.add(agencia);
        }
        return agencia;
    }

    /**
     * Pega uma agência já cadastrada com base em seu número.
     * @param numero O número da agência que será pesquisado.
     * @return Uma agência já cadastrada ou nulo se não encontrar.
     */
    public Agencia getAgencia(int numero) {
        for (Agencia agencia : agencias) {
            if (agencia.getNumero() == numero) return agencia;
        }
        return null;
    }


    /**
     * Imprime um relatório com todas as agências cadastradas para esse banco.
     */
    public void imprimeRelatorio() {

        System.out.println("\n=============================================================");
        System.out.println("            " + NOME_BANCO + " :: Relatório de Agências");
        System.out.println("=============================================================");

        if (agencias.isEmpty()) {
            System.out.println("\tNenhuma Agência cadastrada ainda.");
        } else {
            for (Agencia agencia : agencias) {
                System.out.println("\t" + agencia);
            }
        }
        System.out.println("=============================================================\n");
    }
}

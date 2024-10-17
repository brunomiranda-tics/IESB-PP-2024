package br.edu.iesb.pp2024.devlab5;

import java.util.concurrent.Semaphore;

/*
*
Instituição: IESB
Disciplina:  Programação Paralela (PP)
Objetivo:    Fornecer conhecimentos e práticas de programação paralela com o uso de Semáforos em Java.
Professor:   Bruno Miranda [bruno.marcos@iesb.edu.br; brunomiranda.tics@gmail.com]
Data:        2024/2S

# Prática: DevLab5 - Trabalhando com semáforos e Threads em Java.
*
*/

public class DevLab5Main {

	public static void main(String[] args) throws InterruptedException {

		Semaphore semaforo = new Semaphore(IConfig.NUM_MAXIMO_THREADS);
		
		SemaforoThread semaforoThreadA = new SemaforoThread(semaforo, IConfig.NOME_THREAD_CONCORRENTE_A);
		SemaforoThread semaforoThreadB = new SemaforoThread(semaforo, IConfig.NOME_THREAD_CONCORRENTE_B);
		
		// inicia as threads para trabalho compartilhado
		semaforoThreadA.start();
		semaforoThreadB.start();
		
		semaforoThreadA.join();
		semaforoThreadB.join();
		
		System.out.println(">> Valor final da operação: [" 
				+ RecursoCompartilhado.variavelCompartilhada + "]");
	}
}
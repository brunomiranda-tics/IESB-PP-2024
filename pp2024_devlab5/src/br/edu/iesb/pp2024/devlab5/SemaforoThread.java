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

public class SemaforoThread extends Thread {

	Semaphore semaforo;
	String nomeThread;
	
	public SemaforoThread(Semaphore semaforo, String nomeThread) {
		super(nomeThread);
		
		this.semaforo = semaforo;
		this.nomeThread = nomeThread;
	}

	@Override
	public void run() {

		if(this.getName().equals(IConfig.NOME_THREAD_CONCORRENTE_A)) {
			System.out.println(">> Iniciando [" + nomeThread + "]");
			
			try {
				// obtendo a permissão
				System.out.println("[" + nomeThread + "] está aguarando a permissão para manipular o recurso compartilhado.");
				
				// adquire o bloqueio do recurso
				semaforo.acquire();
				
				System.out.println("[" + nomeThread + "] obteve a permissão para manipular o recurso compartilhado!");
				
				for (int i = 0; i < 10; i++) {
					RecursoCompartilhado.variavelCompartilhada++;

					System.out.println("[" + nomeThread + "] alterou o recurso compartilhado: " + RecursoCompartilhado.variavelCompartilhada);
					
					// faz a thread esperar para a outra thread ter a possibilidad de atuar
					Thread.sleep(IConfig.TEMPO_SLEEP_THREAD);
				}
				
			} catch (InterruptedException exc) {
				System.out.println(exc);				
			}			

			// libera os recursos bloqueados
			System.out.println("[" + nomeThread + "] liberando a permissão para manipular o recurso compartilhado!");
			semaforo.release();
			
		} else {
			System.out.println(">> Iniciando [" + nomeThread + "]");

			try {
				// obtendo a permissão
				System.out.println("[" + nomeThread + "] está aguarando a permissão para manipular o recurso compartilhado.");
				
				// adquire o bloqueio do recurso
				semaforo.acquire();
				
				System.out.println("[" + nomeThread + "] obteve a permissão para manipular o recurso compartilhado!");
				
				for (int i = 0; i < 5; i++) {
					RecursoCompartilhado.variavelCompartilhada--;

					System.out.println("[" + nomeThread + "] alterou o recurso compartilhado: " + RecursoCompartilhado.variavelCompartilhada);
					
					// faz a thread esperar para a outra thread ter a possibilidad de atuar
					Thread.sleep(IConfig.TEMPO_SLEEP_THREAD);
				}
				
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			
			// libera os recursos bloqueados
			System.out.println("[" + nomeThread + "] liberando a permissão para manipular o recurso compartilhado!");
			semaforo.release();
		}
	}
}
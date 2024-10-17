package br.edu.iesb.pp2024.devlab5;

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

public interface IConfig {

	public static final String NOME_THREAD_CONCORRENTE_A = "THREAD A";
	public static final String NOME_THREAD_CONCORRENTE_B = "THREAD B";
	public static final int NUM_MAXIMO_THREADS = 1;
	public static final int VALOR_INICIAL_RECURSO_COMPARTILHADO = 100;
	public static final int TEMPO_SLEEP_THREAD = 1000;
}
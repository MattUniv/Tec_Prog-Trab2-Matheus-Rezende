package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Scanner;

public class StartApp {
	/*
	Utilizando Java, crie um dicionario de inglês para português!
	O usuário deverá ter a opção de salvar uma palavra e seu significado.
	Por exemplo: home = casa e car = carro
	Os dados deverão ser salvos em memória 
	(com isso ao desligar o programa os dados serão perdidos!).
	O usuário poderá cadastrar, editar e excluir as palavras desse dicionário. 
	Além disso, ele terá a opção de “achar” uma palavra e consultar seu significado.
	Não poderá ser permitido o cadastro de palavras repetidas!
	O máximo de palavras permitidas serão 100!
	
	Seu código deverá estar no Github.
	Enviar para o e-mail rodrigolfsi@univas.edu.br o link do Github com o código fonte.
	Ainda no corpo do e-mail é necessário enviar o nome do aluno.
	Data da Entrega: 24/10/2021.
	OBS: trabalhos entregues após a data definida serão aceitos até o dia 29/10/2021.
	*/
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> en = new ArrayList<String>();
	static ArrayList<String> pt = new ArrayList<String>();
	static int i = 0, opt;
	static String aux_S = "";
	
	public static void main(String[] args) {
		int input = -1;
		
		do {
			menu();
			input = read(input);
			calc_Option(input);
			if(input == 0) {
				System.out.println("Programa Finalizado! :)");
			}else {
				input = -1;
			}
		}while(input != 0);
		
		scan.close();
	}
	
	public static void menu() {
		System.out.println("---------------------");
		System.out.println("Dicionário Inglês - Português: Palavras Gravadas ("+en.size()+")");
		System.out.println("1. Cadastrar Palavra");
		System.out.println("2. Editar Palavra");
		System.out.println("3. Excluir Palavra");
		System.out.println("4. Pesquisar Palavra");
		System.out.println("0. Finalizar Programa");
	}
	
	public static int read(int input) {
		while(input > 4 || input < 0) {
			System.out.println("Por Favor, Digite uma Opção: ");
			input = scan.nextInt();
			if(input > 4 || input < 0) {
				System.out.println("Opção Invalida!");
			}
		}
		return input;
	}
	
	public static void calc_Option(int input) {
		if(input == 1) {
			if(en.size() >= 100) {
				System.out.println("Você não pode Gravar Mais de 100 Palavras: ");
			}else {
				add();
			}
		}else if (input == 2) {
			edit();
		}else if (input == 3) {
			delete();
		}else if (input == 4) {
			search();
		}
	}
	
	public static void add() {
		System.out.println("Opção (Adicionar): ");
		scan.nextLine();
		aux_S = ask_En();
		while(repeat(aux_S)) {
			System.out.println("Esta Palavra já foi Adicionada: ");
			aux_S = ask_En();
		}
		en.add(aux_S);
		aux_S = ask_Pt();
		while(repeat(aux_S)) {
			System.out.println("Esta Palavra já foi Adicionada: ");
			aux_S = ask_Pt();
		}
		pt.add(aux_S);
	}
	
	public static void edit() {
		System.out.println("Opção (Editar): ");
		scan.nextLine();
		aux_S = ask_En();
		
		for(int j=0; j<en.size(); j++) {
			if(repeat(aux_S)) {
				System.out.println("Deseja Editar a Palavra: " + aux_S);
				opt = ask_Opt();
				if(opt == 1) {
					scan.nextLine();
					aux_S = ask_En();
					en.set(j, aux_S);
					aux_S = ask_Pt();
					pt.set(j, aux_S);
					break;
				}
			}else {
				System.out.println("Esta Palavra Não Existe");
			}
		}
	}
	
	public static void delete() {
		System.out.println("Opção (Deletar): ");
		scan.nextLine();
		aux_S = ask_En();
		
		for(int j=0; j<en.size(); j++) {
			if(repeat(aux_S)) {
				System.out.println("Deseja Deletar a Palavra: " + aux_S);
				opt = ask_Opt();
				if(opt == 1) {
					en.remove(j);
					pt.remove(j);
					break;
				}
			}else {
				System.out.println("Esta Palavra Não Existe");
			}
		}
	}
	
	public static void search() {
		System.out.println("Opção (Pesquisar): ");
		scan.nextLine();
		aux_S = ask_En();
		
		for(int j=0; j<en.size(); j++) {
			if(repeat(aux_S)) {
				System.out.println("Inglês = " + en.get(j));
				System.out.println("Português = " + pt.get(j));
				break;
			}else {
				System.out.println("Esta Palavra Não Existe");
			}
		}
	}
	
	public static boolean repeat(String word) {
		int j;
		for(j=0; j<en.size(); j++) {
			if(word.equals(en.get(j))) {
				return true;
			}
		}
		for(j=0; j<pt.size(); j++) {// pq na hora de add o en[] vai ser maior q o pt[]
			if(word.equals(pt.get(j))) {
				return true;
			}
		}
		return false;
	}
	
	public static String ask_En() {
		System.out.println("Por Favor, Digite a Palavra: (em Inglês)");
		return scan.nextLine();
	}
	
	public static String ask_Pt() {
		System.out.println("Por Favor, Digite a Palavra: (em Português)");
		return scan.nextLine();
	}
	
	public static int ask_Opt() {
		System.out.println("1. Corfirmar ");
		System.out.println("2. Cancelar ");
		return scan.nextInt();
	}
}
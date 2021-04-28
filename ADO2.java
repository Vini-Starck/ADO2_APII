package ado2;


import java.util.Scanner;

public class ADO2 {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Voce deseja armazenar quantas músicas?");
        int qtd = leitor.nextInt();
        Musica [] musica = new Musica[qtd];
        metodos.inserir(musica);
        metodos.ordenaCodigos(musica);
        
        metodos.opcao(musica);
        metodos.opcao2(musica);
        
    }
    
}

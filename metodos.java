package ado2;

import java.util.Scanner;

public class metodos {

    public static void inserir(Musica[] musica) {

        System.out.println("Inserindo músicas, começando...\n");
        Scanner leitor = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < musica.length; i++) {
            musica[i] = new Musica();

            System.out.println("Nome da " + (i + 1) + "º música: ");
            musica[i].setNome(leitor.nextLine());

            System.out.println("Artista da " + (i + 1) + "º música: ");
            musica[i].setArtista(leitor.nextLine());

            System.out.println("Duração da " + (i + 1) + "º música: ");
            musica[i].setDuracao(sc.nextDouble());

            System.out.println("Código da " + (i + 1) + "º música: ");
            musica[i].setCodigo(sc.nextInt());

        }
    }

    public static void exibir(Musica[] musica) {

        for (int i = 0; i < musica.length; i++) {
            System.out.println("================================");
            System.out.println("\nNome da " + (i + 1) + "º  musica: " + musica[i].getNome());
            System.out.println("\nArtista da " + (i + 1) + "º musica: " + musica[i].getArtista());
            System.out.println("\nDuração da " + (i + 1) + "º musica: " + musica[i].getDuracao());
            System.out.println("\nCodigo da " + (i + 1) + "º musica: " + musica[i].getCodigo());
        }
    }

    public static Musica[] ordenaCodigos(Musica[] musica) {
        Musica[] musicaOrdenada = new Musica[musica.length];
        int[] codOrd = new int[musica.length];

        for (int i = 0; i < musica.length; i++) {
            codOrd[i] = musica[i].getCodigo();
        }

        int j;
        int temp;

        for (int i = 0; i < codOrd.length; i++) {
            temp = codOrd[i];
            j = i;

            while (j > 0 && codOrd[j - 1] >= temp) {
                codOrd[j] = codOrd[j - 1];
                j--;
            }
            codOrd[j] = temp;
        }
        for (int i = 0; i < musica.length; i++) {
            for (j = 0; j < musica.length; j++) {
                if (codOrd[i] == musica[j].getCodigo()) {
                    musicaOrdenada[i] = musica[j];
                }
            }
        }
        return musicaOrdenada;

    }

    public static String PesquisaCodigo(Musica[] musica, int codigo) {

        int low = 0;
        int high = musica.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            
            if (musica[mid].getCodigo() < codigo) {
                low = mid + 1;
            } else if (musica[mid].getCodigo() > codigo) {
                high = mid - 1;
            } else {
                System.out.println("RESULTADO DA PESQUISA:"
                        + "\n===============================");
                System.out.println("Nome da  musica: " + musica[mid].getNome());
                System.out.println("Artista da musica: " + musica[mid].getArtista());
                System.out.println("Duração da musica: " + musica[mid].getDuracao());
                System.out.println("Codigo da musica: " + musica[mid].getCodigo());
                System.out.println("===============================");
                return "";
            }
        }
        System.out.println("==== Musica não encontrada ====");
        return "";

    }

    public static String pesquisaNome(Musica[] musica, String nome) {

        for (int i = 0; i < musica.length; i++) {
            if (nome.equals(musica[i].getNome())) {
                System.out.println("=== MUSICA ENCONTRADA ===\n"
                                + "\nNome: " + musica[i].getNome()
                                + "\nArtista: " + musica[i].getArtista()
                                + "\nDuração: " + musica[i].getDuracao()
                                + "\nCódigo: " + musica[i].getCodigo());
                return "";
            }
        }
        
        System.out.println("=== MUSICA NÃO ENCONTRADA ===");
        return "";
        
        
    }
    
    public static void opcao(Musica[] musica) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("O que deseja fazer?"
                + "\n 1 - Pesquisar por nome"
                + "\n 2 - Pesquisar por codigo"
                + "\n 3 - Excluir uma musica"
                + "\n 4 - Exibir musicas do programa"
                + "\n 5 - Encerrar programa");
        int op = leitor.nextInt();

        if (op == 1) {
            String nome;
            do {
                System.out.println("Digite a musica que deseja procurar: ");
                nome = leitor.nextLine();
            } while (nome.isEmpty());
            pesquisaNome(musica, nome);

        } else if (op == 2) {
            System.out.println("Digite o codigo que deseja procurar: ");
            int cod = leitor.nextInt();
            PesquisaCodigo(musica, cod);

        } else if (op == 3) {
            System.out.println("Digite o codigo da musica que deseja excluir: ");
            int cod = leitor.nextInt();
            excluirMusica(musica, cod);
        } else if(op == 4){
            exibir(musica);
            
        }else if(op == 5) {
            Encerrar();
        } else {
            System.out.println("=== Valor inválido ====");
            opcao(musica);
        }
    }

    public static void Encerrar() {
        System.out.println("Desligando...");
        System.exit(0);
    }

    public static Musica[] excluirMusica(Musica[] musica, int codigo) {
        int low = 0;
        int high = musica.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (musica[mid].getCodigo() < codigo) {
                low = mid + 1;
            } else if (musica[mid].getCodigo() > codigo) {
                high = mid - 1;
            } else {
                
                musica[mid].setNome(null);

                musica[mid].setArtista(null);

                musica[mid].setDuracao(0);

                musica[mid].setCodigo(0);
                return musica;
            }
        }
        System.out.println("==== Musica não encontrada ====");
        return musica;
    }

    public static void opcao2(Musica[]musica) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("==================\n"
                + "Deseja fazer outra ação?"
                + "\n 1 - SIM"
                + "\n 2 - NÃO");
        int op = leitor.nextInt();
        if (op == 1) {
            metodos.opcao(musica);
        } else if (op == 2) {
            metodos.Encerrar();
        } else {
            metodos.opcao2(musica);
        }
    }

}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Revista");
            System.out.println("3. Listar Materiais");
            System.out.println("4. Pesquisar Material");
            System.out.println("5. Excluir Material");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    System.out.println("Gêneros disponíveis: ");
                    for (Genero genero : Genero.values()) {
                        System.out.println(genero);
                    }
                    System.out.print("Escolha o gênero: ");
                    String generoLivro = scanner.nextLine().toUpperCase();
                    biblioteca.adicionarMaterial(new Livro(tituloLivro, autorLivro, Genero.valueOf(generoLivro)));
                    break;

                case 2:
                    System.out.print("Título da revista: ");
                    String tituloRevista = scanner.nextLine();
                    System.out.print("Autor da revista: ");
                    String autorRevista = scanner.nextLine();
                    System.out.print("Número da revista: ");
                    int numeroRevista = scanner.nextInt();
                    biblioteca.adicionarMaterial(new Revista(tituloRevista, autorRevista, numeroRevista));
                    break;

                case 3:
                    biblioteca.listarMateriais();
                    break;

                case 4:
                    System.out.print("Título do material para pesquisa: ");
                    String tituloPesquisa = scanner.nextLine();
                    Material material = biblioteca.pesquisarMaterial(tituloPesquisa);
                    if (material != null) {
                        System.out.println(material);
                    } else {
                        System.out.println("Material não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Título do material para exclusão: ");
                    String tituloExclusao = scanner.nextLine();
                    biblioteca.excluirMaterial(tituloExclusao);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

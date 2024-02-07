import java.util.ArrayList;
import java.util.Scanner;

public class ListaCursosProfessores5 {
    public static void main(String[] args) {
        ArrayList<String> listaCursos = new ArrayList<>();
        ArrayList<String> listaProfessores = new ArrayList<>();
        ArrayList<String> listaCursosConcluidos = new ArrayList<>();

        final String tituloCursos = "cursos";
        final String tituloProfessores = "professores";
        final String tituloCursosConcluidos = "cursos concluídos";

        Scanner entrada = new Scanner(System.in);

        String inputPrincipal = "";

        //LAÇO DE REPETIÇÃO DE EXECUÇÃO DO PROGRAMA

        exibirMenuPrincipal();

        while (!inputPrincipal.equals("0")) {

            inputPrincipal = entrada.nextLine();

            switch (inputPrincipal) {
                case "1": //LISTAR
                    listarTudo(listaCursos, listaProfessores, listaCursosConcluidos, tituloCursos, tituloProfessores, tituloCursosConcluidos);
                    break;

                case "2": //ADICIONAR ALGO

                    String inputAdd = "";

                    do {
                        exibirMenuAdd();

                        inputAdd = entrada.nextLine();

                        switch (inputAdd) {
                            case "1": //ADICIONAR CURSO
                                infoAdd(listaCursos, tituloCursos, entrada);
                                continue;

                            case "2": //ADICIONAR PROFESSOR
                                infoAdd(listaProfessores, tituloProfessores, entrada);
                                continue;

                            case "0": //RETORNAR AO MENU PRINCIPAL
                                break;

                            case "":
                                continue;

                            default:
                                informarErroOpcaoInvalida();
                        }

                    } while (!inputAdd.equals("0"));
                    System.out.println("VOLTANDO AO MENU PRINCIPAL... \n");
                    break;

                case "3": //REMOVER

                    String inputRemover = "";

                    do {
                        exibirMenuRemover();

                        inputRemover = entrada.nextLine();

                        switch (inputRemover) {
                            case "1": //REMOVER CURSO
                                verLista(listaCursos, tituloCursos);
                                removerDaLista(listaCursos, pegarIndice(pedirNome(tituloCursos, listaCursos, entrada), listaCursos));
                                verLista(listaCursos, tituloCursos);
                                break;

                            case "2":
                                verLista(listaProfessores, tituloProfessores);
                                removerDaLista(listaProfessores, pegarIndice(pedirNome(tituloProfessores, listaProfessores, entrada), listaProfessores));
                                verLista(listaProfessores, tituloProfessores);
                                break;

                            case "0": //RETORNAR AO MENU PRINCIPAL
                                break;

                            case "":
                                continue;

                            default:
                                informarErroOpcaoInvalida();
                        }

                    } while (!inputRemover.equals("0"));
                    System.out.println("VOLTANDO AO MENU PRINCIPAL... \n");
                    break;

                case "4": //MARCAR COMO CONCLUÍDO

                    verLista(listaCursos, tituloCursos);

                    marcarComoConcluido(listaCursos, pegarIndice(pedirNome(tituloCursos, listaCursos, entrada), listaCursos), listaCursosConcluidos);

                    break;

                case "5": //LISTAR CUSOS CONCUÍDOS
                    verLista(listaCursosConcluidos, tituloCursosConcluidos);
                    break;

                case "0": //sair
                    listarTudo(listaCursos, listaProfessores, listaCursosConcluidos, tituloCursos, tituloProfessores, tituloCursosConcluidos);
                    sair();
                    continue;

                case "":
                    continue;

                default:
                    informarErroOpcaoInvalida();
            }

            exibirMenuPrincipal();

        }
    }

    public static void exibirMenuPrincipal() {
        System.out.println(
                "-----------MENU PRINCIPAL----------- \n" +
                        "Selecione uma opção: \n" +
                        "------------------------------------ \n" +
                        "1 - Listar cursos e professores. \n" +
                        "2 - Adicionar um curso/professor. \n" +
                        "3 - Remover um curso/professor \n" +
                        "4 - Marcar um curso como concluído \n" +
                        "5 - Listar cursos concluídos \n" +
                        "------------------------------------ \n" +
                        "0 - Listar tudo e sair.");
    }

    public static void exibirMenuAdd() {
        System.out.println(
                "--------------ADICIONAR-------------- \n" +
                        "O que deseja fazer? \n" +
                        "------------------------------------- \n" +
                        "1 - Adicionar um curso. \n" +
                        "2 - Adicionar um(a) professor(a) \n" +
                        "0 - Retornar ao menu principal. \n " +
                        "-------------------------------------");
    }

    public static void infoAdd(ArrayList<String> listaDeItens, String nomeLista, Scanner entrada) {
        System.out.print("Digite o nome de um dos " + nomeLista.toUpperCase() + " que deseja adicionar: ");

        String novoItem = entrada.nextLine();

        addLista(listaDeItens, novoItem);

        verLista(listaDeItens, nomeLista);
    }

    public static void exibirMenuRemover() {
        System.out.println(
                "---------------REMOVER--------------- \n" +
                        "O que deseja fazer? \n" +
                        "------------------------------------- \n" +
                        "1 - Remover um curso. \n" +
                        "2 - Remover um(a) professor(a) \n" +
                        "0 - Retornar ao menu principal. \n " +
                        "-------------------------------------");
    }

    public static void informarErroOpcaoInvalida() {
        System.out.println(" \n **Esta não é uma opção válida.**\n ");
    }

    public static void verLista(ArrayList<String> lista, String nomeLista) {
        System.out.println("|-LISTA ATUAL DE " + nomeLista.toUpperCase() + "-------------------------|");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("|- " + i + " - " + lista.get(i));
        }
        System.out.println("|-------------------------------------------------|\n");
    }

    public static void addLista(ArrayList<String> lista, String item) {
        lista.add(item);
    }

    public static String pedirNome(String tituloLista, ArrayList<String> lista, Scanner entrada) {
        System.out.print("Digite o NOME de um dos " + tituloLista.toUpperCase() + " que deseja selecionar: ");
        String nomeItem = entrada.nextLine();

        return nomeItem;
    }

    public static int pegarIndice(String valor, ArrayList<String> lista) {
        if (!lista.contains(valor)) {
            informarErroOpcaoInvalida();
            valor = "";
        }
        return lista.indexOf(valor);
    }

    public static void removerDaLista(ArrayList<String> lista, int indiceItemRemover) {
        String nomeDoItem = lista.get(indiceItemRemover);

        lista.remove(indiceItemRemover);

        System.out.println(" \n" + "*" + nomeDoItem.toUpperCase() + " foi removido(a) da lista.* \n");
    }

    public static void listarTudo(ArrayList<String> lista1, ArrayList<String> lista2, ArrayList<String> lista3, String titulo1, String titulo2, String titulo3) {
        System.out.print(" \n" +
                "Estas são as listas atuais: \n");

        verLista(lista1, titulo1);
        verLista(lista2, titulo2);
        verLista(lista3, titulo3);
    }

    public static void marcarComoConcluido(ArrayList<String> listaRecebida, int indiceItemMarcado, ArrayList<String> listaConcluidos) {

        if (listaRecebida.size() - 1 < indiceItemMarcado) {
            informarErroOpcaoInvalida();
        } else {
            String nomeCursoMarcado = listaRecebida.get(indiceItemMarcado);

            listaConcluidos.add(nomeCursoMarcado);

            listaRecebida.remove(indiceItemMarcado);

            System.out.println("*" + nomeCursoMarcado + " foi marcado como concluído.* \n");
        }
    }

    public static void sair() {
        System.out.println(" \n" +
                "ENCERRANDO O PROGRAMA. ");
    }
}

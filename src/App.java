import java.util.Arrays;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ATIVIDADE ESTRUTURA DE DADOS");
        System.out.println("Escolha uma ativade");
        System.out.println("1 - Progressão Geometrica");
        System.out.println("2 - Sequencia Decresecente");
        System.out.println("3 - Vetor Dinamico");
        System.out.println("4 - Sequencia Crescente com Soma");
        System.out.println("5 - Matriz com valores Incrementais");
        System.out.println("6 - Operação entre matrizes");
        System.out.println("0 - Sair");

        int atividade = lerValor(sc, null, -1, 6);

        switch (atividade) {
            case 1:
                int v1 = lerValor(sc, "Valor inicial (<=20):", 0, 20);
                int[] pg = progressaoGeometrica(v1);
                System.out.println(Arrays.toString(pg));
                break;
            
            case 2:
                int v2 = lerValor(sc, "Valor inicial (>1):", 1, 0);
                int[] dec = sequenciaDecrescente(v2);
                System.out.println(Arrays.toString(dec));
                break;
            
            case 3:
                int tamanho = lerValor(sc, "Tamanho do vetor (<=1000):", 0, 1000);
                int[] vetor = vetorDinamico(tamanho);
                System.out.println(Arrays.toString(vetor));
                break;

            case 4:
                int v4 = lerValor(sc, "Valor inicial:", 0, 0);
                int[] crescente = sequenciaCresenteComSoma(v4);
                System.out.println(Arrays.toString(crescente));
                System.out.println("Soma: " + calcularSoma(crescente));
                break;

            case 5:
                int n = lerValor(sc, "Tamanho da matriz:", 0, 0);
                int[][] matriz = matrizIncrementais(n);
                exibirMatriz(matriz);
                break;

            case 6:
                int t = lerValor(sc, "Tamanho das matrizes:", 0, 0);
                int[][][] matrizes = operacaoEntreMatrizes(t);

                System.out.println("Matriz N:");
                exibirMatriz(matrizes[0]);

                System.out.println("Matriz Z:");
                exibirMatriz(matrizes[1]);

                System.out.println("Matriz Soma:");
                exibirMatriz(matrizes[2]);
                break;
        
            case 0:
                System.out.println("encerrando o programa");
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo auxiliar para ler e validar entrada do usuario
     * @param scanner Scanner para leitura
     * @param mensagem Mensagem a ser exibida
     * @param min Valor minimo (exclusivo)
     * @param max Valor maximo (inclusivo)
     * @return Valor valido lido
     */
    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
    
    while (true) {
        if (mensagem != null) {
            System.out.println(mensagem);
        }
        
        valor = scanner.nextInt();
        
        if (valor > min && (max == 0 || valor <= max)) {
            return valor;
        }
        
        System.out.println("Valor inválido. Tente novamente.");
    }
    }
    
    /**
     * Metodo auxiliar para exibir matriz formatada
     * @param matriz Matriz a ser exibida
     */
    private static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.printf("%4d ", matriz[i][j]);
        }
        System.out.println();
    }
    }
    
    /**
     * Exercicio 01: Progressao Geometrica
     * @param valorInicial Valor inicial (deve ser <= 20)
     * @return Vetor de 10 elementos com progressao geometrica (dobro) ou null se invalido
     */
    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20 ){
            return null;
        }

        int[] vetor = new int[10];
        vetor[0] = valorInicial;
        for(int i = 1; i<10; i++){
            vetor[i] = vetor[i-1]*2;
        }
        
        return vetor;
    }
    
    /**
     * Exercicio 02: Sequencia Decrescente
     * @param valorInicial Valor inicial (deve ser > 1)
     * @return Vetor de 10 elementos com sequencia decrescente ou null se invalido
     */
    public static int[] sequenciaDecrescente(int valorInicial) {
        if(valorInicial <= 1){
            return null;
        }
        
        int[] vetor = new int[10];
        vetor[0] = valorInicial;

        for (int i = 1; i< 10; i++){
            vetor[i] = vetor[i -1] - 1;
        }
        return vetor;
    }
    
    /**
     * Exercicio 03: Vetor Dinamico
     * @param tamanho Tamanho do vetor (deve ser <= 1000)
     * @return Vetor com sequencia de 1 ate tamanho ou null se invalido
     */
    public static int[] vetorDinamico(int tamanho) {

        if(tamanho > 1000){
            return null;
        }
        int[] vetor = new int[tamanho];
         
        for (int i = 0; i < tamanho; i++){
            vetor[i] = i + 1;
        }
        return vetor;
    }
    
    /**
     * Exercicio 04: Sequencia Crescente com Soma
     * @param valorInicial Valor inicial
     * @return Vetor de 10 elementos com sequencia crescente
     */
    public static int[] sequenciaCresenteComSoma(int valorInicial) {      
        int[] vetor = new int[10];
        vetor[0] = valorInicial;

        for(int i = 1; i < 10; i++){
    vetor[i] = vetor[i - 1] + 1;}
        return vetor;
    }
    
    /**
     * Calcula a soma de todos os elementos do vetor
     * @param vetor Vetor para calcular a soma
     * @return Soma de todos os elementos
     */
    public static int calcularSoma(int[] vetor) {
        int soma = 0;

    for (int i = 0; i < vetor.length; i++) {
        soma += vetor[i];
    }

    return soma;
    }
    
    /**
     * Exercicio 05: Matriz com Valores Incrementais
     * @param tamanho Tamanho da matriz quadrada
     * @return Matriz NxN com valores incrementais iniciando em tamanho+1
     */
    public static int[][] matrizIncrementais(int tamanho) {
        int[][] matriz = new int[tamanho][tamanho];
        int contador = tamanho + 1;

        for (int i = 0; i< tamanho; i++){
            for (int j = 0; j < tamanho; j++){
                matriz[i][j] = contador++;
            }
        }
        return matriz;
    }
    
    /**
     * Exercicio 06: Operacao entre Matrizes
     * @param tamanho Tamanho das matrizes quadradas
     * @return Array com 3 matrizes: [0]=N, [1]=Z, [2]=Soma
     */
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] matrizN = new int[tamanho][tamanho];
        int[][] matrizZ = new int[tamanho][tamanho];
        int[][] matrizSoma = new int[tamanho][tamanho];

        int contador = 1;

        for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
        matrizN[i][j] = contador;
        matrizZ[i][j] = contador;
        matrizSoma[i][j] = matrizN[i][j] + matrizZ[i][j];
        contador++;
    }
}
        return new int[][][] {matrizN, matrizZ, matrizSoma};
    }
    
    // ========================================
    // METODOS REQUERIDOS PELO AUTOGRADER
    // NAO REMOVER - Necessarios para avaliacao automatica
    // ========================================
    
    /**
     * Metodo ex01 para compatibilidade com autograder
     * @return resultado do exercicio 01
     */
    public static int[] ex01() {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        return progressaoGeometrica(valor);
    }
    
    /**
     * Metodo ex02 para compatibilidade com autograder
     * @return resultado do exercicio 02
     */
    public static int[] ex02() {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        return sequenciaDecrescente(valor);
    }
    
    /**
     * Metodo ex03 para compatibilidade com autograder
     * @return resultado do exercicio 03
     */
    public static int[] ex03() {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        return vetorDinamico(valor);
    }
    
    /**
     * Metodo ex04 para compatibilidade com autograder
     * @return resultado do exercicio 04
     */
    public static int[] ex04() {
    Scanner sc = new Scanner(System.in);
    int valor = sc.nextInt();
    return sequenciaCresenteComSoma(valor);
    }
    
    /**
     * Metodo ex05 para compatibilidade com autograder
     * @return resultado do exercicio 05
     */
    public static int[][] ex05() {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        return matrizIncrementais(valor);
    }
    
    /**
     * Metodo ex06 para compatibilidade com autograder
     * @return resultado do exercicio 06
     */
    public static int[][][] ex06() {
        // TODO: Implementar leitura de entrada e chamar operacaoEntreMatrizes()
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        return operacaoEntreMatrizes(valor);
    }
}

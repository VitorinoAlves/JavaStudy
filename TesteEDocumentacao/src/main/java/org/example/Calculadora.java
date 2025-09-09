package org.example;

/**
 * Uma classe simples para realizar operações matemáticas básicas.
 * A classe oferece métodos para adição, subtração, multiplicação e divisão.
 */
public class Calculadora {

    /**
     * Adiciona dois números inteiros.
     *
     * @param a O primeiro número a ser adicionado.
     * @param b O segundo número a ser adicionado.
     * @return A soma dos dois números.
     */
    public int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a O número do qual o segundo será subtraído.
     * @param b O número a ser subtraído.
     * @return A diferença entre os dois números.
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a O primeiro número a ser multiplicado.
     * @param b O segundo número a ser multiplicado.
     * @return O produto dos dois números.
     */
    public int multiplicar(int a, int b) {
        return a*b;
    }

    /**
     * Divide dois números inteiros.
     * Se o divisor for zero, o método retorna 0 para evitar uma exceção.
     *
     * @param a O dividendo.
     * @param b O divisor.
     * @return O resultado da divisão, ou 0 se o divisor for zero.
     */
    public int dividir(int a, int b) {
        if(b==0){
            return 0;
        }
        return a/b;
    }
}

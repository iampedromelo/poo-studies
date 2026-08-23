package br.edu.ifsp.list02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
    Leia um conjunto de cinco números inteiros não repetidos em uma única linha e os armazene em um vetor de 10 posições.
    A partir daí, leia um número por vez. Se o número ainda não estiver no conjunto, faça a inclusão após o último número.
    Caso ele esteja no conjunto, remova o número e libere espaço no array. A cada iteração imprima o vetor. O programa
    acaba quando o array ficar totalmente cheio ou vazio. Veja o exemplo na imagem anexa.

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex03 {
    final int NUM_ARRAY_INICIAL = 5;
    final int NUM_ARRAY = 10;

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(int[] firstFive, int[] otherInts) {
        //checa se o array só tem elementos unicos
        for(int i=0; i<NUM_ARRAY_INICIAL -1;i++){
            for(int j=i+1;j<NUM_ARRAY_INICIAL;j++){
                if(firstFive[i] == firstFive[j]) return "Erro";
            }
        }

        // cria um array novo com os mesmo elementos do first_five, com 10 de length
        int[] arrayRetorno = Arrays.copyOf(firstFive,NUM_ARRAY);
        int tamArray = NUM_ARRAY_INICIAL; //controla quantos elementos já entraram no array

        int i =0;
        StringBuilder retorno = new StringBuilder();

        for(int k=0;k<tamArray;k++) {
            if(k>0){
                retorno.append(" ");
            }
            retorno.append(arrayRetorno[k]);
        }

        while(tamArray> 0 && tamArray < NUM_ARRAY && i < otherInts.length){

            int indice = buscaValorEmArray(arrayRetorno, tamArray, otherInts[i]);
            if (indice < 0) {
                arrayRetorno[tamArray++] = otherInts[i];
            } else {
                removeValorEmArray(arrayRetorno, tamArray--, indice);
            }
            if(tamArray>0) {
                retorno.append("\n");
                //prenche o retorno, é como se fosse um print por vez
                for (int k = 0; k < tamArray; k++) {
                    if (k > 0) {
                        retorno.append(" ");
                    }
                    retorno.append(arrayRetorno[k]);
                }
            }
            i++;
        };
        return retorno.toString();
    }

    int buscaValorEmArray(int[] array, int tamArray, int valor){
        for(int i=0; i<tamArray;i++){
            if(array[i] == valor) return i;
        }
        return -1;
    }

    void removeValorEmArray(int[] array,int tamArray, int indiceRemover){
        for(int i=indiceRemover; i<tamArray-1;i++){
            array[i] = array[i+1];
        }
        array[tamArray - 1] = 0;
    }


}

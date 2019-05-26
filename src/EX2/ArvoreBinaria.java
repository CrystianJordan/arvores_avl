package EX2;

import java.util.Scanner;

public class ArvoreBinaria {


    public static class ARVORE {
        public int num;

        public ARVORE dir, esq;

    }


    public static ARVORE inserir(ARVORE aux, int num) {

        if (aux == null) {

            aux = new ARVORE();

            aux.num = num;

            aux.esq = null;

            aux.dir = null;


        } else if (num < aux.num) {

            aux.esq = inserir(aux.esq, num);

        } else {

            aux.dir = inserir(aux.dir, num);

        }

        return aux;

    }


    public static void imprimirPares(ARVORE aux) {

        if (aux != null) {

            imprimirPares(aux.esq);

            if(aux.num % 2 == 0) {
                System.out.print(aux.num + ", ");
            }

            imprimirPares(aux.dir);

        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ARVORE a = null;
        int num;
for (int i = 0; i< 10;i++){
    System.out.println("Digite um numero");
    num = in.nextInt();
    a = inserir(a,num);
}


        imprimirPares(a);

    }

}












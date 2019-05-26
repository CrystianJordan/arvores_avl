package EX5;

import java.util.Scanner;

public class AVL {

    private static class ARVORE {


        public int num, altd, alte;

        public ARVORE dir, esq;

    }


    public static ARVORE inserir(ARVORE aux, int num) {

        // o objeto novo é um objeto auxiliar

        ARVORE novo;

        if (aux == null) {

            novo = new ARVORE();

            novo.num = num;

            novo.altd = 0;

            novo.alte = 0;

            novo.esq = null;

            novo.dir = null;

            aux = novo;

        } else if (num < aux.num) {

            aux.esq = inserir(aux.esq, num);

            if (aux.esq.altd > aux.esq.alte) {

                aux.alte = aux.esq.altd + 1;

            } else {

                aux.alte = aux.esq.alte + 1;

            }

            aux = balanceamento(aux);

        } else {

            aux.dir = inserir(aux.dir, num);

            if (aux.dir.altd > aux.dir.alte) {

                aux.altd = aux.dir.altd + 1;

            } else {

                aux.altd = aux.dir.alte + 1;

            }

            aux = balanceamento(aux);

        }

        return aux;

    }


    public static ARVORE balanceamento(ARVORE aux) {

        int d, df;

        d = aux.altd - aux.alte;

        if (d == 2) {

            df = aux.dir.altd - aux.dir.alte;

            if (df >= 0) {

                aux = rotacao_esquerda(aux);

            } else {

                aux.dir = rotacao_direita(aux.dir);

                aux = rotacao_esquerda(aux);

            }

        } else if (d == -2) {

            df = aux.esq.altd - aux.esq.alte;

            if (df <= 0) {

                aux = rotacao_direita(aux);

            } else {

                aux.esq = rotacao_esquerda(aux.esq);

                aux = rotacao_direita(aux);

            }

        }

        return aux;

    }


    public static ARVORE rotacao_esquerda(ARVORE aux) {

        ARVORE aux1, aux2;

        aux1 = aux.dir;

        aux2 = aux1.esq;

        aux.dir = aux2;

        aux1.esq = aux;

        if (aux.dir == null) {

            aux.altd = 0;

        } else if (aux.dir.alte > aux.dir.altd) {

            aux.altd = aux.dir.alte + 1;

        } else {

            aux.altd = aux.dir.altd + 1;

        }


        if (aux1.esq.alte > aux1.esq.altd) {

            aux1.alte = aux1.esq.alte + 1;

        } else {

            aux1.alte = aux1.esq.altd + 1;

        }

        return aux1;

    }


    public static ARVORE rotacao_direita(ARVORE aux) {

        ARVORE aux1, aux2;

        aux1 = aux.esq;

        aux2 = aux1.dir;

        aux.esq = aux2;

        aux1.dir = aux;

        if (aux.esq == null) {

            aux.alte = 0;

        } else if (aux.esq.alte > aux.esq.altd) {

            aux.alte = aux.esq.alte + 1;

        } else {

            aux.alte = aux.esq.altd + 1;

        }


        if (aux1.dir.alte > aux1.dir.altd) {

            aux1.altd = aux1.dir.alte + 1;

        } else {

            aux1.altd = aux1.dir.altd + 1;

        }

        return aux1;

    }


    public static void exibirPares(ARVORE aux) {

        if (aux != null) {

            if (aux.num % 2 == 0) {
                System.out.print(aux.num + "  ");
            }

            exibirPares(aux.esq);

            exibirPares(aux.dir);

        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;

        ARVORE a = null;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um numero");
            num = in.nextInt();
            a = inserir(a, num);
        }

        System.out.print("Pares : ");

        exibirPares(a);


    }
}

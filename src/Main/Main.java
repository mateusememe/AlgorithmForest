package Main;

import BTree.BTree;
import BPlus.BPlusTree;
import NArea.NArea;
import NAreaLL.NAreaLL;

public class Main {
    public final int[] vet = new int[]{100, 250, 300, 200, 301, 201, 400, 101, 203, 503, 1290, 1, 98, 15, 19};
    NAreaLL rootNAreaLL;
    NArea rootNArea;
    BTree rootBTree;
    BPlusTree rootBPlus;
    public Main(){
        rootNAreaLL = new NAreaLL();
        rootNArea = new NArea();
        rootBTree = new BTree();
        rootBPlus = new BPlusTree();
    }

    public void NAreaLL(){
        System.out.println("####### Linked List N-4Area Tree ########");
        for(int num : vet)
            rootNAreaLL.inserir(num);
        System.out.println("Exibir in ordem:\n");
        rootNAreaLL.in_ordem(rootNAreaLL.getRaiz());
    }

    public void NArea(){
        System.out.println("####### Default N-3Area Tree ########");
        for(int num : vet)
            rootNArea.inserir(num);
        System.out.println("Exibir in ordem:\n");
        rootNArea.in_ordem(rootNArea.getRaiz());

    }

    public void BTree(){
        System.out.println("####### BTree M=2 ########");
        for(int i=1; i<=10000000;i++)
            rootBTree.inserir(i, 0);

        for(int i=10; i<=9999990;i++)
            rootBTree.excluir(i);
        System.out.println("Exibir in ordem:\n");
        rootBTree.inOrdem(rootBTree.getRaiz());
    }
    public void BPlusTree() {
        System.out.println("####### BPlus M=4 ########");
        /*
        Exemplo 1:
            Inserir 1.000.000 de elementos
        for(int i = 0; i < 1000000; i++)
            rootBPlus.inserir(i);  */

        /*  Exemplo 2:
        Inserir os seguintes elementos:*/
        int[] vetBP = {1, 4, 7, 10, 17, 21, 31, 25, 19, 20, 28, 42};
        for(int num : vetBP)
            rootBPlus.inserir(num);
        System.out.println("Exibir in ordem:\n");
        rootBPlus.inOrdem(rootBPlus.getRaiz());

    }
    public void executa(){
        System.out.println("\n----------------------------------------\n");
        NAreaLL();
        System.out.println("\n----------------------------------------\n");
        NArea();
        System.out.println("\n----------------------------------------\n");
        BTree();
        System.out.println("\n----------------------------------------\n");
        BPlusTree();
        System.out.println("\n----------------------------------------\n");
    }



    public static void main(String[] args) {
        Main app = new Main();
        app.executa();
        System.out.println("Finalizei!");
    }

}

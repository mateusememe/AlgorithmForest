package Main;

import NAreaLL.NArea;

public class Main {
    NArea root;
    public Main(){
        root = new NArea();
    }
    public void executa(int vet[]){
        for(int num : vet)
            root.inserir(num);
        System.out.println("Exibir:\n");
        root.in_ordem(root.getRaiz());
    }
    public static void main(String[] args) {
        Main app = new Main();
        app.executa(new int[]{100, 250, 300, 200, 301, 201, 400, 101});
        System.out.println("Finalizei!");
    }

}

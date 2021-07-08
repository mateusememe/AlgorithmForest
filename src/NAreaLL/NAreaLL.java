package NAreaLL;

import NAreaLL.classes.*;
import NAreaLL.classes.queue.Fila;

public class NAreaLL implements Definicioes {
    private No raiz;

    public NAreaLL() {
        this.raiz = null;
    }

    public void inserir(int info){
        int pos = 0;
        boolean flag = false;
        No p, ant = null;

        if(raiz == null){
            raiz = new No(info);
        }
        else{
            p = raiz;
            while(p != null && !flag){
                pos = p.getListInfo().buscaPosInserir(info);
                if(p.getListInfo().length() < N-1){
                    p.getListInfo().inserir(pos,info);
                    p.getListLig().inserir(null);
                    flag = true;
                }
                else{
                    ant = p;
                    p = p.getListLig().getNoLig(pos).getLig();
                }
            }
            if(!flag) {
                ant.getListLig().getNoLig(pos).setLig(new No(info));
            }
        }
    }

    public void in_ordem(No raiz){
        if(raiz != null){
            int p = 0;
            while(p < raiz.getListLig().length()){
                in_ordem(raiz.getListLig().getNoLig(p).getLig());
                if(p < raiz.getListInfo().length())
                   System.out.println("Info:" + raiz.getListInfo().getInfoPos(p));
                p++;
            }
        }
    }
    //Exibir iterativo
    public void exibir(){
        Fila queue = new Fila();
        No p = raiz, aux = null;

        queue.enqueue(p);
        while(!queue.isEmpty()){
            p = queue.dequeue();
            for(int i = 0; i < p.getListInfo().length(); i++){
                System.out.println("" + p.getListInfo().getInfoPos(i) + " ");
            }
            for(int j = 0; j < p.getListLig().length(); j++){
                aux = p.getListLig().getNoLig(j).getLig();
                if(aux != null){
                    queue.enqueue(aux);
                    System.out.println("");
                }
            }
        }
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

}

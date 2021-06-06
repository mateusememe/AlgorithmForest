package NAreaLL;

import NAreaLL.classes.*;

public class NArea implements Definicioes {
    private No raiz;

    public NArea() {
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
                //System.out.println("Info Inserindo:" + info + "\tNa caixa da info: " + p.getListInfo().getInfoPos(0) + "\tPos: " + pos);
                if(p.getListInfo().length() < N-1){
                    //System.out.println("Length: " + p.getListInfo().length());
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
                //System.out.println("Vou gerar um novo No! com a Info " + info);
                ant.getListLig().getNoLig(pos).setLig(new No(info));
            }
        }
        System.out.println("|| Inserido");
    }
    public void in_ordem(No raiz){
        if(raiz != null){
            int p = 0;
            while(p < raiz.getListLig().length()){
                //System.out.println("P:" + p + "\nGetLig:" + raiz.getListLig().getNoLig(p).getLig());
                in_ordem(raiz.getListLig().getNoLig(p).getLig());
                //System.out.println("length: "+raiz.getListLig().length() + " p: " + p);
                if(p < raiz.getListInfo().length())
                   System.out.println("Info:" + raiz.getListInfo().getInfoPos(p));
                p++;
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

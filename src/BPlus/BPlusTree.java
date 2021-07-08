package BPlus;

import BPlus.classes.Definicoes;
import BPlus.classes.No;

public class BPlusTree implements Definicoes {
    private No raiz;

    public BPlusTree() {
        raiz = null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public No getFolha(int info) {
        int i = 0;
        No aux = this.raiz;
        while (aux.getvLig(1) != null) {
            i = 0;
            while(i < aux.getTL() && info > aux.getvInfo(i)) i++;
            aux = aux.getvLig(i);
        }
        return aux;
    }

    public No getPai (No folha, int info) {
        No aux = this.raiz;
        No pai = aux;
        int i;
        while(aux != folha) {
            i = 0;
            while(i < aux.getTL() && info > aux.getvInfo(i)) i++;
            pai = aux;
            aux = aux.getvLig(i);
        }
        return pai;
    }

    public void inserir(int info) {
        No folha;
        No pai;
        int pos;
        if(this.raiz == null)
            this.raiz = new No(info);
        else {
            folha = this.getFolha(info);
            pos = folha.getPOS(info);
            folha.arrange(pos);
            folha.setTL(folha.getTL() + 1);
            folha.setvInfo(pos, info);
            folha.setvPos(pos, info);
            if (folha.getTL() > M - 1) {
                pai = getPai(folha, info);
                split(folha, pai);
            }
        }
    }

    public void exibir() {
        No aux = this.raiz;
        while (aux.getvLig(0) != null)
            aux = aux.getvLig(0);
        while(aux != null) {
            for(int i = 0; i < aux.getTL(); i++)
                System.out.println(aux.getvInfo(i) + " ");
            aux = aux.getProx();
        }
    }

    public void split(No folha, No pai) {
        No cx1 = new No();
        No cx2 = new No();
        int aux, mid, i, pos, info;
        mid = 0;
        if (folha.getvLig(0) == null) {
            aux = (M - 1) / 2;
            for (i = 0; i < aux; i++) {
                cx1.setvInfo(i, folha.getvInfo(i));
                cx1.setvPos(i, folha.getvPos(i));
                cx1.setTL(cx1.getTL() + 1);
            }
            mid = aux;
            for (i = aux; i < M; i++) {
                cx2.setvInfo(i - (aux), folha.getvInfo(i));
                cx2.setvPos(i - (aux), folha.getvPos(i));
                cx2.setTL(cx2.getTL() + 1);
            }
        } else {
            aux = (M / 2);
            for (i = 0; i < aux; i++) {
                cx1.setvInfo(i, folha.getvInfo(i));
                cx1.setvPos(i, folha.getvPos(i));
                cx1.setvLig(i, folha.getvLig(i));
                cx1.setTL(cx1.getTL() + 1);
            }
            cx1.setvLig(aux, folha.getvLig(aux));
            mid = aux++;
            for (i = aux; i < M; i++) {
                cx2.setvInfo(i - (aux), folha.getvInfo(i));
                cx2.setvPos(i - (aux), folha.getvPos(i));
                cx2.setvLig(i - (aux), folha.getvLig(i));
                cx2.setTL(cx2.getTL() + 1);
            }
            cx2.setvLig(i - aux, folha.getvLig(M));
        }
        if (folha == pai) {
            folha.setvInfo(0, folha.getvInfo(mid));
            folha.setvPos(0, folha.getvPos(mid));
            folha.setvLig(0, cx1);
            folha.setvLig(1, cx2);
            folha.setTL(1);
        } else {
            info = folha.getvInfo(mid);
            pos = pai.getPOS(info);
            pai.arrange(pos);
            pai.setTL(pai.getTL() + 1);
            pai.setvInfo(pos, folha.getvInfo(mid));
            pai.setvPos(pos, folha.getvPos(mid));
            pai.setvLig(pos, cx1);
            pai.setvLig(pos + 1, cx2);
            if (pai.getvLig(0).getvLig(0) == null) {
                for (int j = 0; j < pai.getTL(); j++) {
                    pai.getvLig(j).setProx(pai.getvLig(j + 1));
                    pai.getvLig(j + 1).setant(pai.getvLig(j));
                }
                pai.getvLig(pai.getTL()).setant(pai.getvLig(pai.getTL() - 1));
            }
            if (pai.getTL() > M - 1) {
                folha = pai;
                info = folha.getvInfo(mid);
                pai = this.getPai(folha, info);
                split(folha, pai);
            }
        }
    }
    public void inOrdem(No raiz){
        if(raiz!=null){
            for(int i=0; i<raiz.getTL(); i++){
                inOrdem(raiz.getvLig(i));
                System.out.println(raiz.getvInfo(i));
            }
            inOrdem(raiz.getvLig(raiz.getTL()));
        }
    }

}

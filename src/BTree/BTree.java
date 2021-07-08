package BTree;

import BTree.classes.No;
import BTree.classes.Definicoes;

public class BTree implements Definicoes {
    private No raiz;

    public BTree() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public No navegarAteFolha(int info){
        No aux=raiz;
        int pos=aux.procurarPosicao(info);
        while(aux.getvLig(pos)!=null){
            aux=aux.getvLig(pos);
            pos=aux.procurarPosicao(info);
        }
        return aux;
    }

    public No localizarPai(No folha, int info){
        No aux, pai;
        aux=pai=raiz;
        int pos=aux.procurarPosicao(info);
        while(aux!=folha){
            pai=aux;
            aux=aux.getvLig(pos);
            pos=aux.procurarPosicao(info);
        }
        return pai;
    }

    public void split(No folha, No pai){
        No cx1=new No();
        No cx2=new No();
        int pos;
        for(int i=0; i<M; i++){
            cx1.setvInfo(i, folha.getvInfo(i));
            cx1.setvPos(i, folha.getvPos(i));
            cx1.setvLig(i, folha.getvLig(i));
        }
        cx1.setvLig(M, folha.getvLig(M));
        cx1.setTL(M);
        for(int i=M+1; i<2*M+1; i++){
            cx2.setvInfo(i-(M+1), folha.getvInfo(i));
            cx2.setvPos(i-(M+1), folha.getvPos(i));
            cx2.setvLig(i-(M+1), folha.getvLig(i));
        }
        cx2.setvLig(M, folha.getvLig(2*M+1));
        cx2.setTL(M);
        if(folha==pai){
            folha.setvInfo(0, folha.getvInfo(M));
            folha.setvPos(0, folha.getvPos(M));
            folha.setTL(1);
            folha.setvLig(0, cx1);
            folha.setvLig(1, cx2);
        }
        else{
            pos=pai.procurarPosicao(folha.getvInfo(M));
            pai.remanejar(pos);
            pai.setvInfo(pos, folha.getvInfo(M));
            pai.setvPos(pos, folha.getvPos(M));
            pai.setvLig(pos, cx1);
            pai.setvLig(pos+1, cx2);
            pai.setTL(pai.getTL()+1);
            if(pai.getTL()>2*M){
                folha=pai;
                pai=localizarPai(folha,folha.getvInfo(pos));
                split(folha, pai);
            }
        }
    }

    public void inserir(int info, int posArq){
        No folha, pai;
        int pos;

        if(raiz==null)
            raiz=new No(info, posArq);
        else{
            folha=navegarAteFolha(info);
            pos=folha.procurarPosicao(info);
            folha.remanejar(pos);
            folha.setvInfo(pos, info);
            folha.setvPos(pos, posArq);
            folha.setTL(folha.getTL()+1);
            if(folha.getTL()>2*M){
                pai=localizarPai(folha, info);
                split(folha,pai);
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

    //métodos para a exclusão
    public No localizarNo(int info){
        No aux=raiz;
        int pos;
        boolean flag=false;
        while(aux!=null && !flag){
            pos=aux.procurarPosicao(info);
            if(aux.getvInfo(pos)==info)
                flag=true;
            else
                aux=aux.getvLig(pos);
        }
        return aux;
    }
    public No localizarSubE(No no, int pos){
        no=no.getvLig(pos);
        while(no.getvLig(no.getTL())!=null)
            no=no.getvLig(no.getTL());
        return no;
    }
    public No localizarSubD(No no, int pos){
        no=no.getvLig(pos);
        while(no.getvLig(0)!=null)
            no=no.getvLig(0);
        return no;
    }
    public void excluir(int info){
        int pos;
        No subE, subD, folha=null;
        No no=localizarNo(info);
        if(no!=null){
            pos=no.procurarPosicao(info);
            if(no.getvLig(0)!=null){//não está na folha
                subE=localizarSubE(no,pos);
                subD=localizarSubD(no,pos+1);
                if(subE.getTL()>M || subD.getTL()==M){//pega o sub da esq
                    no.setvInfo(pos, subE.getvInfo(subE.getTL()-1));
                    no.setvPos(pos, subE.getvPos(subE.getTL()-1));
                    folha=subE;
                    pos=subE.getTL()-1;
                }
                else{//pega o sub da dir
                    no.setvInfo(pos, subD.getvInfo(0));
                    no.setvPos(pos, subD.getvPos(0));
                    folha=subD;
                    pos=0;
                }
            }
            else
                folha=no;
            //exclusão da folha
            folha.remanejarEx(pos);
            folha.setTL(folha.getTL()-1);
            if(folha!=raiz && folha.getTL()<M)
                redistribuicao_concatenacao(folha);
        }
    }
    public void redistribuicao_concatenacao(No folha){
        No pai, irmaE, irmaD;
        pai=localizarPai(folha,folha.getvInfo(0));
        int posPai=pai.procurarPosicao(folha.getvInfo(0));
        if(posPai>0)//existe irmã da esquerda
            irmaE=pai.getvLig(posPai-1);
        else
            irmaE=null;
        if(posPai<pai.getTL())//existe irmã da direita
            irmaD=pai.getvLig(posPai+1);
        else
            irmaD=null;
        if(irmaE!=null && irmaE.getTL()>M){//irmã da esquerda possui substituto
            //ok
            folha.remanejar(0);
            folha.setvInfo(0, pai.getvInfo(posPai-1));
            folha.setvPos(0, pai.getvPos(posPai-1));
            folha.setvLig(0, irmaE.getvLig(irmaE.getTL()));//aqui
            folha.setTL(folha.getTL()+1);
            pai.setvInfo(posPai-1,irmaE.getvInfo(irmaE.getTL()-1));
            pai.setvPos(posPai-1, irmaE.getvPos(irmaE.getTL()-1));
            irmaE.setTL(irmaE.getTL()-1);
        }
        else if(irmaD!=null && irmaD.getTL()>M){//irmã da direita possui substituto
            folha.setvInfo(folha.getTL(), pai.getvInfo(posPai));
            folha.setvPos(folha.getTL(), pai.getvPos(posPai));
            folha.setTL(folha.getTL()+1);
            folha.setvLig(folha.getTL(), irmaD.getvLig(0));
            pai.setvInfo(posPai, irmaD.getvInfo(0));
            pai.setvPos(posPai, irmaD.getvPos(0));
            irmaD.remanejarEx(0);
            irmaD.setTL(irmaD.getTL()-1);
        }
        else{//concatenação
            if(irmaE!=null){//irmã da esquerda com folha
                irmaE.setvInfo(irmaE.getTL(), pai.getvInfo(posPai-1));
                irmaE.setvPos(irmaE.getTL(), pai.getvPos(posPai-1));
                irmaE.setTL(irmaE.getTL()+1);
                pai.remanejarEx(posPai-1);
                pai.setTL(pai.getTL()-1);
                pai.setvLig(posPai-1, irmaE);
                for(int i=0; i<folha.getTL(); i++){
                    irmaE.setvInfo(irmaE.getTL(),folha.getvInfo(i));
                    irmaE.setvPos(irmaE.getTL(),folha.getvPos(i));
                    irmaE.setvLig(irmaE.getTL(),folha.getvLig(i));
                    irmaE.setTL(irmaE.getTL()+1);
                }
                irmaE.setvLig(irmaE.getTL(),folha.getvLig(folha.getTL()));
            }
            else{//folha com irmã da direita
                //usei a folha
                //ok
                folha.setvInfo(folha.getTL(), pai.getvInfo(posPai));
                folha.setvPos(folha.getTL(), pai.getvPos(posPai));
                folha.setTL(folha.getTL()+1);
                pai.remanejarEx(posPai);
                pai.setTL(pai.getTL()-1);
                pai.setvLig(posPai, folha);
                for(int i=0; i<irmaD.getTL(); i++){
                    folha.setvInfo(folha.getTL(),irmaD.getvInfo(i));
                    folha.setvPos(folha.getTL(),irmaD.getvPos(i));
                    folha.setvLig(folha.getTL(),irmaD.getvLig(i));
                    folha.setTL(folha.getTL()+1);
                }
                folha.setvLig(folha.getTL(),irmaD.getvLig(irmaD.getTL()));
                irmaD=folha;//apenas não precisar alterar a atribuição da linha 237
            }
            folha=pai;
            //item 6
            if(pai==raiz && pai.getTL()==0){
                if(irmaE!=null)
                    raiz=irmaE;
                else
                    raiz=irmaD;
            }
            else if(pai!=raiz && pai.getTL()<M)
                redistribuicao_concatenacao(folha);
        }
    }
}


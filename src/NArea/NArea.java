package NArea;

import NArea.classes.No;

public class NArea {
    private No raiz;

    public NArea() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int info){
        int pos=0;
        boolean inseriu=false;
        No ant=raiz,atual=raiz;
        if(raiz == null)
            raiz = new No(info);
        else
            while(!inseriu){
                if(atual==null){
                    atual = new No(info);
                    ant.setLig(pos, atual);
                    inseriu = true;
                }
                else{
                    pos = atual.buscarPos(info);
                    if(!atual.cheio()){
                        atual.remanejar(pos);
                        atual.setInfo(pos, info);
                        atual.incTL();
                        inseriu = true;
                    }else{
                        ant = atual;
                        atual = atual.getLig(pos);
                    }
                }
            }
    }

    public void in_ordem(No raiz){
        if(raiz!=null){
            int p=0;
            while(p< No.N){
                in_ordem(raiz.getLig(p));
                if(p<No.N-1 && raiz.getInfo(p)!=0)
                    System.out.println("Info: "+raiz.getInfo(p));
                p++;
            }
        }
    }


    public void exibir(){
        exi(raiz, 1);
    }

    private void exi(No atual, int i) {
        if(atual!=null){
            System.out.println("No "+i);
            atual.exibeInfos();
            int p=0;
            while(p< No.N){
                exi(atual.getLig(p),++i);
                p++;
            }
        }
    }
}





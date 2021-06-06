package NAreaLL.classes;

import NAreaLL.No;

public class ListaInfo implements Definicioes{
    private NoInfo inicio;
    private NoInfo fim;

    public ListaInfo(){
        inicio = fim = null;
    }
    public void inicializa(){
        inicio = fim = null;
    }

    public int length(){
        NoInfo aux = inicio;
        int cont = 0;

        while(aux != null){
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }
    public int buscaPosInserir(int novaInfo){
        NoInfo aux = inicio;
        int pos = 0;
        while(aux != null && novaInfo > aux.getInfo()){
            pos++;
            aux = aux.getProx();
        }
        return pos;
    }

    public void inserir(int pos, int info) {
        NoInfo nova = new NoInfo(info, null, fim);
        NoInfo aux = inicio;

        if(inicio == null)
            inicio = fim = nova;
        else{
            while(pos > 1) {
                aux = aux.getProx();
                pos--;
            }
            nova.setProx(aux.getProx());
            aux.setProx(nova);
        }
    }
    public int getInfoPos(int pos){
        NoInfo no = inicio;
        int i = 0;
        while(i < pos && no != null){
            pos--;
            no = no.getProx();
        }
        if(no != null)
            return no.getInfo();
        return 0;
    }



    public NoInfo getinicio() {
        return inicio;
    }

    public void setinicio(NoInfo inicio) {
        this.inicio = inicio;
    }


    public NoInfo getFim() {
        return fim;
    }

    public void setFim(NoInfo fim) {
        this.fim = fim;
    }

    public NoInfo getInicio() {
        return inicio;
    }

    public void setInicio(NoInfo inicio) {
        this.inicio = inicio;
    }
}

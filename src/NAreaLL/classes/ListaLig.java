package NAreaLL.classes;

import NAreaLL.No;

public class ListaLig implements Definicioes{
    private NoLig inicio;
    private NoLig fim;

    public ListaLig(){
        inicio = null;
    }

    public int length(){
        NoLig aux = inicio;
        int cont = 0;
        while(aux != null){
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }

    public NoLig getNoLig(int pos){
        NoLig no = inicio;
        int i = 0;
        while(i < pos && no != null){
            i++;
            no = no.getProx();
        }
        return no;
    }

    public void inserir(No info) {
        NoLig novo = new NoLig(info, null, fim);
        if(inicio == null)
            inicio = fim = novo;
        else{
            fim.setProx(novo);
            fim = novo;
        }
    }

    public NoLig getInicio() {
        return inicio;
    }

    public void setInicio(NoLig inicio) {
        this.inicio = inicio;
    }
}

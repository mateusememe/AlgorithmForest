package NAreaLL.classes;

import NAreaLL.No;

public class NoLig {
    private NoLig prox;
    private NoLig ant;
    private No lig;

    public NoLig(){
        prox = null;
        lig = null;
    }

    public NoLig(No lig, NoLig prox, NoLig ant) {
        this.prox = prox;
        this.ant = ant;
        this.lig = lig;
    }

    public No getLig() {
        return lig;
    }

    public void setLig(No lig) {
        this.lig = lig;
    }

    public NoLig getProx() {
        return prox;
    }

    public void setProx(NoLig prox) {
        this.prox = prox;
    }

    public NoLig getAnt() {
        return ant;
    }

    public void setAnt(NoLig ant) {
        this.ant = ant;
    }
}

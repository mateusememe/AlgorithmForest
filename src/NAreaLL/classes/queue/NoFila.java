package NAreaLL.classes.queue;

import NAreaLL.No;

public class NoFila {
    private NoFila prox;
    private No info;

    public NoFila(No info, NoFila prox){
        this.prox = prox;
        this.info = info;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }

    public No getInfo() {
        return info;
    }

    public void setInfo(No info) {
        this.info = info;
    }
}

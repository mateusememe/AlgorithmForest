package NAreaLL.classes.queue;

import NAreaLL.No;

public class Fila {
    private NoFila inicio;

    public Fila(){
        inicio = null;
    }

    public void enqueue(No info){
        NoFila novo = new NoFila(info, null);

        if(this.isEmpty())
            this.inicio = novo;
        else{
            NoFila temp = this.inicio;
            while(temp.getProx() != null)
                temp = temp.getProx();

            temp.setProx(novo);
        }
    }

    public No dequeue(){
        if(this.isEmpty())
            return null;
        else{
            NoFila aux = inicio;
            this.inicio = inicio.getProx();
            return aux.getInfo();
        }
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }
}

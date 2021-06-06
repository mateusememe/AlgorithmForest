package NAreaLL.classes;

public class NoInfo {
    private NoInfo prox;
    private NoInfo ant;
    private int info;

    public NoInfo(){
        prox = null;
    }

    public NoInfo(int info, NoInfo prox, NoInfo ant) {
        this.prox = prox;
        this.ant = ant;
        this.info = info;
    }

    public NoInfo getProx() {
        return prox;
    }

    public void setProx(NoInfo prox) {
        this.prox = prox;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NoInfo getAnt() {
        return ant;
    }

    public void setAnt(NoInfo ant) {
        this.ant = ant;
    }
}


package BPlus.classes;

public class No implements Definicoes{
    private int[] vInfo;
    private int[] vPos;
    private No[] vLig;
    private int TL;
    private No ant;
    private No prox;

    public No() {
        this.vInfo = new int[M];
        this.vPos = new int[M];
        this.vLig = new No[M + 1];
        this.ant = this.prox = null;
        this.TL = 0;
    }

    public No(int vInfo) {
        this.vInfo = new int[M];
        this.vPos = new int[M];
        this.vLig = new No[M + 1];
        this.ant = this.prox = null;
        this.TL = 0;
        this.vInfo[this.TL++] = vInfo;
    }

    public int getvInfo(int pos) {
        return this.vInfo[pos];
    }

    public void setvInfo(int pos, int vInfo) {
        this.vInfo[pos] = vInfo;
    }

    public int getvPos(int pos) {
        return this.vPos[pos];
    }

    public void setvPos(int pos, int vPos) {
        this.vPos[pos] = vPos;
    }

    public No getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(int pos, No vLig) {
        this.vLig[pos] = vLig;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

    public No getant() {
        return ant;
    }

    public void setant(No ant) {
        this.ant = ant;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public void arrange(int pos) {
        this.vLig[this.TL + 1] = this.vLig[this.TL];
        for (int i = this.TL; i > pos; i--) {
            this.vInfo[i] = this.vInfo[i - 1];
            this.vPos[i] = this.vPos[i - 1];
            this.vLig[i] = this.vLig[i - 1];
        }
    }

    @SuppressWarnings("empty-statement")
    public int getPOS(int vInfo) {
        int i;
        for(i = 0; i < this.TL && vInfo > this.vInfo[i]; i++);
        return i;
    }

}

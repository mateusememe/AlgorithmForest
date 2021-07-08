package BTree.classes;

public class No implements Definicoes{
    private int vInfo[];
    private int vPos[];
    private No vLig[];
    private int TL;

    public No() {
        vInfo = new int[2*M+1];
        vPos = new int[2*M+1];
        vLig = new No[2*M+2];
        TL=0;
    }

    public No(int info, int posArq){
        this();
        vInfo[0]=info;
        vPos[0]=posArq;
        TL=1;
    }

    public int procurarPosicao(int info){
        int pos=0;
        while(pos<TL && info>vInfo[pos])
            pos++;
        return pos;
    }

    public void remanejar(int pos){
        vLig[TL+1]=vLig[TL];
        for(int i=TL; i>pos; i--){
            vInfo[i]=vInfo[i-1];
            vPos[i]=vPos[i-1];
            vLig[i]=vLig[i-1];
        }
    }
    public void remanejarEx(int pos){
        for(int i=pos; i<TL-1; i++){
            vInfo[i]=vInfo[i+1];
            vPos[i]=vPos[i+1];
            vLig[i]=vLig[i+1];
        }
        vLig[TL-1]=vLig[TL];
    }

    public int getvInfo(int p) {
        return vInfo[p];
    }

    public void setvInfo(int p, int info) {
        vInfo[p]=info;
    }

    public int getvPos(int p) {
        return vPos[p];
    }

    public void setvPos(int p, int posArq) {
        vPos[p]=posArq;
    }

    public No getvLig(int p) {
        return vLig[p];
    }

    public void setvLig(int p, No lig) {
        vLig[p]=lig;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

}

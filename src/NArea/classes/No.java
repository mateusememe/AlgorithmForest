package NArea.classes;

public class No implements Definicoes{
    private int vInfo[], TL;
    private No vLig[];

    public No(int info) {
        vLig = new No[N];
        vInfo = new int[N-1];
        vInfo[0]=info;
        TL = 1;
    }



    public int buscarPos(int info){
        int i=0;
        while(i<TL && info >= vInfo[i])
            i++;
        return i;
    }

    public void remanejar(int pos){
        int TL = this.TL;
        while(TL > pos)
            vInfo[TL] = vInfo[--TL];


    }

    public boolean cheio(){
        return TL==N-1;
    }

    public int getInfo(int p) {
        return vInfo[p];
    }

    public void setInfo(int p, int info) {
        this.vInfo[p] = info;
    }

    public int getTL() {
        return TL;
    }
    public void setTL(int TL) {
        this.TL = TL;
    }
    public void incTL(){
        TL++;
    }

    public No getLig(int p) {
        return vLig[p];
    }

    public void setLig(int p, No lig) {
        this.vLig[p] = lig;
    }

    public void exibeInfos(){
        System.out.print("[");
        if(TL>0)
            System.out.printf("%3d",vInfo[0]);
        for(int i=1; i<N-1; i++){
            System.out.printf(", %3d",vInfo[i]);
        }
        System.out.printf(", %3d]\n",TL);
    }
}



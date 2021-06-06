package NAreaLL;

import NAreaLL.classes.ListaInfo;
import NAreaLL.classes.ListaLig;
import NAreaLL.classes.NoInfo;

public class No {
    private ListaLig listLig;
    private ListaInfo listInfo;

    public No(int info){
        listInfo = new ListaInfo();
        listInfo.inserir(0, info);
        listLig = new ListaLig();
        listLig.inserir(null);
        listLig.inserir(null);
    }
    public No(){
        listLig = null;
        listInfo = null;
    }

    public ListaLig getListLig() {
        return listLig;
    }

    public void setListLig(ListaLig listLig) {
        this.listLig = listLig;
    }

    public ListaInfo getListInfo() {
        return listInfo;
    }

    public void setListInfo(ListaInfo listInfo) {
        this.listInfo = listInfo;
    }


}

package servicos;

import java.util.ArrayList;
import java.util.List;

public class ServicoImpressao<T> {
    private List<T> lista = new ArrayList<>();

    public void adicionarValor(T valor) {
        lista.add(valor);
    }

    public T primeiro() {
        return lista.get(0);
    }

    public void imrpimir() {
        String listaToString = "[ ";
        for (int i = 0; i < lista.size(); i++) {
            listaToString += (i + 1 != lista.size()) ? lista.get(i) + ", " : lista.get(i);
        }
        listaToString += " ]";
        System.out.println(listaToString);
    }
}

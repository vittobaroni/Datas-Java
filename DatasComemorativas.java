import java.util.ArrayList;
import java.util.List;

public class DatasComemorativas {
    private final  List<DataComemorativa> eventos;
    
    public DatasComemorativas(){
        this.eventos = new ArrayList<>();
    }
    public void adiciona(DataComemorativa evento){
        if(evento != null){
            this.eventos.add(evento);
            System.out.println("'" + evento.getNome() + " adicionado à lista .");
        }
    }

    public boolean remove(String nome) {
        boolean foiRemovido = this.eventos.removeIf(evento -> evento.getNome().equals(nome)); // remove cada evento para qual a condição se aplica
        if (foiRemovido) {
            System.out.println("Evento '" + nome + "' removido com sucesso.");
        } else {
            System.out.println("Evento '" + nome + "' não encontrado na lista.");
        }
        return foiRemovido;
    }
    
    // teste trivial para saber se está funcionando como deveria

    public void listarTodas() {
        if (this.eventos.isEmpty()) {
            System.out.println("Nenhuma data comemorativa cadastrada.");
            return;
        }

        System.out.println("\n--- Lista de Datas Comemorativas ---");
        for (DataComemorativa evento : this.eventos) {
            System.out.println(evento);
        }
    }
    public int horasNaoTrabalhadas() {
        int contador = 0;
        for (DataComemorativa evento : this.eventos) {
            if (evento.isFeriado()) {
                contador++; 
            }
        }
        int totalHoras = contador * 8;
        return totalHoras;
    }


}

public class DataComemorativa{
    MinhaData data;
    String nome;
    boolean feriado;
    boolean feriado_mundial;

    public DataComemorativa(String nome,MinhaData data, boolean isferiado, boolean isferiadomundial){
        this.nome = nome;
        this.data = data;
        this.feriado = isferiado;
        this.feriado_mundial = isferiadomundial;
    }

    public String getNome(){
        return nome;
    }
    public MinhaData getData(){
        return data;
    }
    public boolean isFeriado(){
        return feriado;
    }
    public boolean isferiadomundial(){
        return feriado_mundial;
    }
    public String toString(){
        String descricao = "'" + nome + " em" + data.toString();
        if(feriado){
            descricao = descricao + "(Feriado";
            if(feriado_mundial){
                descricao = descricao + ", Mundial";
            } else{
                descricao = descricao + ")";
            }
        }
        return descricao;
    } 
}


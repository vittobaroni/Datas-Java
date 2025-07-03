public class principal{
    public static void main(String [] args){

        // 1- criando as datas e mostrando visualmente
        MinhaData data1 = new MinhaData(4,7,2025);
        MinhaData data2 = new MinhaData(25,12,2025);
        System.out.println("Data atual: " + data1);
        System.out.println("Data do Natal de 2025 : " + data2);

        // 2 - Chamar o método de comparação e imprimir o seu valor
        System.out.println("Comparando as datas : " + data1.compara(data2));

        // 3 - adicionando o objeto Natal à coleção DatasComemorativas e chame o método 
        // de horas não trabalhadas

        DataComemorativa natal2025 = new DataComemorativa("Natal 2025", data2,true,true);
        DatasComemorativas calendario = new DatasComemorativas();
        calendario.adiciona(natal2025);
        int horas = calendario.horasNaoTrabalhadas();
        System.out.println("Total de horas não trabalhadas no calendário : " + horas + "horas");

        //para mais testes, basta instanciar novos elementos
    }
}
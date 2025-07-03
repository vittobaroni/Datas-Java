public class MinhaData{
    int ano;
    int mes;
    int dia;

    public MinhaData (int d, int m, int a){
        if((d > 0 && d <= 31) && (m > 0 && m <= 12)){
            this.dia = d;
            this.mes = m;
            this.ano = a;
            }
    }
    
    public MinhaData(String datacompleta){
        String[] divisao = datacompleta.split("/");
        int dia_string = Integer.parseInt(divisao[0]);
        int mes_string = Integer.parseInt(divisao[1]);
        int ano_string = Integer.parseInt(divisao[2]);

        //valores obtidos aos atributos da classe
        this.dia = dia_string;
        this.mes = mes_string;
        this.ano = ano_string;
    }
    @Override
    public String toString(){
        return dia +"/" + mes + "/" + ano;
    }

    // métodos para adicionar/diminuir dias, meses e anos

    public void adicionarAnos(int anos){    // o mais facil : adicionar anos
        this.ano = this.ano + anos;
    }
    public void adicionarMes(int meses){
        int mesBase = this.mes - 1;
        mesBase = mesBase + meses;
        this.ano = this.ano + Math.floorDiv(mesBase, 12); // função de cálculos com números negativos
        this.mes = (mesBase % 12 + 12) % 12 + 1; //teve que fazer isto, por que dava erro com "rolagem pra trás"
    }

    public void adicionarDias(int dias){
        if(dias > 0){
            for(int i = 0; i < dias; i++){
                this.incrementaDias();
            }
        }
        else if(dias < 0){
            for(int i = 0; i < Math.abs(dias); i++){
                this.diminuirDias();
            }
        }
    }
    private void incrementaDias(){
        this.dia++;
        if(this.dia > this.diasnoMes()){
            this.dia = 1;
            this.adicionarMes(1);
        }
    }
    private void diminuirDias(){
        this.dia--;
        if(this.dia < 1){
            this.adicionarMes(-1);
            this.dia = this.diasnoMes();
        }
    }
    private int diasnoMes(){
        switch(this.mes){ // meses com 30 dias : abril,junho,setembro,novembro
            case 4 : case 6 : case 9: case 11:
                return 30;
            case 2: //pode ser bissexto
                return this.anobissexto()? 29 : 28;
            default:
                return 31;
        }
    }
    private boolean anobissexto(){
        if((this.ano % 4 == 0 && this.ano % 100 != 0) || 
        (this.ano % 100 == 0 && this.ano % 400 == 0)){
            return true;
        }else{
            return false;
        }
    }

    // método compara
    public int compara(MinhaData outradata){ // 3 casos : comparar ano, mes e dia
        if(this.ano < outradata.ano){
            return -1;
        }if(this.ano > outradata.ano){
            return 1;
        }if(this.mes < outradata.mes){
            return -1;
        } if(this.mes > outradata.mes){
            return 1;
        } if(this.dia < outradata.dia){
            return -1;
        }if(this.dia > outradata.dia){
            return 1;
        }
        return 0; // se chegamos até aqui, é porque as datas são iguais
    }
}
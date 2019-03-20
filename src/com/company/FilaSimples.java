import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Processo {
    private int tempo;
    private String nome;

    public Processo(String nome, int tempo){
        this.nome = nome;
        this.tempo = tempo;
    }
    public String getNome(){
        return this.nome;
    }
    public int getTempo(){
        return this.tempo;
    }
    public void setTempo(int tempo){
        this.tempo = tempo;
    }

}


class Fila{
    public List<Processo> processos = new LinkedList<Processo>();
    public int executando;

    public void insere(Processo p) {
        this.processos.add(p);
        this.executando ++;
    }
    public void remove(Processo p){
        this.processos.remove(p);
        this.executando --;
    }
    public void listar(){
        System.out.println("------------------");
        for(Processo p : this.processos){
            System.out.print(p.getNome());
            System.out.print("\n");
            System.out.print("Tempo:"+p.getTempo());
            System.out.print("\n");
            System.out.print("\n--\n");

        }

        System.out.print(this.executando+" Processos Em Running\n----------------------------\n");

    }
    public void executar(){
        if (this.executando > 0){
            Processo p = processos.get(0);
            int novoTempo = p.getTempo() - 1;
            p.setTempo(novoTempo);
            if(p.getTempo() == 0){
                this.remove(p);
            }
            this.listar();
        }

    }

}


public class FilaSimples{

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Fila fila = new Fila();
        while(true){

            //se eu pressionar a tecla 1, crio um processo novo
            //se eu pressionar a tecla 2, eu executo um tempo
            System.out.println("Pressione 1 para criar um novo processo, ou 2 para executar");
            int i = ler.nextInt();
            if(i == 1){
                //crio novo processo
                System.out.println("Nome do processo:");
                String nome = ler.next();
                System.out.println("Tempo do processo:");
                int tempo = ler.nextInt();
                Processo p = new Processo(nome, tempo);
                fila.insere(p);
            }else{
                //executo um tempo
                fila.executar();
            }



        }

    }


}
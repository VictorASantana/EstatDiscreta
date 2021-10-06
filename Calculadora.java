import java.util.Scanner;
import java.util.Arrays;

public class Calculadora{

    public static void main(String[] args){
        String resposta;
        Scanner leitor = new Scanner(System.in);
        while(true){
            resposta = "";
            Calculadora calc = new Calculadora();
            System.out.println("1. Inserir nova amostra. ");
            System.out.println("0. Encerrar operação. ");
            resposta = leitor.next();
            if(resposta.equals("1")){
                resposta = "";
                int tamanho;
                System.out.println("Digite o tamanho da amostra: ");
                resposta = leitor.next();
                tamanho = Integer.parseInt(resposta);
                System.out.println("Digite os valores da amostra: ");
                double[] amostra = new double[tamanho];
                for (int i = 0; i < tamanho; i++){
                    Scanner elemento = new Scanner(System.in);
                    resposta = elemento.next();
                    amostra[i] = Double.parseDouble(resposta);
                }
                while(true){
                    resposta = "";
                    System.out.println("Menu de operações: ");
                    System.out.println("1. Média Aritmética. ");
                    System.out.println("2. Mediana");
                    System.out.println("3. Variância. ");
                    System.out.println("4. Desvio padrão. ");
                    System.out.println("0. Sair. ");
                    resposta = leitor.next();
                    if (resposta.equals("1")){
                        double media = calc.mediaDiscreta(amostra);
                        System.out.println("Media: " + media);
                    }
                    else if(resposta.equals("2")){
                        double mediana = calc.medianaDiscreta(amostra);
                        System.out.println(mediana);
                    }
                    else if(resposta.equals("3")){
                        double variancia = calc.varianciaDiscreta(amostra);
                        System.out.println("Variancia: " + variancia);
                    }
                    else if(resposta.equals("4")){
                        double desvioPadrao = Math.sqrt(calc.varianciaDiscreta(amostra));
                        System.out.println("Desvio padrão: " + desvioPadrao);
                    }
                    else if (resposta.equals("0")) break;
                    else System.out.println("Opção inválida. ");
                }
            }
            else if(resposta.equals("0")) break;
            else System.out.println("Opção inválida. ");
        }

    }

    public double mediaDiscreta(double[] amostra){
        double media = 0;
        for(int i = 0; i < amostra.length; i++) media = media + amostra[i];
        media = media/ amostra.length;
        return media;
    }

    public double medianaDiscreta(double[] amostra){
        double mediana = 0;
        Arrays.sort(amostra);
        if(amostra.length % 2 == 0) mediana = (amostra[amostra.length/2] + amostra[amostra.length/2 + 1])/2;
        else mediana = amostra[amostra.length/2];

        return mediana;
    }

    public double varianciaDiscreta(double[] amostra){
        double variancia = 0;
        double media = this.mediaDiscreta(amostra);
        for (int i = 0; i < amostra.length; i++){
            variancia = variancia + Math.pow((amostra[i] - media), 2);
        }
        variancia = variancia/(amostra.length - 1);
        return variancia;
    }



}
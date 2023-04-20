package Application;

import Methods.FuelCalcMT;

import java.util.Scanner;

public class FuelCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FuelCalcMT con = new FuelCalcMT();

        int stage = 0;
        while (stage == 0) {
            System.out.println("Insira a distancia percorrida em kilometros:");
            float range = input.nextFloat();
            System.out.println("Insira a media do veiculo usado:");
            float avarage = input.nextFloat();
            if (range <= 0 || avarage <= 0) {
                System.out.println("Insira valores validos.");
            } else {
                stage = 1;
                while (stage == 1) {
                    float result1 = con.avaragexrange(avarage, range);
                    System.out.println("Agora insira o preço do combustivel usado no trajeto:");
                    float fuel = input.nextFloat();
                    if (fuel <= 0) {
                        System.out.println("Insira valores validos.");
                    } else {
                        stage = 2;
                        while (stage == 2) {
                            float result2 = con.result1xfuel(fuel, result1);
                            System.out.println("Insira a quantidade de dias que o trajeto foi feito:");
                            float time = input.nextFloat();
                            if (time <= 0) {
                                System.out.println("Insira valores validos.");
                            } else {
                                float result3 = con.result2xtime(time, result2);
                                System.out.printf("O valor gasto do mes e de: %.2f %n", (result3));
                                System.out.println("Para sair digite 1 e para realizar a conta novamente digite 2");
                                int choice = input.nextInt();
                                if (choice == 1) {
                                    stage = 3;
                                } else if (choice == 2) {
                                    stage = 0;
                                } else {
                                    System.out.println("Insira um valor valido.");
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

//    Gabriel mora em uma cidade e trabalha em outra, e notou que está tendo um grande
//        custo com o combustível para ir trabalhar todos os dias!
//        Ele solicitou a você que crie um software que receba os dados:
//        Distância da casa até o trabalho;
//        Média que o veículo faz;
//        Valor da gasolina;
//        Quantidade de dias que Gabriel irá trabalhar no mês;
//        Com estes dados vocês devem retornar o custo de combustível que Gabriel terá no
//        mês!

package Application;

import Application.Class.Pessoas;
import Methods.PessoasComparatorAltura;
import Methods.PessoasComparatorID;
import Methods.PessoasComparatorIMC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SoftwarePessoas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Pessoas> pessoa = new ArrayList<>();
        int stage = 0;

        while (stage == 0) {
            Pessoas p = new Pessoas();
            System.out.println("Id:");
            p.setID(input.nextInt());
            if (p.getID() == 0) {
                System.out.println("---- Dados dos Cadastros ----");
                stage = 1;
            } else {
                System.out.println("Nome:");
                p.setName(input.next());
                System.out.println("Idade:");
                p.setIdade(input.nextInt());
                System.out.println("Altura: ");
                p.setAltura(input.nextDouble());
                System.out.println("Peso: ");
                p.setPeso(input.nextDouble());
                p.setIMC(p.getPeso() / Math.pow(p.getAltura(), 2));
                pessoa.add(p);
                System.out.println("Adcionado com êxito.");
                stage = 0;
            }
        }
        pessoa.sort(new PessoasComparatorID());
        System.out.println("---- Ordem Crescente ID ----");
        for (Pessoas ID : pessoa) {
            System.out.println("\nID: " + ID.getID() +
                    "\nNome: " + ID.getName() +
                    "\nIdade: " + ID.getIdade() +
                    "\nAltura: " + ID.getAltura() +
                    "\nPeso: " + ID.getPeso() +
                    "\n "
            );
        }
        pessoa.sort(new PessoasComparatorIMC());
        Collections.reverse(pessoa);
        System.out.println("---- Ordem Decrescente IMC ----");
        for (Pessoas IMC : pessoa) {
;            System.out.println("\nID: " + IMC.getID() +
                    "\nNome: " + IMC.getName() +
                    "\nIdade: " + IMC.getIdade() +
                    "\nAltura: " + IMC.getAltura() +
                    "\nPeso: " + IMC.getPeso()
            );
            System.out.printf("\nIMC: %.2f %n", (IMC.getIMC()));
            System.out.println("\n ");
        }
        pessoa.sort(new PessoasComparatorAltura());
        System.out.println("---- Ordem Crescente Altura ----");
        for (Pessoas ALT : pessoa) {
            System.out.println("\nID: " + ALT.getID() +
                    "\nNome: " + ALT.getName() +
                    "\nIdade: " + ALT.getIdade() +
                    "\nAltura: " + ALT.getAltura() +
                    "\nPeso: " + ALT.getPeso() +
                    "\n "
            );
        }
        pessoa.sort(new PessoasComparatorID());
        double somaAGE = 0D;
        for (Pessoas AGE : pessoa) {
            somaAGE += AGE.getIdade();
        }
        Double medAGE = somaAGE / pessoa.size();

        double somaALT = 0D;
        for (Pessoas ALT : pessoa) {
            somaALT += ALT.getAltura();
        }
        Double medALT = somaALT / pessoa.size();

        double somaPES = 0D;
        for (Pessoas PES : pessoa) {
            somaPES += PES.getPeso();
        }
        Double medPES = somaPES / pessoa.size();

        double somaIMC = 0D;
        for (Pessoas IMC : pessoa) {
            somaIMC += IMC.getIMC();
        }
        Double medIMC = somaIMC / pessoa.size();

        System.out.println("---- RESUMO ----");
        System.out.printf("Media de idade: %.2f %n", (medAGE));
        System.out.printf("\nMédia de altura: %.2f %n", (medALT));
        System.out.printf("\nMédia de peso: %.2f %n", (medPES));
        System.out.printf("\nMédia de IMC: %.2f %n", (medIMC));
    }
}


//3- Crie um software que leia os seguintes dados para N pessoas:
//        a. ID
//        b. Nome
//        c. Idade
//        d. Altura
//        e. Peso
//        A leitura deve parar quando ID = 0, caso contrário deve inserir uma nova pessoa;
//        E em seguida imprima os dados das pessoas em ordem crescente de acordo com seu
//        ID, depois em ordem decrescente de acordo com seu IMC, depois em ordem crescente
//        de acordo com a altura. No final deve imprimir a média da idade, altura, peso e IMC
//        das pessoas cadastradas
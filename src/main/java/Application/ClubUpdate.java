package Application;

import Methods.WageComparator;

import java.util.*;

public class ClubUpdate {
    ClubUser user = new ClubUser();
    Scanner input = new Scanner(System.in);
    private static List<ClubUser> data;
    private int choice;
    private String name;
    private Integer number;
    private String sex;
    private Float heigth;
    private Float wage;
    private Integer dependents;

    public static void main(String[] args) {
        new ClubUpdate();
    }

    private ClubUpdate() {
        data = new ArrayList<ClubUser>();
        menu();
    }

    private void menu() {
        System.out.println("\n============== Clube Recrativo dos Pampas ==============");
        System.out.println("Você está no menu, digite a opção desejada: " +
                "\n1- Gerar os cadastros" +
                "\n2- Lista dos associados" +
                "\n3- Média da altura dos associados" +
                "\n4- Quantidade de dependetes dos associados" +
                "\n5- Quantidade de Homens e Mulheres associados(as)" +
                "\n6- Associado com o maior salário" +
                "\n0- Sair");
        choice = input.nextInt();
        if (choice == 0) {
            System.exit(0);
        } else if (choice == 1) {
            cadastroAssociado();
        } else if (choice == 2) {
            listarAssociados();
        } else if (choice == 3) {
            medAltura();
        } else if (choice == 4) {
            totalDependents();
        } else if (choice == 5) {
            totalMascFem();
        } else if (choice == 6) {
            maiorSalario();
        } else {
            choice = 0;
        }
    }

    private void cadastroAssociado() {
        System.out.println("Digite a quantidade de associados vão ser cadastrados:");
        int i = input.nextInt();
        for (int x = 0; x < i; x++) {
            int u = x + 1;
            System.out.println("============== Cadastro " + u + " ==============");
            System.out.println("Digite o nome do associado:");
            name = input.next();
            System.out.println("Digite o número do associado:");
            number = input.nextInt();
            boolean sexConfirm = false;
            while (sexConfirm == false) {
                System.out.println("Digite o gênero do associado(M ou F):");
                sex = input.next();
                if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F")) {
                    sexConfirm = true;
                } else {
                    System.out.println("Dado invalido.");
                    sexConfirm = false;
                }
            }
            System.out.println("Digite a altura do associado:");
            heigth = input.nextFloat();
            System.out.println("Digite o salário do associado:");
            wage = input.nextFloat();
            System.out.println("Digite a quantidade de dependentes:");
            dependents = input.nextInt();
            System.out.println("Confirmar cadastro? S/N");
            String confirma = input.next();
            if (confirma.equalsIgnoreCase("S")) {
                System.out.println("Cadastro concluido");
                ClubUser user = new ClubUser();
                user.setName(name);
                user.setNumber(number);
                user.setSex(sex);
                user.setHeigth(heigth);
                user.setWage(wage);
                user.setDependents(dependents);
                data.add(user);
            } else if (confirma.equalsIgnoreCase("n")) {
                System.out.println("Cadastro cancelado.");
            } else {
                System.out.println("Opção invalida");
            }
        }
        menu();
    }

    private void listarAssociados() {
        if (data.size() == 0) {
            System.out.println("Ainda não existe cadastros de associados.");
        } else {
            System.out.println("============== Lista dos Associados ==============");
            for (int i = 0; i < data.size(); i++) {
                ClubUser user = data.get(i);
                System.out.println("Nome: " + user.getName());
                System.out.println("Genero: " + user.getSex());
                System.out.println("Altura: " + user.getHeigth());
                System.out.println("Salario: " + user.getWage());
                System.out.println("Dependentes: " + user.getDependents());
                System.out.println("===================================================");
            }
        }
        menu();
    }

    private void medAltura() {
        if (data.size() == 0) {
            System.out.println("Ainda não existe cadastros de associados.");
        } else {
            float[] heigthArray = new float[data.size()];
            for (int i = 0; i < data.size(); i++) {
                ClubUser user = data.get(i);
                float heigth = user.getHeigth();
                heigthArray[i] = heigth;
            }
            float somaHeigth = 0;
            for (int i = 0; i < heigthArray.length; i++) {
                somaHeigth += heigthArray[i];
            }
            float medHeigth = somaHeigth / data.size();
            System.out.printf("A média de altura dos associados é de: %.2f %n", (medHeigth), "m.");
        }
        menu();
    }

    private void totalDependents() {
        if (data.size() == 0) {
            System.out.println("Ainda não existe cadastros de associados.");
        } else {
            int[] dependentsArray = new int[data.size()];
            for (int i = 0; i < data.size(); i++) {
                ClubUser user = data.get(i);
                int dependents = user.getDependents();
                dependentsArray[i] = dependents;
            }
            float somaDependents = 0;
            for (int i = 0; i < dependentsArray.length; i++) {
                somaDependents += dependentsArray[i];
            }
            System.out.println("A quantidade de dependetes dos associados é de: " + somaDependents);
        }
        menu();
    }

    private void totalMascFem() {
        if (data.size() == 0) {
            System.out.println("Ainda não existe cadastros de associados.");
        } else {
            int maleCount = 0;
            int fameCount = 0;
            for (int i = 0; i < data.size(); i++) {
                ClubUser user = data.get(i);
                String male = user.getSex();
                String fame = user.getSex();
                if (male.equalsIgnoreCase("M")) {
                    maleCount++;
                } else {
                    fameCount++;
                }
            }
            float porcentMale = (maleCount * 100) / data.size();
            float porcentFame = (fameCount * 100) / data.size();
            System.out.println("Dos associados, " + maleCount + " são homens e " + fameCount + " são mulheres.");
            System.out.printf("Homens: %.2f%%", (porcentMale));
            System.out.printf("\nMulheres: %.2f%%", (porcentFame));
        }
        menu();
    }


    private void maiorSalario() {
        if (data.size() == 0) {
            System.out.println("Ainda não existe cadastros de associados.");
        } else {
            System.out.println("============== Associado com maior salário ==============" +
                    "\n obs. se tiver dois associados com o maior salário igual," +
                    "\n será mostrado o de todos os associados.");
            data.sort(new WageComparator());
            Collections.reverse(data);
            if (data.get(0).getWage().equals(data.get(1).getWage())){
                for (int i = 0; i < data.size(); i++){
                    ClubUser user = data.get(i);
                    System.out.println("===================================================");
                    System.out.println("Nome: " + user.getName());
                    System.out.println("Salário: " + user.getWage());
                }
            }else{
                System.out.println("===================================================");
                System.out.println("Nome: "+ data.get(0).getName());
                System.out.println("Salário: " + data.get(0).getWage());
            }

        }
        menu();
    }
}



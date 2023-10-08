import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);


        System.out.println("Valor emprestimo:");
        double valorEmprestimo = input.nextDouble();

        System.out.println("QuantidadeDeParcelas:");
        int quantidadeDeParcelas = input.nextInt();

        System.out.println("TaxaDeJuros:");
        double taxaDeJuros = input.nextDouble();

        System.out.println("Tipo de pessoa: (PF; PJ; MEI:");
        String tipoPessoa= input.next();


        System.out.println("Qual a data de liberação do dinheiro: ");
        String dataLiberacaoDinheiro = input.next();

        System.out.println("Qual a data do primeiro pagamento: ");
        String dataPrimeiroPagamentoStr = input.next();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLiberacao = sdf.parse(dataLiberacaoDinheiro);

        Calendar calendarLiberacao = Calendar.getInstance();
        calendarLiberacao.setTime(dataLiberacao);

        Date dataPrimeiroPagamento = sdf.parse(dataPrimeiroPagamentoStr);

        Calendar calendarPagamento = Calendar.getInstance();
        calendarPagamento.setTime(sdf.parse(dataPrimeiroPagamentoStr));

        long diffInMilliesInicial = Math.abs(calendarPagamento.getTimeInMillis() - calendarLiberacao.getTimeInMillis());

        double taxaIOF = 0.0;

        if(tipoPessoa == "PF"){
            taxaIOF = 0.0112;
        } else if (tipoPessoa == "PJ") {
            taxaIOF = 0.0056;
        } else if (tipoPessoa == "MEI") {
            taxaIOF = 0.0014;
        }

        //toDo Criar um valor para armazenar diferenca entre dataliberacao e data de cada parcela de pagamento.
        //toDo


        double amortizacao = valorEmprestimo / quantidadeDeParcelas;
        System.out.println("Amortizacao = " + amortizacao);


        double saldoDevedorTotal = valorEmprestimo;
        double valorPagamentoDoMes = 0.0;
        double valorDeJuros = 0.0;



        for (int i = quantidadeDeParcelas; i > 0; i--) {
            valorDeJuros = saldoDevedorTotal * taxaDeJuros;
            valorPagamentoDoMes = amortizacao + valorDeJuros;

            saldoDevedorTotal -= amortizacao;

            System.out.println("Parcela Atual: " + i);
            System.out.println("Valor da Parcela : " + valorPagamentoDoMes);
            System.out.println("Valor do Juros da Parcela : " + valorDeJuros);

        }
    }
}



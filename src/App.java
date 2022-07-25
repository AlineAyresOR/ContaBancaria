import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Movimentacao;
import utils.DataUtil;

public class App {

    public static void main(String[] args){
        System.out.println("Criando nosso Banco Digital");
        System.out.println();

        //Instanciando ContaCorrente  e criando o objeto ContaCorrente.

        ContaCorrente conta = new ContaCorrente("8382","17408",03,1200.00);
        System.out.println("Saldo atual de R$" + conta.getSaldo());
        System.out.println();

        conta.depositar(150.00);
        System.out.println("Saldo atual de R$" + conta.getSaldo());
        System.out.println();

        var saque = conta.sacar(1000.00);
        System.out.println("Saldo atual de R$" + conta.getSaldo());
        System.out.println();

        ContaPoupanca conta1 = new ContaPoupanca("7072","7458",1,30000.00);

        conta1.transferir(300.00,conta);
        System.out.println("Saldo conta destino de R$" + conta1.getSaldo());
        System.out.println();

        System.out.println("Saldo atual de R$" + conta.getSaldo());
        System.out.println();

        System.out.println(conta1.getDataAbertura());

        //Printando os metódos de data e horas de formas diferentes e printando as conversões.

        //Para chamar os metódos onde coloquei static eu coloco o nome da classe na frente e não preciso instanciar.

        var f1 = DataUtil.converterDateParaDataEHora(conta1.getDataAbertura());
        var f2 = DataUtil.converterDateParaData(conta1.getDataAbertura());
        var f3 = DataUtil.converterDateParahora(conta1.getDataAbertura());
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        conta.ImprimirExtrato();
        System.out.println();
        System.out.println();
        conta1.ImprimirExtrato();






    }

}
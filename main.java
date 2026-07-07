package banksystem;

abstract class bankD {                  // abstract q customer name and balence is mandetary in any bank.
    protected String CustomerName;      // only child class access kare (SBI is child class)
    private double balence;             // balence  always public 
    
    public bankD(String CustomerName, double balence){                 // constractor
        this.CustomerName=CustomerName;
        this.balence=balence;
    }
    
    public void showdetail(){                               //show details
        System.out.println("customer :" +CustomerName);
        System.out.println("Balence :" +balence);
    } 

    protected double getBalance(){              // balence ko access karta he 
        return balence;
    }

    protected void setBalence(double balence){         // Balence ko upadate karta he
        this.balence =balence;
    }

    abstract void CalculateInterest();

}
interface OnlinePayment {         //inteface q ki payment sabhi bank se hoti he pr method different
    void transferMoney(double amount);
}

class SBI extends bankD implements OnlinePayment{
    private final int pin;
    static String BankName ="State Bank Of India";
    public SBI(String customername, double balence, int pin){
        super(customername,balence);          //super keyword q ki parent class ke attribute he 
        this.pin=pin;
    }
    @Override
    void CalculateInterest()
    {
        System.out.println("interest rate : 6%");   
    }

    @Override
    public void transferMoney(double amount){
        if(amount > getBalance()){
            System.out.println("insufficient balence ");
            return;
        }
        setBalence(getBalance()-amount);
        System.out.println("Transaction successfully :");
        System.out.println("remaining :"+getBalance());
    }

    public void varifypin(int enteredpin){
        if(enteredpin == pin){
            System.out.println("Correct pin");
            showdetail();
            transferMoney(60000);
        }
        else {
            System.out.println("Wrong pin");
            System.out.println("Transaction Failed");
        }
    }

}
public class main{
    public static void main(String[] args) {
        SBI c1 = new SBI("Sandip", 50000, 4342);
        c1.showdetail();
        c1.CalculateInterest();
        c1.varifypin(4344);
        System.out.println("Bank Name :"+SBI.BankName);
    }
}


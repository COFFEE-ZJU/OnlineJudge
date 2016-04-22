package alibaba;

/**
 * Created by zkf on 4/20/16.
 */
public interface Account extends Comparable<Account>{
    int getBalance();
    boolean withdraw(int amount);
    void deposit(int amount);
}

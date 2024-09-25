package eric.demo;

import java.util.concurrent.ExecutionException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

public class Web3Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        System.out.println("ethBlockNumber: " + ethBlockNumber.getBlockNumber());

        EthAccounts ethAccounts = web3j.ethAccounts().sendAsync().get();
        System.out.println("ethAccounts: " + ethAccounts.getAccounts());

        EthGetBalance balance = web3j.ethGetBalance("0x4c2c0525aab87e077754f799cc44d2bf5a09a3c4",
            DefaultBlockParameter.valueOf("latest")).sendAsync().get();
        System.out.println("accounts[0] balance: " + balance.getBalance());
    }
}

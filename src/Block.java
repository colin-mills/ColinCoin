import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.LinkedList;

public class Block {
    LinkedList<Transaction> transactions;
    Block prev;
    String hash;
    Time inceptionTime;
    Integer nonce;

    public Block() throws NoSuchAlgorithmException {
        transactions = new LinkedList<Transaction>();
        prev = null;
        setHash();
    }
    public Block(Block prevBlock) throws NoSuchAlgorithmException {
        transactions = new LinkedList<Transaction>();
        this.prev = prevBlock;
        setHash();

    }

    public void AddTransaction (Transaction T) throws NoSuchAlgorithmException {
        transactions.add(T);
        setHash();
    }

    public void setHash () throws NoSuchAlgorithmException {
            String toHash = transactions.toString() + prev.hash + inceptionTime.toString() + nonce.toString();
            this.hash = Hasher.toHexString(Hasher.getSHA(toHash));
    }

    public void PrintBlock () {
        System.out.println("Hash: " + hash);
        System.out.println("Previous Hash: " + prev.hash);
        System.out.println("inceptionTime: " + inceptionTime);
        System.out.println("nonce: " + nonce);

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

}

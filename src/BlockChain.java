import java.security.NoSuchAlgorithmException;

public class BlockChain {

    public static void main(String[] args) {
        try {
            Block Orign = new Block();
            Orign.PrintBlock();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}

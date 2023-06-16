import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-23
 * Time:15:04
 */

/*
* 建立二叉搜索树的异常*/
public class DictionaryException extends RuntimeException {

    public DictionaryException() {
    }

    public DictionaryException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }
}

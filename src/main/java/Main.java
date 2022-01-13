import cal.Add;
import java.util.Scanner;
import antlr.miniSysYLexer;
import antlr.miniSysYParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main{
    public static void main(String[] args){
        String input = """
                int main() {
                    return 123;
                }
               """;

        miniSysYLexer lexer = new miniSysYLexer(CharStreams.fromString(input));
        miniSysYParser parser = new miniSysYParser(new CommonTokenStream(lexer));
        miniSysYParser.ProgramContext tree= parser.program();
        System.out.println(tree.toStringTree(parser));

//        int a,b;
//        Scanner input = new Scanner(System.in);
//        a = input.nextInt();
//        b = input.nextInt();
//        int c;
//        c = Add.add(a, b);
//        System.out.println(c);
    }
}

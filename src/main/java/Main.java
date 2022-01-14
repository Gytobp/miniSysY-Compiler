import antlr.miniSysYLexer;
import antlr.miniSysYParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main{
    public static void main(String[] args){
        String input = """
                int main() {
                    return 123;
                }
               """;
//        input = args[0];

        miniSysYLexer lexer = new miniSysYLexer(CharStreams.fromString(input));
        lexer.addErrorListener(new BaseErrorListener());
        miniSysYParser parser = new miniSysYParser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new BailErrorStrategy());
        miniSysYParser.ProgramContext tree= parser.program();
//        System.out.println(tree.toStringTree(parser));
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        IRBuilder irb = IRBuilder.getInstance();
        System.out.println(irb.toString());
    }
}

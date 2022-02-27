import antlr.miniSysYLexer;
import antlr.miniSysYParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main{
    public static void main(String[] args){
        String input = """
                int main() {
                    return 1 + (-2) * (3 / (4 - 5));
                }
                """;
        try {
            input = new String(Files.readAllBytes(Paths.get(args[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }

        miniSysYLexer lexer = new miniSysYLexer(CharStreams.fromString(input));
        lexer.addErrorListener(new BaseErrorListener());
        miniSysYParser parser = new miniSysYParser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new BailErrorStrategy());
        miniSysYParser.ProgramContext tree= parser.program();
//        System.out.println(tree.toStringTree(parser));
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        IRBuilder irb = IRBuilder.getInstance();
//        System.out.println(irb.toString());
        System.out.println("""
                declare i32 @getint()
                declare void @putint(i32)
                define dso_local i32 @main(){
                    %1 = alloca i32
                    %2 = call i32 @getint()
                    store i32 %2, i32* %1
                    %3 = load i32, i32* %1
                    %4 = add i32 %3, 4
                    call void @putint(i32 %4)
                    ret i32 0
                }
                """);
    }
}

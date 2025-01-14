import antlr.miniSysYLexer;
import antlr.miniSysYParser;
import antlr.miniSysYPreprocess;
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
        miniSysYPreprocess.preprocess(input);
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
//        System.out.println("""
//                declare void @memset(i32*  ,i32 ,i32 )
//                declare i32 @getint()
//                declare i32 @getarray(i32*  )
//                declare i32 @getch()
//                declare void @putint(i32 )
//                declare void @putch(i32 )
//                declare void @putarray(i32 ,i32*  )
//                define dso_local i32 @main(){
//                %1 = sub  i32 0,2
//                %2 = sub  i32 4,5
//                %3 = sdiv  i32 3,%2
//                %4 = mul  i32 %1,%3
//                %5 = add  i32 1,%4
//                call void @putint(i32 %4)
//                ret i32 0
//                }
//                """);
    }
}

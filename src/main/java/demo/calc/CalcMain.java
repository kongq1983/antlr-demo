package demo.calc;

import calc.CalcLexer;
import calc.CalcParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CalcMain {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromString("9/3+(6/2)");
        CalcLexer lexer = new CalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
        System.out.println(tree.toStringTree(parser));
    }

}

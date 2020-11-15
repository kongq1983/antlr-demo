package demo;

import hello.HelloLexer;
import hello.HelloParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class HelloMain {

    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("hello\tworld");

        // 构造词法分析器
        HelloLexer lexer=new HelloLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 实例化解析器 // 创建语法分析器对象，并将词法分析器输出的tokens作为语法分析器的输入
        HelloParser parser = new HelloParser(tokens);
        // 开始分析程序，这也是生成AST的过程
        // 文法的入口点r会转换为一个方法，调用该方法，就会自顶向下递归分析源代码
        ParseTree tree = parser.r();
        // 创建Visitor对象
        MyHelloVisitor myHelloVisitor = new MyHelloVisitor();
        // 开始遍历AST
        myHelloVisitor.visit(tree);
    }

}

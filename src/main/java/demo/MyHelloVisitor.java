package demo;

import hello.HelloParser;
import hello.HelloVisitor;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MyHelloVisitor extends AbstractParseTreeVisitor<String> implements HelloVisitor<String> {


    @Override public String visitR(HelloParser.RContext ctx) {
        System.out.println(ctx.getText());
        System.out.println(ctx.ID().getText());
        return visitChildren(ctx);
    }
}
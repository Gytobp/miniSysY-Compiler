import antlr.miniSysYBaseVisitor;
import antlr.miniSysYParser;

import java.math.BigInteger;
import java.util.*;

public class Visitor extends miniSysYBaseVisitor<Void> {
    @Override
    public Void visitProgram(miniSysYParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Void visitCompUnit(miniSysYParser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    @Override
    public Void visitDecl(miniSysYParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public Void visitConstDecl(miniSysYParser.ConstDeclContext ctx) {
        return super.visitConstDecl(ctx);
    }

    @Override
    public Void visitBType(miniSysYParser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    @Override
    public Void visitConstDef(miniSysYParser.ConstDefContext ctx) {
        return super.visitConstDef(ctx);
    }

    @Override
    public Void visitConstInitVal(miniSysYParser.ConstInitValContext ctx) {
        return super.visitConstInitVal(ctx);
    }

    @Override
    public Void visitVarDecl(miniSysYParser.VarDeclContext ctx) {
        return super.visitVarDecl(ctx);
    }

    @Override
    public Void visitVarDef(miniSysYParser.VarDefContext ctx) {
        return super.visitVarDef(ctx);
    }

    @Override
    public Void visitInitVal(miniSysYParser.InitValContext ctx) {
        return super.visitInitVal(ctx);
    }

    @Override
    public Void visitFuncDef(miniSysYParser.FuncDefContext ctx) {

        return super.visitFuncDef(ctx);
    }

    @Override
    public Void visitFuncType(miniSysYParser.FuncTypeContext ctx) {
        return super.visitFuncType(ctx);
    }

    @Override
    public Void visitFuncFParams(miniSysYParser.FuncFParamsContext ctx) {
        return super.visitFuncFParams(ctx);
    }

    @Override
    public Void visitFuncFParam(miniSysYParser.FuncFParamContext ctx) {
        return super.visitFuncFParam(ctx);
    }

    @Override
    public Void visitBlock(miniSysYParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public Void visitBlockItem(miniSysYParser.BlockItemContext ctx) {
        return super.visitBlockItem(ctx);
    }

    @Override
    public Void visitStmt(miniSysYParser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }

    @Override
    public Void visitAssignStmt(miniSysYParser.AssignStmtContext ctx) {
        return super.visitAssignStmt(ctx);
    }

    @Override
    public Void visitExpStmt(miniSysYParser.ExpStmtContext ctx) {
        return super.visitExpStmt(ctx);
    }

    @Override
    public Void visitConditionStmt(miniSysYParser.ConditionStmtContext ctx) {
        return super.visitConditionStmt(ctx);
    }

    @Override
    public Void visitWhileStmt(miniSysYParser.WhileStmtContext ctx) {
        return super.visitWhileStmt(ctx);
    }

    @Override
    public Void visitBreakStmt(miniSysYParser.BreakStmtContext ctx) {
        return super.visitBreakStmt(ctx);
    }

    @Override
    public Void visitContinueStmt(miniSysYParser.ContinueStmtContext ctx) {
        return super.visitContinueStmt(ctx);
    }

    @Override
    public Void visitReturnStmt(miniSysYParser.ReturnStmtContext ctx) {
        return super.visitReturnStmt(ctx);
    }

    @Override
    public Void visitExp(miniSysYParser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override
    public Void visitCond(miniSysYParser.CondContext ctx) {
        return super.visitCond(ctx);
    }

    @Override
    public Void visitLVal(miniSysYParser.LValContext ctx) {
        return super.visitLVal(ctx);
    }

    @Override
    public Void visitPrimaryExp(miniSysYParser.PrimaryExpContext ctx) {
        return super.visitPrimaryExp(ctx);
    }

    @Override
    public Void visitNumber(miniSysYParser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    @Override
    public Void visitIntConst(miniSysYParser.IntConstContext ctx) {
        return super.visitIntConst(ctx);
    }

    @Override
    public Void visitUnaryExp(miniSysYParser.UnaryExpContext ctx) {
        return super.visitUnaryExp(ctx);
    }

    @Override
    public Void visitCallee(miniSysYParser.CalleeContext ctx) {
        return super.visitCallee(ctx);
    }

    @Override
    public Void visitUnaryOp(miniSysYParser.UnaryOpContext ctx) {
        return super.visitUnaryOp(ctx);
    }

    @Override
    public Void visitFuncRParams(miniSysYParser.FuncRParamsContext ctx) {
        return super.visitFuncRParams(ctx);
    }

    @Override
    public Void visitParam(miniSysYParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public Void visitMulExp(miniSysYParser.MulExpContext ctx) {
        return super.visitMulExp(ctx);
    }

    @Override
    public Void visitMulOp(miniSysYParser.MulOpContext ctx) {
        return super.visitMulOp(ctx);
    }

    @Override
    public Void visitAddExp(miniSysYParser.AddExpContext ctx) {
        return super.visitAddExp(ctx);
    }

    @Override
    public Void visitAddOp(miniSysYParser.AddOpContext ctx) {
        return super.visitAddOp(ctx);
    }

    @Override
    public Void visitRelExp(miniSysYParser.RelExpContext ctx) {
        return super.visitRelExp(ctx);
    }

    @Override
    public Void visitRelOp(miniSysYParser.RelOpContext ctx) {
        return super.visitRelOp(ctx);
    }

    @Override
    public Void visitEqExp(miniSysYParser.EqExpContext ctx) {
        return super.visitEqExp(ctx);
    }

    @Override
    public Void visitEqOp(miniSysYParser.EqOpContext ctx) {
        return super.visitEqOp(ctx);
    }

    @Override
    public Void visitLAndExp(miniSysYParser.LAndExpContext ctx) {
        return super.visitLAndExp(ctx);
    }

    @Override
    public Void visitLOrExp(miniSysYParser.LOrExpContext ctx) {
        return super.visitLOrExp(ctx);
    }

    @Override
    public Void visitConstExp(miniSysYParser.ConstExpContext ctx) {
        return super.visitConstExp(ctx);
    }
}

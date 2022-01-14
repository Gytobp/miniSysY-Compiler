import antlr.miniSysYBaseVisitor;
import antlr.miniSysYParser;
import ir.*;
import ir.Value.Type;
import ir.instructions.TerminatorInstruction;
import ir.instructions.TerminatorInstruction.Command;

import java.math.BigInteger;
import java.util.ArrayList;

public class Visitor extends miniSysYBaseVisitor<Void> {
    private final IRBuilder irb = IRBuilder.getInstance();

    public ArrayList<Parameter> _parameters = new ArrayList<>();
    public ArrayList<Instruction> _instructions = new ArrayList<>();
    public int _constInt;

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
        String retTypeText = ctx.funcType().getText();
        Type returnType = retTypeText.equals("int") ? Type.INTEGER32 : Type.VOID;
        String funcName = ctx.IDENT().getText();
        ArrayList<Parameter> parameters = new ArrayList<>();
        if (ctx.funcFParams() != null) {
            _parameters.clear();
            visit(ctx.funcFParams()); // TODO deeper visit implementation
            parameters.addAll(_parameters);
        }
        ArrayList<Instruction> instructions = new ArrayList<>();
        if (ctx.block() != null) {
            _instructions.clear();
            ctx.block().blockItem().forEach(this::visit);
            instructions.addAll(_instructions);
        }
        Definition funcDef = new Definition(new Function(returnType, funcName, parameters, new BasicBlock(null, instructions)));
        irb.functionDefinitions.add(funcDef);
        return null;
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
        assert ctx.RETURN_KW().getText().equals("return");
        Command cmd = Command.RET;
        _constInt = 0;
        visit(ctx.exp());
        TerminatorInstruction instruction = new TerminatorInstruction(null, cmd, new ConstInt(Type.INTEGER32, _constInt));
        _instructions.add(instruction);
        return null;
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
        if (ctx.DECIMAL_CONST() != null) {
            _constInt = new BigInteger(ctx.DECIMAL_CONST().getText(), 10).intValue();
        }
        if (ctx.HEXADECIMAL_CONST() != null) {
            _constInt = new BigInteger(ctx.HEXADECIMAL_CONST().getText().substring(2), 16).intValue();
        }
        if (ctx.OCTAL_CONST() != null) {
            _constInt = new BigInteger(ctx.OCTAL_CONST().getText().substring(1), 8).intValue();
        }
        return null;
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

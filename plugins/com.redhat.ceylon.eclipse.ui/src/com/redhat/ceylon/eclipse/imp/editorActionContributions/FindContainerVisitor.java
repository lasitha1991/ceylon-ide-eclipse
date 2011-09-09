package com.redhat.ceylon.eclipse.imp.editorActionContributions;

import com.redhat.ceylon.compiler.typechecker.tree.NaturalVisitor;
import com.redhat.ceylon.compiler.typechecker.tree.Node;
import com.redhat.ceylon.compiler.typechecker.tree.Tree;
import com.redhat.ceylon.compiler.typechecker.tree.Visitor;

public class FindContainerVisitor extends Visitor 
        implements NaturalVisitor {
	Node node;
	Tree.Declaration declaration;
	Tree.Declaration currentDeclaration;
	public Tree.Declaration getDeclaration() {
		return declaration;
	}
	public FindContainerVisitor(Node node) {
		this.node=node;
	}
	@Override
	public void visit(Tree.ObjectDefinition that) {
		Tree.Declaration d = currentDeclaration;
		currentDeclaration = that;
		super.visit(that);
		currentDeclaration = d;
	}
	@Override
	public void visit(Tree.AnyAttribute that) {
		Tree.Declaration d = currentDeclaration;
		currentDeclaration = that;
		super.visit(that);
		currentDeclaration = d;
	}
	@Override
	public void visit(Tree.AnyMethod that) {
		Tree.Declaration d = currentDeclaration;
		currentDeclaration = that;
		super.visit(that);
		currentDeclaration = d;
	}
	@Override
	public void visit(Tree.AnyClass that) {
		Tree.Declaration d = currentDeclaration;
		currentDeclaration = that;
		super.visit(that);
		currentDeclaration = d;
	}
	@Override
	public void visit(Tree.AnyInterface that) {
		Tree.Declaration d = currentDeclaration;
		currentDeclaration = that;
		super.visit(that);
		currentDeclaration = d;
	}
	public void visitAny(Node node) {
		if (this.node==node) {
			declaration=currentDeclaration;
		}
		if (declaration==null) {
			super.visitAny(node);
		}
	}
}
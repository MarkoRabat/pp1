package rs.ac.bg.etf.pp1.util;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.SemanticPass;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPassLogger {
	private Logger log = Logger.getLogger(getClass());
	public StringBuilder build_msg(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0) msg.append("\n\tna liniji ").append(line);
		return msg;
	}
	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = build_msg(message, info);
		msg.insert(0, "Greska: "); log.error(msg.toString());
	}
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = build_msg(message, info);
		log.info(msg.toString());
	}
	public void report_name_isNot_defined(String name, SyntaxNode obj) {
		report_error("ime " + name + " nije definisano", obj); }
	public void report_name_isAlready_defined(String name, SyntaxNode obj) {
		report_error("ime " + name + " je vec definisano", obj); }
	public void report_undefined_type(String name, SyntaxNode obj) {
		report_error("nepostojeci tip " + name, obj); }
	public void report_nonInt_operands(String operator, SyntaxNode obj, Struct... operands) {
		String opNames = " ";
		int opCount = 0;
		for (Struct op : operands) {
			opNames += SemanticPass.getTypeName(op) + ", "; ++opCount; }
		opNames = opNames.substring(0, opNames.length() - 2);
		report_error((opCount > 1 ? "tipovi operanada" : "tip operanda")
			+ " operatora " + operator + " "
			+ (opCount > 1 ? "moraju" : "mora")
			+ " biti int\n\ta ne " 
			+ (opCount > 1 ? "tipova" : "tipa") + ":"
			+ opNames, obj);
	}
	public void report_incompatible_types_inInit(
		String varType, String literalType, SyntaxNode obj) {
		report_error("identifikator tipa " + varType
				+ " inicijalizovan literalom tipa " + literalType, obj); }
	public void report_indexing_nonArray(String ident, SyntaxNode obj) {
		report_error("indeksiranje ne nizovskog identifikatora tipa " + ident, obj);
	}
	public void report_index_nonInt_type(String type, SyntaxNode obj) {
		report_error("index niza ne sme biti tipa "
			+ type + " vec mora biti tipa int", obj);
	}
	public void report_unallowed_assignment(
		Struct identType, Struct exprType, SyntaxNode obj) {
		report_error("nedozvoljena dodela vrednosti tipa "
			+ SemanticPass.getTypeName(exprType)
			+ " identifikatoru tipa "
			+ SemanticPass.getTypeName(identType) + "\n\t( "
			+ SemanticPass.getTypeName(identType) + " = "
			+ SemanticPass.getTypeName(exprType) + " )", obj);
	}
	public void report_array_allocTo_nonArray(SyntaxNode obj, Struct type) {
		report_error(
			"odrediste adrese alociranog niza ne moze biti primitivni tip "
			+ SemanticPass.getTypeName(type), obj);
	}
	public void info_print() { log.info("Prepoznata naredba print"); }
}

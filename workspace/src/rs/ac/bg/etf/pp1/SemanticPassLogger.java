package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;

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
	public void info_print() { log.info("Prepoznata naredba print"); }
}

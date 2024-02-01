package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class MJParserTest {
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(MJParserTest.class); Reader br = null;
		try {
			//File sourceCode = new File("test/program.mj");
			File sourceCode = new File("test/test301.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			br = new BufferedReader(new FileReader(sourceCode)); Yylex lexerVisitor = new Yylex(br);
			MJParser parserVisitor = new MJParser(lexerVisitor);
			Symbol s = parserVisitor.parse();
			Program prog = (Program) (s.value); log.info(prog.toString(""));
			log.info("====================================");
			Tab.init(); SemanticPass semanticVisitor = new SemanticPass();
			prog.traverseBottomUp(semanticVisitor);
			log.info(" Broj print naredbi = "
					+ semanticVisitor.getPrintCallCount());
			log.info(" Deklarisanih promenljivih ima = "
					+ semanticVisitor.getVarDeclCount());
			log.info(" Deklarisanih simbolickih konstanti ima = "
					+ semanticVisitor.getConDeclCount());
			log.info("===================================="); Tab.dump();
			if (!parserVisitor.noSyntaxicalErrors()
				|| !semanticVisitor.noSemanticErrors()) {
				log.error("Prevodjenje NIJE uspesno zavrseno"); return; }
			File objFile = new File("test/program.obj");
			if (objFile.exists()) objFile.delete();
			CodeGenerator codeGenVisitor = new CodeGenerator();
			prog.traverseBottomUp(codeGenVisitor);
			Code.dataSize = semanticVisitor.getNVars();
			Code.mainPc = codeGenVisitor.getMainPc();
			Code.write(new FileOutputStream(objFile));
			log.info("Prevodjenje uspesno zavrseno");
		}
		finally {
			if (br != null) try { br.close(); }
			catch (IOException e1)  { log.error(e1.getMessage(), e1); }
		}
	}
}

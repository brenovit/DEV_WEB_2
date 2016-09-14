package Recursos;
import javax.swing.JOptionPane;

public class InOut {
	
	public static Integer InInt(String titulo){
		int in;
		try {
			in = Integer.parseInt(JOptionPane.showInputDialog(titulo));
			return in;
		}catch(Exception e){
			OutMessage("Erro de Execução:\n"+e,"ERRO",3);
		}finally {
			in = 0;
		}
		return in;
	}
	
	public static Float InFloat(String titulo){
		float in;
		try {
			in = Float.parseFloat(JOptionPane.showInputDialog(titulo));
			return in;
		}catch(Exception e){
			OutMessage("Erro de Execução:\n"+e,"ERRO",3);		
		}finally {
			in = 0;
		}	
		return in;
	}
	
	public static Double InDouble(String titulo){
		double in;
		try {
			in = Double.parseDouble(JOptionPane.showInputDialog(titulo));	
			return in;
		}catch(Exception e){
			OutMessage("Erro de Execução:\n"+e,"ERRO",3);		
		}finally {
			in = 0;
		}
		return in;
	}
	
	public static String InString(String titulo){
		String in;
		try {
			in = JOptionPane.showInputDialog(titulo);
			return in;
		}catch(Exception e){
			OutMessage("Erro de Execução:\n"+e,"ERRO", 3);		
		}finally {
			in = "";
		}
		return in;
	}
	
	public static void  OutMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static void  OutMessage(String msg, String titulo) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void  OutMessage(String msg, String titulo, int msgType) {
		JOptionPane.showMessageDialog(null, msg, titulo, msgType);
	}
	
	public static int ConfirmDialog(String msg, String titulo){
		int op = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
		if(op == 0)
			return 0;
		else if(op == 1)
			return 1;
		return 2;
	}
}
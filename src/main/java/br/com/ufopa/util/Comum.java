package br.com.ufopa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Part;

public class Comum {

	public static Date dataSemHoras(Date data){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String ds;
		try {
			ds = df.format(data);
			return df.parse(ds);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public static Date dataSemHoras(String data){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//String ds;
		
		try {
			return df.parse(data);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public static String dataToStr(Date data){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(data);
	}
	
	public static Date addDiaToData(int numDia, Date data){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, numDia);
		return calendar.getTime();
	}
	
	public static Date diminuiDiaToData(int numDia, Date data){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, -numDia);
		return calendar.getTime();
	}
	
	public static String getFileName(Part file){
		for(String cd : file.getHeader("content-disposition").split(";")){
			if(cd.trim().startsWith("filename")){
				String filename = cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
			}
		}
		return null;
	}
	
	public static String getExtensao(String file){
		if(file!=null){
			String[] extensao = file.split("\\.");
			return extensao[extensao.length-1];
		}
		return null;
	}
	
	public static boolean isExtensaoValida(String ext, String[] tipos){
		List<String> lists = Arrays.asList(tipos);
		for(String item : lists ){
			if(item.equals(ext)){
				return true;
			}
		}
		return false;
	}
	
}

package br.com.projetospring.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetospring.models.ArquivoCSV;

@Controller
public class CsvController {

	@RequestMapping("csv")
	public String paginaCsv() {
		return "upload/csvUpload";
	}
	
	@RequestMapping("uploadCSV")
	public String uploadArquivo(String pasta,String nome, MultipartFile arquivo) throws IOException {
		
		String caminho = pasta + "/" + nome;
		File arquivoGerado = new File(caminho);
		FileOutputStream arquivoSaida = new FileOutputStream(arquivoGerado);
		
		copiaArquivoServidor(arquivo.getInputStream(),arquivoSaida);
		
		lerArquivo(arquivoGerado);
		
		return "upload/sucesso";
	}
	
	public void lerArquivo(File arquivo) throws FileNotFoundException {
		
		Scanner lerArquivo = new Scanner(arquivo);
		ArquivoCSV csv = new ArquivoCSV();
		
		lerArquivo.nextLine();
		
		while(lerArquivo.hasNextLine()) {
			
			String[] colunas = lerArquivo.nextLine().split(",");
			
			
			if(colunas.length >1) {			

					csv.setTeste1(colunas[0]);
					csv.setTeste2(colunas[1]);
					csv.setTeste3(colunas[2]);
					
					System.out.println(csv);
		
			}
			
			
			
		}
		
		lerArquivo.close();
		
	}
	
	
	public void copiaArquivoServidor(InputStream arquivoEntrada, OutputStream arquivoSaida ) {
		
		int bytes = 0;
		byte[] bytesMax = new byte[1024 * 10];
		
		try {
			
			
			while((bytes = arquivoEntrada.read(bytesMax)) >= 0) {
				System.out.println(arquivoEntrada.read(bytesMax));	
				arquivoSaida.write(bytesMax);
			}
		}
		catch(IOException e){
			System.out.println("catch");
			e.printStackTrace();
			
		}
	}
	
	
}

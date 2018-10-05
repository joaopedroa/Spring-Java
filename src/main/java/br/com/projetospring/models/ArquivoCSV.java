package br.com.projetospring.models;

public class ArquivoCSV {

	public String teste1;
	public String teste2;
	public String teste3;
	
	public String getTeste1() {
		return teste1;
	}
	public void setTeste1(String teste1) {
		this.teste1 = teste1;
	}
	public String getTeste2() {
		return teste2;
	}
	public void setTeste2(String teste2) {
		this.teste2 = teste2;
	}
	public String getTeste3() {
		return teste3;
	}
	public void setTeste3(String teste3) {
		this.teste3 = teste3;
	}
	
	@Override
	public String toString() {
		return "teste1=" + teste1 + ", teste2=" + teste2 + ",teste3=" + teste3;
	}
	
}

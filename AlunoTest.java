package Aula4.ED2;

import java.nio.ByteBuffer;

public class AlunoTest {

	public static void main(String[] args) {
		//Aluno a = new Aluno(5,"Simone","Rua Aaa",(short)27,"F","a@a.com.br");
		Aluno c = new Aluno(7000,"Leozin","rua a",(short)24,"M","b@b.com.br");		
		
		ByteBuffer buf = c.getBuffer();
		Aluno b = new Aluno(buf);
		
		//a.getBuffer();
		System.out.println(b.getMatricula());
		System.out.println(b.getNome());
		System.out.println(b.getEndereco());
		System.out.println(b.getIdade());
		System.out.println(b.getSexo());
		System.out.println(b.getEmail());
		

	}

}

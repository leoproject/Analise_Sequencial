package Aula4.ED2;

import java.io.IOException;

public class TesteDeComplexidade {

	public void TesteAdd(int n, IFileOrganizer arg2) throws IOException {
		long ini = System.currentTimeMillis();

		for (int i = 1; i <= n; i++) {
			Aluno a = new Aluno(i, "Aluno" + i, "Rua " + i, (short) 19, "F",
					"aluno" + i + "@ufs.br");
			arg2.addReg(a);
		}
		long fim = System.currentTimeMillis();
		long total=(fim-ini);
	    System.out.println(total);
	    
	    int minutes = (int) ((total / (1000*60)) % 60);
	    System.out.println(minutes);
	}
}

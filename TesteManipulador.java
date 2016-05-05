package Aula4.ED2;


import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class TesteManipulador {


	public static void main(String[] args) throws IOException {


		IFileOrganizer arg1 = new ManipuladorSequencial("C:/Users/Leonardo De Jesus/workspace/Estrutura de Dados 2/src/Aula4/ED2/enem_seq.db");
		File fOrigem = new File("C:/Users/Leonardo De Jesus/workspace/Estrutura de Dados 2/src/Aula4/ED2/selected.db");
		RandomAccessFile fileOrigem = new RandomAccessFile(fOrigem, "r");
		FileChannel channelOrigem = fileOrigem.getChannel();
		int[] matriculas;
		matriculas = new int[1000];
		int i, cont = 0;

		for (i = 0; i < 1000; i++) {
			ByteBuffer matric = ByteBuffer.allocate(4);
			matric.position(0);
			channelOrigem.read(matric, i * 4);
			matric.position(0);
			int mat = matric.getInt();
			matric.position(0);
			matriculas[i] = mat;
		}

		// Analise de desempenho para busca de forma sequencial binária
		long inib = System.currentTimeMillis();

		for (i = 0; i < 1000; i++) {
			Aluno c = arg1.getRegBin(matriculas[i]);
			/*System.out.println(c.getMatricula());
			cont += 1;
			System.out.println(cont);*/

		}

		long fimb = System.currentTimeMillis();

		long totalb = (fimb - inib);
		System.out.println("Analise de tempo do Sequencial em Binário:\n");
		System.out.println("Tempo total em milisegundos de forma binária é :"+ totalb);
		int minutesb = (int) ((totalb / (1000 * 60)) % 60);
		System.out.println("Tempo total em minutos de forma binária é :"+ minutesb);
		float hoursb = minutesb / 60;
		System.out.println("Tempo de processamento das buscas de forma binária em horas:"+ hoursb+"\n\n");

		// Analise de desempenho para busca de forma sequencial
		long ini = System.currentTimeMillis();

		for (i = 0; i < 1000; i++) {
			Aluno b = arg1.getReg(matriculas[i]);
			/*System.out.println(b.getMatricula());*/
			/*cont += 1;
			System.out.println(cont);*/

		}

		long fim = System.currentTimeMillis();

		long total = (fim - ini);
		System.out.println("Analise de tempo do Sequencial :\n");
		System.out.println("Tempo total em milisegundos é :" + total);
		int minutes = (int) ((total / (1000 * 60)) % 60);
		System.out.println("Tempo total em minutos de forma binária é :"+ minutes+"\n");
		float hours = minutes / 60;
		System.out.println("Tempo de processamento das buscas em horas:"
				+ hours);

	}

}

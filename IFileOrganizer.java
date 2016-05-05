package Aula4.ED2;

import java.io.IOException;

public interface IFileOrganizer {
	public void addReg (Aluno a) throws IOException;
	public Aluno delReg(int matric) throws IOException;
	public Aluno getReg (int matric) throws IOException;
	public Aluno getRegBin (int matric) throws IOException;
}

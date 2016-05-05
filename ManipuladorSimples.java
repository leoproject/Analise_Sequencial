package Aula4.ED2;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ManipuladorSimples implements IFileOrganizer{
	private FileChannel canal;

	public ManipuladorSimples(String path) throws FileNotFoundException{
		File file = new File (path);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		this.canal = raf.getChannel(); 
		
	}
	@Override
	public void addReg(Aluno a) throws IOException {
		
		ByteBuffer rec = a.getBuffer();
		canal.write(rec,canal.size());
		
	}

	@Override
	public Aluno delReg(int matric) throws IOException {
		int p = (int)(canal.size()-157);
		this.canal.position(0);
        for( int i = 0; i< canal.size(); i+=157){
     	   ByteBuffer buf = ByteBuffer.allocate(157);
     	   canal.read(buf, i);
     	   buf.flip();
     	   Aluno a = new Aluno(buf);
     	   if ( a.getMatricula()== matric)
     	   {
     		  ByteBuffer bufb = ByteBuffer.allocate(157); 
     		  canal.read(bufb, p);
     		  bufb.flip();
     		  canal.write(bufb, i);
     		  canal.truncate(p); 
  // o truncate estabelece o canal do tamanha desejado.
     	   }
        }
        return null;
       
	}

	@Override
	public Aluno getReg(int matric) throws IOException{
		   this.canal.position(0);
           for( int i = 0; i< canal.size(); i+=157){
        	   ByteBuffer buf = ByteBuffer.allocate(157);
        	   canal.read(buf, i);
        	   buf.flip();
        	   Aluno a = new Aluno(buf);
        	   if ( a.getMatricula()== matric)
        	   {
        		   return a;
        	   }
           }
           return null;
          
	
	}
	@Override
	public Aluno getRegBin(int matric) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}

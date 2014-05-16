package braendli.cipher;
/**
 * 
 */

/**
 * @author Erik
 *
 */
public class MonoAlpabethicCipher implements Cipher{
	private String secretAlphabet;
	public MonoAlpabethicCipher(){}
	
	protected void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}
	
	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	@Override
	public String encrypt(String text) {
		String[] alpha= new String[2];
		alpha[0]="abcdefghijklmnopqrstuvwxyzäöüß";
		alpha[1]=secretAlphabet;
		String shity= "";
		char[] vok= text.toCharArray();
		for(int i = 0; i < vok.length; i++){
			vok[i]=alpha[1].charAt(alpha[0].lastIndexOf(vok[i]));
			shity+=vok[i];
		}
		return shity;	
	}
	

	@Override
	public String decrypt(String text) {
		String[] alpha= new String[3];
		alpha[0]="abcdefghijklmnopqrstuvwxyzäöüß";
		alpha[1]=secretAlphabet;
		alpha[2]="";
		char[] vok= text.toCharArray();
		for(int i = 0; i < vok.length; i++){
			vok[i]=alpha[0].charAt(alpha[1].lastIndexOf(vok[i]));
			alpha[2] += vok[i];
		}
		return alpha[2];	
	}
	
}

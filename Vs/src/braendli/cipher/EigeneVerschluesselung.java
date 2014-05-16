package braendli.cipher;

public class EigeneVerschluesselung implements Cipher {
	public int x = 5;
	public void setX(int x){this.x=x;}
	public String encrypt(String text){
		String txt1,txt = crypt(text, x);
		txt1="";
		for(int i= 0; i< txt.length();i++)
			txt1+=txt.charAt(i);
		return txt1;
	}
	public String decrypt(String text){
		String txt1,txt = dcrypt(text, x);
		txt1="";
		for(int i= 0; i< text.length();i++)
			txt1+=txt.charAt(i);
		return txt1;
	}
	private String dcrypt(String text, int level){
		int rowcount = 0;
		if(text.length() % level !=0){
			rowcount = text.length() / level;
			rowcount++;
		}else{
			rowcount = text.length() / level;
		}
		char[][] tab = new char[rowcount][level];
		int pointer = 0;

		String rtext = "";
		for(int a = level-1; a>=0;a--){
			for(int i = rowcount-1; i>=0; i--){
				if(pointer  < text.length())
					tab[i][a] = text.charAt(pointer);
				tab[i][a]-=level;
				pointer++;

			}
		}
		for(int i = rowcount-1; i >= 0;i--)
			for(int a = level-1; a >= 0;a--){
				rtext += tab[i][a];
			}

		return rtext;
	}
	private String crypt(String text, int level){

		int rowcount = 0;
		if(text.length() % level !=0){
			rowcount = text.length() / level;
			rowcount++;
		}else{
			rowcount = text.length() / level;
		}
		char[][] tab = new char[rowcount][level];
		int pointer = 0;
		for(int i = 0; i<rowcount; i++){
			for(int a = 0; a<level;a++){
				if(pointer < text.length())
					tab[i][a]=text.charAt(pointer);
				tab[i][a] += level;
				pointer++;
			}
		}
		String rtext = "";
		for(int a = 0; a<level;a++){
			for(int i = 0; i<rowcount; i++){
				rtext += tab[i][a];

			}
		}
		return rtext;
	}
	public static void main(String[] args) {
		EigeneVerschluesselung ev = new EigeneVerschluesselung();
		ev.setX(2);
		String text = ev.encrypt("Sarah Kreutzer");
		System.out.println(text);
		text = ev.decrypt(text);
		System.out.println(text);
	}
}

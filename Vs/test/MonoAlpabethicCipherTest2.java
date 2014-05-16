import static org.junit.Assert.*;

import org.junit.Test;


public class MonoAlpabethicCipherTest2 {

	@Test
	public final void testSetSecretAlphabet() {
		MonoAlpabethicCipher mac = new MonoAlpabethicCipher();
		String g ="adcbefghijklmnopqrstuvwxyzäöüß";
		mac.setSecretAlphabet(g);
		if(!mac.getSecretAlphabet().equals(g)){
			throw new RuntimeException("secretalphabet konnte nicht gesetzt bzw gelesen werden");
		}
	}

	@Test
	public final void testGetSecretAlphabet() {
		MonoAlpabethicCipher mac = new MonoAlpabethicCipher();
		String g ="adcbefghijklmnopqrstuvwxyzäöüß";
		mac.setSecretAlphabet(g);
		if(!mac.getSecretAlphabet().equals(g)){
			throw new RuntimeException("secretalphabet konnte nicht gesetzt bzw gelesen werden");
		}
	}

	@Test
	public final void testEncrypt() {
		MonoAlpabethicCipher mac = new MonoAlpabethicCipher();
		String g ="adcbefghijklmnopqrstuvwxyzäöüß";
		mac.setSecretAlphabet(g);
		if(!mac.encrypt("bd").equals("db"))
			throw new RuntimeException("Verschluesselung schlaegt fehl");
		
		
	}

	@Test
	public final void testDecrypt() {
		MonoAlpabethicCipher mac = new MonoAlpabethicCipher();
		String g ="adcbefghijklmnopqrstuvwxyzäöüß";
		mac.setSecretAlphabet(g);
		if(!mac.decrypt("bd").equals("db"))
			throw new RuntimeException("Entschluesselung schlaegt fehl");
	}

}

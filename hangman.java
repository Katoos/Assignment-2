package eg.edu.alexu.csd.datastructure.hangman.cs7;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.Random;

public class hangman implements IHangman {
	public String[] word;
	public String secretWord;
	public int maxWrongGuess;
	public String currentWord = "";
	@Override
	public void setDictionary(String[] words) {
		word = words;
	}
	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (word == null)
			return null;
		else {
			int ran = new Random().nextInt(word.length);
			secretWord = word[ran];
			for (int i = 0; i < secretWord.length(); i++)
				currentWord += "-";
			return secretWord;
		}
	}

	@Override
	public String guess(final Character c) throws Exception {
		// TODO Auto-generated method stub
		int ans = 0;
		StringBuilder array_char = new StringBuilder(currentWord);

		if (maxWrongGuess == 0) {
			return null;
		}

		if (c != null) {
			for (int i = 0; i < secretWord.length(); i++) {
				if (Character.toLowerCase(c) == Character.toLowerCase(secretWord.charAt(i))) {
					array_char.setCharAt(i, secretWord.charAt(i));
					ans = 1;
				}
			}
		}
		
		currentWord = array_char.toString();

		if (ans == 0) {
			maxWrongGuess--;
		}
		if (secretWord == null) {
			return null;
		}

		if (secretWord.length() == 0 || secretWord.charAt(0) == ' ') {
			throw new UnsupportedOperationException();
		}

		if (maxWrongGuess == 0) {
			return null;
		} else {
			return currentWord;
		}

	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max == null) {
			maxWrongGuess = 1;
		} else
			maxWrongGuess = max;
	}
}

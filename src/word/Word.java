package word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
	//멤버변수
	private String word;
	private List<String> mean = new ArrayList<String>();
	
	//생성자
	public Word() {
		
	}
	
	public Word(String word) {
		this.word = word;
	}
	
	public Word(String word, String mean) {
		this.word = word;
		this.mean.add(mean);
	}

	//메서드
	public void print() {
		System.out.println("[" + word + "]");
		for(int i=0; i<mean.size(); i++) {
			if(i == mean.size()-1) {
				System.out.print(mean.get(i));
			}else {
				System.out.print(mean.get(i) + ", ");				
			}
		}
		System.out.println();
	}
	
	public void printMean() {
		for(int i=0; i<mean.size(); i++) {
			System.out.println(i+1 + ". " + mean.get(i));
		}
	}
	
	public void addMean(String a) {
		this.mean.add(a);
	}	
	
	@Override
	public String toString() {
		String s;
		s = "[" + word + "]\n";
		for(int i=0; i<mean.size(); i++) {
			if(i == mean.size()-1) {
				s += mean.get(i);
			}else {
				s += mean.get(i) + ", ";
			}
		}
		return s;
	}

	//equals 수정
	@Override
	public int hashCode() {
		return Objects.hash(mean, word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	//Getters and Setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<String> getMean() {
		return mean;
	}

	public void setMean(List<String> mean) {
		this.mean = mean;
	}
	
}

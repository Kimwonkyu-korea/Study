package dto;

import java.util.Arrays;

public class HumanDto {
	
	private String name;
	private String age;
	private String gen;
	private String hobby[];
	public HumanDto(String name, String age, String gen, String[] hobby) {
		super();
		this.name = name;
		this.age = age;
		this.gen = gen;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "결과 출력 : [이름=" + name + ", 나이=" + age + ", 성별=" + gen + ", 취미=" + Arrays.toString(hobby) + "]";
	}
	
	
}

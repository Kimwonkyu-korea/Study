public class DoWhileSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c ='a';
		
		do {
			System.out.print(c);
			c= (char)(c+1); // ������ ��� 1�� ���ϸ� ���� ������ �ڵ� �� ȣ��
		}while(c<='z');
	}
}

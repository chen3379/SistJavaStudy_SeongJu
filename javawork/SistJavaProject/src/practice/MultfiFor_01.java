package practice;

public class MultfiFor_01 {

	public static void main(String[] args) {
		
		// 애국가 1~4절 3번 반복
		
		String a="동해물과 백두산이 마르고 닳도록\r\n"
				+ "하느님이 보우하사 우리나라 만세\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람 대한으로 길이 보전하세";
		String b="남산 위에 저 소나무 철갑을 두른 듯\r\n"
				+ "바람 서리 불변함은 우리 기상일세\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람 대한으로 길이 보전하세";
		String c="가을 하늘 공활한데 높고 구름 없이\r\n"
				+ "밝은 달은 우리 가슴 일편단심일세\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람 대한으로 길이 보전하세";
		String d="이 기상과 이 맘으로 충성을 다하여\r\n"
				+ "괴로우나 즐거우나 나라 사랑하세\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람 대한으로 길이 보전하세";
		
		for(int i=1;i<=3;i++) {
			System.out.println("["+i+"번째 재생]\n");
			for(int j=1;j<=4;j++) {
				if(j==1) {
				System.out.println("["+j+"절]");
				System.out.println(a);
				}
				else if(j==2) {
					System.out.println("["+j+"절]");
					System.out.println(b);
				}
				else if(j==3) {
					System.out.println("["+j+"절]");
					System.out.println(c);
				}
				else {
					System.out.println("["+j+"절]");
					System.out.println(d);
				}
			
			}
			
			
		}

		
		
	}

}

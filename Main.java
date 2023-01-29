package com.KoreaIT.java.AM;

import java.text.NumberFormat.Style;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;//스캐너 프로그램의 필요한 프로그램

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 == ");

		Scanner sc = new Scanner(System.in);
		int 게시글번호 = 0;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.println("명령어 입력 :");
			String cmd = sc.nextLine();

			if (cmd.length() == 0) {
				// 명령어의 길이가 0이면 처음부터 다시, 명령어가 0이면 명령어를 입력 x
				System.out.println("명령어를 입력하세요");
				continue;

			}
			if (cmd.equals("게시글 종료")) {
				// 명령어가 "게시글 종료"를 치면 작업종료
				break;

			}

			if (cmd.equals("게시글 작성")) {
				int 마지막번호 = 게시글번호 + 1;
				게시글번호 = 마지막번호;

				System.out.printf("제목: ");
				String 제목 = sc.nextLine();

				System.out.printf("내용: ");
				String 내용 = sc.nextLine();

				Article article = new Article(제목, 내용, 게시글번호);
				// Article를 보고 만든 article에 제목과 내용 게시글 번호를 넘긴다
				articles.add(article);
				// articles(저장장치)에 article의 정보를 넘긴다.

				System.out.printf("%d번글 생성되었습니다.\n", 게시글번호);

			}

			else if (cmd.equals("게시글 보기")) {

				if (articles.size() == 0) {
					// "게시글 보기"를 입력받았지만 articles(저장장치)에 아무것도 없다면 "게시글이 없습니다"를 출력한다

					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("게시글의 번호    ㅣ      제목");
				for (int i = articles.size() - 1; i >= 0; i--) { //역순 반복문
					Article article = articles.get(i);
					// articles(게시글)만 담을 수 있는 articles변수에 articles(저장장치)에 있는 i의 값(정보)을 뺴오겠다
					System.out.printf("%d             ㅣ      %s\n", article.게시글번호, article.제목);
				}
			}

			else {
				System.out.println("존재하지 않는 명령어입니다.");
			}

		}

		System.out.println("== 프로그램 종료 == ");
	}
}

class Article {
	String 제목;
	String 내용;
	int 게시글번호;

	Article(String 제목, String 내용, int 게시글번호) {
		this.제목 = 제목;
		this.내용 = 내용;
		this.게시글번호 = 게시글번호;
	}

}
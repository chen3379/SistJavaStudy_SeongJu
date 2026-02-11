package com.gisa.quiz;

import com.gisa.quiz.domain.Quiz;
import com.gisa.quiz.repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final QuizRepository quizRepository;

    public DataLoader(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (quizRepository.count() == 0) {
            Quiz q1 = new Quiz(
                "다음 중 SQL의 DDL(Data Definition Language)에 해당하는 명령어는?",
                "1. SELECT; 2. INSERT; 3. CREATE; 4. UPDATE",
                "3",
                "DDL은 데이터 정의 언어로, 테이블이나 스키마를 생성, 수정, 삭제하는 역할을 합니다. CREATE, ALTER, DROP, TRUNCATE가 여기에 속합니다."
            );

            Quiz q2 = new Quiz(
                "프로토콜(Protocol)의 기본 요소 3가지가 아닌 것은?",
                "1. 구문(Syntax); 2. 의미(Semantics); 3. 순서(Timing); 4. 처리(Processing)",
                "4",
                "프로토콜의 3요소는 구문(Syntax), 의미(Semantics), 순서(Timing)입니다. '처리'는 프로토콜의 요소가 아닙니다."
            );

            Quiz q3 = new Quiz(
                "객체지향 프로그래밍(OOP)의 특징 중, 기존 클래스의 내용을 변경하지 않고 새로운 기능을 추가하여 확장할 수 있는 것은?",
                "1. 캡슐화(Encapsulation); 2. 상속(Inheritance); 3. 다형성(Polymorphism); 4. 추상화(Abstraction)",
                "2",
                "상속(Inheritance)은 부모 클래스의 필드와 메소드를 자식 클래스가 물려받아 사용할 수 있게 하며, 기능을 추가하거나 재정의하여 클래스를 확장하는 핵심적인 방법입니다."
            );
            
            Quiz q4 = new Quiz(
                "TCP/IP 4계층 모델에서 인터넷 계층(Internet Layer)에 해당하는 프로토콜은?",
                "1. TCP; 2. IP; 3. HTTP; 4. FTP",
                "2",
                "인터넷 계층의 핵심 프로토콜은 IP(Internet Protocol)입니다. TCP는 전송 계층, HTTP와 FTP는 응용 계층 프로토콜입니다."
            );

            quizRepository.saveAll(Arrays.asList(q1, q2, q3, q4));
        }
    }
}

package data.dao;

import data.dto.MycarCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MycarCommentDaoInter extends JpaRepository<MycarCommentDto, Integer> {

    // @Query : repository 에 원하는 쿼리를 작성하게 해주는 어노테이션
    // value (속성) : 쿼리 작성부
    // nativeQuery : JPA 에서 지정한 규칙을 모두 무시할 수 있는 속성
    // @Transactional : update, delete 를 할 때 표기해줘야 정상 실행
    // @Modifying : DDL 구문 사용할 때 표기

    // num 에 해당하는 댓글목록출력 메서드
    // @Query("select c from jpacar_comment c where c.nim=:num order by c.idx desc")
    @Query(value = "select * from jpacar_comment where num=:num order by idx desc", nativeQuery = true)
    public List<MycarCommentDto> getMycarCommentList(@Param("num") Long num);
}

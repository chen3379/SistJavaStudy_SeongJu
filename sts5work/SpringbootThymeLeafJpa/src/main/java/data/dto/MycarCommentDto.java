package data.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jpacar_comment")
public class MycarCommentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@JoinColumn(name = "num")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne // 여러 개가 하나를 참조 - 해당 엔티티 테이블에 외래키 존재
	private MycarDto mycar;
	
	@Column
	private String comment;
	
	@CreationTimestamp
	@Column(updatable = false)
	@JsonFormat(pattern = "yy-MM-dd HH:mm")
	private Timestamp writeday;
}

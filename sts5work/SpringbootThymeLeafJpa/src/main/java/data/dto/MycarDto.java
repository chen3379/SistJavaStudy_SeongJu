package data.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jpacar")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MycarDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	@Column(length = 30)
	private String carname;

	@Column(length = 30)
	private int carprice;

	@Column(length = 30)
	private String carcolor;

	@Column(length = 100)
	private String carphoto;

	@Column
	private String carguip;

	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp writeday;
	
	@Transient // 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용 가능한 변수
	private int commentcount;
	
	@Transient
	private String message;
	
}

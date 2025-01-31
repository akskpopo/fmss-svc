package egovframework.bbs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

import egovframework.bas.BaseEntity;
import egovframework.bas.FileEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * fileName       : BbsUseEntity
 * author         : hanslee
 * date           : 2023/11/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/11/27        shchun		최초 생성
 * 2023/11/30        hanslee	엔티티명 변경 및 BaseEntity 상속 추가 등
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="TB_BBS_USE_M")
public class BbsUseEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "bbsDtlId", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="BBS_USE_ID", length=32, nullable=false)
    @Comment("UUID")
	private String bbsUseId;
	
	/* 원래의 PK1, FK */ 
	@ManyToOne
    @JoinColumn(name="BBS_ID", nullable = false)
    private BbsEntity bbsEntity;
	
	@Column(name="TRGT_ID", length=20, nullable = false)
    @Comment("대상ID")
	private String trgtId; // char(20) not null default '',
	
	@Column(name="USE_YN", length=1, nullable = false)
    @Comment("사용여부")
	private String useYn; // char(1) not null,
	
	@Column(name="REG_DIVS_CD", length=6)
    @Comment("등록구분코드")
	private String regDivsCd; // char(6) default null,
	

}

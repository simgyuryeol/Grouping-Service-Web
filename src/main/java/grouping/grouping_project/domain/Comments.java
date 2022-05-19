package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Comments {

    @Id
    @GeneratedValue
    private int comments_id;

    private String id; //댓글 유저 아이디
    private String contents; // 댓글 내용
    private String datetime; //작성 일자
}

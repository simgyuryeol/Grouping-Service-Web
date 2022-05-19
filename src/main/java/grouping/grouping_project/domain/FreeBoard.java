package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class FreeBoard {

    @Id
    @GeneratedValue
    private int boardid; //글 번호

    private String id; //작성자 아이디
    private Comments comment; //댓글 번호
    private String content; //글 내용
    private String datetime; //글 작성 일자
}

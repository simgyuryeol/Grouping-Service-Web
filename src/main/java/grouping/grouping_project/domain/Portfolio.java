package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Portfolio {

    @Id
    @GeneratedValue
    private int potfolioid;

    private String id; //유저 아이디
    private String contents;
    private String datetime; //수정 일자
}

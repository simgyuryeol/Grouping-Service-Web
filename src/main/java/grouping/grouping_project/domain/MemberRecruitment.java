package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class MemberRecruitment {

    @Id
    @GeneratedValue
    private int memberid;

    private String id;
    private Comments comments;
    private String contents;
    private String datetime;
}

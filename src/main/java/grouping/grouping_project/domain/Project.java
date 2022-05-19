package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Project {
    @Id
    @GeneratedValue
    private int projectid;

    private String id;
    private Comments comments;
    private String contents;
    private String datetime;
}

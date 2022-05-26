package grouping.grouping_project.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Team {

    @Id @GeneratedValue
    private long seq;

    @Column(name="team_name")
    private String team_name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member id;


    private String contents;
    private String created_time;


}

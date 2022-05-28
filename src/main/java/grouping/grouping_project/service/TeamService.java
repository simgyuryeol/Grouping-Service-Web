package grouping.grouping_project.service;

import grouping.grouping_project.Dto.TeamForm;
import grouping.grouping_project.domain.Member;
import grouping.grouping_project.domain.Team;
import grouping.grouping_project.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;

    public String TeamCreate(TeamForm request, Member member){

        teamRepository.save(Team.builder()
                .team_name(request.getTeam_name())
                .id(member)
                .contents(request.getContents())
                .created_time(request.getCreated_time())
                .build());
        return "Success";
    }

    public String TeamUpdate(Long teamid, TeamForm request){
        Optional<Team> team = teamRepository.findById(teamid);
        request.updateEntity(team.get());
        teamRepository.save(team.get());
        return "Success";
    }

    public List<TeamForm> TeamList() {
        List<Team> teams = teamRepository.findAll();
        List<TeamForm> teamFormList = new ArrayList<>();

        for (Team t: teams){
            TeamForm teamForm = new TeamForm();
            teamForm.setTeam_name(t.getTeam_name());
            teamForm.setContents(t.getContents());
            teamForm.setCreated_time(t.getCreated_time());
            teamForm.setId(t.getId().getId());
            teamFormList.add(teamForm);
        }
        return teamFormList;
    }

    public String teamDelete(Long teamId){
        Optional<Team> team = teamRepository.findById(teamId);
        teamRepository.delete(team.get());
        return "Success";
    }
}

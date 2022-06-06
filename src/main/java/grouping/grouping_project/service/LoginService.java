package grouping.grouping_project.service;

import grouping.grouping_project.Dto.CustomMemberForm;
import grouping.grouping_project.domain.Member;
import grouping.grouping_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final CustomMemberForm customMemberForm;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member id = memberRepository.findById(username).get();
        if(id==null) {
            throw new UsernameNotFoundException("User not authorized");
        }
        return new CustomMemberForm(id);
    }
}

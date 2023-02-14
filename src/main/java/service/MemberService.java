package service;

import domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    // 회원가입
    @Transactional
    public Long join(Member member){
        existMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void existMember(Member member) {
        List<Member> members = memberRepository.memberList(member.getLoginID());
        if(!members.isEmpty()){
            throw new IllegalStateException("존재하는 회원!");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findByLoginID(String loginId){
        return memberRepository.findByLoginId(loginId);
    }

    public Member findById(Long memberId){
        return memberRepository.findById(memberId);
    }

    @Transactional
    public void update(Long id, String name, String loginId, String password, int age){
        Member findLoginId = memberRepository.findByLoginId(loginId);

    }
}

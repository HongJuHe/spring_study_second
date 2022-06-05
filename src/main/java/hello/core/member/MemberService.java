package hello.core.member;

public interface MemberService {

    //회원 가입 서비스
    void join(Member member);

    //회원 조회 서비스
    Member findMember(Long memberId);
}

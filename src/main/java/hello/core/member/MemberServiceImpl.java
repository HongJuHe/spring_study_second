package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //인터페이스 사용시,  nullpointerexception 발생 주의

    private final MemberRepository memberRepository; //추상화에만 의존
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

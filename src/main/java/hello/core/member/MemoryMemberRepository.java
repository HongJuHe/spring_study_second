package hello.core.member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //동시성의 이슈가 있어서 hashmap보다는 concurrenthashmap 추천
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

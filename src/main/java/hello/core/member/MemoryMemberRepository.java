package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 동시성 이슈가 있을수 있으므로 실무에서는 ConcurrentHashMap을 사용하자
    private static Map<Long, Member> store = new HashMap();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

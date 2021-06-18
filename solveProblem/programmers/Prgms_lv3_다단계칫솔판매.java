import java.util.Arrays;
import java.util.HashMap;

public class Prgms_lv3_다단계칫솔판매 {
    public static void main(String[] args) {
        int[] answer = {};
        answer = new Prgms_lv3_다단계칫솔판매().solution(
                      new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                    , new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
                    , new String[] {"young", "john", "tod", "emily", "mary"}
                    , new int[] {12, 4, 2, 5, 10});
        System.out.println(Arrays.toString(answer));
    }

    // enroll : 각 판매원의 이름, 10글자 이내, 조직에 참여한 순서로 정렬, enroll.length : 민호 제외 전체 구성원의 수 (1 ~ 1만)
    // referral : 각 판매원의 추천인 이름(부모노드), "-" : 추천인 없음 (= 민호)
    // seller : 판매원이름 (1 ~ 10만)
    // amount : 판매수량 (1 ~ 100), 개당가격 : 100원, 판매금액 = amount[i] * 100(원)
    // 구하는 것 : 각 enroll 당 총 이익

    private String[] referral;

    private int[] answer;
    private HashMap<String, Integer> idxFromName;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        this.referral = referral;

        answer = new int[enroll.length];
        for(int i = 0; i < answer.length; ++i) answer[i] = 0;

        idxFromName = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            idxFromName.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            shareProfit(seller[i], amount[i] * 100);
        }

        return answer;
    }

    private void shareProfit(String name, int profit) {
        if (name.equals("-")) return;
        if (profit == 0) return;
        int idx = idxFromName.get(name);
        int fee = profit/10;
        answer[idx] += profit - fee;
        shareProfit(referral[idx], fee);
    }
}

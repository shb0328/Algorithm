function solution(price, money, count) {
    // const sum = [...Array(count)].reduce((acc,_,i)=>acc+=(i+1),0);
    const sum = (1 + count) * count / 2;
    const answer = money - (price * sum);
    return answer > 0 ? 0 : -answer;
}

const ans = solution(3, 20, 4);
console.log(ans);
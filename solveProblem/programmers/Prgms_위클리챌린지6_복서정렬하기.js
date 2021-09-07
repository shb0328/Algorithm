function solution(weights, head2head) {
  
  const compare = (b1, b2) => 
    b1.winRate != b2.winRate ? b2.winRate - b1.winRate
    : b1.expensiveWin != b2.expensiveWin ? b2.expensiveWin - b1.expensiveWin
    : b1.weight != b2.weight ? b2.weight - b1.weight
    : b1.index - b2.index
  ; 
  
  const boxer = head2head.map((v, me) => {
    let winCnt = 0;
    let expensiveWinCnt = 0;
    let vsCnt = v.length;
    const arr = v.split('');
    arr.forEach((element, other) => {
      if(element == 'N') vsCnt--;
      if(element == 'W') {
        winCnt++;
        if(weights[me] < weights[other]) expensiveWinCnt++;
      }
    })

    return {
      'index' : me,
      'weight' : weights[me],
      'winRate': vsCnt == 0 ? 0 : winCnt/vsCnt,
      'expensiveWin': expensiveWinCnt
    }
  });

  return boxer.sort(compare).map(v => v.index+1);
}

const t1 = solution([50,82,75,120],["NLWL","WNLL","LWNW","WWLN"]);
const t2 = solution([145,92,86],["NLW","WNL","LWN"]);
const t3 = solution([60,70,60],["NNN","NNN","NNN"]);

console.log(` t1 : ${t1}, answer : [3,4,1,2]`);
console.log(` t2 : ${t2}, answer : [2,3,1]`);
console.log(` t3 : ${t3}, answer : [2,1,3]`);
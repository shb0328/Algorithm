function solution(word) {
  //     1                        2                    3                 4                  5
  // a   n*(n*((n*(n+1))+1))+1    n*((n*(n+1))+1)+1    n*(n+1)+1         n+1=6              1
  //ans  (dic1*a1)+1              ans1+(dic2*a2)+1     ans2+(dic3*a3)+1  ans3+(dic4*a4)+1   ans4+(dic5*a5)+1
  const n = 5;
  const dic = { 'A':0,'E':1,'I':2,'O':3,'U':4 };
  const sub = [...Array(n)].fill(1);
  for(let i = 1; i < n; i++) sub[i] = n*sub[i-1]+1;
  sub.reverse();
  const answer = word.split('').reduce((result,v,i)=> result + dic[v]*sub[i] + 1, 0);
  return answer;
}

console.log(solution('AAAAE')); //6
console.log(solution('AAAE')); //10
console.log(solution('I')); // 1563
console.log(solution('EIO')); //1189

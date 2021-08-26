function solution(scores) {

  const getGrade = score => 
  score >= 90 ? 'A' :
  score >= 80 ? 'B' :
  score >= 70 ? 'C' :
  score >= 50 ? 'D' :
  'F';

  const transpose = matrix => matrix.reduce((result, row) => row.map((e, i) => [...(result[i] || []), e]),[]);

  const answer = transpose(scores).reduce((result, row, i) => {
    
    const onlyMaxFromMe = () => (row[i] == max) && (row.filter(v => v == max).length == 1);
    const onlyMinFromMe = () => (row[i] == min) && (row.filter(v => v == min).length == 1);
    
    const max = Math.max(...row);
    const min = Math.min(...row);
    const sum = row.reduce((acc,v)=>acc+v,0);
    const avg = 
      onlyMaxFromMe() ? (sum - max) / (row.length-1) :
      onlyMinFromMe() ? (sum - min) / (row.length-1) : 
      sum / row.length;
    
    return result += getGrade(avg);
  },"");

  return answer;
}

const scores = [[100, 90, 98, 88, 65], [50, 45, 99, 85, 77], [47, 88, 95, 80, 67], [61, 57, 100, 80, 65], [24, 90, 94, 75, 65]];
const result = solution(scores);
console.log(result === "FBABD");
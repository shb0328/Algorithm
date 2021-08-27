function solution(table, languages, preference) {
  const result = [];

  const score = (career, total) => {
    return {
      career : career,
      total : total
    }
  }

  const getScore = (arr, lang, pref) => {
    const idx = arr.indexOf(lang);
    return (idx == -1 ? 0 : (6-idx)*pref);
  }

  table.forEach((col, idx) => {
    const arr = col.split(' ');
    const total = languages.reduce((sum, lang, i) => sum + getScore(arr, lang, preference[i]), 0);
    result.push(score(arr[0],total));
  });

  result.sort((a,b)=>{
    if(a.total == b.total) {
      return a.career>b.career ? 1 :
             a.career<b.career ? -1 :
             0;
    };
    return b.total - a.total;
  })

  return result[0].career;
}

// const table = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
// const language = ["PYTHON", "C++", "SQL"];
// const preference = [7, 5, 5];
const table = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
const language = ["JAVA", "JAVASCRIPT"]	;
const preference = [7, 5];

const result = solution(table, language, preference);
console.log(result);

// console.log(result == 'HARDWARE');
console.log(result == 'PORTAL');
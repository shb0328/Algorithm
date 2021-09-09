const dx = [0,0,-1,1];
const dy = [-1,1,0,0];

function solution(game_board, table) {
  let answer = 0;
  const visited_table = table.map(v=>v.map(vv=>false));
  const visited_game_board = game_board.map(v=>v.map(vv=>false));

  const listOfPieces = getListOfPuzzles(table, visited_table, 1);
  const listOfBlanks = getListOfPuzzles(game_board, visited_game_board, 0);

  answer = listOfBlanks.reduce((acc, blanks, size) => {
    const pieces = listOfPieces[size];
    for(let j = 0; j < blanks.length; ++j){
      for(let i = 0; i < pieces.length; ++i) {
        if(!isSamePuzzle(pieces[i], blanks[j])) continue;
        pieces.splice(i,1);
        acc += size;
        break;
      }
    }
    return acc;
  }, 0);

  return answer;
}

const isSamePuzzle = (piece, blank) => {
  const cnt = blank.reduce((acc, b) => {
    for(let i = 0; i < piece.length; ++i) {
      let p = piece[i];
      for(let r = 0; r < 4; r++) {
        if( p.up == b.up && p.down == b.down && p.right == b.right && p.left == b.left) 
          return acc+1;
        p = rotatePiece(p);
      }
    }
    return acc;
  }
  ,0);
  return cnt == blank.length;
}
  
const rotatePiece = piece => {
  return {
    'up' : piece.right,
    'down' : piece.left,
    'right' : piece.down,
    'left' : piece.up
  }
}

const getListOfPuzzles = (board, visited, value) => {
  const list = [0,[],[],[],[],[],[]];
  for(let i = 0; i < board.length; ++i) {
    for(let j = 0; j < board.length; ++j) {
      if(visited[i][j]) continue;
      visited[i][j] = true;
      if(board[i][j] != value) continue;
      const piece = getPuzzle([j,i], board, visited, value);
      list[piece.length].push( 
        piece.map(pos => { 
          return {
            'up' : piece.filter(v => v[1] < pos[1]).length,
            'down' : piece.filter(v => v[1] > pos[1]).length,
            'right' : piece.filter(v => v[0] > pos[0]).length,
            'left' : piece.filter(v => v[0] < pos[0]).length
          }
        })
      );
    }
  }
  return list;
}

const getPuzzle = (start, board, visited, value) => {
  const puzzle = [];
  const q = [start];
  
  while(q.length > 0) {
    const pos = q.shift();
    puzzle.push(pos);

    for(let d = 0; d < 4; d++) {
      let nx = pos[0] + dx[d];
      let ny = pos[1] + dy[d];
      if(!isRange(board, nx,ny)) continue;
      if(visited[ny][nx]) continue;
      visited[ny][nx] = true;
      if(board[ny][nx] == value) q.push([nx,ny]);
    }
  }
  return puzzle;
}

const isRange = (board, x, y) => {
  return x >= 0 && y >= 0 && x < board[0].length && y < board.length;
}


//--- test ---//

// const game_board = [[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]];
// const table = [[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]];

// const game_board = [[1,0,1],[1,1,1],[1,0,1]];
// const table = [[1,0,1],[0,0,0],[1,0,1]];

const game_board = 
[ [0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0]
, [1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0]
, [0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0]
, [1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1]
, [0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0]
, [0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1]
, [0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0]
, [0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0]
, [1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0]
, [0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0]
, [0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1]
, [0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0]];

const table = 
[ [1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1]
, [1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1]
, [1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0]
, [0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0]
, [1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0]
, [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0]
, [1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1]
, [1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1]
, [0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1]
, [1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1]
, [1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1]
, [1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1]];

const result = solution(game_board, table);
console.log(result); //54
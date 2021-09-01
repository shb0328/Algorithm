const dx = [0,0,-1,1];
const dy = [-1,1,0,0];

function solution(game_board, table) {
  let answer = 0;
  const visited_table = table.map(v=>v.map(vv=>false));
  const visited_game_board = game_board.map(v=>v.map(vv=>false));

  const pieces = getPieces(table, visited_table);
  const blanks = getBlanks(game_board, visited_game_board);

  answer = blanks.reduce((acc, blank) => {
    const size = blank[0].size;
    const piecesOfSameSize = pieces[size];
    for(let i = 0; i < piecesOfSameSize.length; ++i) {
      if(!isSamePuzzle(piecesOfSameSize[i], blank)) continue;
      piecesOfSameSize.splice(i,1);
      return acc + size;
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
  return (cnt == blank.length);
}
  
const rotatePiece = piece => {
  return {
    'up' : piece.right,
    'down' : piece.left,
    'right' : piece.down,
    'left' : piece.up
  }
}

const getPieces = (table, visited_table) => {
  const pieces = [0,[],[],[],[],[],[]];
  for(let i = 0; i < table.length; ++i) {
    for(let j = 0; j < table.length; ++j) {
      if(visited_table[i][j]) continue;
      visited_table[i][j] = true;
      if(table[i][j] != 1) continue;
      const piece = getPuzzle([j,i], table, visited_table, 1);
      pieces[piece.length].push( 
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
  return pieces;
}

const getBlanks = (game_board, visited_game_board) => {
  const blanks = [];
  for(let i = 0; i < game_board.length; ++i) {
    for(let j = 0; j < game_board.length; ++j) {
      if(visited_game_board[i][j]) continue;
      visited_game_board[i][j] = true;
      if(game_board[i][j] != 0) continue;
      const blank = getPuzzle([j,i], game_board, visited_game_board, 0);
      blanks.push( 
        blank.map(pos => { 
          return {
            'up' : blank.filter(v => v[1] < pos[1]).length,
            'down' : blank.filter(v => v[1] > pos[1]).length,
            'right' : blank.filter(v => v[0] > pos[0]).length,
            'left' : blank.filter(v => v[0] < pos[0]).length,
            'size' : blank.length
          }
        })
      );
    }
  }
  return blanks;
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



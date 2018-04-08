background(84, 30, 0);
var cells = [];
var cellSize = 30;
var numRows = 400 / (2 * cellSize);
// var numRows = 5;
var numCols = numRows;

noStroke();

// STEP 1
// initialize labirynth with initial
// value (in java I need some char), done it
for (var row = 0; row < numRows; row += 1) {
    cells[row] = [];
    for (var col = 0; col < numCols; col += 1) {
        cells[row][col] = "not in maze";
    }
}

// STEP 2
var drawCell = function(row, col, cell) {
    if (cell === "active") {
        fill(250, 0, 0);
    } else if (cell === "in maze") {
        fill(250, 250, 0);
    } else {
        fill(0, 0, 0);  //
    }

    // this code is draw in array
    // (first 2 args) and what exact to draw
    rect(2 + (cellSize * 2) * col,
        2 + (cellSize * 2) * row,
        cellSize, cellSize);
};


// STEP 3
// code to check is our row / col out of bound
var isOutOfBounds = function(row, col) {
    return (row < 0 || col < 0 || row >= numRows || col >= numCols);
};


// STEP 4
// if position is not out bounders. it in maze
var inMaze = function(row, col) {
    if (isOutOfBounds(row, col)) {
        return true;
    }
    return cells[row][col] === "in maze";
};

// STEP 5
// get walls
var getWalls = function(row, col) {
    var walls = [];
    if (!inMaze(row, col - 1)) {
        walls.push([[row, col], [row, col - 1]]);
    }
    if (!inMaze(row - 1, col)) {
        walls.push([[row, col], [row - 1, col]]);
    }
    if (!inMaze(row, col + 1)) {
        walls.push([[row, col], [row, col + 1]]);
    }
    if (!inMaze(row + 1, col)) {
        walls.push([[row, col], [row + 1, col]]);
    }
    return walls;
};


// STEP 6
for (var row = 0; row < numRows; row += 1) {
    for (var col = 0; col < numCols; col += 1) {
        drawCell(row, col, cells[row][col]);
    }
}

// STEP 7
var curRow = random(0, numRows);
var curCol = random(0, numCols);

curRow = floor(curRow);
curCol = floor(curCol);

cells[curRow][curCol] = "in maze";
var wallsToKnockDown = getWalls(curRow, curCol);


// STEP 8

var draw = function() {
    if (wallsToKnockDown.length !== 0) {
        var wall = wallsToKnockDown.splice(
            random(0, wallsToKnockDown.length), 1)[0];

        var sourceRow = wall[0][0];
        var sourceCol = wall[0][1];
        var destRow = wall[1][0];
        var destCol = wall[1][1];
        var destCell = cells[destRow][destCol];

        if (destCell === "in maze") {
            return;
        }

        cells[destRow][destCol] = "in maze";

        wallsToKnockDown = wallsToKnockDown.concat(
            getWalls(destRow, destCol));

        cells[curRow][curCol] = "in maze";
        cells[destRow][destCol] = "active";
        drawCell(curRow, curCol, cells[curRow][curCol]);
        drawCell(destRow, destCol, cells[destRow][destCol]);

        fill(255, 255, 255);
        rect(2 + (cellSize * 2) * (sourceCol + destCol)/2,
            2 + (cellSize * 2) * (sourceRow + destRow)/2,
            cellSize, cellSize);

        curRow = destRow;
        curCol = destCol;
    }
};

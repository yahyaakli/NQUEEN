# NQUEEN
This repository contains a backtrack solution to NQueens problem.<br>
The algorithm is implemented in JAVA.
<br>
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.

## Description of the methods
The solution is stored in a Vector of Integer. This data structure is used to optimize storage.

```
public static Vector<Integer> position(int n, int col)
```
Shows the possible positions left to explore on the chess board
```
public static int solveFirstSolution (int n,int col)
```
Solves the NQueens problem and stops once it finds the first solution. At the end, it displays the solution.
```
public static void solveAllSolutions (int n,int col)
```
Solves all the possible solutions and display them.
```
public static void showSolution(Vector<Integer> Sol)
```
Displays a solution.
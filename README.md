# Knight-s-Tour

Modify your Knight’s Tour solver to print the trace below.

PART 1. Data

 1) Board: 5x5.
 2) Initial position: X=1, Y=1. L=1.
    
PART 2. Trace

 1) R1. U=3, V=2. L=2. Free. BOARD[3,2]:=2.
 2) -R1. U=5, V=3. L=3. Free. BOARD[5,3]:=3.
 3) --R1. U=7, V=4. L=4. Out.
 4) --R2. U=6, V=5. L=4. Out.
 5) --R3. U=4, V=5. L=4. Free. BOARD[4,5]:=4.
 6) ---R1. U=6, V=6. L=5. Out.
 7) ---R2. U=5, V=7. L=5. Out.
 8) ---R3. U=3, V=7. L=5. Out.
 9) ---R4. U=2, V=6. L=5. Out.
 10) ---R5. U=2, V=4. L=5. Free. BOARD[2,4]:=5.
 11) ----R1. U=4, V=5. L=6. Thread.
 And so on until the deadend at L=21. Then backtrack one level, i.e. pop one hyphen.
 ...) -------------------R1. U=4, V=2. L=21. Free. BOARD[4,2]:=21.
 ...) --------------------R1. U=6, V=3. L=22. Out.
 ...) --------------------R2. U=5, V=4. L=22. Thread.
 ...) --------------------R3. U=3, V=4. L=22. Thread.
 ...) --------------------R4. U=2, V=3. L=22. Thread.
 ...) --------------------R5. U=2, V=1. L=22. Thread.
 ...) --------------------R6. U=3, V=0. L=22. Out.
 ...) --------------------R7. U=5, V=0. L=22. Out.
 ...) --------------------R8. U=6, V=1. L=22. Out. Backtrack.
 ...) -------------------R2. U=3, V=3. L=21. Thread.
 ...) -------------------R3. U=1, V=3. L=21. Thread.
 ...) -------------------R4. U=0, V=2. L=21. Out.
 ...) -------------------R5. U=0, V=0. L=21. Out.
 ...) -------------------R6. U=1, V=-1. L=21. Out.
 ...) -------------------R7. U=3, V=-1. L=21. Out.
 ...) -------------------R8. U=4, V=0. L=21. Out. Backtrack.
 ...) ------------------R8. U=3, V=2. L=20. Thread. Backtrack
 ...) -----------------R7. U=3, V=3. L=19. Thread.
 ...) -----------------R8. U=4, V=4. L=19. Thread. Backtrack.
 ...) ----------------R5. U=2, V=3. L=18. Thread.
 ...) ----------------R6. U=3, V=2. L=18. Thread.
 ...) ----------------R7. U=5, V=2. L=18. Free. BOARD[5,2]:=18.
 ...) -----------------R1. U=7, V=3. L=19. Out.
     
 And so on.
 
70611) ---------------------R1. U=5, V=5. L=23. Free. BOARD[5,5]:=23.
70612) ----------------------R1. U=7, V=6. L=24. Out.
70613) ----------------------R2. U=6, V=7. L=24. Out.
70614) ----------------------R3. U=4, V=7. L=24. Out.
70615) ----------------------R4. U=3, V=6. L=24. Out.
70616) ----------------------R5. U=3, V=4. L=24. Thread.
70617) ----------------------R6. U=4, V=3. L=24. Free. BOARD[4,3]:=24.
70618) -----------------------R1. U=6, V=4. L=25. Out.
70619) -----------------------R2. U=5, V=5. L=25. Thread.
70620) -----------------------R3. U=3, V=5. L=25. Thread.
70621) -----------------------R4. U=2, V=4. L=25. Thread.
70622) -----------------------R5. U=2, V=2. L=25. Thread.
70623) -----------------------R6. U=3, V=1. L=25. Thread.
70624) -----------------------R7. U=5, V=1. L=25. Free. BOARD[5,1]:=25.
       
PART 3. Results
 1) Path is found. Trials=70624.
 2) Path graphically:
    
 Y, V ^
 
 5 | 21 16 11 4 23
 
 4 | 10 5 22 17 12
 
 3 | 15 20 7 24 3
 
 2 | 6 9 2 13 18
 
 1 | 1 14 19 8 25
 
 ------------------> X, U
 
 1 2 3 4 5

Seven tests:
1) N=5, X=1, Y=1. Trials=70 624.
2) N=5, X=5, Y=1. Trials=236.
3) N=5, X=1, Y=5. Trials= 111 981.
4) N=5, X=2, Y=1. No tour. Trials=14 635 368.
5) N=6, X=1, Y=1. Trials=1 985 212.
6) N=7, X=1, Y=1. Trials=57 209 233.
7) N=4, X=1, Y=1. No tour. Trials=17 784.
   
Print the output of each test to two files as follows:
a) PART 1 and PART 3 – to screen and the file out-short.txt;
b) all three parts – to the file out-long.txt.

Implemented Instructions
Instruction
Description
DomExp $t0, imm
Adds an immediate value to $t0 (e.g. DomExp $t0, -100)
TucaDonka
Loads random 0–100 into $t0 or adds to existing value; prints YouTube link if 50 or 100
mahoragaHELP
Doubles the value in $t0
standproud
Adds 100 to $s0
infVeggies
Sets $s1 to maximum 32-bit integer
swapcurse
Swaps the values of $t0 and $t1
lobo
Finds min of $t1 and $t2, stores it in $t0
bigraga
Negates value in $a2
HeianEra
Resets all registers and program counter to 0
PotentialMan
Sets $t3 to 0 and prints a meme line
GuguGaga
Loads random printable ASCII character into $a0, prints the char and a link


How to Use in MARS-LE
Compile the Java Source
javac mars/mips/instructions/customlangs/LobotomyKaisen.java
Copy .class Files
Move the compiled .class file into:
mars/mips/instructions/customlangs/
Rebuild or Launch MARS-LE
Launch MARS-LE.
Navigate to: Tools → Language Switcher .→ Select Language → Lobotomy Kaisen Assembly
Click Lobotomy Kaisen Assembly.
Write and Run Test Programs
Use the implemented instructions directly in your .asm file:
.text
.globl main

main:
    DomExp $t0, 20
    TucaDonka
    mahoragaHELP
    PotentialMan
    GuguGaga
    HeianEra

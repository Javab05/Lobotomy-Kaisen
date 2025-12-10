package mars.mips.instructions.customlangs;

import mars.mips.hardware.*;
import mars.*;
import mars.util.*;
import mars.mips.instructions.*;
import java.util.*;

public class LobotomyKaisen extends CustomAssembly {

    @Override
    public String getName() {
        return "Lobotomy Kaisen Assembly";
    }

    @Override
    public String getDescription() {
        return "Assembly language for the lobotomized warriors of Jujutsu Kaisen.\n";
    }

    @Override
    protected void populate() {

        // DomExp: Load Immediate into $t0
        instructionList.add(new BasicInstruction(
                "DomExp $t0, -100",
                "Domain Expansion: Conjuration of the Immediate",
                BasicInstructionFormat.I_FORMAT,
                "001000 fffff 00000 ssssssssssssssss",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int imm = statement.getOperands()[0] << 16 >> 16;
                        RegisterFile.updateRegister(8, RegisterFile.getValue(8) + imm);
                    }
                }));

        // TucaDonka: Random boost on $t0
        instructionList.add(new BasicInstruction(
                "TucaDonka",
                "As Hakari randomly hits his jackpot in his DE, TucaDonka randomly load values into t0",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 01000 00000 101000",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int val = RegisterFile.getValue(8);
                        int rand = new Random().nextInt(101);

                        RegisterFile.updateRegister(8, val == 0 ? rand : val + rand);

                        if (rand == 50 || rand == 100) {
                            SystemIO.printString("https://www.youtube.com/watch?v=34Pl2DTuwoQ&t=31s\n");
                        }
                    }
                }));

        // mahoragaHELP: Double $t0
        instructionList.add(new BasicInstruction(
                "mahoragaHELP",
                "Awwwwwweeee, does Megumi need papa raga to adapt and double the value in t0",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 01000 00000 100000",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int val = RegisterFile.getValue(8);
                        RegisterFile.updateRegister(8, val * 2);
                    }
                }));

        // standproud: Add 100 to $s0
        instructionList.add(new BasicInstruction(
                "standproud",
                "Stand proud Jogoat, you are strong...enough to load 100 to s0",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 10000 00000 100001",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int val = RegisterFile.getValue(16);
                        RegisterFile.updateRegister(16, val + 100);
                    }
                }));

        // gojostare: Set $s1 to max int
        instructionList.add(new BasicInstruction(
                "infVeggies",
                "Gojo uses his DE to vegetablize s1 by adding max int",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 10001 00000 100010",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        RegisterFile.updateRegister(17, Integer.MAX_VALUE);
                    }
                }));

        // swapcurse: Square $s2
        instructionList.add(new BasicInstruction("swapcurse",
               "Freaky Kenjaku uuhh, swaps t0 and t1...like with Yuji's mom...",
              BasicInstructionFormat.R_FORMAT,
               "000000 00000 00000 00000 00000 110000",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int val0 = RegisterFile.getValue(8);
                        int val1 = RegisterFile.getValue(9);
                        RegisterFile.updateRegister(8, val1);
                        RegisterFile.updateRegister(9, val0);
                    }
                }));

        // lobo: Min of $t1 and $t2 into $t0
        instructionList.add(new BasicInstruction(
                "lobo",
                "Selects lobotomized min of $t1 and $t2 into $t0",
                BasicInstructionFormat.R_FORMAT,
                "000000 01001 01010 01000 00000 100111",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int val1 = RegisterFile.getValue(9);
                        int val2 = RegisterFile.getValue(10);
                        int min = Math.min(val1, val2);
                        RegisterFile.updateRegister(8, min);
                        SystemIO.printString("Minimum of " + val1 + " and " + val2 + " is " + min + "\n");
                    }
                }));

        // bigraga: Negate $a2 (reg 6)
        instructionList.add(new BasicInstruction(
                "bigraga",
                "Adapt to any and all phenomena including negating value in $a2",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 00110 00000 100101",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int val = RegisterFile.getValue(6);
                        RegisterFile.updateRegister(6, -val);
                    }
                }));

        // HeianEra: Clear all registers and PC
        instructionList.add(new BasicInstruction(
                "HeianEra",
                "Aahhh yes, Sukuna's ancient technique from the Heian Era, reg and PC deletion",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 00010 00000 100110",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        for (int i = 0; i < RegisterFile.getRegisters().length; i++) {
                            RegisterFile.updateRegister(i, 0);
                        }
                        RegisterFile.setProgramCounter(0);
                        SystemIO.printString("Fuga!\n");
                    }
                }));

        // PotentialMan: $t3 always becomes 0
        instructionList.add(new BasicInstruction(
                "PotentialMan",
                "Much like Bumgumi's win streak, t3 will always be at 0 when this is called",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 01100 00000 101010",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        RegisterFile.updateRegister(11, 0);
                        SystemIO.printString("'Renji' from bleach ahh\n");
                    }
                }));

        // GuguGaga: Random printable ASCII to $a0
        instructionList.add(new BasicInstruction(
                "GuguGaga",
                "This makes no sense like brain rot and might not even have a useful fucntion.",
                BasicInstructionFormat.R_FORMAT,
                "000000 00000 00000 00100 00000 101011",
                new SimulationCode() {
                    public void simulate(ProgramStatement statement) throws ProcessingException {
                        int ascii = 33 + new Random().nextInt(94);
                        RegisterFile.updateRegister(4, ascii);
                        SystemIO.printString("Gugu Gagakuna summons: " + (char) ascii + "\n");
                        SystemIO.printString("https://www.youtube.com/shorts/OCskZ9nHRXU\n");
                    }
                }));
    }
}


//        //Randomize value
//        instructionList.add(new BasicInstruction("gachapon $a2",
//                "Roll the gacha: assign a random int",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 fffff 00000 00000 00000 101011",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        int[] operands = statement.getOperands();
//                        RegisterFile.updateRegister(operands[0], new Random().nextInt());
//                    }
//                }));
//
//        //Shift bits left by 3
//        instructionList.add(new BasicInstruction("eightfold $t0",
//                "Shift bits to simulate Eightfold Blitz",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 fffff 00000 00000 00000 101100",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        int[] operands = statement.getOperands();
//                        int val = RegisterFile.getValue(operands[0]);
//                        RegisterFile.updateRegister(operands[0], val << 3);
//                    }
//                }));
//
//        // Flip sign only if positive
//        instructionList.add(new BasicInstruction("flipneg $t1",
//                "Flip sign if positive (negative charge)",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 fffff 00000 00000 00000 101101",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        int[] operands = statement.getOperands();
//                        int val = RegisterFile.getValue(operands[0]);
//                        RegisterFile.updateRegister(operands[0], val > 0 ? -val : val);
//                    }
//                }));
//
//        // Set to PI
//        instructionList.add(new BasicInstruction("mugenpi $s1",
//                "Set register to truncated PI (3)",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 fffff 00000 00000 00000 101110",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        int[] operands = statement.getOperands();
//                        RegisterFile.updateRegister(operands[0], 3);
//                    }
//                }));
//
//        //Copy value from $zero
//        instructionList.add(new BasicInstruction("zerotrans $s2",
//                "Forcefully inherit the nothingness",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 fffff 00000 00000 00000 101111",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        int[] operands = statement.getOperands();
//                        RegisterFile.updateRegister(operands[0], 0);
//                    }
//                }));
//
//        //Triple register value
//        instructionList.add(new BasicInstruction("triplex $a3",
//                "Triple the register value",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 fffff 00000 00000 00000 110001",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        int[] operands = statement.getOperands();
//                        int val = RegisterFile.getValue(operands[0]);
//                        RegisterFile.updateRegister(operands[0], val * 3);
//                    }
//                }));
//
//        //Output curse chant
//        instructionList.add(new BasicInstruction("chantcurse",
//                "Chant a curse: outputs a spooky line",
//                BasicInstructionFormat.R_FORMAT,
//                "000000 00000 00000 00000 00000 110010",
//                new SimulationCode() {
//                    public void simulate(ProgramStatement statement) throws ProcessingException {
//                        SystemIO.printString("Curse Technique Lobotomy: Active...\n");
//                    }
//                }));
//    }
//}


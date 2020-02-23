package cr.ac.ucenfotec.BL;

import java.util.Random;

public class CodeGen {
    public StringBuilder generateAlphaCode(int codeLength){
        StringBuilder stringCode = new StringBuilder();
        for(int index = 0; index < codeLength; index++){
            int randomInteger = generateRandomInt(26);
            int ascii_letter = 'A';
            for(int eggs = 0; eggs < randomInteger; eggs++){
                ascii_letter++;
            }
            char c = (char) ascii_letter;
            stringCode.append(c);
        }
        return stringCode;
    }

    // generates a random integer between two ranges
    private int generateRandomInt(int max){
        //create an instance of Random Class
        Random rand = new Random();

        //generate a random integer in range 0 to max - 1 inclusive
        int randomReal = rand.nextInt(max);

        return randomReal;
    }
}

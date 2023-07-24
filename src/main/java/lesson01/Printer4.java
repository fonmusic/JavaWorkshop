package lesson01;

import java.io.BufferedReader;
import java.io.FileReader;

public class Printer4 {
    public static void main(String[] args) {
        Equation equation = new Equation();
        String result = equation.getSolution("input.txt");
        System.out.println(result);
    }
}

class Equation {
    public static String getSolution(String str) {

        String equation = readFromFile(str);
        String result = "Given the equation: " + equation + "\n";
        String solution = getOneSolution(equation);
        if (solution == "") {
            result += "No solution\n";
        } else {
            result += "Result: " + solution + "\n";
        }
        return  result;
    }

    public static String getOneSolution(String str) {
        String[] tmp1 = str.split("[+=]");
        for (int d1: getDigits(tmp1[0].trim())) {
            for (int d2: getDigits(tmp1[1].trim())) {
                for (int res: getDigits(tmp1[2].trim())) {
                    if (d1 + d2 == res) {
                        return d1 + " + " + d2 + " = " + res;
                    }
                }
            }
        }
        return "";
    }

    public static String readFromFile(String path){
        String str = "";
        try (FileReader fr = new FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
            str = br.readLine();
            br.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  str;

    }

    public static int[] getDigits(String str) {
        int[] result;
        if (!str.contains("?")) {
            result = new int[1];
            result[0] = Integer.parseInt(str);
            return result;
        }
        int countNone = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                countNone *= 10;
            }
        }
        result = new int[countNone];
        int index = 0;
        String tempNumber;
        int indexNone = str.indexOf("?");
        int[] tempArray;
        for (int j = 0; j < 10; j++) {
            if (indexNone == 0) {
                tempNumber = j + str.substring(1);
            } else if ((indexNone + 1) == str.length()) {
                tempNumber = str.substring(0, str.length() - 1) + j;
            } else {
                tempNumber = str.substring(0, indexNone) + j + str.substring(indexNone + 1);
            }
            tempArray = getDigits(tempNumber);
            for (int item : tempArray) {
                result[index] = item;
                index++;
            }
        }

        return result;
    }
}

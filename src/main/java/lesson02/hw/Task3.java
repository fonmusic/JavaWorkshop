package lesson02.hw;

class Answer {
    public static StringBuilder answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {
        // Напишите свое решение ниже
        StringBuilder stringBuilder = new StringBuilder();

        int startChar = 0;
        String currentKey = "";
        boolean readString = false;
        boolean readKey = false;

        String[] values = new String[3]; // фамилия, предмет, оценка

        for (int i = 0; i < JSON.length(); i++) {

            if (JSON.charAt(i) == '\"') {
                if (!readString) {
                    readString = true;
                    if (readKey) {
                        readKey = false;
                    } else readKey = true;
                    startChar = i + 1;
                } else {
                    readString = false;
                    if (readKey) {
                        currentKey = JSON.substring(startChar, i);
                    } else {
                        switch (currentKey) {
                            case "фамилия":
                                values[0] = JSON.substring(startChar, i);
                                break;
                            case "предмет":
                                values[1] = JSON.substring(startChar, i);
                                break;
                            case "оценка":
                                values[2] = JSON.substring(startChar, i);
                                break;
                        }
                    }
                }
            } else if (JSON.charAt(i) == '}') {

                if (stringBuilder.length() > 0) stringBuilder.append("\n");
                stringBuilder.append("Студент ");
                stringBuilder.append(values[0]);
                stringBuilder.append(" получил ");
                stringBuilder.append(values[2]);
                stringBuilder.append(" по предмету ");
                stringBuilder.append(values[1]);

            }
        }

        return stringBuilder;
    }


}


public class Task3 {
    public static void main(String[] args) {
        String JSON = "";
        String ELEMENT1 = "";
        String ELEMENT2 = "";
        String ELEMENT3 = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
            ELEMENT1 = "Студент ";
            ELEMENT2 = " получил ";
            ELEMENT3 = " по предмету ";
        } else {
            JSON = args[0];
            ELEMENT1 = args[1];
            ELEMENT2 = args[2];
            ELEMENT3 = args[3];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3));
    }
}

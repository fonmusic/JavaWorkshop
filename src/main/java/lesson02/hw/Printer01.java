package lesson02.hw;

public class Printer01 {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        }
        else{
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer01 ans = new Answer01();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}

class Answer01 {
    // form WHERE clause using StringBulder
    // PARAMS "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} "
    // return {"name": "Ivanov", "country": "Russia", "city": "Moscow", "age": "null"}
    public static StringBuilder answer(String QUERY, String PARAMS){

        StringBuilder stringBuilder = new StringBuilder(QUERY);
        String[] parts = PARAMS.split("[,{}]");
        String[] keyValue;
        boolean hasParams = false;
        for (String item: parts) {
            keyValue = item.split(":");
            if (keyValue.length == 2 && !keyValue[1].equals("\"null\"")) {
                if (hasParams) stringBuilder.append(" and ");
                else hasParams = true;
                stringBuilder.append(keyValue[0].trim().replace("\"", ""));
                stringBuilder.append("='");
                stringBuilder.append(keyValue[1].trim().replace("\"", ""));
                stringBuilder.append("'");
            }
        }
        return stringBuilder;
    }
}
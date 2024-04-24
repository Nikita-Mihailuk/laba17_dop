import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("input_code.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output_code.txt")))
        {
            String str;
            StringBuilder code = new StringBuilder();

            Pattern pattern = Pattern.compile("<([a-zA-Z]+).*>\\s*\\S(.*\\S)?\\s*</\\1>");

            while ((str = reader.readLine()) != null){
                code.append(str + "\n");
            }

            str = code.toString();
            code.delete(0,code.length()-1);

            Matcher matcher = pattern.matcher(str);
            while (matcher.find()){
                code.append(matcher.group() + "\n");
            }

            writer.write(code.toString());
            System.out.println("Пустые теги и строки удалены, а код сохранен в output_code.txt");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
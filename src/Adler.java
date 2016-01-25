import java.util.ArrayList;

public class Adler {
    ArrayList<Integer> A;
    ArrayList<Integer> B;

    public Adler() {
        A = new ArrayList<>();
        B = new ArrayList<>();
    }

    public ArrayList<Integer> insertToA(String text) {

        for (int i = 0; i < text.length(); ++i) {
            if (i == 0) {
                A.add(1 + (int) text.charAt(i));
            } else {
                A.add(A.get(i - 1) + (int) text.charAt(i));
            }
        }

        return A;
    }

    public String showArray(String nameArray, ArrayList array) {
        String result = nameArray + " = [";
        for (int i = 0; i < array.size(); i++) {
            if (i != array.size() - 1) {
                result += array.get(i) + ", ";
            } else {
                result += array.get(i) + "";
            }
        }
        return result += "];";
    }

    public ArrayList<Integer> insertToB() {

        for (int i = 0; i < A.size(); ++i) {
            if (i == 0) {
                B.add(0 + (int) A.get(i));
            } else {
                B.add(B.get(i - 1) + A.get(i));
            }
        }

        return B;
    }

    public String completString(String text) {
        while (text.length() < 4) {
            text = 0 + "" + text;
        }
        return text;
    }

    public String convertToHexArray(ArrayList<Integer> nameArray) {
        String a = Integer.toHexString(nameArray.get(nameArray.size() - 1));
        a = completString(a);
        return a;
    }

}

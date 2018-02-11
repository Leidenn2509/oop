import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] argc ) {
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new InputStreamReader(new FileInputStream(argc[0]));

            int count = 0;
            HashSet<MyWord> dict = new HashSet<>();
            int ch;
            StringBuilder strB = new StringBuilder();

            while (true) {
                ch = reader.read();
                if(!Character.isLetterOrDigit(ch)) {
                    if(strB.toString().equals("")) {
                        if (ch == -1){
                            break;
                        } else {
                            continue;
                        }
                    }
                    count++;
                    if(!dict.add(new MyWord(strB.toString()))) {
                        for (MyWord word : dict) {
                            if (strB.toString().equals(word.getWord())) {
                                word.inc();
                            }
                        }
                    }
                    strB = new StringBuilder();

                } else {
                    strB.append((char)ch);
                }
            }

            writer = new OutputStreamWriter(new FileOutputStream("out.txt"));

            for(MyWord a : dict) {
                writer.write(a.getWord() + ", " + a.getCount() + ", " + (double)a.getCount()/count*100 + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}

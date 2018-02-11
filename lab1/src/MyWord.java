public class MyWord {
    MyWord(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void inc() {
        count++;
    }

    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < word.length(); i++) {
            hash = hash*31 + (int)word.charAt(i);
        }
        return hash;
    }


    public boolean equals(Object o) {
        return getClass() == o.getClass() && word.equals(((MyWord) o).getWord());
    }


    private String word;
    private int count;


}

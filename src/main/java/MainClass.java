import org.example.model.DictWord;
import org.example.service.DictionaryImpl;
import org.example.service.IDictionary;

public class MainClass {
    public static void main(String[] args) throws Exception {
        IDictionary dict = new DictionaryImpl();
        dict.addWord(new DictWord("Z", "a"));
        dict.addWord(new DictWord("G", "b"));
        dict.addWord(new DictWord("G", "h"));
        dict.addWord(new DictWord("q", "y"));
        dict.addWord(new DictWord("a", "b"));
        System.out.println(dict.searchWord(new DictWord("G")));
        System.out.println(dict.searchWord(new DictWord("1")));
        System.out.println(dict.listAllWords());

    }
}

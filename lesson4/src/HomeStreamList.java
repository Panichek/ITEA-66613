import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeStreamList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        List<Integer> newList = list1.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        System.out.println(newList);
        List<String> list2 = new ArrayList<>();
        list2.add("ab");
        list2.add("cd");
        list2.add("ef");
        list2.add("gi");
        list2.add("jk");
        List<String> newList2 = list2.stream().map(e -> e.concat("wz")).collect(Collectors.toList());
        System.out.println(newList2);
        List<Character> list3 = new ArrayList<>();
        list3.add((char) ('a'+'b'));
        list3.add((char) ('c'+'d'));
        list3.add((char) ('e'+'f'));
        list3.add((char) ('g'+'i'));
        list3.add((char) ('j'+'k'));
        List<Character> newList3 = list3.stream().map(e -> e.charValue()).collect(Collectors.toList());
        System.out.println(newList3);
    }
}


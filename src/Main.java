import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void filterText(String text){
        Character[] vowel = new Character[]{'a','i','u','e','o'};
        List<Character> filterVowel = new ArrayList<>();
        List<Character> filterConsonant = new ArrayList<>();
        String lowerCase = text.toLowerCase().replaceAll("\\s","");
        for (int i = 0; i < lowerCase.length(); i++) {
            boolean flag = false;
            for (Character character : vowel) {
                if (lowerCase.charAt(i) == character) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                filterVowel.add(lowerCase.charAt(i));
            }else{
                if(!filterConsonant.contains(lowerCase.charAt(i))){
                    filterConsonant.add(lowerCase.charAt(i));
                }else{
                    int i1 = filterConsonant.indexOf(lowerCase.charAt(i));
                    filterConsonant.add(i1+1, lowerCase.charAt(i));
                }
            }
        }
        Collections.sort(filterVowel);
        System.out.println("Vowel Character:");
        if(!filterVowel.isEmpty()){
            filterVowel.stream().map(detail -> detail).forEach(System.out::print);
        }else{
            System.out.println(" ");
        }
        System.out.println("\nConsonant");
        if(!filterConsonant.isEmpty()){
            filterConsonant.stream().map(detail -> detail).forEach(System.out::print);
        }else{
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    public static Integer needBus(int input, Integer[] arr){
        if(input != arr.length){
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        filterText("Sample Case");
        filterText("Next Case");
    }
}

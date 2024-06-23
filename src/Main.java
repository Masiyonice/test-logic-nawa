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

    public static Integer needBus(Integer input, Integer[] arr){
        if(input != arr.length){

            return 0;
        }
        int fam = 2;
        int max = 4;
        int temp = 0;
        int bus = 0;
        for (int i = 0; i < input; i++) {
            if(fam > 0){
                if(max > 0){
                    if((arr[i]+temp)>max){
                        temp += (arr[i] - max);
                        max = 0;
                    }else {
                        max -= (arr[i])+temp;
                        temp = 0;
                        bus++;
                    }
                    System.out.println(i + " 1. sisa kursi "+ max+ " sisa orang "+ temp + " bus "+ bus);
                }else {
                    fam = 2;
                    max = 4;
                    bus++;
                    if(temp != 0){
                        fam--;
                    }
                    if((arr[i]+temp)>max){
                        temp += (arr[i] - max);
                        max = 0;
                    }else {
                        max -= (arr[i])+temp;
                        temp = 0;
                    }
                    System.out.println(i + " 2. sisa kursi "+ max+ " sisa orang "+ temp + " bus "+ bus);
                }
            }else {
                fam = 2;
                max = 4;
                bus++;
                if((arr[i]+temp)>max){
                    temp += (arr[i] - max);
                    max = 0;
                }else {
                    max -= (arr[i])+temp;
                    temp = 0;
                }
                System.out.println(i + " 3. sisa kursi "+ max+ " sisa orang "+ temp + " bus "+ bus);
            }
            fam--;
        }
        return bus;
    }

    public static void main(String[] args) {
//        filterText("Sample Case");
//        filterText("Next Case");
        Integer[] input = new Integer[]{2,3,4,4,2,1,3,1};
        Integer test = needBus(8,input);
        System.out.println(test);
        Integer[] input2 = new Integer[]{1,2,4,3,3};
        Integer test2 = needBus(5,input2);
        System.out.println(test2);
    }
}

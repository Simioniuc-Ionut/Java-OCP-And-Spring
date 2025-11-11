package org.example.Chapter10;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainArrays {
            public static void arrays(){
                Integer[] a = new Integer[]{1};
                // Will print the reference.
                System.out.println(a);

                int index = 1;
                String[] strArr = new String[5];
                var myStr  = strArr[index];
                System.out.println(myStr);

                Arrays.mismatch(a,strArr);
                char[] ar = {'a','b','c','d'};
                char[] ar2 = {'a'};
                char[] ar3 = {};
                char[] ar4 = null;
                System.out.println(Arrays.compare(ar,ar2));
                System.out.println(Arrays.compare(ar2,ar));
                System.out.println(Arrays.compare(ar2,ar3));
                System.out.println(Arrays.compare(ar2,ar4));
                System.out.println(Arrays.compare(ar3,ar4));
                System.out.println(Arrays.compare(ar4,ar4));

                System.out.println(Arrays.mismatch(ar,ar2));
                System.out.println(Arrays.mismatch(ar,ar3));
                System.out.println(Arrays.mismatch(ar2,ar));


    }
    non-sealed class A extends B{}
    public sealed class B implements FunctionalInterface permits A{
        @Override
        public Class<? extends Annotation> annotationType() {
            return null;
        }
    }
    static void main() {
        arrays();
        Integer ala = 23;
        Function<Integer,String> cons = x -> ala.toHexString(x);
        List<String> letters = Arrays.asList("j", "a", "v","a");
        String word = letters.stream().reduce("",(a,b)->a.concat(b));
        String word2 = letters.stream().collect(Collectors.joining());
        String word3 = letters.stream().collect(Collectors.groupingBy(a->"")).toString();
        System.out.println(word2 );
    }

}

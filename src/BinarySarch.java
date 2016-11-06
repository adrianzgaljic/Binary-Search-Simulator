import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by adrianzgaljic on 22/10/16.
 */
public class BinarySarch {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input list of elements divided by space. Eg. \"3 8 1 17\":");
        String input = scanner.nextLine();
        String[] strList = input.split(" ");
        List<Integer> list = new ArrayList<Integer>();

        for (String str:strList){
            list.add(Integer.parseInt(str));
        }

        System.out.println("Input element you want to find:");
        input = scanner.nextLine();
        int numberToFind = Integer.parseInt(input);
        find(list, numberToFind);
    }

    private static void find(List<Integer> list, int numberToFind) {
        Collections.sort(list);
        int l = 0;
        int h = list.size();
        int mid;
        int noOfIterations = 0;
        while(true){
            noOfIterations++;
            mid = l+(h-l)/2;
            if (list.get(mid)==numberToFind){
                System.out.println("Found: "+list.get(mid));
                break;
            } else if (list.get(mid)>numberToFind){
                h = mid;
            } else {
                l = mid;
            }
            if (l==h || l==h-1){
                System.out.println("Your number is not in the list.");
                break;
            }
        }
        System.out.println("Expected complexity log(n): "+Math.log(list.size())/Math.log(2));
        System.out.println("No of iterations: "+noOfIterations);

    }


}

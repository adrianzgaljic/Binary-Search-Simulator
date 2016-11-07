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
        int h = list.size()-1;
        int mid;
        int noOfIterations = 0;
        while(true){
            noOfIterations++;
            mid = l+(h-l)/2;
            draw(l, mid, h, list);

            System.out.println("");
            if (list.get(mid)==numberToFind){
                System.out.println("Found: " + list.get(mid));
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
        System.out.println("Worst-case complexity log(n): "+Math.log(list.size())/Math.log(2));
        System.out.println("No of iterations: " + noOfIterations);

    }

    private static void draw(int l, int mid, int h, List<Integer> list) {

        int leftSpace = 0;
        int middleSpace = 0;
        int rightSpace = 0;

        for (int i=0; i<list.size(); i++) {
            System.out.print(" " + list.get(i) + " ");
            if (i<l){
                leftSpace += (int)Math.log10(list.get(i))+3;
            } else if (i<mid){
                middleSpace += (int)Math.log10(list.get(i))+3;
            } else if (i<h){
                rightSpace += (int)Math.log10(list.get(i))+3;
            }
        }

        System.out.println();
        drawArrows(leftSpace,middleSpace,rightSpace,'^');
        drawArrows(leftSpace,middleSpace,rightSpace,'|');
        drawArrows(leftSpace,middleSpace,rightSpace,'.');





    }

    public static void drawArrows(int leftSpace, int middleSpace, int rightSpace, char sign){

        if (sign == '^' || sign == '|'){
            for (int i=0; i<leftSpace; i++){
                System.out.print(" ");
            }
            System.out.print(" "+sign+" ");
            for (int i=0; i<middleSpace-3; i++){
                System.out.print(" ");
            }
            System.out.print(" "+sign+" ");
            for (int i=0; i<rightSpace-3; i++){
                System.out.print(" ");
            }
            System.out.println(" "+sign+" ");
        } else {
            for (int i=0; i<leftSpace; i++){
                System.out.print(" ");
            }
            System.out.print(" l ");
            for (int i=0; i<middleSpace-3; i++){
                System.out.print(" ");
            }
            System.out.print("mid");
            for (int i=0; i<rightSpace-3; i++){
                System.out.print(" ");
            }
            System.out.println(" h ");
        }

    }


}

package Test0201;

import java.util.ArrayList;
import java.util.List;

public class test {
//    public List<List<Integer>> generate(int numRows) {
//        if (numRows < 0) {
//            return new ArrayList();
//        }
//        List<List<Integer>> result = new ArrayList();
//        List<Integer> first = new ArrayList();
//        first.add(1);
//        result.add(first);
//        if (numRows == 1) {
//            return result;
//        }
//        List<Integer> second = new ArrayList();
//        second.add(1);
//        second.add(1);
//        result.add(second);
//        if (numRows == 2) {
//            return result;
//        }
//        for (int row = 3; row <= numRows; row++) {
//            List<Integer> prev = result.get(row - 1 - 1);
//            List<Integer> current = new ArrayList();
//            current.add(1);
//            for (int col = 2; col < row - 1; col++) {
//                int num1 = prev.get(col - 1);
//                int num2 = prev.get(col - 1 - 1);
//                current.add(num1 + num2);
//            }
//            current.add(1);
//            result.add(current);
//        }
//        return result;
//    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        if (numRows == 1) {
            return result;
        }
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(second);
        if (numRows == 2) {
            return result;
        }
        for (int row = 3; row <= numRows; row++) {
            List<Integer> prev = result.get(row - 1 - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int col = 2; col <= row - 1; col++) {
                int num1 = prev.get(col - 1);
                int num2 = prev.get(col - 1 - 1);
                current.add(num1 + num2);
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}

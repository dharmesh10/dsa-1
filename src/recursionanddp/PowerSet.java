package recursionanddp;

import java.util.ArrayList;

public class PowerSet {
  public ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allSubsets;
    if (set.size() == index) {
      allSubsets = new ArrayList<ArrayList<Integer>>();
      allSubsets.add(new ArrayList<Integer>());
    } else {
      allSubsets = getSubset(set, index + 1);
      int item = set.get(index);
      ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> subSet : allSubsets) {
        ArrayList<Integer> newSubSet = new ArrayList<Integer>();
        newSubSet.addAll(subSet);
        newSubSet.add(item);
        moreSubsets.add(newSubSet);
      }
      allSubsets.addAll(moreSubsets);
    }
    return allSubsets;
  }

  public static void main(String[] args) {
    ArrayList<Integer> input = new ArrayList<Integer>();
    input.add(1);
    input.add(2);
    input.add(3);
    ArrayList<ArrayList<Integer>> output = new PowerSet().getSubset(input, 0);
    System.out.println(output);
  }
}

// Given a sorted list of already scheduled programs and a list of new programs, 
// write an algorithm to find if the given new programs can be scheduled or not?
// Each program is a pair of values where 1st value is the starting time and 2nd is the execution time.
import java.util.List;
import java.util.ArrayList;

class Solution {
  public static class Program {
    public int start;
    public int end;

    public Program(int start, int duration) {
      this.start = start;
      this.end = start + duration;
    }
  }

  public boolean[] scheduleProgram(List<Program> scheduledPrograms, List<Program> newPrograms) {
    boolean[] res = new boolean[newPrograms.size()];

    for (int i = 0; i < newPrograms.size(); i ++) {
      Program p = newPrograms.get(i);
      int idx = binarySearch(scheduledPrograms, p);
      res[i] = true;

      if (idx == 0) {
        Program program = scheduledPrograms.get(0);

        if (p.end > program.start) {
          res[i] = false;
        }

        continue;
      }

      if (idx == scheduledPrograms.size()) {
        Program prevProgram = scheduledPrograms.get(scheduledPrograms.size() - 1);

        if (p.start < prevProgram.end) {
          res[i] = false;
        }

        continue;
      }

      Program program = scheduledPrograms.get(idx);
      Program prevProgram = scheduledPrograms.get(idx - 1);

      if (p.end > program.start || p.start < prevProgram.end) {
        res[i] = false;
      }
    }

    return res;
  }

  public int binarySearch(List<Program> programs, Program p) {
    int lo = 0;
    int hi = programs.size() - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;

      if (p.start <= programs.get(mid).start) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    if (p.start > programs.get(lo).start) {
      return lo + 1;
    }

    return lo;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    List<Program> scheduledPrograms = new ArrayList<>();
    List<Program> newPrograms = new ArrayList<>();

    scheduledPrograms.add(new Program(10, 5));
    scheduledPrograms.add(new Program(25, 15));

    newPrograms.add(new Program(5, 5));   // T
    newPrograms.add(new Program(5, 6));   // F
    newPrograms.add(new Program(5, 4));   // T
    newPrograms.add(new Program(15, 10)); // T
    newPrograms.add(new Program(14, 10)); // F
    newPrograms.add(new Program(15, 11)); // F
    newPrograms.add(new Program(14, 12)); // F
    newPrograms.add(new Program(16, 8));  // T
    newPrograms.add(new Program(40, 10)); // T
    newPrograms.add(new Program(39, 10)); // F
    newPrograms.add(new Program(41, 10)); // T

    printArr(sol.scheduleProgram(scheduledPrograms, newPrograms));
  }

  public static void printArr(boolean[] arr) {
    for (boolean bool : arr) {
      System.out.print(bool + " ");
    }

    System.out.println();
  }
}
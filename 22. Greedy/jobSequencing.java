import java.util.ArrayList;
import java.util.Arrays;

public class jobSequencing {
    // Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline.
    // It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
    // Maximize the profit if only one job can be scheduled at a time.

    public static class DataNode implements Comparable<DataNode> {
        char jobName;
        int deadline;
        int profit;

        public DataNode(char jobName, int deadline, int profit) {
            this.jobName = jobName;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public int compareTo(DataNode node) {
            return node.profit - this.profit;
        }

        @Override
        public String toString() {
            return "{ Job: " + this.jobName + ", Deadline: " + this.deadline + ", Profit: " + this.profit + " }";
        }
    }

    public static ArrayList<DataNode> solution(DataNode[] jobs) {
        ArrayList<DataNode> res = new ArrayList<>();

        Arrays.sort(jobs);

        int time = 0;

        for(DataNode job : jobs) {
            if(job.deadline > time) {
                res.add(job);
                time++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        DataNode[] jobs = new DataNode[4];
        jobs[0] = new DataNode('A', 4, 20);
        jobs[1] = new DataNode('B', 1, 10);
        jobs[2] = new DataNode('C', 1, 40);
        jobs[3] = new DataNode('C', 1, 30);

        System.out.println(solution(jobs).toString());
    }
}

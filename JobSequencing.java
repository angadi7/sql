package com.Day19;

import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static List<Job> JobSequencing(List<Job> jobs) {
        // Sort jobs in descending order of profit
        jobs.sort((a, b) -> b.profit - a.profit);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Create an array to keep track of free time slots
        int[] result = new int[maxDeadline];
        Arrays.fill(result, -1); // -1 indicates the slot is free

        // To store the sequence of jobs that maximize profit
        List<Job> jobSequence = new ArrayList<>();

        // Iterate through the sorted jobs and place them in the result array
        for (Job job : jobs) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (result[j] == -1) {
                    result[j] = job.id;
                    jobSequence.add(job);
                    break;
                }
            }
        }

        return jobSequence;
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        );

        List<Job> jobSequence = JobSequencing(jobs);
        System.out.println("The job sequence to maximize profit is:");
        for (Job job : jobSequence) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
}


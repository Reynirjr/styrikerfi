How to run:
1. Compile Scheduler.java:
    javac Scheduler.java
2. Run Scheduler.java:
    java Scheduler

Description:
- This is a round-robin scheduler simulation.
- handleTimerInterrupt: moves the running process to ready queue and sets running to null.
- handleSystemCallLeadingToIO: moves the running process to waiting queue (blocked for I/O).
- handleIOcompletedInterrupt: finds the PCB of the completed I/O process in waiting queue,
  puts it back in ready queue.
- handlingCommonCode: picks the next ready process (if any) to run; sleeps CPU if none; 
  re-enables interrupts.

  Files in this zip:
- Scheduler.java
- readme.txt
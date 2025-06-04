---
date: 2025-06-01T16:00:00
---

# PV

## mutex template | 互斥模板

```c
// Mutex template (mutual exclusion) | 互斥模板

semaphore mutex = 1;

void A() {
    // Entry section: wait (P) on the mutex
    P(mutex);

    // Critical section: only one thread/process can execute here
    {
        // ... critical section code ...
    }

    // Exit section: signal (V) the mutex
    V(mutex);
}

void B() {
    P(mutex);
    {
        // ... critical section code ...
    }
    V(mutex);
}
```

- P: `--mutex`
- V: `++mutex`

## synchronization  template | 同步模版

```c
// Synchronization template | 同步模板
// Ensures A happens-before B (A -> B)

semophore ab_sync = 0;

void A() {
    // Do something before signaling
    // ... non-critical section ...

    // Signal to indicate A has completed
    V(ab_sync);
}

void B() {
    // Wait until A has signaled
    P(ab_sync);

    // Proceed only after A has completed
    // ... continue with B's operations ...
}
```

## Producer-Consumer Problem (C-style pseudocode using semaphores)

```c
#define BUFFER_SIZE 10

int buffer[BUFFER_SIZE];
int in = 0;     // index for next item to produce
int out = 0;    // index for next item to consume

// Semaphores
semaphore mutex = 1;       // mutual exclusion for buffer access
semaphore empty = BUFFER_SIZE;  // count of empty slots
semaphore full = 0;        // count of full slots

// Producer thread
void producer() {
    while (true) {
        int item = produce_item();     // generate an item

        P(empty);                      // wait for empty slot
        P(mutex);                      // enter critical section

        buffer[in] = item;             // add item to buffer
        in = (in + 1) % BUFFER_SIZE;

        V(mutex);                      // leave critical section
        V(full);                       // signal full slot
    }
}

// Consumer thread
void consumer() {
    while (true) {
        P(full);                       // wait for full slot
        P(mutex);                      // enter critical section

        int item = buffer[out];        // remove item from buffer
        out = (out + 1) % BUFFER_SIZE;

        V(mutex);                      // leave critical section
        V(empty);                      // signal empty slot

        consume_item(item);           // use the item
    }
}
```

- 生产者-消费者
- 关键词：生产 / 消费 / 缓冲区
	- **互斥**：缓冲区互斥访问 (`mutex = 1`)
	- **同步**  (`empty = n, full = 0`)
		- 先生产、再消费
		- 先消费、再生产

---

![](1-ProCon/pro-con.drawio.svg)

## Reader-Writer Problem Template (Reader Priority)

```c
// Shared data
int read_count = 0;

// Semaphores
semaphore mutex = 1;   // protects read_count
semaphore wrt = 1;     // controls writer access

// Reader process
void reader() {
    while (true) {
        P(mutex);              // entry section for reader
        read_count++;
        if (read_count == 1)
            P(wrt);            // first reader locks writer
        V(mutex);

        // --- critical section: reading ---
        read_data();
        // --- end of critical section ---

        P(mutex);              // exit section for reader
        read_count--;
        if (read_count == 0)
            V(wrt);            // last reader unlocks writer
        V(mutex);
    }
}

// Writer process
void writer() {
    while (true) {
        P(wrt);                // entry section for writer

        // --- critical section: writing ---
        write_data();
        // --- end of critical section ---

        V(wrt);                // exit section for writer
    }
}
```

- 读者-写者
- 读并行
- 写互斥
	- 写读互斥
	- 写写互斥

## Reader-Writer Problem Template (Writer Priority)

```c
// Shared variables
int read_count = 0;     // number of active readers
int write_waiting = 0;  // number of waiting writers

// Semaphores
semaphore mutex = 1;       // protects read_count and write_waiting
semaphore wrt = 1;         // controls access to the shared resource
semaphore read_try = 1;    // blocks readers when writers are waiting

// Reader process
void reader() {
    while (true) {
        P(read_try);            // check if writer is waiting
        P(mutex);
        read_count++;
        if (read_count == 1)
            P(wrt);             // first reader locks writer
        V(mutex);
        V(read_try);

        // --- critical section: reading ---
        read_data();
        // --- end of critical section ---

        P(mutex);
        read_count--;
        if (read_count == 0)
            V(wrt);             // last reader unlocks writer
        V(mutex);
    }
}

// Writer process
void writer() {
    while (true) {
        P(mutex);
        write_waiting++;
        if (write_waiting == 1)
            P(read_try);        // block new readers
        V(mutex);

        P(wrt);                 // exclusive access to resource

        // --- critical section: writing ---
        write_data();
        // --- end of critical section ---

        V(wrt);

        P(mutex);
        write_waiting--;
        if (write_waiting == 0)
            V(read_try);        // allow readers again
        V(mutex);
    }
}
```

## Reader-Writer Problem Template (Fairness for Readers & Writers)

```c
// Shared counters
int read_count = 0;

// Semaphores
semaphore mutex     = 1;  // protects read_count
semaphore wrt       = 1;  // controls access to shared resource
semaphore queue     = 1;  // ensures arrival order (fairness)

// Reader process
void reader() {
    while (true) {
        P(queue);           // wait in line (fairness)
        P(mutex);           // protect read_count
        read_count++;
        if (read_count == 1)
            P(wrt);         // first reader locks writer
        V(mutex);
        V(queue);           // allow next thread (reader/writer)

        // --- critical section: reading ---
        read_data();
        // --- end of critical section ---

        P(mutex);
        read_count--;
        if (read_count == 0)
            V(wrt);         // last reader unlocks writer
        V(mutex);
    }
}

// Writer process
void writer() {
    while (true) {
        P(queue);           // wait in line (fairness)
        P(wrt);             // exclusive access to resource
        V(queue);           // allow next thread

        // --- critical section: writing ---
        write_data();
        // --- end of critical section ---

        V(wrt);
    }
}
```

![](2-RW/rw-rw.drawio.svg)





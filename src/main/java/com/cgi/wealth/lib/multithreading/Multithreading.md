**Multi-thread**
- extends Thread
- implements runnable 
- implements Callable

- Join() A thread can invoke the join() method on other thread to wait for other thread to complete its
  execution

- Yield() method gives chance to remaining threads of equal priority which are in waiting state.

- Thread.sleep(1) To freeze the operations for fixed amount of time

- wait() Thread to go to wait state

- notify() is used to wake any thread in the wait set like mutually exclusive locking

- notifyAll() is used to wake up all the threads in the waiting set like threads waiting for a certain task to finish;

**Locks**
- ReentrantLock
```
ReentrantLock lock = new ReentrantLock();
```
- ReadWriteLock
```
ReadWriteLock lock = new ReentrantReadWriteLock();
```
- Semaphores
```
permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
```

**Callable**
- it has return type

**Completable**
- To do batch tasks which don't have dependencies and run in async
  - SupplyAsync
  - RunAsync 

What is Thread Scheduler?
It is responsible for the order in which the threads get executed

Executor
```
    ExecutorService executor = Executors.newFixedThreadPool(10);

    ExecutorService executor = Executors.newSingleThreadExecutor();

    ExecutorService executor = Executors.newCachedThreadPool();

    ExecutorService executor = Executors.newScheduledThreadPool(5);
```
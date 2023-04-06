## What it is and what it does and how its implemented

This project is implementing a read-write lock using the ReentrantReadWriteLock class from the java.util.concurrent.locks package. The main purpose of this program is to demonstrate how the read-write lock can be used to synchronize access to a shared resource that can be read by multiple threads simultaneously but can only be written to by a single thread at a time.

Here's a summary of what the program does:

    It defines a ReadWriteLock class with two methods - writeCount() and readCount(). The writeCount() method acquires the write lock, increments a shared counter, and returns the updated value of the counter as a string. The readCount() method acquires the read lock, reads the current value of the counter, and returns it as a string.

    It defines a MultipleThreads class that creates four threads - two for reading the counter value and two for incrementing the counter value.

    The first two threads (threadReadOne and threadReadTwo) read the counter value using the readCount() method of the ReadWriteLock class. They acquire the read lock, read the current value of the counter, and release the read lock. They also print the current thread name and a message indicating that the lock has been released.

    The second two threads (threadWriteOne and threadWriteTwo) increment the counter value using the writeCount() method of the ReadWriteLock class. They acquire the write lock, increment the counter, and release the write lock. They also print the current thread name and a message indicating that the lock has been released.

    The Thread.sleep() method is used to simulate some processing time between acquiring and releasing locks in each thread.

Overall, the program demonstrates how a read-write lock can be used to provide better concurrent access to a shared resource, with multiple threads allowed to read the resource simultaneously but only one thread allowed to write to it at a time.

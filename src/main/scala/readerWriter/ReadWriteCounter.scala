import java.util.concurrent.locks.ReentrantReadWriteLock

class ReadWriteLock {
  private val reentrantReadWriteLock = new ReentrantReadWriteLock()
  private var counter = 0

  /* Method to increment the counter value */
  def writeCount(): String = {
    reentrantReadWriteLock.writeLock().lock()
    try {
      // Acquiring the writing lock on the current thread
      println("\nAcquiring Writing Lock on :" + Thread.currentThread().getName)
      counter = counter + 1
      s"Start Writing Count :$counter"
    }
    finally {
      // Releasing the writing lock
      reentrantReadWriteLock.writeLock().unlock()
    }
  }

  /* Method to read the counter value */
  def readCount(): String = {
    reentrantReadWriteLock.readLock().lock()
    try {
      // Acquiring the reading lock on the current thread
      println("\nAcquiring Reading Lock on :" + Thread.currentThread().getName)
      s"Start Read Count :$counter"
    }
    finally {
      // Releasing the reading lock
      reentrantReadWriteLock.readLock().unlock()
    }
  }
}

/* This class contains multiple threads */
class MultipleThreads {
  private val readWriteLock = new ReadWriteLock

  /* First thread to read the counter value */
  val threadReadOne = new Runnable {
    override def run(): Unit = {
      // Reading the counter value and releasing the reading lock
      println(readWriteLock.readCount() + "\nReleasing Reading Lock :" + Thread.currentThread().getName)
      Thread.sleep(1000)
    }
  }

  /* Second thread to read the counter value */
  val threadReadTwo = new Runnable {
    override def run(): Unit = {
      // Reading the counter value and releasing the reading lock
      println(readWriteLock.readCount() + "\nReleasing Reading Lock :" + Thread.currentThread().getName)
      Thread.sleep(1000)
    }
  }

  /* First thread to increment the counter value */
  val threadWriteOne = new Runnable {
    override def run(): Unit = {
      // Incrementing the counter value and releasing the writing lock
      println(readWriteLock.writeCount() + "\nReleasing Writing Lock :" + Thread.currentThread().getName)
      Thread.sleep(1000)
    }
  }

  /* Second thread to increment the counter value */
  val threadWriteTwo = new Runnable {
    override def run(): Unit = {
      // Incrementing the counter value and releasing the writing lock
      println(readWriteLock.writeCount() + "\nReleasing Writing Lock :" + Thread.currentThread().getName)
      Thread.sleep(1000)
    }
  }
}

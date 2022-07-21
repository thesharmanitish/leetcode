class Foo {
//     Semaphore s2;
//     Semaphore s3;
    
//     public Foo() {
//         s2 = new Semaphore(0);
//         s3 = new Semaphore(0);
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
        
//         // printFirst.run() outputs "first". Do not change or remove this line.
//         printFirst.run();
//         s2.release();
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
        
//         // printSecond.run() outputs "second". Do not change or remove this line.
//         s2.acquire();
//         printSecond.run();
//         s3.release();
//     }

//     public void third(Runnable printThird) throws InterruptedException {
        
//         // printThird.run() outputs "third". Do not change or remove this line.
//         s3.acquire();
//         printThird.run();
//     }
    
    private Lock lock;
    private boolean oneDone;
    private boolean twoDone;
    private Condition one;
    private Condition two;
    
    public Foo() {
        lock = new ReentrantLock();
        one = lock.newCondition();
        two = lock.newCondition();
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            oneDone = true;
            one.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!oneDone) {
                one.await();
            }
            printSecond.run();
            twoDone = true;
            two.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!twoDone) {
                two.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
    
    
//        Lock lock = new ReentrantLock();
//     boolean first;
//     boolean second;
//     public Foo() {
//         first = false;
//         second = false;
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
        
//         // printFirst.run() outputs "first". Do not change or remove this line.
//         synchronized(lock){
//             printFirst.run();
//             first = true;
//             lock.notifyAll();
//         }
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
        
//         // printSecond.run() outputs "second". Do not change or remove this line.

//         synchronized(lock){
//             while(!first)
//                 lock.wait();
//             printSecond.run();
//             second = true;
//             lock.notifyAll();
//         }
//     }

//     public void third(Runnable printThird) throws InterruptedException {
        
//         // printThird.run() outputs "third". Do not change or remove this line.
//         synchronized(lock){
//             while(!second)
//                 lock.wait();            
//             printThird.run();
//         }
//     }
}
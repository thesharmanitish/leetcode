class FooBar {
    private int n;
    Semaphore foo;
    Semaphore bar;
    public FooBar(int n) {
        this.n = n;
        foo = new Semaphore(1);
        bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            foo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foo.release();
        }
    }
    
//         private int n;
//     AtomicBoolean isFoo;
//     Lock lock;
//     public FooBar(int n) {
//         this.n = n;
//         lock = new ReentrantLock();
//         isFoo = new AtomicBoolean(true);
//     }

//     public void foo(Runnable printFoo) throws InterruptedException {
        
//         for (int i = 0; i < n; i++) {
//             synchronized(lock){
//                 if(!isFoo.get())
//                     lock.wait();
//                     // printFoo.run() outputs "foo". Do not change or remove this line.
//                 printFoo.run();
//                 isFoo.set(false);
//                 lock.notifyAll();
//             }
//         }
//     }

//     public void bar(Runnable printBar) throws InterruptedException {
        
//         for (int i = 0; i < n; i++) {
//             synchronized(lock){
//                 if(isFoo.get())
//                     lock.wait();
//                     // printBar.run() outputs "bar". Do not change or remove this line.
//                printBar.run();
//                isFoo.set(true); 
//                lock.notifyAll(); 
//             }
//         }
//     }
}
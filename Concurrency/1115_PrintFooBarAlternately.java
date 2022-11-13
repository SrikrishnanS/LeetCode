/*
1115. Print FooBar Alternately

Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads:

thread A will call foo(), while
thread B will call bar().
Modify the given program to output "foobar" n times.

*/

class FooBar
{
    private int n;
    private boolean isFoo;

    public FooBar(int n)
    {
        this.n = n;
        this.isFoo = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException
    {
        synchronized(this)
        {
            for (int i = 0; i < n; i++)
            {
                while (!isFoo)
                    this.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                this.isFoo = false;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException
    {
        synchronized(this)
        {
            for (int i = 0; i < n; i++)
            {
                while (isFoo)
                    this.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                this.isFoo = true;
                this.notifyAll();
            }
        }
    }
}
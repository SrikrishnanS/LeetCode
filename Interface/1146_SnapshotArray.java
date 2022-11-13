/* 1146. Snapshot Array

Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 */

class SnapshotArray
{
    // snapshot -> value
    TreeMap<Integer, Integer> [] snapshot;

    int snap_id;

    public SnapshotArray(int length)
    {
        this.snapshot = new TreeMap[length];

        for (int i = 0; i < length; ++i)
           this.snapshot[i] = new TreeMap<Integer, Integer>();

        this.snap_id = 0;
    }

    public void set(int index, int val)
    {
        // put in current snap
        snapshot[index].put(this.snap_id, val);
    }

    public int snap()
    {
        return this.snap_id++; // return current snap and upgrade to next
    }

    public int get(int index, int snap_id)
    {
        Map.Entry<Integer, Integer> entry = snapshot[index].floorEntry(snap_id);
        return entry == null ? 0 : entry.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

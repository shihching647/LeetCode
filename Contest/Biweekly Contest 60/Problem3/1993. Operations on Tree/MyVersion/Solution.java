/**
 * 基本上就是照題目需求給的做(主要是考給parent[]如何traverse)
 * 
 * Time complexity: 
 * Space complexity: O(N)
 *
 */

class LockingTree {

    private int[] parent;
    private boolean[] locked;
    private int[] users;
    private HashMap<Integer, List<Integer>> childrenMap;
    
    public LockingTree(int[] parent) {
        this.parent = parent;
        locked = new boolean[parent.length];
        users = new int[parent.length];
        childrenMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            childrenMap.computeIfAbsent(parent[i], key -> new ArrayList<>()).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (!locked[num]) {
            locked[num] = true;
            users[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if (locked[num] && users[num] == user) {
            locked[num] = false;
            users[num] = 0;
            return true;
        }
        return false;
    }
    
    //The node is unlocked,
    //It has at least one locked descendant (by any user), and
    //It does not have any locked ancestors.
    public boolean upgrade(int num, int user) {
        List<Integer> unLockList = new LinkedList<>();
        if (!locked[num] && !hasAncestorLock(parent[num]) && hasDecendantLock(num, unLockList)) {
            locked[num] = true;
            users[num] = user;
            for (int child : unLockList) {
                locked[child] = false;
                users[child] = 0;
            }
            return true;
        }
        return false;
    }
    
    private boolean hasDecendantLock(int num, List<Integer> unLockList) {
        boolean hasLocked = false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (childrenMap.containsKey(node)) {
                for (int child : childrenMap.get(node)) {
                    q.offer(child);
                    unLockList.add(child);
                    hasLocked |= locked[child];
                }
            }
        }
        return hasLocked;
    }
    
    private boolean hasAncestorLock(int num) {
        while (num != -1) {
            if (locked[num]) {
                return true;
            }
            num = parent[num];
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
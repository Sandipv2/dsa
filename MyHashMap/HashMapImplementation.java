// PW

package MyHashMap;

import java.util.LinkedList;

public class HashMapImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int DEFAULT_CAPACITY = 4;
        private float DEFAULT_LOAD_FACTOR = 0.75f;
        private int n; // Total nodes
        private LinkedList<Node>[] buckets;

        private void initBuckets(int size) {
            buckets = new LinkedList[size];
            for(int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public HashMap() {
            initBuckets(DEFAULT_CAPACITY);
        }

        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private int searchInLL(K key, int bucketIdx) {
            LinkedList<Node> ll = buckets[bucketIdx];
            for(int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i;
                }
            }

            return -1;
        }

        private void reHashing() {
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(buckets.length * 2);
            n = 0;

            for(LinkedList<Node> ll : oldBuckets) {
                for(Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx == -1) { // Key not exist
                buckets[bucketIdx].add(new Node(key, value));
                n++;
            } else { // Key exists
                Node node = buckets[bucketIdx].get(nodeIdx);
                node.value = value;
            }

            float lambda = (float) n / buckets.length;
            if(lambda >= DEFAULT_LOAD_FACTOR) {
                reHashing();
            }
        }

        public V remove(K key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx != -1) {
                V value = buckets[bucketIdx].get(nodeIdx).value;
                buckets[bucketIdx].remove(nodeIdx);
                n--;
                return value;
            }

            return null;
        }

        public V get(K key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx != -1) {
                Node node = buckets[bucketIdx].get(nodeIdx);
                return node.value;
            }

            return null;
        }

        public boolean containsKey(K key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            return nodeIdx != -1;
        }

        public int size() {
            return n;
        }

        float load() {
            return (float) n / buckets.length;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("Mango", 12);
        mp.put("Watermelon", 15);
        mp.put("Banana", 23);

        System.out.println(mp.size());
        System.out.println(mp.remove("Banana"));
        System.out.println(mp.get("Banana"));
    }
}

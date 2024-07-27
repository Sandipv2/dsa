// Apna College

package MyHashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V> { // generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // No. of nodes
        private int N; // Bucket length
        private double loadFactor = 0.75;
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked") // Removes the warnings
        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[this.N];
            for(int i = 0; i < N; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int n = key.hashCode();
            return Math.abs(n) % N;
        }

        private int searchInLL(K key, int idx) {
            LinkedList<Node> ll = bucket[idx];
            for(int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldbucket[] = bucket;
            bucket = new LinkedList[bucket.length*2];

            for(int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }

            n = 0;
            for (LinkedList<Node> ll : oldbucket) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx == -1) {
                bucket[bucketIdx].add(new Node(key, value));
                n++;
            } else {
                Node node = bucket[bucketIdx].get(nodeIdx);
                node.value = value;
            }

            double lambda = (double) n / bucket.length;
            if(lambda >= loadFactor) {
                reHash();
            }
        }

        public V get(K key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx == -1) {
                return null;
            } else {
                Node node = bucket[bucketIdx].get(nodeIdx);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(key, bucketIdx);

            if(nodeIdx == -1) {
                return null;
            } else {
                Node node = bucket[bucketIdx].remove(nodeIdx);
                n--;
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(LinkedList<Node> ll : bucket) {
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("India", 1);
        mp.put("USA", 2);
        mp.put("Japan", 3);
        mp.put("Russia", 4);
        mp.put("China", 5);

        System.out.println("Test size : "+mp.size());
    }
}

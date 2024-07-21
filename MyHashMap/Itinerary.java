// Asked in Microsoft and Ola

package MyHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Itinerary {
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
//        Mumbai -> Delhi -> Goa -> Chennai -> Bengaluru

        String start = getStart(tickets);
        System.out.println(path(tickets, start));
    }

    static List<String> path(HashMap<String, String> tickets, String start) {
        List<String> list = new ArrayList<>();

        while(tickets.containsKey(start)) {
            list.add(start);
            start = tickets.get(start);
        }
        list.add(start);

        return list;
    }

    static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMp = new HashMap<>();

        for(var e : tickets.entrySet()) {
            reverseMp.put(e.getValue(), e.getKey());
        }

        for(var e : tickets.entrySet()) {
            if(!reverseMp.containsKey(e.getKey())) {
                return e.getKey();
            }
        }

        return null;
    }
}

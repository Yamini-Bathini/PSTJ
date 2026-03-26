import java.util.*;

class UndergroundSystem {
    private Map<Integer, Pair> checkInMap;
    private Map<String, int[]> routeMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        int duration = t - p.time;
        String key = p.station + "_" + stationName;
        routeMap.putIfAbsent(key, new int[2]);
        int[] data = routeMap.get(key);
        data[0] += duration;
        data[1] += 1;
    }
    public double getAverageTime(String startStation, String endStation) {
        int[] data = routeMap.get(startStation + "_" + endStation);
        return (double) data[0] / data[1];
    }
    private static class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

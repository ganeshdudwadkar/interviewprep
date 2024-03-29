package leetcode.easy;

// Logger Rate Limiter LC # 359 (Beats 98%) - Locked

/*


 */

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int lastPrinted = map.get(message);
            if (timestamp - lastPrinted >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
}

package ShoulderU.Stack.june4;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory1472 {
    List<String> list = new ArrayList<String>();
    int index = -1;
    public DesignBrowserHistory1472(String homepage) {
        list.add(homepage);
        index++;
    }

    public void visit(String url) {
        // clears up all the forward history.
        list.subList(index + 1, list.size()).clear();
        list.add(url);
        index++;
    }

    public String back(int steps) {
        int i = 0;
        // check if go beyond the maximum index
        while (i < steps && index >= 0) {
            index--;
            i++;
        }
        if (index < 0) {
            index = 0;
        }
        return list.get(index);
    }

    public String forward(int steps) {
        int i = 0;
        // check if its smaller than index 0
        while (i < steps && index < list.size() - 1) {
            index++;
            i++;
        }
        if (index >= list.size()) {
            index = list.size() - 1;
        }
        return list.get(index);
    }
}

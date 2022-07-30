package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
        Integer skips = null;
        Integer forwards = fastForward(startIndex, selection);
        Integer backwards = reverse(startIndex, selection);
        if (backwards > forwards) skips = forwards;
        else skips = backwards;
        return skips;
    }

    public Integer fastForward(Integer startIndex, String selection) {
        Integer numOfSkips = 0;
        for (int i = startIndex; !playList[i].contains(selection); i++) {
            if (i == playList.length - 1) i -= playList.length;
            numOfSkips++;
        }
        return numOfSkips;
    }
    public Integer reverse(Integer startIndex, String selection) {
        Integer numOfSkips = 0;
        for (int i = startIndex; !playList[i].contains(selection); i--) {
            if (i == 0) i = playList.length;
            numOfSkips++;
        }
        return numOfSkips;
    }
}

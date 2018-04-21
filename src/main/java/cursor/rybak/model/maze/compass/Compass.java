package cursor.rybak.model.maze.compass;

import cursor.rybak.model.maze.LineTypes;
import cursor.rybak.model.maze.Location;

import java.util.List;


/**
 * Vector abstraction, move by abstraction
 * right, left, straight, back
 */
public interface Compass {

    /**
     * method to move straight
     *
     * @param currentLocation current location
     * @param newLocation     new location
     */
    default void moveStraightCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineA));
                newLocation.setCrossLine(ListUtil.reverse(lineB));
            } else {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
            }
        } else {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
            } else {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine(ListUtil.reverse(lineA));
            }
        }

        newLocation.setMainLineType(currentLocation.getMainLineType());
        newLocation.setMainReverse(currentLocation.isMainReverse());
    }


    /**
     * method to move back
     *
     * @param currentLocation current location
     * @param newLocation     new location
     */
    default void moveBackCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
            } else {
                newLocation.setMainLine(ListUtil.reverse(lineA));
                newLocation.setCrossLine(ListUtil.reverse(lineB));
            }
        } else {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine(ListUtil.reverse(lineA));
            } else {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
            }
        }

        newLocation.setMainLineType(currentLocation.getMainLineType());
        newLocation.setMainReverse(!currentLocation.isMainReverse());
    }


    /**
     * method to turn right
     *
     * @param currentLocation current location
     * @param newLocation     new location
     */
    default void moveRightCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
                newLocation.setMainReverse(true);
            } else {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine(ListUtil.reverse(lineB));
                newLocation.setMainReverse(false);
            }

            newLocation.setMainLineType(LineTypes.lineTypeB);
        } else {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
                newLocation.setMainReverse(false);
            } else {
                newLocation.setMainLine(ListUtil.reverse(lineA));
                newLocation.setCrossLine(ListUtil.reverse(lineB));
                newLocation.setMainReverse(true);
            }

            newLocation.setMainLineType(LineTypes.lineTypeA);
        }
    }


    /**
     * method to turn left
     *
     * @param currentLocation current location
     * @param newLocation     new location
     */
    default void moveLeftCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine(ListUtil.reverse(lineA));
                newLocation.setMainReverse(false);
            } else {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
                newLocation.setMainReverse(true);
            }

            newLocation.setMainLineType(LineTypes.lineTypeB);
        } else {
            if (currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineA));
                newLocation.setCrossLine(ListUtil.reverse(lineB));
                newLocation.setMainReverse(true);
            } else {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
                newLocation.setMainReverse(false);
            }

            newLocation.setMainLineType(LineTypes.lineTypeA);
        }
    }
}
